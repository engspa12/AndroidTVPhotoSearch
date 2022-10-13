package com.example.dbm.photosearchandroidtv.presentation.view.grid

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.dbm.photosearchandroidtv.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosGridActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
    }
}