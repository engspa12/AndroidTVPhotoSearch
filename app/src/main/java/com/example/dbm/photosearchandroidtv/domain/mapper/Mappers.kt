package com.example.dbm.photosearchandroidtv.domain.mapper

import com.example.dbm.photosearchandroidtv.data.model.PhotoNetwork
import com.example.dbm.photosearchandroidtv.domain.model.PhotoDomain
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView
import com.example.dbm.photosearchandroidtv.util.formatDate
import com.example.dbm.photosearchandroidtv.util.getImageUrl

fun PhotoNetwork.toPhotoDomain() = PhotoDomain(
    title = if (this.title != "") this.title ?: "No title available" else "No title available",
    date = this.datetaken?.formatDate() ?: "No date available",
    author = if(this.ownername != "") this.ownername ?: "No author available" else "No author available",
    imgUrl = this.getImageUrl()
)

fun PhotoDomain.toPhotoView() = PhotoView(
    title = this.title,
    date = this.date,
    author = this.author,
    imgUrl = this.imgUrl
)
