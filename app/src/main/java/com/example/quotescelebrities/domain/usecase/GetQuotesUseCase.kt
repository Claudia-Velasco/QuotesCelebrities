package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.data.remote.QuoteApiResponse
import com.example.quotescelebrities.domain.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuotes(token: String): Flow<QuoteApiResponse?> = quoteRepository.getQuotes(token)

}