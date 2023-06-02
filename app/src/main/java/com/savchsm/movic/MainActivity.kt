package com.savchsm.movic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.savchsm.movic.common.visible
import com.savchsm.movic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navController = this.findNavController(R.id.nav_host_fragment)
        binding?.bottomNavigation?.apply {
            this.setupWithNavController(navController)
            navController.addOnDestinationChangedListener { _, destination, _ ->
                this.visible(destination.id != R.id.editProfileFragment)
            }
        }
    }
}