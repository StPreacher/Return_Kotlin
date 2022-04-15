package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.CountryInfo
import com.example.returnkotlin.repo.CountryInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryInfoViewModel @Inject constructor(private val repository: CountryInfoRepository) :
    BaseViewModel() {

    val resource = MutableLiveData<Resource<CountryInfo>>()

    fun getCountryInfo(countryCode: String) {
        resource.postValue(Resource(ResourceStatus.PROGRESS))
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCountryInfo(countryCode)
            if (response.isSuccessful) {
                response.let {
                    resource.postValue(Resource(ResourceStatus.SUCCESS,it.body()))
                }
            } else {
                resource.postValue(Resource(ResourceStatus.ERROR,null, ResourceError(61,response.message())))
            }
        }
    }

}