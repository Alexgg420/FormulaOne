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
import com.example.formulaone.databinding.FragmentCircuitoDetailBinding

class CircuitoDetailFragment : Fragment() {
    private lateinit var binding: FragmentCircuitoDetailBinding
    private val args: CircuitoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCircuitoDetailBinding
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
        val imageUrl = obtenerUrlImagen(args.circuito.round)
        binding.circuitoImageView.load(imageUrl)
        binding.circuitoRoundText.text = getString(R.string.ronda_text) + ": " + args.circuito.round
        binding.circuitoRaceNameText.text = getString(R.string.gp_text) + ": " + args.circuito.grandPrixName
        binding.circuitoNameText.text = getString(R.string.circuitName_text) + ": " + args.circuito.circuitoName
        binding.circuitoCountryText.text = getString(R.string.countryName_text) + ": " + args.circuito.circuitoCountry
        binding.circuitoLocalText.text = getString(R.string.cityName_text) + ": " + args.circuito.circuitoLocal
        binding.circuitoDateText.text = getString(R.string.day_text) + ": " + args.circuito.date
        binding.circuitoTimeText.text = getString(R.string.hour_text) + ": " + args.circuito.time
    }
    private fun obtenerUrlImagen(round: String): String {
        return when (round) {
            "1" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/bahrein.jpg"
            "2" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/arabia-saudi.jpg"
            "3" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/australia.jpg"
            "4" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/azerbaiyan.jpg"
            "5" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/miami.jpg"
            "6" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/monaco.jpg"
            "7" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/espana.jpg"
            "8" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/canada.jpg"
            "9" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/austria.jpg"
            "10" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/gran-bretana.jpg"
            "11" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/hungria.jpg"
            "12" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/belgica.jpg"
            "13" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/paises-bajos.jpg"
            "14" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/italia.jpg"
            "15" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/singapur.jpg"
            "16" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/japon.jpg"
            "17" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/qatar.jpg"
            "18" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/eeuu.jpg"
            "19" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/mexico.jpg"
            "20" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/brasil.jpg"
            "21" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/las-vegas.jpg"
            "22" -> "https://e00-marca.uecdn.es/deporte/motor/formula1/img/circuitos/abu-dhabi.jpg"
            // Imagen mostrada en caso de haber un circuito sin imagen
            else -> "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
        }
    }
}