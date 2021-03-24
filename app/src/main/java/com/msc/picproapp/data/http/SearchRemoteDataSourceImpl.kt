package com.msc.picproapp.data.http

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRemoteDataSourceImpl: SearchRemoteDataSource {
    private val clientId: String
        get() = "Client-ID iP4X7u5tebPdazJpIxoozupp8qJAdUIvg7fyDgBHooA"

    override fun searchImage(
        query: String,
        resultCallback: SearchRemoteDataSource.GetSearchResultCallback
    ) {
        val retrofitInstance = NetworkUtils.getRetrofitInstance("https://api.unsplash.com")
        val endPoint = retrofitInstance.create(APIService::class.java)
        val callback = endPoint.getImages(clientId, query)
        callback.enqueue(object : Callback<List<Photos>> {
            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                resultCallback.onDataNotAvailable()
            }

            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                resultCallback.onSearchResultLoaded(response.body().toString())
            }

        })
    }
}