package com.example.formulaone.ui.equipo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.formulaone.R
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.FragmentEquipoBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EquipoFragment : Fragment() {
    private lateinit var binding: FragmentEquipoBinding
    private val viewModel: EquipoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEquipoBinding.inflate(inflater, container, false)
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

        var pilotoselected1 = ""
        var pilotoselected2 = ""

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allPilotos.collect { equipos ->
                val equiposName = equipos.map { it.name + " " + it.surname }
                val adapter = ArrayAdapter(
                    requireContext(),
                    R.layout.dropdown_item,
                    equiposName
                )
                binding.nombrePiloto1.setAdapter(adapter)
                binding.nombrePiloto1.setOnItemClickListener { _, _, position, _ ->
                    pilotoselected1 = adapter.getItem(position).toString()
                }
                binding.nombrePiloto2.setAdapter(adapter)
                binding.nombrePiloto2.setOnItemClickListener { _, _, position, _ ->
                    pilotoselected2 = adapter.getItem(position).toString()
                }
            }
        }
        var equipoId = 0
        binding.submitButton.isEnabled = false
        binding.submitButton.setOnClickListener {
            equipoId+=1;
            val equipo = Equipo(
                id = equipoId,
                binding.nombreEquipo.text.toString(),
                pilotoselected1,
                binding.numeroPiloto1.text.toString().toInt(),
                pilotoselected2,
                binding.numeroPiloto2.text.toString().toInt(),
            )
            if (isValidInput(equipo)) {
                viewModel.createEquipo(equipo)
                findNavController().popBackStack()
            } else if ((binding.numeroPiloto1.text.toString().toInt() < 1 || binding.numeroPiloto1.text.toString().toInt() > 99) || (binding.numeroPiloto2.text.toString().toInt() < 1 || binding.numeroPiloto2.text.toString().toInt() > 99)){
                // Mostrar un mensaje de advertencia al usuario si algún campo está vacío o fuera de rango
                Snackbar.make(
                    requireView(),
                    "Por favor, selecciona un número entre 1 y 99.",
                    Snackbar.LENGTH_SHORT
                ).show()
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
