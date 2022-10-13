package com.example.dbm.photosearchandroidtv.di

import com.example.dbm.photosearchandroidtv.data.datasource.RemoteAPI
import com.example.dbm.photosearchandroidtv.data.repository.PhotosRepository
import com.example.dbm.photosearchandroidtv.domain.repository.IPhotosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePhotosRepository(
        networkDataSource: RemoteAPI,
        @DispatchersModule.IODispatcher dispatcher: CoroutineDispatcher
    ): IPhotosRepository {
        return PhotosRepository(networkDataSource, dispatcher)
    }
}