package com.msc.picproapp.searchresultimage

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface SearchResultImageContract {

    interface View : BaseView<SearchResultImagePresenter> {
        fun setProgress(visible: Boolean)
        fun showNoDataMessage()
        fun getArgs()
    }

    interface Presenter : BasePresenter {
        fun startSearch(query: String)
    }

}