package com.example.dbm.photosearchandroidtv.presentation.state

import com.example.dbm.photosearchandroidtv.util.ErrorMessage
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView

data class PhotosUIState(
    val errorPresent: Boolean = false,
    val errorMessage: ErrorMessage? = null,
    val listPhotos: List<PhotoView> = listOf(),
)