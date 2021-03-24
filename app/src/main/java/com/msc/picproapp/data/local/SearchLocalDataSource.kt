package com.msc.picproapp.data.local

import com.msc.picproapp.data.entity.Search
import java.util.*

interface SearchLocalDataSource {

    fun getRecentSearches(count: Int, searchesResult: GetLocalSearchesCallback)

    fun getRecentSearches(date: Date, searchesResult: GetLocalSearchesCallback)

    fun saveSearch(search: Search)

    interface GetLocalSearchesCallback {

        fun onSearchLocalLoaded()

    }
}