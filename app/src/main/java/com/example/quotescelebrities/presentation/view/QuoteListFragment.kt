package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotescelebrities.core.utils.CellClickListener
import com.example.quotescelebrities.databinding.FragmentQuoteListBinding
import com.example.quotescelebrities.domain.model.QuoteModel
import com.example.quotescelebrities.presentation.viewmodel.QuoteListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteListFragment : Fragment(), CellClickListener {
    private var _binding: FragmentQuoteListBinding? = null
    private val binding get() = _binding!!
    private lateinit var quoteListViewModel: QuoteListViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteListBinding.inflate(inflater, container, false)
        quoteListViewModel = ViewModelProvider(this)[QuoteListViewModel::class.java]
        val root: View = binding.root

        observer()

        lifecycleScope.launch(Dispatchers.IO) {
            quoteListViewModel.getQuotes()
        }
        return root
    }

    private fun callEditQuote(currentQuote: QuoteModel) {
        val bundle = bundleOf(
            Pair("id", currentQuote.id),
            Pair("quote", currentQuote.quote),
            Pair("author", currentQuote.author)
        )

        val quoteEditFragment = QuoteEditFragment()
        quoteEditFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(
                com.example.quotescelebrities.R.id.nav_host_fragment_content_main,
                quoteEditFragment
            ).addToBackStack(this.tag)
            .setReorderingAllowed(true)
            .commit()
    }

    private fun observer() {

        lifecycleScope.launch {
            quoteListViewModel.quotes.collect {
                val adapter = QuoteAdapter(it.data as List<QuoteModel>, this@QuoteListFragment)
                with(binding) {
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter
                }
            }
        }
        lifecycleScope.launch {
            quoteListViewModel.isLoading.collect {
                binding.loading.isVisible = it
            }
        }
    }

    override fun onCellClickListener(quoteModel: QuoteModel) {
        callEditQuote(quoteModel)
    }
}