package com.example.dbm.photosearchandroidtv.presentation.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import androidx.leanback.app.SearchSupportFragment
import androidx.leanback.widget.*

class PhotosSearchFragment: SearchSupportFragment(), SearchSupportFragment.SearchResultProvider {

    private val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

    companion object {
        const val SEARCH_TERM = "search_term"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSearchResultProvider(this)
        setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            Log.e("PhotosSearchFragment", "Inside click listener")
        }
    }

    override fun getResultsAdapter(): ObjectAdapter {
        return rowsAdapter
    }

    override fun onQueryTextChange(newQuery: String?): Boolean {
        rowsAdapter.clear()
        Log.e("PhotosSearchFragment", "The text change is $newQuery")
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        rowsAdapter.clear()
        Log.e("PhotosSearchFragment", "The text submitted is $query")
        val intent = Intent(requireActivity(), GridActivity::class.java).apply {
            putExtra(SEARCH_TERM, query)
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
        requireActivity().finish()
        return true
    }
}