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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.formulaone.data.local.EquipoLocalRepository
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.FragmentEquipoDetailBinding
import com.example.formulaone.ui.MainActivity

class EquipoDetailFragment : Fragment() {
    private lateinit var binding: FragmentEquipoDetailBinding
    private val repository = EquipoLocalRepository.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipoDetailBinding
            .inflate(inflater, container, false)
        return binding.root
    }
    var nombre = ""
    var piloto1 = ""
    var piloto2 = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.toolBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.nombreInput.setText(nombre)
        binding.piloto1Input.setText(piloto1)
        binding.piloto2Input.setText(piloto2)
        binding.submitButton.setOnClickListener {
            var equipo = Equipo(id, binding.equipoNombre.toString(), binding.equipoPiloto1.toString(), binding.equipoPiloto2.toString())
            repository.update(equipo)
            //setResult(Activity.RESULT_OK)
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            //finish()
        }
        binding.cancelButton.setOnClickListener {
            //setResult(Activity.RESULT_CANCELED)
            //finish()
        }
    }

    private fun obtenerUrlImagen(): String {
        return "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
    }
}