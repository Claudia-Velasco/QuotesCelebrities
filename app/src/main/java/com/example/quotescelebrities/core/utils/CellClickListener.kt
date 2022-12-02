package com.example.quotescelebrities.core.utils

import com.example.quotescelebrities.domain.model.QuoteModel

interface CellClickListener {
    fun onCellClickListener(quoteModel: QuoteModel)
}