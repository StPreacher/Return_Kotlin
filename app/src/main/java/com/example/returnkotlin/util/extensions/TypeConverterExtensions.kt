package com.example.returnkotlin.util.extensions

fun Int?.isNullOrBlank() : Boolean {
    return this?.toString()?.isBlank() ?: true
}

fun String.toNullableInt() : Int? {
    return if (this.isEmpty()) {
        null
    } else {
        this.toInt()
    }

}