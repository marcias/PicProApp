package com.msc.picproapp.data.http

import android.util.Log
import com.msc.picproapp.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRemoteDataSourceImpl : SearchRemoteDataSource {
    private val clientId: String
        get() = "iP4X7u5tebPdazJpIxoozupp8qJAdUIvg7fyDgBHooA"

    override fun searchImage(
        query: String,
        resultCallback: SearchRemoteDataSource.GetSearchResultCallback
    ) {
        val retrofitInstance = NetworkUtils.getRetrofitInstance(Constants.API_UNSPLASH_ENDPOINT)
        val endPoint = retrofitInstance.create(APIService::class.java)
        val callback = endPoint.getImages(query, clientId, 30)
        val request = callback.request().url().toString()
        Log.v("SearchDataSourceImpl",">>request $request")
        callback.enqueue(object : Callback<Photos> {
            override fun onFailure(call: Call<Photos>, t: Throwable) {
                resultCallback.onFailure(t)
            }

            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                var photos = response.body()
                if (photos != null) {
                    resultCallback.onSearchResultLoaded(photos)
                } else {
                    resultCallback.onDataNotAvailable()
                }
            }

        })
    }
}