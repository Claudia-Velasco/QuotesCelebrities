package com.example.quotescelebrities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quotescelebrities.domain.usecase.GetQuoteRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val getQuoteRandomUseCase: GetQuoteRandomUseCase
) : ViewModel()