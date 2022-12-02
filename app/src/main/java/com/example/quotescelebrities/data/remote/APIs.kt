package com.example.quotescelebrities.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET

interface APIs {
    @GET("api/v1/quotes")
    suspend fun getQuotes(): JsonObject
}