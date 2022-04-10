package com.example.returnkotlin.util

import android.view.View
import com.example.returnkotlin.model.PublicHoliday

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun List<PublicHoliday>.toStringList() : List<String> {
    var string = ""
    val list = arrayListOf<String>()
    for (item in this) {
        string = item.countryCode + " " + item.name
        list.add(string)
    }
    return list
}

/*
fun <T> List<T>.toString() : String {
    var sum : String
    for (item in this) {
        sum += item
    }
}*/
