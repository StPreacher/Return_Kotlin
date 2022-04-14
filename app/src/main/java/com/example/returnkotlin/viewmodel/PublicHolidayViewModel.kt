package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.HolidaySearchArgument
import com.example.returnkotlin.model.PublicHoliday
import com.example.returnkotlin.repo.PublicHolidayRepository
import com.example.returnkotlin.util.extensions.isNullOrBlank
import com.example.returnkotlin.util.extensions.isSame
import com.example.returnkotlin.util.extensions.toNullableInt
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

    private var lastSearchArguments: HolidaySearchArgument? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        resource.postValue(
            Resource(ResourceStatus.ERROR, null,
                throwable.localizedMessage?.let { ResourceError(62, it) })
        )
    }

    fun getResource(): MutableLiveData<Resource<List<PublicHoliday>>> {
        return resource
    }

    fun clickSearchBtn() {
        val year = yearText.value?.toNullableInt()
        val countryCode = countryCodeText.value
        when {
            year.isNullOrBlank() -> {
                toastHelper.showToastShort(stringHelper.getString(R.string.empty_year_toast))
            }
            countryCode.isNullOrBlank() -> {
                toastHelper.showToastShort(stringHelper.getString(R.string.empty_country_code_toast))
            }
            else -> {
                if (lastSearchArguments == null) {
                    lastSearchArguments = HolidaySearchArgument(year, countryCode)
                    getPublicHolidays(year!!, countryCode)
                } else {
                    if (lastSearchArguments?.isSame(
                            HolidaySearchArgument(
                                year,
                                countryCode
                            )
                        ) == false
                    ) {
                        lastSearchArguments = HolidaySearchArgument(year, countryCode)
                        getPublicHolidays(year!!, countryCode)
                    }
                }
            }
        }
    }

    fun updateYearText(text: String?) {
        text?.let { yearText.postValue(text) }
    }

    fun updateCountryCodeText(text: String?) {
        text?.let { countryCodeText.postValue(text) }
    }

    private fun getPublicHolidays(year: Int, countryCode: String) {
        resource.postValue(Resource(ResourceStatus.PROGRESS))
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getPublicHolidays(year, countryCode)
            if (response.isSuccessful) {
                if (response.body() == null) {
                    resource.postValue(
                        Resource(
                            ResourceStatus.ERROR,
                            null,
                            ResourceError(61, response.message())
                        )
                    )
                } else {
                    resource.postValue(Resource(ResourceStatus.SUCCESS, response.body()))
                }
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