package com.example.dbm.photosearchandroidtv.util

import androidx.annotation.StringRes

data class UserMessage(
    @StringRes val userMessageResource: Int = 0,
    val dataForResource: String? = null
)