package com.example.formulaone.ui.list

import com.example.formulaone.data.repository.Piloto

data class PilotoListUiState(
    val piloto: List<Piloto>,
    val errorMessage: String?=null
)
