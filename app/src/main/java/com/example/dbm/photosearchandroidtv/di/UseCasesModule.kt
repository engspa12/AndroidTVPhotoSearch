package com.example.dbm.photosearchandroidtv.di

import com.example.dbm.photosearchandroidtv.domain.repository.IPhotosRepository
import com.example.dbm.photosearchandroidtv.domain.usecase.GetPhotosBySearchTermUseCase
import com.example.dbm.photosearchandroidtv.domain.usecase.GetPhotosFromFeedUseCase
import com.example.dbm.photosearchandroidtv.domain.usecase.IGetPhotosBySearchTermUseCase
import com.example.dbm.photosearchandroidtv.domain.usecase.IGetPhotosFromFeedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideGetPhotosBySearchTermUseCase(
        photosRepository: IPhotosRepository
    ): IGetPhotosBySearchTermUseCase {
        return GetPhotosBySearchTermUseCase(photosRepository)
    }

    @Provides
    fun provideGetPhotosFromFeedUseCase(
        photosRepository: IPhotosRepository
    ): IGetPhotosFromFeedUseCase {
        return GetPhotosFromFeedUseCase(photosRepository)
    }
}