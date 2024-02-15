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