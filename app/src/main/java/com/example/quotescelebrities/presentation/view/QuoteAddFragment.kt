package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.databinding.FragmentQuoteAddBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteAddViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteAddFragment : Fragment() {
    private var _binding: FragmentQuoteAddBinding? = null
    private val binding get() = _binding!!
    private val quoteAddViewModel: QuoteAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuoteAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnAddQuote.setOnClickListener {
            // observerAdd()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observerAdd() {
        lifecycleScope.launch {
            //GUARDAR QUOTE
            val quoteCelebritie = QuoteModel(
                id = binding.tvAddId.text.toString().toInt(),
                quote = binding.tvAddQuote.text.toString(),
                author = binding.tvAddAuthor.text.toString()
            )
            quoteAddViewModel.addQuote(quoteCelebritie)
        }
    }
}
