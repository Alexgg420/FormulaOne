package com.example.formulaone.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulaone.data.repository.Circuito
import com.example.formulaone.data.repository.Piloto

@Entity(tableName = "piloto")
data class PilotoEntity (
    @PrimaryKey
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val name: String,
    val surname: String,
    val fecNac: String,
    val nation: String
)

fun List<PilotoEntity>.asListPiloto():List<Piloto> {
    return this.map {
        Piloto(
            it.driverId,
            it.permanentNumber,
            it.code,
            it.name,
            it.surname,
            it.fecNac,
            it.nation
        )
    }
}