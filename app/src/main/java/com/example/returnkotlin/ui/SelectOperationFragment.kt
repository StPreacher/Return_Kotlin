package com.example.returnkotlin.ui

import androidx.fragment.app.viewModels
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.databinding.FragmentSelectOperationBinding
import com.example.returnkotlin.viewmodel.SelectOperationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectOperationFragment : BaseFragment<FragmentSelectOperationBinding, SelectOperationViewModel>() {

    override val mViewModel : SelectOperationViewModel by viewModels()

    override fun bindLayoutId(): Int {
        return R.layout.fragment_select_operation
    }

    override fun initViews() {
        mBinding.viewModel = mViewModel
    }

}