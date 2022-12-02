package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.R
import com.example.quotescelebrities.databinding.FragmentQuoteAddBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteAddViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteAddFragment : Fragment() {
    private var _binding: FragmentQuoteAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var quoteAddViewModel: QuoteAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteAddBinding.inflate(inflater, container, false)
        quoteAddViewModel = ViewModelProvider(this)[QuoteAddViewModel::class.java]
        val root: View = binding.root

        with(binding) {
            btnSave.setOnClickListener {
                val quoteModel = QuoteModel(
                    id = etId.text.toString().toInt(),
                    quote = etQuote.text.toString(),
                    author = etAuthor.text.toString(),
                )
                lifecycleScope.launch(Dispatchers.IO) {
                    quoteAddViewModel.addQuote(quoteModel)
                }
                val alert = CustomAlert()
                alert.showDialog(this@QuoteAddFragment.parentFragment, getString(R.string.saved))

            }
        }
        return root
    }
}