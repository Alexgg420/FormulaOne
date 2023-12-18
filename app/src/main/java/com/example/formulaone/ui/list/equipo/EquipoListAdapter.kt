package com.example.formulaone.ui.list.equipo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.EquipoItemBinding

class EquipoListAdapter (private val context: Context, private val onEdit: (Equipo) -> Unit
): ListAdapter<Equipo, EquipoListAdapter.EquipoViewHolder>(EquipoDiffCallBack) {
    var onEditClickListener: ((Equipo, View) -> Unit)? = null
    inner class EquipoViewHolder(val binding: EquipoItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindEquipo(e: Equipo) {
            val imageUrl = obtenerUrlImagen()
            binding.equipoImageView.load(imageUrl)
            binding.equipoNombre.text = e.nombre
            binding.editButton.setOnClickListener {
                onEditClickListener?.invoke(e, it)
            }
        }
    }

    private fun obtenerUrlImagen(): String {
        return "https://www.thedesignfrontier.com/wp-content/uploads/2019/05/f1-logo.png"
    }

    private object EquipoDiffCallBack: DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoViewHolder {
        val binding = EquipoItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return EquipoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EquipoViewHolder, position: Int) {
        holder.bindEquipo(getItem(position))
    }

}