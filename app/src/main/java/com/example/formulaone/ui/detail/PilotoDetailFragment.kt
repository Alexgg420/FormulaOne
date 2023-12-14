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
        binding.pilotoNameText.text = "Nombre: " + args.piloto.name + " " + args.piloto.surname
        binding.pilotoCode.text = "Código: " + args.piloto.code
        binding.pilotoNumber.text = "Número: " + args.piloto.permanentNumber
        binding.pilotoNation.text = "Nacionalidad: " + args.piloto.nation
        binding.pilotoFecNac.text = "Fecha de nacimiento: " + args.piloto.fecNac
    }

    private fun obtenerUrlImagen(driverId: String): String {
        return when (driverId) {
            "albon" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5592.png&w=350&h=254"
            "alonso" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/348.png&w=350&h=254"
            "bottas" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4520.png&w=350&h=254"
            "de_vries" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5718.png&w=350&h=254"
            "gasly" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5501.png&w=350&h=254"
            "hamilton" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/868.png&w=350&h=254"
            "hulkenberg" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4396.png&w=350&h=254"
            "lawson" -> "https://soymotor.com/sites/default/files/2023-08/liam-lawson.png"
            "leclerc" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5498.png&w=350&h=254"
            "kevin_magnussen" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4623.png&w=350&h=254"
            "norris" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5579.png&w=350&h=254"
            "ocon" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4678.png&w=350&h=254"
            "perez" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4472.png&w=350&h=254"
            "piastri" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5752.png&w=350&h=254"
            "ricciardo" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4510.png&w=350&h=254"
            "russell" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5503.png&w=350&h=254"
            "sainz" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4686.png&w=350&h=254"
            "sargeant" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5745.png&w=350&h=254"
            "stroll" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4775.png&w=350&h=254"
            "tsunoda" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5652.png&w=350&h=254"
            "max_verstappen" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4665.png&w=350&h=254"
            "zhou" -> "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5682.png&w=350&h=254"
            // Agrega más casos según sea necesario para otras rondas
            else -> "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
        }
    }
}