package com.example.formulaone.ui.equipo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formulaone.data.api.pilotoApi.PilotoApiRepository
import com.example.formulaone.data.database.EquipoLocalRepository
import com.example.formulaone.data.repository.CircuitoRepository
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.data.repository.Piloto
import com.example.formulaone.ui.list.equipo.EquipoListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class EquipoViewModel @Inject constructor(private val repository: CircuitoRepository): ViewModel() {

    private val _uiState = MutableStateFlow(EquipoListUiState(listOf()))
    val uiState: StateFlow<EquipoListUiState> get() = _uiState.asStateFlow()

    private val _allPilotos = MutableStateFlow<List<Piloto>>(emptyList())
    val allPilotos: StateFlow<List<Piloto>> get() = _allPilotos

    init {
        viewModelScope.launch {
            repository.getAllPilotos().collect { pilotos ->
                _allPilotos.value = pilotos
            }

            try {
                repository.refreshList()
            } catch (e: IOException) {
                Log.e("ERROR", e.toString())
            }
            repository.allEquipos.collect() {
                _uiState.value = EquipoListUiState(it)
            }
        }
    }

    fun createEquipo(equipo: Equipo) {
        viewModelScope.launch {
            try {
                repository.createEquipo(equipo)
            } catch (e: IOException) {
                Log.e("ERROR", e.toString())
            }
        }
    }
}