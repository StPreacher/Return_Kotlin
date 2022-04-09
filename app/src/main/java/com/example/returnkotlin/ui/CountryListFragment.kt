package com.example.returnkotlin.ui

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentCountryListBinding
import com.example.returnkotlin.repo.CountryListRepository
import com.example.returnkotlin.service.ApiClient
import com.example.returnkotlin.service.ApiService
import com.example.returnkotlin.viewmodel.CountryListViewModel
import com.example.returnkotlin.viewmodel.vmfactory.CountryListViewModelFactory

class CountryListFragment : BaseFragment<FragmentCountryListBinding>() {

    private val TAG : String = CountryListFragment::class.java.simpleName

    private val mViewModel by lazy {
        val service = ApiClient.getClient().create(ApiService::class.java)
        val repository = CountryListRepository(service)
        val factory = CountryListViewModelFactory(repository)
        ViewModelProvider(this,factory).get(CountryListViewModel::class.java)
    }

    override fun bindLayoutId(): Int {
        return R.layout.fragment_country_list
    }

    override fun initViews() {
        mViewModel.getAllMovies()
        mViewModel.resource.observe(viewLifecycleOwner) {
            when(it.status) {
                ResourceStatus.PROGRESS -> Log.v(TAG, "progress")
                ResourceStatus.SUCCESS -> Log.v(TAG, "success")
                ResourceStatus.ERROR -> Log.v(TAG, "error")
            }
        }
    }

}