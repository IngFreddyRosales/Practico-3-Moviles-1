package com.example.practico_3_moviles_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.practico_3_moviles_1.databinding.ActivityMainBinding
import com.example.practico_3_moviles_1.view.LikedProfilesFragment
import com.example.practico_3_moviles_1.view.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            setupInitialFragment()
        }

        setupEventListeners()

    }

    private fun setupInitialFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_Container, ProfileFragment())
            .commit()
    }

    private fun setupEventListeners() {
    }

    fun navigateToLikedProfiles() {
        navigateToFragment(LikedProfilesFragment())
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_Container, fragment)
            .addToBackStack(null)
            .commit()
    }

    // Función para regresar al fragmento anterior si se quiere manejar la navegación manualmente
    fun navigateBack() {
       // supportFragmentManager.popBackStack()
    }
}
