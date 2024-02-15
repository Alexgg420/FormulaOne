package com.example.formulaone.ui.list.piloto

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.formulaone.data.repository.Piloto
import com.example.formulaone.databinding.PilotoItemBinding

class PilotoListAdapter(private val context: Context, private val onItemClick: (Piloto) -> Unit): ListAdapter<Piloto, PilotoListAdapter.PilotoListViewHolder>(
    PilotoDiffCallBack
) {

    inner class PilotoListViewHolder(private val binding: PilotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindPiloto(p: Piloto) {
            val imageUrl = obtenerUrlImagen(p.driverId)
            binding.pilotoImageView.load(imageUrl)
            binding.pilotoNameText.text = p.name + " " + p.surname
            binding.pilotoNumber.text = p.permanentNumber
        }
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

    private object PilotoDiffCallBack : DiffUtil.ItemCallback<Piloto>() {
        override fun areItemsTheSame(oldItem: Piloto, newItem: Piloto) = oldItem.driverId == newItem.driverId
        override fun areContentsTheSame(oldItem: Piloto, newItem: Piloto) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PilotoListViewHolder {
        val binding = PilotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PilotoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PilotoListViewHolder, position: Int) {
        val piloto = getItem(position)
        holder.bindPiloto(piloto)
        holder.itemView.setOnClickListener {
            onItemClick(piloto)
        }
    }
}