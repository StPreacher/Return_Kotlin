package com.example.returnkotlin.ui

import androidx.navigation.findNavController
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.databinding.FragmentSelectOperationBinding

class SelectOperationFragment : BaseFragment<FragmentSelectOperationBinding>() {
    override fun bindLayoutId(): Int {
        return R.layout.fragment_select_operation
    }

    override fun initViews() {
        val actionToCountryListPage =
            SelectOperationFragmentDirections.actionToCountryList()
        val actionToHolidayPage =
            SelectOperationFragmentDirections.actionHolidayFragment()
        mBinding.goToCountryList.setOnClickListener {
            it.findNavController().navigate(actionToCountryListPage)
        }
        mBinding.goToHolidayPage.setOnClickListener {
            it.findNavController().navigate(actionToHolidayPage)
        }
    }


}