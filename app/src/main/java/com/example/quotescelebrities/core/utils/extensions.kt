package com.example.quotescelebrities.core.utils

import com.example.quotescelebrities.data.local.entities.QuoteEntity
import com.example.quotescelebrities.domain.model.QuoteModel

fun QuoteEntity.toQuoteModel() = QuoteModel(
    id=id,
    quote = quote,
    author = author,
)
fun QuoteModel.toEntity() = QuoteEntity(
    id= id,
    quote = quote,
    author = author,
)

fun List<QuoteModel>.toListQuoteEntity () =
    map {it.toEntity() }

fun List<QuoteEntity>.toListQuoteModel () =
    map {it.toQuoteModel() }


/*
class extensions {
}

 */