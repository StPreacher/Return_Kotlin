package com.example.returnkotlin.ui.list

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentCountryListBinding
import com.example.returnkotlin.repo.CountryListRepository
import com.example.returnkotlin.service.ApiClient
import com.example.returnkotlin.service.ApiService
import com.example.returnkotlin.util.hide
import com.example.returnkotlin.util.show
import com.example.returnkotlin.viewmodel.CountryListViewModel
import com.example.returnkotlin.viewmodel.vmfactory.CountryListViewModelFactory

class CountryListFragment : BaseFragment<FragmentCountryListBinding>() {

    private val TAG : String = CountryListFragment::class.java.simpleName

    private lateinit var adapter: CountryListAdapter

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
                ResourceStatus.PROGRESS -> {
                    Log.v(TAG, "progress")
                    mBinding.progressBar.show()
                    mBinding.countryRV.hide()
                    mBinding.errorText.hide()
                }
                ResourceStatus.SUCCESS -> {
                    Log.v(TAG, "success")
                    mBinding.countryRV.show()
                    mBinding.progressBar.hide()
                    mBinding.errorText.hide()
                    adapter = CountryListAdapter(it.data!!)
                    mBinding.countryRV.adapter = adapter
                }
                ResourceStatus.ERROR -> {
                    Log.v(TAG, "error")
                    mBinding.errorText.show()
                    mBinding.countryRV.hide()
                    mBinding.progressBar.hide()
                }
            }
        }
    }

}