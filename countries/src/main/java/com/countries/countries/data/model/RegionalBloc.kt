package com.countries.countries.data.model

import com.google.gson.annotations.SerializedName

data class RegionalBloc(
    @SerializedName("acronym")
    val acronym: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("otherAcronyms")
    val otherAcronyms: List<Any>? = null,

    @SerializedName("otherNames")
    val otherNames: List<Any>? = null
)