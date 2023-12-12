package com.example.formulaone.data.api

import com.example.formulaone.data.local.CircuitoEntity
import com.google.gson.annotations.SerializedName

data class CircuitoApiModel(
    val round: String,
    val grandPrixName: String,
    val circuitoName: String,
    val circuitoCountry: String,
    val circuitoLocal: String,
    val date: String,
    val time: String
)

data class CircuitoListApiModel(
    val circuitoList: List<CircuitoApiModel>
)

data class CircuitSuperResponse(
    @SerializedName("MRData")
    val mrdata: CircuitSuperListResponse,
)

data class CircuitSuperListResponse(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("RaceTable")
    val raceTable: CircuitListResponse,
)

data class CircuitListResponse(
    val season: String,
    @SerializedName("Races")
    val races: List<Races>,
)

data class Races(
    val round: String,
    val raceName: String,
    @SerializedName("Circuit")
    val circuit: Circuit,
    val date: String,
    val time: String,
){
    fun asApiModel():CircuitoApiModel {
        return CircuitoApiModel(
            round,
            raceName,
            circuit.circuitName,
            circuit.location.country,
            circuit.location.locality,
            date,
            time
        )
    }
}

data class CircuitDetailResponse(
    @SerializedName("MRData")
    val mrdata: Mrdata,
)

data class Mrdata(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("RaceTable")
    val raceTable: RaceTable,
)

data class RaceTable(
    val season: String,
    @SerializedName("Races")
    val races: List<CircuitDetailItemsResponse>,
)

data class CircuitDetailItemsResponse(
    val round: String,
    val raceName: String,
    @SerializedName("Circuit")
    val circuit: Circuit,
    val date: String,
    val time: String,
)

data class Circuit(
    val circuitName: String,
    @SerializedName("Location")
    val location: Location,
)

data class Location(
    val locality: String,
    val country: String,
)

fun List<CircuitoApiModel>.asEntityModelList(): List<CircuitoEntity> {
    return this.map {
        CircuitoEntity(
            it.round,
            it.grandPrixName,
            it.circuitoName,
            it.circuitoCountry,
            it.circuitoLocal,
            it.date,
            it.time,
        )
    }
}