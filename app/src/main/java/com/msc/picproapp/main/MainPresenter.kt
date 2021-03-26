package com.msc.picproapp.main

import com.msc.picproapp.data.SearchRepository

class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {

    init {
        mainView.presenter = this
    }

    lateinit var searchRepository: SearchRepository

    override fun queryReceived(query: String) {
        //chamar méotodo setarguments onde enviará query para fragment

        mainView.setArguments(query)
    }

    override fun start() {
       mainView.setSearchView()
    }


}