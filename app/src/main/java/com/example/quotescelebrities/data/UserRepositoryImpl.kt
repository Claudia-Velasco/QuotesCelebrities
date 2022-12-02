package com.example.quotescelebrities.data

import com.example.quotescelebrities.data.model.LoginRequest
import com.example.quotescelebrities.data.remote.UserLoginResponse
import com.example.quotescelebrities.data.remote.UserRemoteDataSource
import com.example.quotescelebrities.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>? {
        val userLoginResponse =
            try {
                userRemoteDataSource.login(loginRequest)
            } catch (ex: Exception) {
                val message = if (ex.message!!.contains("HTTP 422", ignoreCase = false))
                    "Cuenta o password incorrecto"
                else
                    "" + ex.message
                val userLoginResponse = UserLoginResponse(
                    success = false, message =
                    message, data = ""
                )

                return flow { emit(userLoginResponse) }

            }

        return userLoginResponse
    }
}