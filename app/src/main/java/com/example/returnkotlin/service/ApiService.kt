package com.example.returnkotlin.service

import com.example.returnkotlin.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v3/AvailableCountries")
    fun getCountries() : Call<List<Country>>
}