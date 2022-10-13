package com.example.dbm.photosearchandroidtv.presentation.view.search

import android.content.Intent
import android.os.Bundle
import androidx.leanback.app.SearchSupportFragment
import androidx.leanback.widget.*
import com.example.dbm.photosearchandroidtv.presentation.view.grid.PhotosGridActivity

class PhotosSearchFragment: SearchSupportFragment(), SearchSupportFragment.SearchResultProvider {

    private val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

    companion object {
        const val SEARCH_TERM = "search_term"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSearchResultProvider(this)
    }

    override fun getResultsAdapter(): ObjectAdapter {
        return rowsAdapter
    }

    override fun onQueryTextChange(newQuery: String?): Boolean {
        rowsAdapter.clear()
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        rowsAdapter.clear()
        val intent = Intent(requireActivity(), PhotosGridActivity::class.java).apply {
            putExtra(SEARCH_TERM, query)
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
        requireActivity().finish()
        return true
    }
}