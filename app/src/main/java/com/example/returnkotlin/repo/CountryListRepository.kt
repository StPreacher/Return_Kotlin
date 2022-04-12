package com.example.returnkotlin.repo

import com.example.returnkotlin.service.ApiService
import javax.inject.Inject

class CountryListRepository @Inject constructor(private val retrofitService: ApiService){

    suspend fun getAllCountries() = retrofitService.getCountries()

}