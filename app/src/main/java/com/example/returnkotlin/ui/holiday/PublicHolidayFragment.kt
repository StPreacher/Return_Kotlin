package com.example.returnkotlin.ui.holiday

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentPublicHolidayBinding
import com.example.returnkotlin.util.extensions.changeWith
import com.example.returnkotlin.util.extensions.hide
import com.example.returnkotlin.util.extensions.show
import com.example.returnkotlin.viewmodel.PublicHolidayViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG: String = "PublicHolidayFragment.java"

@AndroidEntryPoint
class PublicHolidayFragment : BaseFragment<FragmentPublicHolidayBinding, PublicHolidayViewModel>() {

    override val mViewModel: PublicHolidayViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_public_holiday

    lateinit var mAdapter: PublicHolidayAdapter

    override fun initViews() {

        mBinding.viewModel = mViewModel
        showSearchStatus(getString(R.string.please_search))

        mBinding.yearText.doAfterTextChanged {
            mViewModel.updateYearText(it?.toString())
        }

        mBinding.countryCodeText.doAfterTextChanged {
            mViewModel.updateCountryCodeText(it?.toString())
        }

        mViewModel.getResource().observe(viewLifecycleOwner) {
            when (it.status) {
                ResourceStatus.PROGRESS -> {
                    mBinding.searchStatusText.hide()
                    mBinding.holidayRV.hide()
                    mBinding.progressBar.show()
                }
                ResourceStatus.SUCCESS -> {
                    mBinding.progressBar.hide()
                    mBinding.searchStatusText.hide()
                    mBinding.holidayRV.show()
                    mAdapter = PublicHolidayAdapter(it.data!!)
                    mBinding.holidayRV.adapter = mAdapter
                }
                ResourceStatus.ERROR -> {
                    mBinding.progressBar.hide()
                    mBinding.holidayRV.hide()
                    showSearchStatus(getString(R.string.something_went_wrong))
                }
            }
        }
    }

    private fun showSearchStatus(message: String?) {
        mBinding.let {
            it.searchStatusText.changeWith(message)
            it.searchStatusText.show()
        }
    }

}