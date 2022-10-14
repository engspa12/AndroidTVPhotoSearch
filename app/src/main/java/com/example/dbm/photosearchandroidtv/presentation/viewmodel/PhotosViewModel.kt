package com.example.dbm.photosearchandroidtv.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dbm.photosearchandroidtv.R
import com.example.dbm.photosearchandroidtv.di.DispatchersModule
import com.example.dbm.photosearchandroidtv.domain.usecase.IGetPhotosBySearchTermUseCase
import com.example.dbm.photosearchandroidtv.domain.usecase.IGetPhotosFromFeedUseCase
import com.example.dbm.photosearchandroidtv.util.UserMessage
import com.example.dbm.photosearchandroidtv.presentation.state.PhotosUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosFromFeedUseCase: IGetPhotosFromFeedUseCase,
    private val getPhotosBySearchTermUseCase: IGetPhotosBySearchTermUseCase,
    @DispatchersModule.MainDispatcher private val mainDispatcher: CoroutineDispatcher
): ViewModel() {

    private val _uiState = MutableStateFlow(PhotosUIState())
    val uiState: StateFlow<PhotosUIState> = _uiState

    private var fetchJob: Job? = null

    fun getPhotosBySearchTerm(searchTerm: String) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(mainDispatcher) {
            try {
                val result = getPhotosBySearchTermUseCase(searchTerm = searchTerm)
                _uiState.update {
                    if(result.isEmpty()){
                        it.copy(listPhotos = result, resultListEmpty = true, errorPresent = false, userMessage = UserMessage(R.string.no_search_results_for, searchTerm))
                    } else {
                        it.copy(listPhotos = result, resultListEmpty = false, errorPresent = false, userMessage = UserMessage(R.string.search_results_for, searchTerm))
                    }
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(errorPresent = true, userMessage = UserMessage(R.string.error_message))
                }
            }
        }
    }

    fun getPhotosFromFeed() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(mainDispatcher) {
            try {
                val result = getPhotosFromFeedUseCase()
                _uiState.update {
                    it.copy(listPhotos = result)
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(errorPresent = true, userMessage = UserMessage(R.string.error_message))
                }
            }
        }
    }

}