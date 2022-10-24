package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.R
import com.example.quotescelebrities.databinding.FragmentQuoteRandomBinding
import com.example.quotescelebrities.presentation.viewmodel.QuoteRandomViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomFragment : Fragment() {
    private var _binding: FragmentQuoteRandomBinding? = null
    private val quotRandomViewModel: QuoteRandomViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuoteRandomBinding.inflate(layoutInflater, container, false)

        quotRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quotRandomViewModel.randomQuote()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        lifecycleScope.launch {
            quotRandomViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text = it.author
            }
        }
    }
}