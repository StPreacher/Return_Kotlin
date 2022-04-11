package com.example.returnkotlin.util.extensions

import android.view.View
import com.example.returnkotlin.model.PublicHoliday

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}
