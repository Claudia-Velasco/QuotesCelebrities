package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.domain.QuoteRepository
import com.example.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteAddUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    // suspend fun getQuote(quoteId: Int): Flow<QuoteModel> = quoteRepository.getQuote(quoteId)
    suspend fun addQuote(quoteModel: QuoteModel) = quoteRepository.addQuote(quoteModel)

}