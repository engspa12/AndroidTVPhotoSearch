package com.example.dbm.photosearchandroidtv.domain

import com.example.dbm.photosearchandroidtv.data.model.search.PhotoItemNetwork
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoItemView
import com.example.dbm.photosearchandroidtv.util.formatDate
import com.example.dbm.photosearchandroidtv.util.getImageUrl

fun PhotoItemNetwork.toPhotoItemDomain() = PhotoItemDomain(
    title = if (this.title != "") this.title ?: "No title available" else "No title available",
    date = this.datetaken?.formatDate() ?: "No date available",
    author = if(this.ownername != "") this.ownername ?: "No author available" else "No author available",
    imgUrl = this.getImageUrl()
)

fun PhotoItemDomain.toPhotoItemView() = PhotoItemView(
    title = this.title,
    date = this.date,
    author = this.author,
    imgUrl = this.imgUrl
)
