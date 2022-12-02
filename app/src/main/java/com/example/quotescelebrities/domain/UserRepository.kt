package com.example.quotescelebrities.domain

import com.example.quotescelebrities.data.model.LoginRequest
import com.example.quotescelebrities.data.remote.UserLoginResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>?

}