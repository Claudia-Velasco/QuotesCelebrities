package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.data.model.QuoteResponse
import com.example.quotescelebrities.domain.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuotes(): Flow<QuoteResponse?> = quoteRepository.getQuotes()

}