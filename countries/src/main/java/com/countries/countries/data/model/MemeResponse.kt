package com.countries.countries.data.model

import com.google.gson.annotations.SerializedName

data class MemeResponse (
//    @SerializedName("code")
//    val code: Int? = null,

    @SerializedName("count")
    val count: Int? = null,

    @SerializedName("memes")
    val memes: List<Meme>? = null,
        )