package com.example.dbm.photosearchandroidtv.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.lifecycleScope
import com.example.dbm.photosearchandroidtv.R
import com.example.dbm.photosearchandroidtv.data.datasource.RemoteConnection
import com.example.dbm.photosearchandroidtv.domain.toPhotoItemDomain
import kotlinx.coroutines.launch

class MainFragment: BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var appTitle = getString(R.string.app_title)
        appTitle = appTitle.uppercase()

        title = appTitle

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        viewLifecycleOwner.lifecycleScope.launch {

            val photos = RemoteConnection.remoteAPI.getPhotosFromFeed()
                .photosGroupNetwork
                .photos
                .map {
                    it.toPhotoItemDomain()
            }

            (1..5).forEach { categoryId ->
                val categoryTitle = "Category $categoryId"

                val listRowAdapter = ArrayObjectAdapter(CardPresenter())

                listRowAdapter.addAll(0,
                    photos
                    /*(1..10).map {
                        PhotoItemDomain(
                            title = "Title $it",
                            date = "11-10-2022",
                            author = "Author $it",
                            imgUrl = "https://loremflickr.com/176/313/cat?lock=$it"
                        )
                    }*/
                )

                val headerItem = HeaderItem(categoryId.toLong(), categoryTitle)
                rowsAdapter.add(ListRow(headerItem, listRowAdapter))

            }

            adapter = rowsAdapter

        }

        setOnSearchClickedListener { view ->
            Toast.makeText(requireActivity(), "Implement your own in-app search", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //headersState = HEADERS_DISABLED
    }
}

