package com.example.dbm.photosearchandroidtv.presentation.main

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.dbm.photosearchandroidtv.domain.PhotoItemDomain
import com.example.dbm.photosearchandroidtv.util.loadUrl

class PhotoItemPresenter: Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(580, 300)
        }

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val photoItemDomain = item as PhotoItemDomain
        with(viewHolder.view as ImageCardView){
            titleText = photoItemDomain.title
            contentText = "${photoItemDomain.author} / ${photoItemDomain.date}"

            mainImageView.loadUrl(photoItemDomain.imgUrl)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as ImageCardView){
            mainImage = null
        }
    }

}