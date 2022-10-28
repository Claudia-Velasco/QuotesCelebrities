package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.databinding.FragmentQuoteAllBinding
import com.example.quotescelebrities.presentation.viewmodel.QuoteAllViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteAllFragment : Fragment() {
    private var _binding: FragmentQuoteAllBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: QuoteAllViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteAllBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[QuoteAllViewModel::class.java]
        observerList(binding.tvData)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observerList(textView: TextView) {
        lifecycleScope.launch {
            viewModel.getAllQuote()
            viewModel.quoteModelList.collect { listQuotes ->
                listQuotes.forEach { quote ->
                    textView.append("${quote.id} - ${quote.quote} - ${quote.author} \n")
                }
            }
        }
    }
}