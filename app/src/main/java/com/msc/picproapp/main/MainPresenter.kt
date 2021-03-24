package com.msc.picproapp.main

import android.util.Log
import com.msc.picproapp.data.SearchRepository
import com.msc.picproapp.data.http.SearchRemoteDataSource.GetSearchResultCallback
import com.msc.picproapp.data.http.SearchRemoteDataSourceImpl

class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {

    lateinit var searchRepository: SearchRepository

    override fun startSearch(query: String) {
        Log.v("MainPresenter", ">> starSearch $query")
        searchRepository = SearchRepository.getInstance(SearchRemoteDataSourceImpl())
        searchRepository.searchImage(query, object : GetSearchResultCallback {
            override fun onSearchResultLoaded(result: String) {
                Log.v("MainPresenter", ">> onResponse $result")

            }

            override fun onDataNotAvailable() {
                Log.v("MainPresenter", ">> onFailure")

            }

        })
    }

    override fun start() {
        //get recent search info
        //get saved search info
    }

    init {
        mainView.presenter = this
    }


}