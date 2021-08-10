package com.countries.countries.data.model

import com.google.gson.annotations.SerializedName

data class Meme (

    @SerializedName("postLink")
    val post_link: String? = null,

    @SerializedName("subreddit")
    val subreddit: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("ups")
    val ups: Int? = null,

    @SerializedName("author")
    val author: String? = null,

    @SerializedName("spoiler")
    val spoilersEnabled: Boolean? = null,

    @SerializedName("nsfw")
    val nsfw: Boolean? = null,

    @SerializedName("preview")
    val imagePreviews: List<String?>? = null

        )