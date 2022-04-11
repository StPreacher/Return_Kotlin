package com.example.returnkotlin.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.returnkotlin.util.SingleLiveEvent
import com.example.returnkotlin.util.StringHelper
import javax.inject.Inject

open class BaseViewModel : ViewModel() {

    @Inject
    lateinit var stringHelper: StringHelper

    val navigationAction = SingleLiveEvent<NavDirections>()

    fun navigate(action : NavDirections, bundle: Bundle? = null) {
        navigationAction.postValue(action)
    }

}