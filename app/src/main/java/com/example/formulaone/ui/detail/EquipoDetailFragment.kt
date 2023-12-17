package com.example.formulaone.ui.detail

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
import com.example.formulaone.databinding.FragmentEquipoDetailBinding

class EquipoDetailFragment : Fragment() {
    private lateinit var binding: FragmentEquipoDetailBinding
    private val args: EquipoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipoDetailBinding
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
        val imageUrl = obtenerUrlImagen()
        binding.equipoImageView.load(imageUrl)
        binding.equipoNombre.text = "Nombre: " + args.equipo.nombre
        binding.equipoPiloto1.text = "Piloto 1: " + args.equipo.piloto1
        binding.equipoPiloto2.text = "Piloto 2: " + args.equipo.piloto2
    }

    private fun obtenerUrlImagen(): String {
        return "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
    }
}