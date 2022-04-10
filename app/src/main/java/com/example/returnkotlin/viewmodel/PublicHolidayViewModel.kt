package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.PublicHoliday
import com.example.returnkotlin.repo.PublicHolidayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PublicHolidayViewModel @Inject constructor(private val repository: PublicHolidayRepository) :
    ViewModel() {

    private val resource = MutableLiveData<Resource<List<PublicHoliday>>>()

    fun getResource() : MutableLiveData<Resource<List<PublicHoliday>>> {
        return resource
    }

    fun getPublicHolidays(year: Int, countryCode: String){
        resource.postValue(Resource(ResourceStatus.PROGRESS))
        repository.getPublicHolidays(year, countryCode).enqueue(object : Callback<List<PublicHoliday>>{
            override fun onResponse(
                call: Call<List<PublicHoliday>>,
                response: Response<List<PublicHoliday>>
            ) {
                resource.postValue(Resource(ResourceStatus.SUCCESS,response.body()))
            }

            override fun onFailure(call: Call<List<PublicHoliday>>, t: Throwable) {
                resource.postValue(Resource(ResourceStatus.ERROR,null,
                    t.localizedMessage?.let { ResourceError(62, it) }))
            }

        })
    }

}