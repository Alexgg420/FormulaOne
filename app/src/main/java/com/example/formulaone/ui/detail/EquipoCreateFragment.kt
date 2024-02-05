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
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.formulaone.data.database.EquipoLocalRepository
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.FragmentEquipoCreateBinding
import com.example.formulaone.ui.MainActivity

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
    var nombreEquipo = ""
    var nombrePiloto1 = ""
    var numeroPiloto1 = 0
    var nombrePiloto2 = ""
    var numeroPiloto2 = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.toolBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.nombreEquipo.setText(nombreEquipo)
        binding.nombrePiloto1.setText(nombrePiloto1)
        binding.numeroPiloto1.setText(numeroPiloto1.toString())
        binding.nombrePiloto2.setText(nombrePiloto2)
        binding.numeroPiloto2.setText(numeroPiloto2.toString())
        binding.submitButton.setOnClickListener {
            val equipo = Equipo(
                id,
                binding.equipoNombre.editText?.text.toString(),
                binding.namePiloto1.editText?.text.toString(),
                binding.numberPiloto1.editText?.text.toString().toInt(),
                binding.namePiloto2.editText?.text.toString(),
                binding.numberPiloto2.editText?.text.toString().toInt()
            )
            val result = Bundle().apply {
                putParcelable("equipo", equipo)
            }
            setFragmentResult("equipoKey", result)
            findNavController().navigateUp()
        }


        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}