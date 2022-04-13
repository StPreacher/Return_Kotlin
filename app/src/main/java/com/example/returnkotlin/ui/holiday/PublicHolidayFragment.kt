package com.example.returnkotlin.ui.holiday

import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentPublicHolidayBinding
import com.example.returnkotlin.util.extensions.toStringList
import com.example.returnkotlin.viewmodel.PublicHolidayViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG : String = "PublicHolidayFragment.java"

@AndroidEntryPoint
class PublicHolidayFragment : BaseFragment<FragmentPublicHolidayBinding,PublicHolidayViewModel>() {

    override val mViewModel : PublicHolidayViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_public_holiday

    override fun initViews() {

        mBinding.viewModel = mViewModel

        mBinding.yearText.doAfterTextChanged {
            mViewModel.updateYearText(it?.toString())
        }

        mBinding.countryCodeText.doAfterTextChanged {
            mViewModel.updateCountryCodeText(it?.toString())
        }

        mViewModel.getPublicHolidays(2022,"TR")
        mViewModel.getResource().observe(viewLifecycleOwner) {
            when(it.status) {
                ResourceStatus.PROGRESS -> {
                    Log.v(TAG, "progress")
                }
                ResourceStatus.SUCCESS -> {
                    Log.v(TAG, "success")
                    for (item in it.data?.toStringList()!!) {
                        Log.v(TAG, "success: $item")
                    }
                }
                ResourceStatus.ERROR -> {
                    Log.v(TAG, "error")
                }
            }
        }
    }

}