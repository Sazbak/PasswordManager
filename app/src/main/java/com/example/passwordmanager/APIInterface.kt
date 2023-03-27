package com.example.passwordmanager

import com.example.passwordmanager.model.AccountsResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/af5beb947b7666a0a284")
    suspend fun getAccounts(): AccountsResponse
}