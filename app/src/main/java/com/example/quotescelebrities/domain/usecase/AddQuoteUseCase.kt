package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.domain.QuoteRepository
import com.example.quotescelebrities.domain.model.QuoteModel
import javax.inject.Inject

class AddQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun addQuote(quoteModel: QuoteModel) = quoteRepository.addQuote(quoteModel)

}