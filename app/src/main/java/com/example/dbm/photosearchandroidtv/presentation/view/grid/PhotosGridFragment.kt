package com.example.dbm.photosearchandroidtv.presentation.view.grid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.VerticalGridPresenter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.dbm.photosearchandroidtv.R
import com.example.dbm.photosearchandroidtv.presentation.view.search.PhotosSearchActivity
import com.example.dbm.photosearchandroidtv.presentation.view.search.PhotosSearchFragment
import com.example.dbm.photosearchandroidtv.presentation.viewmodel.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhotosGridFragment: VerticalGridSupportFragment() {

    private val viewModel: PhotosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.app_title)
        badgeDrawable = ResourcesCompat.getDrawable(resources, R.drawable.badge_grid, null)

        val arrayAdapter = ArrayObjectAdapter(PhotosPresenter())
        adapter = arrayAdapter

        setupGridPresenter()
        setSearchListener()
        setObservers(arrayAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity?.intent?.hasExtra(PhotosSearchFragment.SEARCH_TERM) == true){
            val searchTerm = activity?.intent?.getStringExtra(PhotosSearchFragment.SEARCH_TERM) ?: ""
            title = getString(R.string.search_results_for, searchTerm)
            searchPhotos(searchTerm)
        } else {
            loadPhotosFromFeed()
        }
    }

    private fun setupGridPresenter(){
        val gridPresenter = VerticalGridPresenter()
        gridPresenter.numberOfColumns = 3
        setGridPresenter(gridPresenter)
    }

    private fun setSearchListener(){
        setOnSearchClickedListener { _ ->
            val intent = Intent(requireActivity(), PhotosSearchActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun setObservers(arrayAdapter: ArrayObjectAdapter) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    arrayAdapter.addAll(0, uiState.listPhotos)
                    if(uiState.resultListEmpty){
                        title = getString(uiState.userMessage.userMessageResource, uiState.userMessage.dataForResource)
                    }
                }
            }
        }
    }

    private fun searchPhotos(searchTerm: String){
        viewModel.getPhotosBySearchTerm(searchTerm)
    }

    private fun loadPhotosFromFeed(){
        viewModel.getPhotosFromFeed()
    }
}

