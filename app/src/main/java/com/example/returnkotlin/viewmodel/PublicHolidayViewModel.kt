package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.PublicHoliday
import com.example.returnkotlin.repo.PublicHolidayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PublicHolidayViewModel @Inject constructor(private val repository: PublicHolidayRepository) :
    BaseViewModel() {

    private val resource = MutableLiveData<Resource<List<PublicHoliday>>>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        resource.postValue(
            Resource(ResourceStatus.ERROR, null,
                throwable.localizedMessage?.let { ResourceError(62, it) })
        )
    }

    fun getResource(): MutableLiveData<Resource<List<PublicHoliday>>> {
        return resource
    }

    fun getPublicHolidays(year: Int, countryCode: String) {
        resource.postValue(Resource(ResourceStatus.PROGRESS))
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getPublicHolidays(year, countryCode)
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