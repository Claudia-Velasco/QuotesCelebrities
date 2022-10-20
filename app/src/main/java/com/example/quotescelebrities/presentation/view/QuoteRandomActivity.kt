package com.example.quotescelebrities.presentation.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.quotescelebrities.databinding.ActivityQuoteRandomBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.domain.usecase.GetQuoteRandomUseCase
import com.example.quotescelebrities.presentation.viewmodel.QuoteRandomViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class QuoteRandomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteRandomBinding
    private val quotRandomViewModel: QuoteRandomViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuoteRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //----------------------------
        quotRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quotRandomViewModel.randomQuote()
        }

    }
    private fun observer(){
        lifecycleScope.launch {
            quotRandomViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }


}