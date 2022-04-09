package com.example.returnkotlin.viewmodel.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.returnkotlin.repo.CountryListRepository
import com.example.returnkotlin.viewmodel.CountryListViewModel
import java.lang.IllegalArgumentException

class CountryListViewModelFactory(private val repository : CountryListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryListViewModel::class.java)) {
            return CountryListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
