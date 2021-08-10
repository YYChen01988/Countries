package com.countries.countries.data.model

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("iso639_1")
    val iso6391: String? = null,

    @SerializedName("iso639_2")
    val iso6392: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("nativeName")
    val nativeName: String? = null,
)