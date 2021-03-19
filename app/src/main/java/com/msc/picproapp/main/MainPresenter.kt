package com.msc.picproapp.main

class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {
    override fun startSearch() {
        TODO("Not yet implemented")
    }

    override fun start() {
        //get recent search info
        //get saved search info
    }

    init {
        mainView.presenter = this
    }


}