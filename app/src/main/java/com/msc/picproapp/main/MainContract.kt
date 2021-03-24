package com.msc.picproapp.main

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface MainContract {
    interface View : BaseView<MainPresenter> {
        fun navigateTo(resId: Int)
        fun setArguments()

    }

    interface Presenter: BasePresenter {
        fun startSearch(word: String)
    }
}