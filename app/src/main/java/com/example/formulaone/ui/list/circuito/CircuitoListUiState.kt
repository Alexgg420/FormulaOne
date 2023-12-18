package com.example.formulaone.ui.list.circuito

import com.example.formulaone.data.repository.Circuito

data class CircuitoListUiState(
    val circuito: List<Circuito>,
    val errorMessage: String?=null
)
