package com.msc.picproapp.data.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("search/photos")
    fun getImages( @Query("query") query: String, @Query("client_id") token: String, @Query("per_page") sizePage: Int): Call<Photos>
}