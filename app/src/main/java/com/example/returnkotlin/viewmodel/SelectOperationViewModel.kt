package com.example.returnkotlin.viewmodel

import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.ui.SelectOperationFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectOperationViewModel @Inject constructor() : BaseViewModel() {

    fun onCountryListClick() {
        navigate(SelectOperationFragmentDirections.actionToCountryList())
    }

    fun onPublicHolidayClick() {
        navigate(SelectOperationFragmentDirections.actionHolidayFragment())
    }

}