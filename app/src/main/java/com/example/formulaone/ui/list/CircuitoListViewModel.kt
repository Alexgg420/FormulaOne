package com.example.formulaone.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formulaone.data.api.CircuitoApiModel
import com.example.formulaone.data.api.CircuitoListApiModel
import com.example.formulaone.data.repository.CircuitoRepository
import com.example.formulaone.data.repository.Circuito
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CircuitoListViewModel @Inject constructor(private val repository: CircuitoRepository): ViewModel() {
    private val _uiState = MutableStateFlow(CircuitoListUiState(listOf()))
    val uiState: StateFlow<CircuitoListUiState>
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
            repository.allCircuitos.collect{
                _uiState.value = CircuitoListUiState(it)
            }
        }
    }
}