package com.example.formulaone.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.formulaone.data.repository.Circuito
import com.example.formulaone.databinding.CircuitoItemBinding

class CircuitListAdapter(private val context: Context, private val onItemClick: (Circuito) -> Unit): ListAdapter<Circuito, CircuitListAdapter.CircuitoListViewHolder>(CircuitoDiffCallBack) {

    inner class CircuitoListViewHolder(private val binding: CircuitoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindCircuito(c: Circuito) {
            val imageUrl = obtenerUrlImagen(c.round)
            binding.circuitoImageView.load(imageUrl)
            binding.circuitoRoundText.text = c.round
            binding.circuitoRaceNameText.text = c.grandPrixName
        }
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
            // Agrega más casos según sea necesario para otras rondas
            else -> "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
        }
    }

    private object CircuitoDiffCallBack : DiffUtil.ItemCallback<Circuito>() {
        override fun areItemsTheSame(oldItem: Circuito, newItem: Circuito) = oldItem.round == newItem.round
        override fun areContentsTheSame(oldItem: Circuito, newItem: Circuito) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircuitoListViewHolder {
        val binding = CircuitoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CircuitoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CircuitoListViewHolder, position: Int) {
        val circuito = getItem(position)
        holder.bindCircuito(circuito)
        holder.itemView.setOnClickListener {
            onItemClick(circuito)
        }
    }
}