package com.example.dbm.photosearchandroidtv.presentation.view.grid

import android.view.ViewGroup
import android.widget.ImageView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView
import com.example.dbm.photosearchandroidtv.util.loadUrl

class PhotosPresenter: Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(580, 320)
        }

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val photoView = item as PhotoView
        with(viewHolder.view as ImageCardView){
            titleText = photoView.title
            contentText = "${photoView.author} / ${photoView.date}"
            mainImageView.loadUrl(photoView.imgUrl)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as ImageCardView){
            mainImage = null
        }
    }

}