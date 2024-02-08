package com.example.formulaone.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.formulaone.data.database.EquipoLocalRepository
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.FragmentEquipoCreateBinding
import com.example.formulaone.ui.MainActivity
import com.google.android.material.snackbar.Snackbar

class EquipoCreateFragment : Fragment() {
    private lateinit var binding: FragmentEquipoCreateBinding
    private val repository = EquipoLocalRepository.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipoCreateBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.toolBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.nombreEquipo.setText("")
        binding.nombrePiloto1.setText("")
        binding.numeroPiloto1.setText("")
        binding.nombrePiloto2.setText("")
        binding.numeroPiloto2.setText("")
        binding.submitButton.isEnabled = false
        binding.submitButton.setOnClickListener {
            val equipo = Equipo(
                id,
                binding.equipoNombre.editText?.text.toString(),
                binding.namePiloto1.editText?.text.toString(),
                binding.numberPiloto1.editText?.text.toString().toInt(),
                binding.namePiloto2.editText?.text.toString(),
                binding.numberPiloto2.editText?.text.toString().toInt()
            )
            if (isValidInput(equipo)) {
                repository.add(equipo)
                val result = Bundle().apply {
                    putParcelable("equipo", equipo)
                }
                setFragmentResult("equipoKey", result)
                findNavController().navigateUp()
            } else {
                // Mostrar un mensaje de advertencia al usuario si algún campo está vacío o fuera de rango
                Snackbar.make(
                    requireView(),
                    "Por favor, complete todos los campos correctamente.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.nombreEquipo.addTextChangedListener { validateFields() }
        binding.nombrePiloto1.addTextChangedListener { validateFields() }
        binding.nombrePiloto2.addTextChangedListener { validateFields() }
        binding.numberPiloto1.editText?.addTextChangedListener { validateFields() }
        binding.numberPiloto2.editText?.addTextChangedListener { validateFields() }
    }
    private fun isValidInput(equipo: Equipo): Boolean {
        return equipo.nombreEquipo.isNotBlank() &&
                equipo.piloto1Nombre.isNotBlank() &&
                equipo.piloto2Nombre.isNotBlank() &&
                equipo.piloto1Number in 1..99 &&
                equipo.piloto2Number in 1..99
    }

    private fun validateFields() {
        val equipona = binding.equipoNombre.editText?.text.toString()
        val equipona1 = binding.namePiloto1.editText?.text.toString()
        val equipona2 = binding.namePiloto2.editText?.text.toString()
        val equipono1 = binding.numberPiloto1.editText?.text.toString()
        val equipono2 = binding.numberPiloto2.editText?.text.toString()

        val fieldsNotEmpty = equipona.isNotBlank() && equipona1.isNotBlank() && equipona2.isNotBlank() && equipono1.isNotBlank() && equipono2.isNotBlank()
        val validNumbers = equipono1.toIntOrNull() in 1..99 && equipono2.toIntOrNull() in 1..99

        binding.submitButton.isEnabled = fieldsNotEmpty && validNumbers
    }
}