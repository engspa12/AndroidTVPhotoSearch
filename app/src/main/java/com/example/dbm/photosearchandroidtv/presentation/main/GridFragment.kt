package com.example.dbm.photosearchandroidtv.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.VerticalGridPresenter
import androidx.lifecycle.lifecycleScope
import com.example.dbm.photosearchandroidtv.R
import com.example.dbm.photosearchandroidtv.data.datasource.RemoteConnection
import com.example.dbm.photosearchandroidtv.domain.toPhotoItemDomain
import kotlinx.coroutines.launch

class GridFragment: VerticalGridSupportFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.app_title)
        badgeDrawable = ResourcesCompat.getDrawable(resources, R.drawable.badge_grid, null)

        setupGridPresenter()
        setSearchListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter = ArrayObjectAdapter(PhotoItemPresenter())
        adapter = arrayAdapter

        if(activity?.intent?.hasExtra(PhotosSearchFragment.SEARCH_TERM) == true){
            Log.e("GridFragment", "Intent comes from PhotosSearchFragment")
            val searchTerm = activity?.intent?.getStringExtra(PhotosSearchFragment.SEARCH_TERM) ?: ""
            performPhotosSearch(searchTerm, arrayAdapter)
        } else {
            Log.e("GridFragment", "Intent comes from App startup")
            loadPhotosFromFeed(arrayAdapter)
        }
    }

    private fun setupGridPresenter(){
        val gridPresenter = VerticalGridPresenter()
        gridPresenter.numberOfColumns = 3
        setGridPresenter(gridPresenter)
    }

    private fun setSearchListener(){
        setOnSearchClickedListener { view ->
            val intent = Intent(requireActivity(), SearchActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun performPhotosSearch(searchTerm: String, arrayAdapter: ArrayObjectAdapter){
        viewLifecycleOwner.lifecycleScope.launch {
            val photos = RemoteConnection.remoteAPI.getPhotosBySearchTerm(searchTerm = searchTerm)
                .photosGroupNetwork
                .photos
                .map {
                    it.toPhotoItemDomain()
                }

            arrayAdapter.addAll(0, photos)
        }
    }

    private fun loadPhotosFromFeed(arrayAdapter: ArrayObjectAdapter){
        viewLifecycleOwner.lifecycleScope.launch {
            val photos = RemoteConnection.remoteAPI.getPhotosFromFeed()
                .photosGroupNetwork
                .photos
                .map {
                    it.toPhotoItemDomain()
                }

            arrayAdapter.addAll(0, photos)
        }
    }
}

