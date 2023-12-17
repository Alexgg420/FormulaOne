package com.example.formulaone.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulaone.data.repository.Circuito
import com.example.formulaone.data.repository.Equipo
import com.example.formulaone.data.repository.Piloto

@Entity(tableName = "equipo")
data class EquipoEntity (
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val piloto1: String,
    val piloto2: String
)

fun List<EquipoEntity>.asListEquipo():List<Equipo> {
    return this.map {
        Equipo(
            it.id,
            it.nombre,
            it.piloto1,
            it.piloto2
        )
    }
}