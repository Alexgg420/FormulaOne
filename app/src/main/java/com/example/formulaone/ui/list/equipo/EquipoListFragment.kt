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
import androidx.navigation.Navigation
import com.example.formulaone.R
import com.example.formulaone.data.repository.Circuito
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
        val adapter = EquipoListAdapter(requireContext()) { equipo ->
            onShowDetail(equipo, view)
        }
        val rv = binding.equipoList
        rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    adapter.submitList(it.equipo)
                }
            }
        }

        binding.createEquipo.setOnClickListener {
            //findNavController().navigate(R.id.action_equipoListFragment_to_equipoCreateFragment)
        }
    }

    fun onShowDetail(equipo: Equipo, view: View) {
        val bundle = Bundle()
        bundle.putParcelable("equipo", equipo)
        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_equipoListFragment_to_equipoDetailFragment, bundle)
    }
}
