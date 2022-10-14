package com.example.dbm.photosearchandroidtv.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.SearchOrbView
import androidx.leanback.widget.TitleViewAdapter
import com.example.dbm.photosearchandroidtv.R

class CustomTitleView(context: Context, attrs: AttributeSet?, defStyle: Int): RelativeLayout(context, attrs, defStyle), TitleViewAdapter.Provider  {

    var mTitleView: TextView? = null
    var mBadgeView: ImageView? = null
    var mOrbView: SearchOrbView? = null

    private var mTitleViewAdapter: TitleViewAdapter = object : TitleViewAdapter() {

        override fun getSearchAffordanceView(): View? {
            return null
        }

        override fun setTitle(titleText: CharSequence?) {
            this@CustomTitleView.setTitle(titleText)
        }

        override fun setBadgeDrawable(drawable: Drawable?) {
            this@CustomTitleView.setBadgeDrawable(drawable)
        }

        override fun setOnSearchClickedListener(listener: OnClickListener?) {
            this@CustomTitleView.setOnSearchClickedListener(listener)
        }

        override fun updateComponentsVisibility(flags: Int) {
            //super.updateComponentsVisibility(flags)
        }

        private fun updateBadgeVisibility(visible:Boolean) {
            if (visible) {
                mTitleView?.visibility = View.VISIBLE
            } else {
                mTitleView?.visibility = View.GONE
            }
        }

    }

    init {
        val root  = LayoutInflater.from(context).inflate(R.layout.custom_title_view, this)
        mTitleView = root.findViewById(R.id.title_tv) as TextView
        mBadgeView = root.findViewById(R.id.badge_iv) as ImageView
        mOrbView = root.findViewById(R.id.search_orb_view) as SearchOrbView
    }

    constructor (context: Context): this(context, null, 0) {

    }

    constructor (context: Context, attrs: AttributeSet?): this(context, attrs, 0) {

    }

    fun setTitle(title: CharSequence?) {
        if (title != null) {
            mTitleView?.text = title
            mTitleView?.visibility = View.VISIBLE
        }
    }

    fun setBadgeDrawable(drawable: Drawable?) {
        if (drawable != null) {
            mBadgeView?.setImageDrawable(drawable)
            mBadgeView?.visibility = View.VISIBLE
        }
    }

    fun setOnSearchClickedListener(listener: OnClickListener?) {
        if(listener != null){
            mOrbView?.setOnClickListener(listener)
            mOrbView?.visibility = View.VISIBLE
            mOrbView?.orbColors = SearchOrbView.Colors(
                ContextCompat.getColor(context, R.color.background_orb)
            )
        }
    }

    override fun getTitleViewAdapter(): TitleViewAdapter {
        return mTitleViewAdapter
    }
}