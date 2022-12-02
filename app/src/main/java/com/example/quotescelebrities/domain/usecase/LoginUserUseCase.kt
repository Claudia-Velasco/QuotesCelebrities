package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.data.model.LoginRequest
import com.example.quotescelebrities.data.remote.UserLoginResponse
import com.example.quotescelebrities.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>? =
        userRepository.login(loginRequest)
}
