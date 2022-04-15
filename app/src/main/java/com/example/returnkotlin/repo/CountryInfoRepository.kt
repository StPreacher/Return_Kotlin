package com.example.returnkotlin.repo

import com.example.returnkotlin.service.ApiService
import javax.inject.Inject

class CountryInfoRepository @Inject constructor(private val retrofitService: ApiService) {

    suspend fun getCountryInfo(countryCode: String) = retrofitService.getCountryInfo(countryCode)

}