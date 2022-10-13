package com.example.dbm.photosearchandroidtv.domain.usecase

import com.example.dbm.photosearchandroidtv.domain.repository.IPhotosRepository
import com.example.dbm.photosearchandroidtv.domain.mapper.toPhotoView
import com.example.dbm.photosearchandroidtv.presentation.model.PhotoView
import javax.inject.Inject

interface IGetPhotosFromFeedUseCase {
    suspend operator fun invoke(): List<PhotoView>
}

class GetPhotosFromFeedUseCase @Inject constructor(
    private val photosRepository: IPhotosRepository
): IGetPhotosFromFeedUseCase {

    override suspend fun invoke(): List<PhotoView> {
        return photosRepository.getPhotosFromFeed().map {
            it.toPhotoView()
        }
    }

}