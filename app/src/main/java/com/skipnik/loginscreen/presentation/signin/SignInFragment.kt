package com.skipnik.loginscreen.presentation.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.skipnik.loginscreen.R
import com.skipnik.loginscreen.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val viewModel: SignInViewModel by viewModels()

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSignInBinding.bind(view)

        binding.apply {
            buttonContinue.setOnClickListener {
                viewModel.apply {
                    login(
                        phoneNumber.text.toString(),
                        passwordField.text.toString()
                    ).observe(viewLifecycleOwner) { id ->
                        if (id != null) {
                            val action =
                                SignInFragmentDirections.actionSignInFragmentToProfileFragment(
                                    id
                                )
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


