package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotescelebrities.data.model.LoginRequest
import com.example.quotescelebrities.databinding.FragmentLoginBinding
import com.example.quotescelebrities.presentation.viewmodel.DataStoreViewModel
import com.example.quotescelebrities.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var dataStoreViewModel: DataStoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        dataStoreViewModel = ViewModelProvider(this)[DataStoreViewModel::class.java]
        val root: View = binding.root

        observer()
        binding.login.setOnClickListener {
            val account = binding.account.text.toString()
            val password = binding.password.text.toString()
            lifecycleScope.launch {
                loginViewModel.login(LoginRequest(account, password))
            }
        }
        return root
    }

    private fun observer() {
        lifecycleScope.launch {
            loginViewModel.user?.collect {
                if (it.success) {
                    val token = it.data
                    val alert = CustomAlert()
                    alert.showDialog(this@LoginFragment, it.message)
                    dataStoreViewModel.let {
                        dataStoreViewModel.saveToken(token)
                    }
                    this.cancel()
                    activity?.onBackPressed()
                } else {
                    if (it.message != "") {
                        val alert = CustomAlert()
                        alert.showDialog(this@LoginFragment, it.message)
                    }
                }
            }
        }

    }
}
