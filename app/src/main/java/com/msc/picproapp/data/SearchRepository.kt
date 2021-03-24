package com.msc.picproapp.data

import com.msc.picproapp.data.entity.Search
import com.msc.picproapp.data.http.SearchRemoteDataSource
import com.msc.picproapp.data.local.SearchLocalDataSource
import java.util.*

class SearchRepository(private val searchRemoteDataSource: SearchRemoteDataSource) :
    SearchLocalDataSource, SearchRemoteDataSource {

    override fun getRecentSearches(
        count: Int,
        searchesResult: SearchLocalDataSource.GetLocalSearchesCallback
    ) {
        TODO("Not yet implemented")
    }

    override fun getRecentSearches(
        date: Date,
        searchesResult: SearchLocalDataSource.GetLocalSearchesCallback
    ) {
        TODO("Not yet implemented")
    }

    override fun saveSearch(search: Search) {
        TODO("Not yet implemented")
    }

    override fun searchImage(
        query: String,
        resultCallback: SearchRemoteDataSource.GetSearchResultCallback
    ) {
        searchRemoteDataSource.searchImage(query, resultCallback)
    }

    companion object {
        private var INSTANCE: SearchRepository? = null
        @JvmStatic
        fun getInstance(searchRemoteDataSource: SearchRemoteDataSource): SearchRepository {
            return INSTANCE ?: SearchRepository(searchRemoteDataSource).apply { INSTANCE = this }
        }

    }
}