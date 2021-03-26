package com.msc.picproapp.main

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface MainContract {
    interface View : BaseView<MainPresenter> {
        fun setSearchView()
        fun setArguments(argument: String)

    }

    interface Presenter: BasePresenter {
        fun queryReceived(word: String)
    }
}