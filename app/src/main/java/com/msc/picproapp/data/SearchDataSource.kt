package com.msc.picproapp.data

import com.msc.picproapp.data.entity.Search
import java.util.*

interface SearchDataSource {

    fun getRecentSearches(count: Int): List<Search>
    fun getRecentSearches(date: Date): List<Search>
    fun saveSearch(search: Search)
}