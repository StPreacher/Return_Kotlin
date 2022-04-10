package com.example.returnkotlin.model

import com.google.gson.annotations.SerializedName

data class PublicHoliday(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("localName")
    var localName: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("countryCode")
    var countryCode: String? = null,
    @SerializedName("fixed")
    var fixed: Boolean? = null,
    @SerializedName("global")
    var global: Boolean? = null,
    @SerializedName("counties")
    var counties: ArrayList<String> = arrayListOf(),
    @SerializedName("launchYear")
    var launchYear: Int? = null,
    @SerializedName("types")
    var types: ArrayList<String> = arrayListOf()
)
