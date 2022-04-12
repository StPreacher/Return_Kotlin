package com.example.returnkotlin.ui.list

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentCountryListBinding
import com.example.returnkotlin.util.extensions.hide
import com.example.returnkotlin.util.extensions.show
import com.example.returnkotlin.viewmodel.CountryListViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG : String = "CountryListFragment.java"

@AndroidEntryPoint
class CountryListFragment : BaseFragment<FragmentCountryListBinding,CountryListViewModel>() {

    private lateinit var adapter: CountryListAdapter

    override val mViewModel : CountryListViewModel by viewModels()

    override fun bindLayoutId(): Int {
        return R.layout.fragment_country_list
    }

    override fun initViews() {
        mViewModel.getAllCountries()
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