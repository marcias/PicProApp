package com.msc.picproapp.data.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {
        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder().baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}