package com.example.healthkiosk.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.healthkiosk.MainActivity
import com.example.healthkiosk.R
import com.example.healthkiosk.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home, container, false)

        binding.btnDifferentialDiagnosis.setOnClickListener{ goToDifferentialDiagnosis() }
        binding.btnNearestHospitals.setOnClickListener{ goToNearbyHospitals() }
        binding.btnSymptomsList.setOnClickListener{ goToSymptomsList() }
        binding.btnDiseasesList.setOnClickListener{ goToDiseeasesList() }

        (activity as MainActivity).setDrawerUnLocked()

        binding.txtName.setText((activity as MainActivity).txtName)

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

    fun goToDifferentialDiagnosis() {
        findNavController().navigate(R.id.action_homeFragment_to_diffentialDiagnosisFragment)
    }

    fun goToNearbyHospitals() {
        findNavController().navigate(R.id.action_homeFragment_to_nearestHospitalsFragment)
    }

    fun goToSymptomsList() {
        findNavController().navigate(R.id.action_homeFragment_to_symptomsListFragment)
    }

    fun goToDiseeasesList() {
        findNavController().navigate(R.id.action_homeFragment_to_diseasesListFragment)
    }

}