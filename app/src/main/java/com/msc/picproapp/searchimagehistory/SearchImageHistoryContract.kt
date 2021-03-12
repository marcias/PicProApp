package com.msc.picproapp.searchimagehistory

import com.msc.picproapp.BasePresenter
import com.msc.picproapp.BaseView

interface SearchImageHistoryContract {

    interface View : BaseView<Presenter> {
        fun showNoSearchLayout()
        fun showNoSavedSearchesMessage()
    }

    interface Presenter : BasePresenter

}