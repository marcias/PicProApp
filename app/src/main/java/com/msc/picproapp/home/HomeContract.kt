package com.msc.picproapp.home

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {


    }

    interface Presenter: BasePresenter

}