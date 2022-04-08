package com.example.returnkotlin.repo

import com.example.returnkotlin.service.ApiService

class CountryListRepository constructor(private val retrofitService: ApiService){

    fun getAllCountries() = retrofitService.getCountries()

}