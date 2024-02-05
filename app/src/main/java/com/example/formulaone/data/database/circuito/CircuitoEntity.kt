package com.example.formulaone.data.database.circuito

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formulaone.data.repository.Circuito

@Entity(tableName = "circuito")
data class CircuitoEntity (
    @PrimaryKey
    val round: String,
    val grandPrixName: String,
    val circuitName: String,
    val circuitCountry: String,
    val circuitLocal: String,
    val date: String,
    val time: String
)

fun List<CircuitoEntity>.asListCircuit():List<Circuito> {
    return this.map {
        Circuito(
            it.round,
            it.grandPrixName,
            it.circuitName,
            it.circuitCountry,
            it.circuitLocal,
            it.date,
            it.time
        )
    }
}