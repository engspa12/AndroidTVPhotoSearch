package com.example.dbm.photosearchandroidtv.data.model.search

import com.google.gson.annotations.SerializedName

data class PhotoItemNetwork(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("owner")
    var owner: String? = null,
    @SerializedName("secret")
    var secret: String? = null,
    @SerializedName("server")
    var server: String? = null,
    @SerializedName("farm")
    var farm: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("ispublic")
    var ispublic: Int? = null,
    @SerializedName("isfriend")
    var isfriend: Int? = null,
    @SerializedName("isfamily")
    var isfamily: Int? = null,
    @SerializedName("datetaken")
    var datetaken: String? = null,
    @SerializedName("datetakengranularity")
    var datetakengranularity: Int? = null,
    @SerializedName("datetakenunknown")
    var datetakenunknown: String? = null,
    @SerializedName("ownername")
    var ownername: String? = null,
    @SerializedName("url_h")
    var urlH: String? = null,
    @SerializedName("height_h")
    var heightH: Int? = null,
    @SerializedName("width_h")
    var widthH: Int? = null,
    @SerializedName("url_c")
    var urlC: String? = null,
    @SerializedName("height_c")
    var heightC: Int? = null,
    @SerializedName("width_c")
    var widthC: Int? = null,
    @SerializedName("url_o")
    var urlO: String? = null,
    @SerializedName("height_o")
    var heightO: Int? = null,
    @SerializedName("width_o")
    var widthO: Int? = null
)