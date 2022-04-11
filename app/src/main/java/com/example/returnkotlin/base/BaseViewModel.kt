package com.example.returnkotlin.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.returnkotlin.util.SingleLiveEvent

open class BaseViewModel : ViewModel() {

    val navigationAction = SingleLiveEvent<NavDirections>()

    fun navigate(action : NavDirections, bundle: Bundle? = null) {
        navigationAction.postValue(action)
    }

}