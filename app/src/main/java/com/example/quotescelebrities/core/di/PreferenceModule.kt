package com.example.quotescelebrities.core.di

import com.example.quotescelebrities.data.PreferenceStorageImpl
import com.example.quotescelebrities.domain.PreferenceStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {
    @Binds
    abstract fun bindPreferenceStorage(preferenceStorageImpl: PreferenceStorageImpl):
            PreferenceStorage
}
