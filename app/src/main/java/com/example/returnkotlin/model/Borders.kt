package com.example.returnkotlin.model

import com.google.gson.annotations.SerializedName

data class Borders(
    @SerializedName("commonName")
    var commonName: String? = null,
    @SerializedName("officialName")
    var officialName: String? = null,
    @SerializedName("countryCode")
    var countryCode: String? = null,
    @SerializedName("region")
    var region: String? = null,
    @SerializedName("borders")
    var borders: String? = null
)
