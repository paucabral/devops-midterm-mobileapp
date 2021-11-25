package com.example.healthkiosk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.healthkiosk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var txtName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.homeFragment), drawerLayout)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navView, navController)

        txtName="None"

        val logout = binding.navView.menu.findItem(R.id.loginFragment).setOnMenuItemClickListener {
            setDrawerLocked()
            when(navController.currentDestination?.id) {
                R.id.homeFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.diffentialDiagnosisFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_diffentialDiagnosisFragment_to_homeFragment)
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.nearestHospitalsFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_nearestHospitalsFragment_to_homeFragment)
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.diseasesListFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_diseasesListFragment_to_homeFragment)
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.symptomsListFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_symptomsListFragment_to_homeFragment)
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.faqFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_faqFragment_to_homeFragment)
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.aboutFragment -> {
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_aboutFragment_to_homeFragment)
                    this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_homeFragment_to_loginFragment)
                    Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_LONG).show()
                    true
                }
                else -> NavigationUI.navigateUp(navController, appBarConfiguration)
            }
        }

        setDrawerLocked()
    }

    override fun onSupportNavigateUp(): Boolean {
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.homeFragment), drawerLayout)
        val navController = this.findNavController(R.id.myNavHostFragment)
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
        return when(navController.currentDestination?.id) {
            R.id.faqFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_faqFragment_to_homeFragment)
                true
            }
            R.id.aboutFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_aboutFragment_to_homeFragment)
                true
            }
            R.id.diffentialDiagnosisFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_diffentialDiagnosisFragment_to_homeFragment)
                true
            }
            R.id.nearestHospitalsFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_nearestHospitalsFragment_to_homeFragment)
                true
            }
            R.id.diseasesListFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_diseasesListFragment_to_homeFragment)
                true
            }
            R.id.symptomsListFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_symptomsListFragment_to_homeFragment)
                true
            }
            else -> NavigationUI.navigateUp(navController, appBarConfiguration)
        }
    }

    override fun onBackPressed() {
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.homeFragment), drawerLayout)
        val navController = this.findNavController(R.id.myNavHostFragment)
        when(navController.currentDestination?.id) {
            R.id.faqFragment -> {
                this.findNavController(R.id.myNavHostFragment)
                    .navigate(R.id.action_faqFragment_to_homeFragment)
                true
            }
            R.id.aboutFragment -> {
                this.findNavController(R.id.myNavHostFragment)
                    .navigate(R.id.action_aboutFragment_to_homeFragment)
                true
            }
            R.id.diffentialDiagnosisFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_diffentialDiagnosisFragment_to_homeFragment)
                true
            }
            R.id.nearestHospitalsFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_nearestHospitalsFragment_to_homeFragment)
                true
            }
            R.id.diseasesListFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_diseasesListFragment_to_homeFragment)
                true
            }
            R.id.symptomsListFragment -> {
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_symptomsListFragment_to_homeFragment)
                true
            }
            else -> NavigationUI.navigateUp(navController, appBarConfiguration)
        }
    }

    fun setDrawerLocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        supportActionBar?.hide()
    }

    fun setDrawerUnLocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        supportActionBar?.show()
    }

    fun hideActionBar() {
        supportActionBar?.hide()
    }
}