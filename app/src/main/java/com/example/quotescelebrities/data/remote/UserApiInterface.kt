package com.example.quotescelebrities.data.remote

import com.example.quotescelebrities.data.model.LoginRequest
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApiInterface {
    @Headers("Content-Type: application/json; charset=utf-8", "Accept: */*; charset=utf-8")
    @POST("api/v1/users/login")
    suspend fun login(@Body requestLogin: LoginRequest): JsonObject

}