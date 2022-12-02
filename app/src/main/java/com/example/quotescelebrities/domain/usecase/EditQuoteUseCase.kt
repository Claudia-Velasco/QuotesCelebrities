package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.domain.QuoteRepository
import com.example.quotescelebrities.domain.model.QuoteModel
import javax.inject.Inject

class EditQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun editQuote(quoteModel: QuoteModel) =
        quoteRepository.editQuote(quoteModel)

}
