package com.example.returnkotlin.util.extensions

import com.example.returnkotlin.model.HolidaySearchArgument

fun HolidaySearchArgument.isSame(value: HolidaySearchArgument): Boolean {
    return this.countryCode == value.countryCode && this.year == value.year
}