package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.databinding.FragmentQuoteAllBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteAllViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteAllFragment : Fragment() {
    private var _binding: FragmentQuoteAllBinding? = null
    private val binding get() = _binding!!
    private val quoteAllViewModel: QuoteAllViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuoteAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

       // observerList(binding.tvData)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observerList(tv: TextView) {
        lifecycleScope.launch {
            var data = ""
            quoteAllViewModel.getAllQuote()
            quoteAllViewModel.quoteModelList.collect { listQuotes ->
                listQuotes.forEach { quoteModel ->
                    data += "${quoteModel.id}-${quoteModel.quote}-${quoteModel.author} \n"
                }
                tv.append(data)
            }
        }
    }

}
