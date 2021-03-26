package com.msc.picproapp.home

import com.msc.picproapp.R

class HomePresenter(private val homeView: HomeContract.View) : HomeContract.Presenter {

    init {
        homeView.presenter = this
    }

    override fun argumentSet(query: String) {
        homeView.navigateTo(R.id.search_result_image, query)
    }

    override fun start() {
        homeView.setViewModelObserver()
    }
}