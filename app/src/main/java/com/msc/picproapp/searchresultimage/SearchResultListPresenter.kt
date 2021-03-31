package com.msc.picproapp.searchresultimage

import android.util.Log
import com.msc.picproapp.data.SearchRepository
import com.msc.picproapp.data.http.Photo
import com.msc.picproapp.data.http.Photos
import com.msc.picproapp.data.http.SearchRemoteDataSource
import com.msc.picproapp.data.http.SearchRemoteDataSourceImpl

class SearchResultListPresenter(private val searchResultView: SearchResultListContract.View) : SearchResultListContract.Presenter {

    init {
        searchResultView.presenter = this
    }

    override fun startSearch(query: String) {
        val searchRepository = SearchRepository.getInstance(SearchRemoteDataSourceImpl())
        searchRepository.searchImage(query, object : SearchRemoteDataSource.GetSearchResultCallback {
            override fun onSearchResultLoaded(result: Photos) {
                searchResultView.setProgress(false)
                searchResultView.updateResultLabel(result.total)
                searchResultView.initList(result.results)
            }

            override fun onDataNotAvailable() {
                searchResultView.showDataMessage(true)
            }

            override fun onFailure(t: Throwable) {
                Log.e("SearchResultListPresenter", "Error: $t.cause")
                searchResultView.showDataMessage(true)
            }

        })
    }

    override fun start() {
        searchResultView.getArgs()
    }
}