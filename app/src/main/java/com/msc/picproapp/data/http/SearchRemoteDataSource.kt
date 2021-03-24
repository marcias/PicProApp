package com.msc.picproapp.data.http

interface SearchRemoteDataSource {

    fun searchImage(word: String, callback: GetSearchResultCallback)

    interface GetSearchResultCallback {

        fun onSearchResultLoaded(result: String)

        fun onDataNotAvailable()

    }
}