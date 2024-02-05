package com.example.formulaone.data.database.equipo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulaone.data.repository.Equipo

@Entity(tableName = "equipo")
data class EquipoEntity (
    @PrimaryKey
    val id: Int,
    val nombreEquipo: String,
    val nombrePiloto1: String,
    val numeroPiloto1: Int,
    val nombrePiloto2: String,
    val numeroPiloto2: Int
)

fun List<EquipoEntity>.asListEquipo():List<Equipo> {
    return this.map {
        Equipo(
            it.id,
            it.nombreEquipo,
            it.nombrePiloto1,
            it.numeroPiloto1,
            it.nombrePiloto2,
            it.numeroPiloto2
        )
    }
}