package com.example.formulaone.data.database.piloto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.formulaone.data.database.equipo.EquipoEntity
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

data class PilotoEquipo(
    @Embedded val piloto: PilotoEntity,
    @Relation(
        parentColumn = "name",
        entityColumn = "nombrePiloto1"
    ) val formacion : List<EquipoEntity>
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