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
import com.example.formulaone.R
import com.example.formulaone.databinding.FragmentPilotoDetailBinding

class PilotoDetailFragment : Fragment() {
    private lateinit var binding: FragmentPilotoDetailBinding
    private val args: PilotoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPilotoDetailBinding
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
        val imageUrl = obtenerUrlImagen(args.piloto.driverId)
        binding.pilotoImageView.load(imageUrl)
        binding.pilotoNameText.text = getString(R.string.name_text) + ": " + args.piloto.name + " " + args.piloto.surname
        binding.pilotoCode.text = getString(R.string.code_text) + ": " + args.piloto.code
        binding.pilotoNumber.text = getString(R.string.number_text) + ": " + args.piloto.permanentNumber
        binding.pilotoNation.text = getString(R.string.nac) + ": " + args.piloto.nation
        binding.pilotoFecNac.text = getString(R.string.fecnac) + ": " + args.piloto.fecNac
    }

    private fun obtenerUrlImagen(driverId: String): String {
        return when (driverId) {
            "albon"            -> "https://static.motor.es/f1/fichas/contenido/alexander-albon/alexander-albon2023_1689441670.jpg"
            "alonso"           -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/348.png&w=350&h=254"
            "bottas"           -> "https://static.motor.es/f1/fichas/contenido/valtteri-bottas/valtteri-bottas2023_1689414606.jpg"
            "de_vries"         -> "https://static.motor.es/f1/fichas/contenido/nyck-de-vries/nyck-de-vries2023_1689440787.jpg"
            "gasly"            -> "https://static.motor.es/f1/fichas/contenido/pierre-gasly/pierre-gasly2023_1689412806.jpg"
            "hamilton"         -> "https://static.motor.es/f1/fichas/contenido/lewis-hamilton/lewis-hamilton2023_1689443210.jpg"
            "hulkenberg"       -> "https://static.motor.es/f1/fichas/contenido/nico-hulkenberg/nico-hulkenberg2023_1689440532.jpg"
            "lawson"           -> "https://static.motor.es/f1/fichas/contenido/liam-lawson/liam-lawson2024_1706685456.jpg"
            "leclerc"          -> "https://static.motor.es/f1/fichas/contenido/charles-leclerc/charles-leclerc2023_1689442833.jpg"
            "kevin_magnussen"  -> "https://static.motor.es/f1/fichas/contenido/kevin-magnussen/kevin-magnussen2023_1689440107.jpg"
            "norris"           -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5579.png&w=350&h=254"
            "ocon"             -> "https://static.motor.es/f1/fichas/contenido/esteban-ocon/esteban-ocon2023_1689412511.jpg"
            "perez"            -> "https://static.motor.es/f1/fichas/contenido/sergio-perez/sergio-perez2023_1689442720.jpg"
            "piastri"          -> "https://static.motor.es/f1/fichas/contenido/oscar-piastri/oscar-piastri2023_1689415808.jpg"
            "ricciardo"        -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4510.png&w=350&h=254"
            "russell"          -> "https://static.motor.es/f1/fichas/contenido/george-russell/george-russell2023_1689411697.jpg"
            "sainz"            -> "https://static.motor.es/f1/fichas/contenido/carlos-sainz/carlos-sainz2023_1689443003.jpg"
            "sargeant"         -> "https://static.motor.es/f1/fichas/contenido/logan-sargeant/logan-sargeant2023_1689441817.jpg"
            "stroll"           -> "https://static.motor.es/f1/fichas/contenido/lance-stroll/lance-stroll2023_1689415417.jpg"
            "tsunoda"          -> "https://static.motor.es/f1/fichas/contenido/yuki-tsunoda/yuki-tsunoda2023_1689441011.jpg"
            "max_verstappen"   -> "https://static.motor.es/f1/fichas/contenido/max-verstappen/max-verstappen2023_1689442564.jpg"
            "zhou"             -> "https://static.motor.es/f1/fichas/contenido/guanyu-zhou/guanyu-zhou2023_1689414843.jpg"
            // Agrega más casos según sea necesario para otras rondas
            else -> "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
        }
    }
}