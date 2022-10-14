package com.example.dbm.photosearchandroidtv.presentation.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.BaseCardView
import com.example.dbm.photosearchandroidtv.R
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView
import com.example.dbm.photosearchandroidtv.util.loadUrl

class CustomCardView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
    : BaseCardView(context, attrs, defStyleAttr) {

    var mTextView: TextView? = null
    var mImageView: ImageView? = null

    init {
        isFocusable = true
        isFocusableInTouchMode = true
        val root = LayoutInflater.from(context).inflate(R.layout.custom_card_view, this)
        mTextView = root.findViewById(R.id.card_title_author_date_tv) as TextView
        mImageView = root.findViewById(R.id.card_background_image) as ImageView
    }

    constructor(context: Context): this(context, null, 0){

    }

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0){

    }

    fun bind(photoView: PhotoView){
        mTextView?.text = context.getString(R.string.card_text, photoView.title , photoView.author, photoView.date)
        mImageView?.loadUrl(photoView.imgUrl)
    }

    fun unbind() {
        mImageView?.setImageDrawable(null)
    }
}