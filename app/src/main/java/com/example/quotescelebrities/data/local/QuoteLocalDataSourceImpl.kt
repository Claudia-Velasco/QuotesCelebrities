package com.example.quotescelebrities.data.local

import com.example.quotescelebrities.core.utils.toEntity
import com.example.quotescelebrities.core.utils.toListQuoteModel
import com.example.quotescelebrities.core.utils.toQuoteModel
import com.example.quotescelebrities.data.local.daos.QuoteDao
import com.example.quotescelebrities.data.model.QuoteResponse
import com.example.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class QuoteLocalDataSourceImpl @Inject constructor(private val quoteDao: QuoteDao) :
    QuoteLocalDataSource {
    override suspend fun getQuotes(): Flow<QuoteResponse> {
        val quotesEntity = quoteDao.getQuotes()
        val data = quotesEntity.map { it.toListQuoteModel() }
        val quotesModel = data.first()
        return flow { emit(QuoteResponse(true, "list quotes", quotesModel)) }
    }

    override fun getQuote(quoteId: Int): Flow<QuoteModel> {
        return quoteDao.getQuote(quoteId).map { it.toQuoteModel() }
    }

    override fun getQuoteRandom(): Flow<QuoteModel> {
        return quoteDao.getQuoteRandom().map { it.toQuoteModel() }
    }

    override suspend fun insertAll(quotes: List<QuoteModel>) {
        quoteDao.insertAll(quotes.map { it.toEntity() })
    }

    override suspend fun insert(quoteModel: QuoteModel) {
        quoteDao.insert(quoteModel.toEntity())
    }

    override suspend fun editQuote(quoteModel: QuoteModel) {
        quoteDao.updateQuote(quoteModel.toEntity())
    }
}