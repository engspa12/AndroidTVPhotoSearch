package com.example.dbm.photosearchandroidtv.domain.repository

import com.example.dbm.photosearchandroidtv.domain.model.PhotoDomain

interface IPhotosRepository {
    suspend fun getPhotosFromFeed(): List<PhotoDomain>
    suspend fun getPhotosBySearchTerm(searchTerm: String): List<PhotoDomain>
}