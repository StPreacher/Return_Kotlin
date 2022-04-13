package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.PublicHoliday
import com.example.returnkotlin.repo.PublicHolidayRepository
import com.example.returnkotlin.util.ToastHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PublicHolidayViewModel @Inject constructor(private val repository: PublicHolidayRepository) :
    BaseViewModel() {

    private val resource = MutableLiveData<Resource<List<PublicHoliday>>>()

    private var yearText = MutableLiveData<String?>()

    private var countryCodeText = MutableLiveData<String?>()

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

    fun clickSearchBtn() {
        val year = yearText.value
        val countryCode = countryCodeText.value
        when {
            year.isNullOrBlank() -> {
                toastHelper.showToastShort(stringHelper.getString(R.string.empty_year_toast))
            }
            countryCode.isNullOrBlank() -> {
                toastHelper.showToastShort(stringHelper.getString(R.string.empty_country_code_toast))
            }
            else -> {
                getPublicHolidays(year = year.toInt(), countryCode = countryCode)
            }
        }
    }

    fun updateYearText(text : String?) {
        text?.let { yearText.postValue(text) }
    }

    fun updateCountryCodeText(text: String?) {
        text?.let { countryCodeText.postValue(text) }
    }

}