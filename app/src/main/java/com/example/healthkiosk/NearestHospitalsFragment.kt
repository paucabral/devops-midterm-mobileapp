package com.example.healthkiosk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthkiosk.databinding.FragmentNearestHospitalsBinding


class NearestHospitalsFragment : Fragment() {
    var long: Double = 0.0
    var lat: Double = 0.0
    lateinit var binding: FragmentNearestHospitalsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNearestHospitalsBinding.inflate(inflater, container, false)

        randomCoordinates()

        binding.btnFind.setOnClickListener{ gotoGoogleMaps(requireView()) }

        return binding.root
    }

    fun gotoGoogleMaps(view: View){
        var url = "https://www.google.com/maps/search/hospitals+near+me/@$lat,$long"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    fun randomCoordinates() {
        long = (0..150).random().toDouble()
        lat = (0..150).random().toDouble()
        binding.txtCoordinates.setText("$lat, $long")
    }
}