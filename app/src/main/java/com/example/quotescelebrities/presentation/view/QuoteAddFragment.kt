package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var viewModel: QuoteAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteAddBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[QuoteAddViewModel::class.java]
        binding.btnAddQuote.setOnClickListener { observerAdd() }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observerAdd() {
        lifecycleScope.launch {
            when {
                isValidData() -> {
                    viewModel.let {
                        it.addQuote(getQuoteModel())
                        showMessage("Quote added")
                        clearData()
                    }
                }
                else -> showMessage("Please fill all fields")
            }
        }
    }

    private fun isValidData() = binding.tvAddId.text.toString().isNotEmpty() &&
            binding.tvAddQuote.text.toString().isNotEmpty() &&
            binding.tvAddAuthor.text.toString().isNotEmpty()

    private fun getQuoteModel(): QuoteModel {
        return QuoteModel(
            id = binding.tvAddId.text.toString().toInt(),
            quote = binding.tvAddQuote.text.toString(),
            author = binding.tvAddAuthor.text.toString()
        )
    }

    private fun clearData() {
        binding.tvAddId.text.clear()
        binding.tvAddQuote.text.clear()
        binding.tvAddAuthor.text.clear()
    }

    private fun showMessage(message: String) = makeText(context, message, LENGTH_SHORT).show()
}
