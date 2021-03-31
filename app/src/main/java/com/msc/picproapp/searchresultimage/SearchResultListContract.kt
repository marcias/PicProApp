package com.msc.picproapp.searchresultimage

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView
import com.msc.picproapp.data.http.Photo

interface SearchResultListContract {

    interface View : BaseView<SearchResultListPresenter> {
        fun initList(photos: List<Photo>)
        fun setProgress(visible: Boolean)
        fun showDataMessage(visible: Boolean)
        fun getArgs()
        fun updateResultLabel(result: Int)
    }

    interface Presenter : BasePresenter {
        fun startSearch(query: String)
    }

}