package com.msc.picproapp.searchresultimage

import android.util.Log
import com.msc.picproapp.data.SearchRepository
import com.msc.picproapp.data.http.SearchRemoteDataSource
import com.msc.picproapp.data.http.SearchRemoteDataSourceImpl

class SearchResultImagePresenter(private val searchResultView: SearchResultImageContract.View) : SearchResultImageContract.Presenter {

    init {
        searchResultView.presenter = this
    }

    override fun startSearch(query: String) {
        val searchRepository = SearchRepository.getInstance(SearchRemoteDataSourceImpl())
        searchRepository.searchImage(query, object : SearchRemoteDataSource.GetSearchResultCallback {
            override fun onSearchResultLoaded(result: String) {
                Log.v("MainPresenter", ">> onResponse $result")

            }

            override fun onDataNotAvailable() {
                Log.v("MainPresenter", ">> onFailure")

            }

        })
    }

    override fun start() {
        searchResultView.getArgs()
    }
}