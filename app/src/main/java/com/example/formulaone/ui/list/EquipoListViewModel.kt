package com.example.formulaone.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formulaone.data.repository.CircuitoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class EquipoListViewModel @Inject constructor(private val repository: CircuitoRepository): ViewModel() {
    private val _uiState = MutableStateFlow(EquipoListUiState(listOf()))
    val uiState: StateFlow<EquipoListUiState>
        get() = _uiState.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                repository.refreshList()
            } catch (e:IOException) {
                Log.e("ERROR", e.toString())
            }
        }
        viewModelScope.launch {
            repository.allEquipo.collect{
                _uiState.value = EquipoListUiState(it)
            }
        }
    }
}