package com.example.formulaone.ui.list.equipo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.setFragmentResultListener
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.databinding.FragmentEquipoListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EquipoListFragment : Fragment() {

    private lateinit var binding: FragmentEquipoListBinding
    private val viewModel: EquipoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipoListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = EquipoListAdapter(requireContext(), ::onEdit)
        val rv = binding.equipoList
        rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    adapter.submitList(it.equipo)
                }
            }
        }

        // Escuchar los resultados del fragmento hijo
        setFragmentResultListener("equipoKey") { _, result ->
            val equipo = result.getParcelable<Equipo>("equipo")
            // Hacer algo con el objeto 'equipo' recibido
            // Por ejemplo, agregarlo a la lista, actualizar la vista, etc.
            //viewModel.addEquipo(equipo) // Asume que tienes un método en el viewModel para agregar un nuevo equipo
        }

        binding.createEquipo.setOnClickListener {
            onNew()
        }
    }

    fun onNew() {
        val action = EquipoListFragmentDirections.actionEquipoListFragmentToEquipoDetailFragment()
        findNavController().navigate(action)
    }

    fun onEdit(equipo: Equipo) {
        // Puedes implementar la edición del equipo aquí
    }

    fun onCancel() {
        // Puedes implementar la cancelación aquí
    }
}
