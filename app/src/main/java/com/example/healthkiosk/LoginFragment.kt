package com.example.healthkiosk

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.healthkiosk.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener { gotoHome() }
        binding.btnGoToRegister.setOnClickListener { gotoRegistration() }

        (activity as MainActivity).hideActionBar()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun gotoHome() {
        val username = binding.editUsername.text.toString()
        val password = binding.editPassword.text.toString()

        val correctUsername = "paucabral"
        val correctPassword = "1811023"

        if(username == correctUsername && password == correctPassword){
            Toast.makeText(requireActivity(), "Welcome $username!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        else{
            Toast.makeText(requireActivity(), "Incorrect username or password.", Toast.LENGTH_LONG).show()
        }
    }

    private fun gotoRegistration() {
        findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
    }

}