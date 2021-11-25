package com.example.healthkiosk

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.healthkiosk.api.ApiInterface
import com.example.healthkiosk.api.RetrofitInstance
import com.example.healthkiosk.databinding.FragmentLoginBinding
import com.example.healthkiosk.model.SignInBody
import com.example.healthkiosk.model.loginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        (activity as MainActivity).txtName = username
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = SignInBody(username, password)
        retIn.signIn(signInInfo).enqueue(object : Callback<loginResponse> {
            override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                Toast.makeText(requireContext(), t.message,Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<loginResponse>, response: Response<loginResponse>) {
                if (response.code() == 200) {
                    val retMessage = response.body()?.message
                    val retPublic_id = response.body()?.public_id
                    val retToken = response.body()?.token
                    val retUsername = response.body()?.username

                    if (retMessage.isNullOrEmpty()){
                        Toast.makeText(requireContext(), "Welcome " + retUsername + "!", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        (activity as MainActivity).txtName = retUsername.toString()
                    }
                    else{
                        Toast.makeText(requireContext(), retMessage, Toast.LENGTH_LONG).show()
                    }

                } else {
                    Toast.makeText(requireContext(), "There was an error during login.", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    private fun gotoRegistration() {
        findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
    }

}