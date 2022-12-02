package com.example.quotescelebrities.data.local

import com.example.quotescelebrities.data.model.QuoteResponse
import com.example.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteLocalDataSource {
    suspend fun getQuotes(): Flow<QuoteResponse>
    fun getQuote(quoteId: Int): Flow<QuoteModel>
    fun getQuoteRandom(): Flow<QuoteModel>

    suspend fun insertAll(quotes: List<QuoteModel>)
    suspend fun insert(quoteModel: QuoteModel)
    suspend fun editQuote(quoteModel: QuoteModel)
}