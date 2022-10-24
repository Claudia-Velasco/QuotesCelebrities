package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.domain.QuoteRepository
import javax.inject.Inject

class GetAllQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend fun getAllQuote() = quoteRepository.getAllQuote()
}