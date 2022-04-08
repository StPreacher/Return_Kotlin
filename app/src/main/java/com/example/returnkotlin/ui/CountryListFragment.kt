package com.example.returnkotlin.ui

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.returnkotlin.R
import com.example.returnkotlin.databinding.FragmentCountryListBinding
import com.example.returnkotlin.repo.CountryListRepository
import com.example.returnkotlin.service.ApiClient
import com.example.returnkotlin.service.ApiService
import com.example.returnkotlin.viewmodel.CountryListViewModel

class CountryListFragment : BaseFragment<FragmentCountryListBinding>() {

    override fun bindLayoutId(): Int {
        return R.layout.fragment_country_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model : CountryListViewModel by viewModels()
    }

    override fun initViews() {

    }
}