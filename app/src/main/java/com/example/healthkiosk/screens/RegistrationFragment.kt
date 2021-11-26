package com.example.healthkiosk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.healthkiosk.MainActivity
import com.example.healthkiosk.R
import com.example.healthkiosk.api.ApiInterface
import com.example.healthkiosk.api.RetrofitInstance
import com.example.healthkiosk.databinding.FragmentRegistrationBinding
import com.example.healthkiosk.model.UserBody
import com.example.healthkiosk.model.defaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
        val username = binding.editRegUsername.text.toString().trim()
        val password = binding.editRegPassword.text.toString().trim()
        val password2 = binding.editRegPassword2.text.toString().trim()
        val email = binding.editRegEmail.text.toString().trim()
        val first_name = binding.editRegFirstname.text.toString().trim()
        val last_name = binding.editRegLastname.text.toString().trim()

        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = UserBody(username,password,email, first_name,last_name)

        if (email != "" && username != "" && password != "" && password2 != ""){
            if (password != password2){
                Toast.makeText(requireActivity(), "The passwords you enter do not match.", Toast.LENGTH_SHORT).show()
            }
            else{
                if (password.length < 8){
                    Toast.makeText(requireActivity(), "The password should be\n    at least 8 characters.", Toast.LENGTH_SHORT).show()
                }
                else {
                    retIn.registerUser(registerInfo).enqueue(object : Callback<defaultResponse> {
                        override fun onFailure(call: Call<defaultResponse>, t: Throwable) {
                            Toast.makeText(requireContext(), t.message,Toast.LENGTH_SHORT).show()
                        }
                        override fun onResponse(call: Call<defaultResponse>, response: Response<defaultResponse>) {
                            if (response.code() == 200) {
//                    Toast.makeText(requireContext(), response.body()?.message, Toast.LENGTH_LONG).show()
                                if(response.body()?.message == "Email is already in use."
                                    || response.body()?.message == "Username already exists."
                                    || response.body()?.message == "User already exists."){
                                    Toast.makeText(requireContext(), response.body()?.message, Toast.LENGTH_LONG).show()
                                }
                                else {
                                    Toast.makeText(requireContext(), response.body()?.message, Toast.LENGTH_LONG).show()
                                    findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
                                }
                            }
                            else{
                                Toast.makeText(requireContext(), "There was an error creating the account.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                }
            }
        }
        else {
            Toast.makeText(requireActivity(), "Fields cannot be blank.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun gotoLogin() {
        findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
    }
}