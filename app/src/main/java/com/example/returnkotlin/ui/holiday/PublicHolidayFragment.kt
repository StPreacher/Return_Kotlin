package com.example.returnkotlin.ui.holiday

import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentPublicHolidayBinding
import com.example.returnkotlin.util.extensions.changeWith
import com.example.returnkotlin.util.extensions.hide
import com.example.returnkotlin.util.extensions.show
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
        mBinding.searchStatusText.changeWith(getString(R.string.please_search))
        mBinding.searchStatusText.show()

        mBinding.yearText.doAfterTextChanged {
            mViewModel.updateYearText(it?.toString())
        }

        mBinding.countryCodeText.doAfterTextChanged {
            mViewModel.updateCountryCodeText(it?.toString())
        }

        mViewModel.getResource().observe(viewLifecycleOwner) {
            when(it.status) {
                ResourceStatus.PROGRESS -> {
                    mBinding.searchStatusText.hide()
                    mBinding.holidayRV.hide()
                    mBinding.progressBar.show()
                }
                ResourceStatus.SUCCESS -> {
                    mBinding.progressBar.hide()
                    mBinding.searchStatusText.hide()
                    mBinding.holidayRV.show()
                }
                ResourceStatus.ERROR -> {
                    mBinding.progressBar.hide()
                    mBinding.holidayRV.hide()
                    mBinding.searchStatusText.changeWith(getString(R.string.something_went_wrong))
                    mBinding.searchStatusText.show()
                }
            }
        }
    }

}