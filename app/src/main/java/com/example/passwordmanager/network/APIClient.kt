package com.example.passwordmanager.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIClient {
    private val retrofit: Retrofit

    init {
        val client = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.npoint.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val service: APIInterface = retrofit.create(APIInterface::class.java)
}