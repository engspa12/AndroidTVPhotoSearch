package com.example.dbm.photosearchandroidtv.domain.usecase

import com.example.dbm.photosearchandroidtv.domain.repository.IPhotosRepository
import com.example.dbm.photosearchandroidtv.domain.mapper.toPhotoView
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView
import javax.inject.Inject

interface IGetPhotosBySearchTermUseCase {
    suspend operator fun invoke(searchTerm: String): List<PhotoView>
}

class GetPhotosBySearchTermUseCase @Inject constructor(
    private val photosRepository: IPhotosRepository
): IGetPhotosBySearchTermUseCase {

    override suspend fun invoke(searchTerm: String): List<PhotoView> {
       return photosRepository.getPhotosBySearchTerm(searchTerm).map {
           it.toPhotoView()
       }
    }
}