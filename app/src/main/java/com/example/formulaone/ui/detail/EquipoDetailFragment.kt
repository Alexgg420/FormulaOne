package com.example.formulaone.ui.detail

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
        binding.piloto1Img.load(imageUrl)
        binding.piloto2Img.load(imageUrl)
        binding.equipoName.text = args.equipo.nombreEquipo
        binding.piloto1Name.text = args.equipo.piloto1Nombre
        binding.piloto1Number.text = args.equipo.piloto1Number.toString()
        binding.piloto2Name.text = args.equipo.piloto2Nombre
        binding.piloto2Number.text = args.equipo.piloto2Number.toString()
    }

    private fun obtenerUrlImagen(): String {
        return "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
    }
}