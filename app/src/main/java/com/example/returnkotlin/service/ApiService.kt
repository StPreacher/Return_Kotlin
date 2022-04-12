package com.example.returnkotlin.service

import com.example.returnkotlin.model.Country
import com.example.returnkotlin.model.PublicHoliday
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/v3/AvailableCountries")
    suspend fun getCountries() : Response<List<Country>>

    @GET("/api/v3/PublicHolidays/{year}/{countryCode}")
    suspend fun getPublicHolidays(@Path("year") year: Int, @Path("countryCode") countryCode: String) : Response<List<PublicHoliday>>
}