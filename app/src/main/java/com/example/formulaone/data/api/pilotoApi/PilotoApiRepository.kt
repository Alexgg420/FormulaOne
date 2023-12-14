package com.example.formulaone.data.api.pilotoApi

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PilotoApiRepository @Inject constructor(private val service: PilotoService){

    suspend fun getAllPilotos(): List<PilotoApiModel> {
        val simpleList = service.api.getAllPilotos()
        return simpleList.mrdata.driverTable.drivers.map { pilotoListItem ->
            try {
                val response = service.api.getDetailPiloto(pilotoListItem.driverId)
                response.mrdata.driverTable.drivers[0].asApiModel()
            } catch (e: Exception) {
                Log.e("Error", "Error al obtener detalles del piloto para el id ${pilotoListItem.driverId}", e)
                null
            }!!
        }
    }
}