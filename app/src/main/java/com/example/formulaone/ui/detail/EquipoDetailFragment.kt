package com.example.formulaone.ui.detail

import android.content.Context
import android.net.Uri
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
import com.example.formulaone.R
import com.example.formulaone.databinding.FragmentEquipoDetailBinding

class EquipoDetailFragment() : Fragment() {
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
        val imageUrl = Uri.parse("android.resource://${context?.packageName}/${R.drawable.iconequipo}").toString()
        binding.equipoImageView.load(imageUrl)
        val imageUrlPiloto1 = obtenerUrlImagen(args.equipo.piloto1Nombre)
        binding.piloto1Img.load(imageUrlPiloto1)
        val imageUrlPiloto2 = obtenerUrlImagen(args.equipo.piloto2Nombre)
        binding.piloto2Img.load(imageUrlPiloto2)
        binding.equipoName.text = args.equipo.nombreEquipo
        binding.piloto1Name.text = args.equipo.piloto1Nombre
        binding.piloto1Number.text = args.equipo.piloto1Number.toString()
        binding.piloto2Name.text = args.equipo.piloto2Nombre
        binding.piloto2Number.text = args.equipo.piloto2Number.toString()
    }

    private fun obtenerUrlImagen(namePiloto: String): String {
        return when (namePiloto) {
            "Alexander Albon"  -> "https://static.motor.es/f1/fichas/contenido/alexander-albon/alexander-albon2023_1689441670.jpg"
            "Fernando Alonso"  -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/348.png&w=350&h=254"
            "Valtteri Bottas"  -> "https://static.motor.es/f1/fichas/contenido/valtteri-bottas/valtteri-bottas2023_1689414606.jpg"
            "Nyck de Vries"    -> "https://static.motor.es/f1/fichas/contenido/nyck-de-vries/nyck-de-vries2023_1689440787.jpg"
            "Pierre Gasly"     -> "https://static.motor.es/f1/fichas/contenido/pierre-gasly/pierre-gasly2023_1689412806.jpg"
            "Lewis Hamilton"   -> "https://static.motor.es/f1/fichas/contenido/lewis-hamilton/lewis-hamilton2023_1689443210.jpg"
            "Nico Hülkenberg"  -> "https://static.motor.es/f1/fichas/contenido/nico-hulkenberg/nico-hulkenberg2023_1689440532.jpg"
            "Liam Lawson"      -> "https://static.motor.es/f1/fichas/contenido/liam-lawson/liam-lawson2024_1706685456.jpg"
            "Charles Leclerc"  -> "https://static.motor.es/f1/fichas/contenido/charles-leclerc/charles-leclerc2023_1689442833.jpg"
            "Kevin Magnussen"  -> "https://static.motor.es/f1/fichas/contenido/kevin-magnussen/kevin-magnussen2023_1689440107.jpg"
            "Lando Norris"     -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5579.png&w=350&h=254"
            "Esteban Ocon"     -> "https://static.motor.es/f1/fichas/contenido/esteban-ocon/esteban-ocon2023_1689412511.jpg"
            "Sergio Pérez"     -> "https://static.motor.es/f1/fichas/contenido/sergio-perez/sergio-perez2023_1689442720.jpg"
            "Oscar Piastri"    -> "https://static.motor.es/f1/fichas/contenido/oscar-piastri/oscar-piastri2023_1689415808.jpg"
            "Daniel Ricciardo" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4510.png&w=350&h=254"
            "George Russell"   -> "https://static.motor.es/f1/fichas/contenido/george-russell/george-russell2023_1689411697.jpg"
            "Carlos Sainz"     -> "https://static.motor.es/f1/fichas/contenido/carlos-sainz/carlos-sainz2023_1689443003.jpg"
            "Logan Sargeant"   -> "https://static.motor.es/f1/fichas/contenido/logan-sargeant/logan-sargeant2023_1689441817.jpg"
            "Lance Stroll"     -> "https://static.motor.es/f1/fichas/contenido/lance-stroll/lance-stroll2023_1689415417.jpg"
            "Yuki Tsunoda"     -> "https://static.motor.es/f1/fichas/contenido/yuki-tsunoda/yuki-tsunoda2023_1689441011.jpg"
            "Max Verstappen"   -> "https://static.motor.es/f1/fichas/contenido/max-verstappen/max-verstappen2023_1689442564.jpg"
            "Guanyu Zhou"      -> "https://static.motor.es/f1/fichas/contenido/guanyu-zhou/guanyu-zhou2023_1689414843.jpg"
            // Agrega más casos según sea necesario para otras rondas
            else -> "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
        }
    }
}