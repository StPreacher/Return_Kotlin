package com.example.returnkotlin.ui.info

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentCountryInfoBinding
import com.example.returnkotlin.viewmodel.CountryInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG : String = "CountryInfoFragment.java"

@AndroidEntryPoint
class CountryInfoFragment : BaseFragment<FragmentCountryInfoBinding, CountryInfoViewModel>() {

    override val mViewModel: CountryInfoViewModel by viewModels()

    override fun bindLayoutId() = R.layout.fragment_country_info

    override fun initViews() {
        mViewModel.getCountryInfo("TR")
        mViewModel.resource.observe(viewLifecycleOwner) {
            when(it.status) {
                ResourceStatus.PROGRESS -> {
                    Log.v(TAG, "progress")
                }
                ResourceStatus.SUCCESS -> {
                    Log.v(TAG, "success")
                }
                ResourceStatus.ERROR -> {
                    Log.v(TAG, "error")
                }
            }
        }
    }

}