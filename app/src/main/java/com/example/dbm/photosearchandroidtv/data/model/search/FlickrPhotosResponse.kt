package com.example.dbm.photosearchandroidtv.data.model.search

import com.google.gson.annotations.SerializedName

data class FlickrPhotosResponse(
    @SerializedName("photos")
    var photosGroupNetwork : PhotosGroupNetwork = PhotosGroupNetwork(),
    @SerializedName("stat")
    var stat   : String? = null
)