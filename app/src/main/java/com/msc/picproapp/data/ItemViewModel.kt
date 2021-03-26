package com.msc.picproapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val mutableArgument = MutableLiveData<String>()
    val argument: LiveData<String> get() = mutableArgument

    fun argument(argument: String) {
        mutableArgument.value = argument
    }
}