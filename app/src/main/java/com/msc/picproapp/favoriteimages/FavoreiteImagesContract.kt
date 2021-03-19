package com.msc.picproapp.searchresultimage

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface FavoriteImagesContract {

    interface View : BaseView<Presenter> {
        fun showNoFavoriteImagesMessage()

    }

    interface Presenter: BasePresenter
}