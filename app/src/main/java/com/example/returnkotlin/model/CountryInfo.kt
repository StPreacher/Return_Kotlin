package com.example.returnkotlin.model

import com.google.gson.annotations.SerializedName

data class CountryInfo(
    @SerializedName("commonName")
    var commonName: String? = null,
    @SerializedName("officialName")
    var officialName: String? = null,
    @SerializedName("countryCode")
    var countryCode: String? = null,
    @SerializedName("region")
    var region: String? = null,
    @SerializedName("borders")
    var borders: ArrayList<Borders> = arrayListOf()
)
