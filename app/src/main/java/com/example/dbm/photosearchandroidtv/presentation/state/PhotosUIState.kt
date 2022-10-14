package com.example.dbm.photosearchandroidtv.presentation.state

import com.example.dbm.photosearchandroidtv.util.MessageWrapper
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView

data class PhotosUIState(
    val errorPresent: Boolean = false,
    val messageWrapper: MessageWrapper = MessageWrapper(),
    val resultListEmpty: Boolean = false,
    val listPhotos: List<PhotoView> = listOf(),
)