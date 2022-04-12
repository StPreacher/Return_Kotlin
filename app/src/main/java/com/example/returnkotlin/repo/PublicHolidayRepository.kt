package com.example.returnkotlin.repo

import com.example.returnkotlin.service.ApiService
import javax.inject.Inject

class PublicHolidayRepository @Inject constructor(
    private val service: ApiService) {

    suspend fun getPublicHolidays(year : Int, countryCode : String) = service.getPublicHolidays(year,countryCode)

}