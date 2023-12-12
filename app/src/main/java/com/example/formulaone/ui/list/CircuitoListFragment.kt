package com.example.formulaone.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation.findNavController
import com.example.formulaone.R
import com.example.formulaone.data.adapter.CircuitoAdapter
import com.example.formulaone.data.repository.Circuito
import com.example.formulaone.databinding.FragmentCircuitoListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CircuitoListFragment : Fragment() {

    private lateinit var binding: FragmentCircuitoListBinding
    private val viewModel:CircuitoListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCircuitoListBinding.inflate(inflater,
            container,
            false,
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.circuitoList.collect{
                    val adapter = CircuitoAdapter(it, ::onShowDetail)
                    binding.circuitoList.adapter = adapter
                }
            }
        }
    }

    fun onShowDetail(circuito: Circuito, view: View) {
        val bundle = Bundle()
        bundle.putParcelable("circuito", circuito)
        val navController = findNavController(view)
        navController.navigate(R.id.action_circuitoListFragment_to_circuitoDetailFragment, bundle)
    }
}