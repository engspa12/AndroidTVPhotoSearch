package com.example.dbm.photosearchandroidtv.presentation.view.grid

import android.view.ViewGroup
import android.widget.ImageView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView
import com.example.dbm.photosearchandroidtv.presentation.view.custom.CustomCardView
import com.example.dbm.photosearchandroidtv.util.loadUrl

class PhotosPresenter: Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(CustomCardView(parent.context))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val photoView = item as PhotoView
        with(viewHolder.view as CustomCardView){
            bind(photoView)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as CustomCardView){
            unbind()
        }
    }

}