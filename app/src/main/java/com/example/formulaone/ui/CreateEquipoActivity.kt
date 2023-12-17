package com.example.formulaone.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulaone.data.local.EquipoLocalRepository
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.ActivityCreateEquipoBinding

class CreateEquipoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateEquipoBinding
    private val repository = EquipoLocalRepository.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createButton.setOnClickListener {
            var equipo = Equipo(1, binding.equipoNombre.toString(), binding.piloto1.toString(), binding.piloto2.toString())
            repository.add(equipo)
            setResult(Activity.RESULT_OK)
            finish()
        }

        binding.cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}