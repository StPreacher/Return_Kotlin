package com.example.returnkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnkotlin.model.Country
import com.example.returnkotlin.repo.CountryListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListViewModel constructor(private val repository : CountryListRepository) : ViewModel() {

    val countryList = MutableLiveData<List<Country>>()

    fun getAllMovies() {
        val response = repository.getAllCountries()
        response.enqueue(object : Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    countryList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {

            }

        })
    }
}