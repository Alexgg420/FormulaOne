package com.example.formulaone.data.database

import android.util.Log
import com.example.formulaone.data.repository.Equipo
import javax.inject.Inject

class EquipoLocalRepository @Inject constructor() {
    companion object {
        private var _INSTANCE:EquipoLocalRepository? = null
        fun getInstance():EquipoLocalRepository {
            if (_INSTANCE == null) {
                _INSTANCE = EquipoLocalRepository()
            }
            return _INSTANCE!!
        }
    }
    private val _equipo = mutableListOf<Equipo>()
    private var id = 0

    val equipo:List<Equipo>
        get() = _equipo

    fun add(equipo: Equipo) {
        equipo.id = ++id
        _equipo.add(equipo)
    }

    suspend fun getAllEquipos(): List<Equipo> {
        try {
            val equipos = _equipo.map { equipoListItem ->
                Equipo(
                    equipoListItem.id,
                    equipoListItem.nombreEquipo,
                    equipoListItem.piloto1Nombre,
                    equipoListItem.piloto1Number,
                    equipoListItem.piloto2Nombre,
                    equipoListItem.piloto2Number
                )
            }
            return equipos
        } catch (e: Exception) {
            // Manejar errores al obtener los equipos
            Log.e("Error", "Error al obtener equipos", e)
            return emptyList()
        }
    }
}