package com.example.quotescelebrities.data

import com.example.quotescelebrities.data.local.QuoteLocalDataSource
import com.example.quotescelebrities.data.model.QuoteResponse
import com.example.quotescelebrities.domain.QuoteRepository
import com.example.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepositoryImpl @Inject constructor
    (private val localDataSource: QuoteLocalDataSource) :
    QuoteRepository {

    override suspend fun getQuoteRandom(): Flow<QuoteModel> {
        return localDataSource.getQuoteRandom()
    }

    override suspend fun getQuote(quoteId: Int): Flow<QuoteModel> {
        return localDataSource.getQuote(quoteId)
    }

    override suspend fun getQuotes(): Flow<QuoteResponse?> {
        return localDataSource.getQuotes()
    }

    override suspend fun editQuote(quoteModel: QuoteModel) {
        return localDataSource.editQuote(quoteModel)
    }

    override suspend fun addQuote(quoteModel: QuoteModel) {
        return localDataSource.insert(quoteModel)
    }
}