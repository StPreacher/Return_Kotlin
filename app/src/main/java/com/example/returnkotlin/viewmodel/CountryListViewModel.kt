package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.base.Resource
import com.example.returnkotlin.base.ResourceError
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.model.Country
import com.example.returnkotlin.repo.CountryListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

private const val TAG : String = "CountryListViewMode.java"

@HiltViewModel
class CountryListViewModel @Inject constructor(private val repository : CountryListRepository) : BaseViewModel() {

    val resource = MutableLiveData<Resource<List<Country>>>()

    fun getAllMovies() {
        resource.postValue(Resource(ResourceStatus.PROGRESS))
        val doRequest = repository.getAllCountries()
        doRequest.enqueue(object : Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    resource.postValue(Resource(ResourceStatus.SUCCESS,response.body()))
                } else{
                    resource.postValue(Resource(ResourceStatus.ERROR,null, ResourceError(61,"something wrong")))
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                resource.postValue(Resource(ResourceStatus.ERROR,null,
                    t.localizedMessage?.let { ResourceError(62, it) }))
            }
        })
    }
}