package com.example.quotescelebrities.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.databinding.ActivityQuoteAddBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteAddViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteAddBinding
    private val quoteAddViewModel: QuoteAddViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuoteAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddQuote.setOnClickListener {
            observerAdd()
        }
    }

    fun observerAdd() {
        lifecycleScope.launch {
            val quoteCelebritie = QuoteModel(
                id = binding.tvAddId.text.toString().toInt(),
                quote = binding.tvAddQuote.text.toString(),
                author = binding.tvAddAuthor.text.toString()
            )
            quoteAddViewModel.addQuote(quoteCelebritie)
        }
    }

}