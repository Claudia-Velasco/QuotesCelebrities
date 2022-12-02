package com.example.quotescelebrities.core.di

import com.example.quotescelebrities.data.UserRepositoryImpl
import com.example.quotescelebrities.data.remote.UserRemoteDataSource
import com.example.quotescelebrities.data.remote.UserRemoteDataSourceImpl
import com.example.quotescelebrities.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl):
            UserRepository

    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl):
            UserRemoteDataSource

}