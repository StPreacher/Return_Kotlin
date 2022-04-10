package com.example.returnkotlin.ui

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.returnkotlin.R
import com.example.returnkotlin.base.BaseFragment
import com.example.returnkotlin.base.ResourceStatus
import com.example.returnkotlin.databinding.FragmentPublicHolidayBinding
import com.example.returnkotlin.util.toStringList
import com.example.returnkotlin.viewmodel.PublicHolidayViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class PublicHolidayFragment : BaseFragment<FragmentPublicHolidayBinding>() {

    private val TAG : String = PublicHolidayFragment::class.java.simpleName

    private val mViewModel : PublicHolidayViewModel by lazy {
        ViewModelProvider(this)[PublicHolidayViewModel::class.java]
    }

    override fun bindLayoutId(): Int = R.layout.fragment_public_holiday

    override fun initViews() {
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