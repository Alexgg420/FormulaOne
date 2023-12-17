package com.example.formulaone.data.local

import com.example.formulaone.data.repository.Equipo

class EquipoLocalRepository() {
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
    fun delete(id:Int) {
        val existingEquipo = _equipo.find {it.id == id}
        if (existingEquipo != null) {
            _equipo.remove(existingEquipo)
        }
    }
    fun update(equipo: Equipo) {
        val existingEquipo = _equipo.find {it.id == equipo.id}
        if (existingEquipo != null) {
            val index = _equipo.indexOf(existingEquipo)
            _equipo[index] = equipo
        }
    }
}