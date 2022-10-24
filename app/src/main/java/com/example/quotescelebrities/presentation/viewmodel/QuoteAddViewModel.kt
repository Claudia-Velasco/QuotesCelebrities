package com.example.quotescelebrities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.domain.usecase.GetQuoteAddUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteAddViewModel
@Inject constructor(
    private val getQuoteAddUseCase: GetQuoteAddUseCase
) : ViewModel() {

    fun addQuote(quoteModel: QuoteModel) {
        viewModelScope.launch {
            getQuoteAddUseCase.addQuote(quoteModel)
        }
    }

}
