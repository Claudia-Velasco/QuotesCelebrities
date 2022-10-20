package com.example.quotescelebrities.domain.usecase

import com.example.quotescelebrities.domain.QuoteRepository
import com.example.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()

}