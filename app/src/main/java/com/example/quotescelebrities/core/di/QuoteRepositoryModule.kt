package com.example.quotescelebrities.core.di

import com.example.quotescelebrities.data.QuoteRepositoryImpl
import com.example.quotescelebrities.data.local.QuoteLocalDataSource
import com.example.quotescelebrities.data.local.QuoteLocalDataSourceImpl
import com.example.quotescelebrities.domain.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):
            QuoteLocalDataSource

}