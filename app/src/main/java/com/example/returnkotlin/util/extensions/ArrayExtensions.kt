package com.example.returnkotlin.util.extensions

import com.example.returnkotlin.model.PublicHoliday


fun List<PublicHoliday>.toStringList(): List<String> {
    var string = ""
    val list = arrayListOf<String>()
    for (item in this) {
        string = item.countryCode + " " + item.name
        list.add(string)
    }
    return list
}

