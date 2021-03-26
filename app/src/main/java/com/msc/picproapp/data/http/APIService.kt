package com.msc.picproapp.data.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {

    @GET("photos")
    fun getImages(@Header("Authorization") token: String, @Query("query") query: String): Call<List<Photos>>
}