package com.example.healthkiosk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.healthkiosk.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.btnRegister.setOnClickListener { register() }
        binding.btnGoToLogin.setOnClickListener { gotoLogin() }

        (activity as MainActivity).hideActionBar()

        return binding.root
    }

    private fun register() {
        val email = binding.editRegEmail.text.toString()
        val username = binding.editRegUsername.text.toString()
        val password = binding.editRegUsername.text.toString()

        if(email != "" && username != "" && password != ""){
            Toast.makeText(requireActivity(), "Registration Success!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        else{
            Toast.makeText(requireActivity(), "Fields cannot be blank.", Toast.LENGTH_LONG).show()
        }
    }

    private fun gotoLogin() {
        findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
    }
}