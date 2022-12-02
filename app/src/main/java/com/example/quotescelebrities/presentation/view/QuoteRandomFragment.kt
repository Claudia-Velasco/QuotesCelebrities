package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.databinding.FragmentQuoteRandomBinding
import com.example.quotescelebrities.presentation.viewmodel.QuoteRandomViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomFragment : Fragment() {
    private lateinit var quoteRandomViewModel: QuoteRandomViewModel
    private var _binding: FragmentQuoteRandomBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuoteRandomBinding.inflate(inflater, container, false)
        quoteRandomViewModel = ViewModelProvider(this)[QuoteRandomViewModel::class.java]
        val root: View = binding.root

        //----------------------------
        quoteRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quoteRandomViewModel.randomQuote()
        }
        return root
    }

    private fun observer() {
        lifecycleScope.launch {
            quoteRandomViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text = it.author
            }
        }
    }
}