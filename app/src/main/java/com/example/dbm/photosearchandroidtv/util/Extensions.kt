package com.example.dbm.photosearchandroidtv.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.dbm.photosearchandroidtv.R
import com.example.dbm.photosearchandroidtv.data.model.search.PhotoItemNetwork
import java.text.SimpleDateFormat
import java.util.*

fun ImageView.loadUrl(url: String){

    val options = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.placeholder_image)
        .error(R.drawable.no_image_available)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .override(480, 300)

    Glide
        .with(this)
        .load(url)
        .apply(options)
        .into(this)
}

fun PhotoItemNetwork.getImageUrl(): String {
    return if(this.urlH != null && this.urlH != ""){
        this.urlH ?: ""
    } else if (this.urlO != null && this.urlO != "") {
        this.urlO ?: ""
    } else if (this.urlC != null && this.urlC != "") {
        this.urlC ?: ""
    } else {
        ""
    }
}

fun String.formatDate(): String {

    val onlyDateString = this.substring(0, 10)
    val oldFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val newFormatter = SimpleDateFormat("EEE dd yyyy", Locale.US)

    val date = oldFormatter.parse(onlyDateString)

    return newFormatter.format(date ?: Date())
}