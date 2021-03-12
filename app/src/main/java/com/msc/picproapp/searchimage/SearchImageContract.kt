package com.msc.picproapp.searchimage

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface SearchImageContract {

    interface View : BaseView<Presenter> {


    }

    interface Presenter: BasePresenter
}