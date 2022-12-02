package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.R
import com.example.quotescelebrities.databinding.FragmentQuoteEditBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteEditViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteEditFragment : Fragment() {
    private var _binding: FragmentQuoteEditBinding? = null
    private val binding get() = _binding!!
    private lateinit var quoteEditViewModel: QuoteEditViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etId.setText(arguments?.getInt("id", 0).toString())
        binding.etQuote.setText(arguments?.getString("quote", "").toString())
        binding.etAuthor.setText(arguments?.getString("author", "").toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteEditBinding.inflate(inflater, container, false)
        quoteEditViewModel = ViewModelProvider(this)[QuoteEditViewModel::class.java]
        val root: View = binding.root

        //----------------------------
        with(binding) {
            btnSave.setOnClickListener {
                val quoteModel = QuoteModel(
                    id = etId.text.toString().toInt(),
                    quote = etQuote.text.toString(),
                    author = etAuthor.text.toString(),
                )
                lifecycleScope.launch(Dispatchers.IO) {
                    quoteEditViewModel.editQuote(quoteModel)
                }
                val alert = CustomAlert()
                alert.showDialog(this@QuoteEditFragment.parentFragment, getString(R.string.saved))
                activity?.onBackPressed()
            }
        }
        return root
    }

}