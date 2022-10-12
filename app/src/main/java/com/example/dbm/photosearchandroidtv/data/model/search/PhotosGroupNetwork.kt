package com.example.dbm.photosearchandroidtv.data.model.search

import com.google.gson.annotations.SerializedName

data class PhotosGroupNetwork(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("pages")
    var pages: Int? = null,
    @SerializedName("perpage")
    var perpage: Int? = null,
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("photo")
    var photos: List<PhotoItemNetwork> = listOf()
)