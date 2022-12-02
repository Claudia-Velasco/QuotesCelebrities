package com.example.quotescelebrities.data.remote

import com.example.quotescelebrities.domain.model.QuoteModel
import com.google.gson.annotations.SerializedName

data class QuoteApiResponse(
    @SerializedName("success")
    var success: Boolean,

    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    var data: List<QuoteModel?>?
)