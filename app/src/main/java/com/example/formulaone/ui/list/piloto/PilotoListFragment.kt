package com.example.formulaone.ui.list.piloto

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
import com.example.formulaone.data.repository.Piloto
import com.example.formulaone.databinding.FragmentPilotoListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PilotoListFragment : Fragment() {

    private lateinit var binding: FragmentPilotoListBinding
    private val viewModel: PilotoListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPilotoListBinding.inflate(inflater,
            container,
            false,
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PilotoListAdapter(requireContext()) { piloto ->
            onShowDetail(piloto, view)
        }
        val rv = binding.pilotoList
        rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect{
                    adapter.submitList(it.piloto)
                }
            }
        }
    }

    fun onShowDetail(piloto: Piloto, view: View) {
        val bundle = Bundle()
        bundle.putParcelable("piloto", piloto)
        val navController = findNavController(view)
        navController.navigate(R.id.action_pilotoListFragment_to_pilotoDetailFragment, bundle)
    }
}