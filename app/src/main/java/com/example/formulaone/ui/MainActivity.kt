package com.example.formulaone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulaone.R
import com.example.formulaone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}