package com.msc.picproapp.main

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface MainContract {
    interface View : BaseView<Presenter> {


    }

    interface Presenter: BasePresenter
}