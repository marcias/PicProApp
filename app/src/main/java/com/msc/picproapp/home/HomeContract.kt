package com.msc.picproapp.home

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface HomeContract {

    interface View : BaseView<HomePresenter> {
        fun navigateTo(resId: Int, argument: String)
        fun setViewModelObserver()
    }

    interface Presenter : BasePresenter {
        fun argumentSet(query: String)
    }

}