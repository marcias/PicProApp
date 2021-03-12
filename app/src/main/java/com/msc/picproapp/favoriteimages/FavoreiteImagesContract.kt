package com.msc.picproapp.searchimage

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface FavoriteImagesContract {

    interface View : BaseView<Presenter> {
        fun showNoFavoriteImagesMessage()

    }

    interface Presenter: BasePresenter
}