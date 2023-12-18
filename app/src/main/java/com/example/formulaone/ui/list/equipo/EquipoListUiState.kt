package com.example.formulaone.ui.list.equipo

import com.example.formulaone.data.repository.Equipo

data class EquipoListUiState(
    val equipo: List<Equipo>,
    val errorMessage: String?=null
)
