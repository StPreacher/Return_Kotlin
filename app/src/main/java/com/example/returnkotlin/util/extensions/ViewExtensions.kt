package com.example.returnkotlin.util.extensions

import android.view.View
import android.widget.TextView
import com.example.returnkotlin.model.PublicHoliday

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun TextView.changeWith(value: String?) {
    this.text = value
}
