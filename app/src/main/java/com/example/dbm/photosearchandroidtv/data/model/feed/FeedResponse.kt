package com.example.dbm.photosearchandroidtv.data.model.feed

import com.google.gson.annotations.SerializedName

data class FeedResponse(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("link")
    var link: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("modified")
    var modified: String? = null,
    @SerializedName("generator")
    var generator: String? = null,
    @SerializedName("items")
    var items: List<Item> = arrayListOf()
)
