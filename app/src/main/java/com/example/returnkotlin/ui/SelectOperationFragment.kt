package com.example.returnkotlin.ui

import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.databinding.FragmentSelectOperationBinding
import com.example.returnkotlin.viewmodel.SelectOperationViewModel

class SelectOperationFragment : BaseFragment<FragmentSelectOperationBinding, SelectOperationViewModel>() {

    override val mViewModel : SelectOperationViewModel by viewModels()

    override fun bindLayoutId(): Int {
        return R.layout.fragment_select_operation
    }

    override fun initViews() {
        mBinding.viewModel = mViewModel
    }

}