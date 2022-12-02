package com.example.quotescelebrities.data.remote

import com.example.quotescelebrities.data.model.LoginRequest
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>
}
