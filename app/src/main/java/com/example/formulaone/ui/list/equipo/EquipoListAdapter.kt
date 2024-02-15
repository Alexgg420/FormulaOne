package com.example.formulaone.ui.list.equipo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.formulaone.R
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.EquipoItemBinding

class EquipoListAdapter (private val context: Context, private val onEdit: (Equipo) -> Unit
): ListAdapter<Equipo, EquipoListAdapter.EquipoViewHolder>(EquipoDiffCallBack) {
    inner class EquipoViewHolder(val binding: EquipoItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindEquipo(e: Equipo, view: View) {
            val imageUrl = obtenerUrlImagen(context)
            binding.equipoImageView.load(imageUrl)
            binding.equipoNombre.text = e.nombreEquipo
            binding.showMoreButton.setOnClickListener {
                onShowDetail(e, view)
            }
        }
    }

    fun onShowDetail(equipo: Equipo, view: View) {
        val bundle = Bundle()
        bundle.putParcelable("equipo", equipo)
        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_equipoListFragment_to_equipoDetailFragment, bundle)
    }


    private fun obtenerUrlImagen(context: Context): String {
        return Uri.parse("android.resource://${context.packageName}/${R.drawable.iconequipo}").toString()
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
        val view = holder.itemView
        holder.bindEquipo(getItem(position), view)
    }
}