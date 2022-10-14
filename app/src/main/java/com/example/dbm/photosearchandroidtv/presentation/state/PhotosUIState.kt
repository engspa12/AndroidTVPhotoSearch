package com.example.dbm.photosearchandroidtv.presentation.state

import com.example.dbm.photosearchandroidtv.util.UserMessage
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView

data class PhotosUIState(
    val errorPresent: Boolean = false,
    val userMessage: UserMessage = UserMessage(),
    val resultListEmpty: Boolean = false,
    val listPhotos: List<PhotoView> = listOf(),
)