package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.Country
import com.example.returnkotlin.repo.CountryListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG: String = "CountryListViewMode.java"

@HiltViewModel
class CountryListViewModel @Inject constructor(private val repository: CountryListRepository) :
    BaseViewModel() {

    val resource = MutableLiveData<Resource<List<Country>>>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        resource.postValue(
            Resource(ResourceStatus.ERROR, null,
                throwable.localizedMessage?.let { ResourceError(62, it) })
        )
    }

    fun getAllCountries() {
        resource.postValue(Resource(ResourceStatus.PROGRESS))
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getAllCountries()
            if (response.isSuccessful) {
                resource.postValue(Resource(ResourceStatus.SUCCESS, response.body()))
            } else {
                resource.postValue(
                    Resource(
                        ResourceStatus.ERROR,
                        null,
                        ResourceError(61, response.message())
                    )
                )
            }
        }
    }

}