package com.example.returnkotlin.viewmodel

import com.example.returnkotlin.repo.CountryInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountryInfoViewModel @Inject constructor(private val repository: CountryInfoRepository) {

    fun getCountryInfo(countryCode: String) {

    }

}