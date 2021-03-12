package com.msc.picproapp.imagedetail

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface ImageDetailsContract {
    interface View : BaseView<Presenter> {


    }

    interface Presenter: BasePresenter
}