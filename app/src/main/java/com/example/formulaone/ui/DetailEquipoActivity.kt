package com.example.formulaone.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.formulaone.data.local.EquipoLocalRepository
import com.example.formulaone.databinding.ActivityDetailEquipoBinding
import com.example.formulaone.data.repository.Equipo

class DetailEquipoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailEquipoBinding
    private val repository = EquipoLocalRepository.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val equipo:Equipo? = intent?.extras?.getParcelable("EQUIPO")
        var id = 0
        var nombre = ""
        var piloto1 = ""
        var piloto2 = ""

        if (equipo!=null) {
            id = equipo.id
            nombre = equipo.nombre
            piloto1 = equipo.piloto1
            piloto2 = equipo.piloto2
        }

        binding.nombreInput.setText(nombre)
        binding.piloto1Input.setText(piloto1)
        binding.piloto2Input.setText(piloto2)

        binding.submitButton.setOnClickListener {
            var equipo = Equipo(id, binding.nombreInput.text.toString(), binding.piloto1Input.text.toString(), binding.piloto2Input.text.toString())
            repository.update(equipo)
            setResult(Activity.RESULT_OK)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}