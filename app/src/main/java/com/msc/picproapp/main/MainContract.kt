package com.msc.picproapp.main

import androidx.fragment.app.Fragment
import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface MainContract {
    interface View : BaseView<Presenter> {
        fun changeFragment(fragment: Fragment)

    }

    interface Presenter: BasePresenter {
        fun startSearch()
    }
}