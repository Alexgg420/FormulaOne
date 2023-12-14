package com.example.formulaone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.formulaone.R
import com.example.formulaone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtén el NavHostFragment desde el contenedor
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Asocia el BottomNavigationView con el NavController
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_menu)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.circuitoListFragment -> {
                    navController.navigate(R.id.circuitos_nav_graph)
                    true
                }
                R.id.pilotoListFragment -> {
                    navController.navigate(R.id.pilotos_nav_graph)
                    true
                }
                else -> false
            }
        }
    }
}
