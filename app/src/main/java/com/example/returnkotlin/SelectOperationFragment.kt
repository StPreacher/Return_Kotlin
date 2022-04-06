package com.example.returnkotlin

import androidx.navigation.findNavController
import com.example.returnkotlin.databinding.FragmentSelectOperationBinding

class SelectOperationFragment : BaseFragment<FragmentSelectOperationBinding>() {
    override fun bindLayoutId(): Int {
        return R.layout.fragment_select_operation
    }

    override fun initViews() {
        val action = SelectOperationFragmentDirections.actionToCountryList()
        mBinding.goToCountryList.setOnClickListener {
            it.findNavController().navigate(action)
        }
    }


}