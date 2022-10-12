package com.example.dbm.photosearchandroidtv.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.dbm.photosearchandroidtv.R

class SearchActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}