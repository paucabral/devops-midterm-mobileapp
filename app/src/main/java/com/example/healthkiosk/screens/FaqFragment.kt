package com.example.healthkiosk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.healthkiosk.R
import com.example.healthkiosk.databinding.FragmentFaqBinding


class FaqFragment : Fragment() {
    lateinit var binding: FragmentFaqBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFaqBinding>(inflater,
            R.layout.fragment_faq, container, false)

        return binding.root
    }
}