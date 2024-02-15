package com.example.formulaone.data.repository

import com.example.formulaone.data.api.circuitoApi.CircuitoApiRepository
import com.example.formulaone.data.api.circuitoApi.asEntityModelList
import com.example.formulaone.data.api.pilotoApi.PilotoApiRepository
import com.example.formulaone.data.api.pilotoApi.asEntityModelList
import com.example.formulaone.data.api.pilotoApi.asEntityModel
import com.example.formulaone.data.database.CircuitoDBRepository
import com.example.formulaone.data.database.EquipoLocalRepository
import com.example.formulaone.data.database.circuito.asListCircuit
import com.example.formulaone.data.database.equipo.EquipoEntity
import com.example.formulaone.data.database.equipo.asListEquipo
import com.example.formulaone.data.database.piloto.asListPiloto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CircuitoRepository @Inject constructor(
    private val dbRepository: CircuitoDBRepository,
    private val apiRepository: CircuitoApiRepository,
    private val apiRepository2: PilotoApiRepository
) {
    val allCircuitos: Flow<List<Circuito>>
        get() = dbRepository.allCircuitos
            .map { entities ->
                withContext(Dispatchers.Default) {
                    entities.asListCircuit()
                }
            }

    val allPilotos: Flow<List<Piloto>>
        get() = dbRepository.allPilotos
            .map { entities ->
                withContext(Dispatchers.Default) {
                    entities.asListPiloto()
                }
            }

    suspend fun getAllPilotos(): Flow<List<Piloto>> {
        return dbRepository.getAllPilotos().map { it.asListPiloto() }
    }

    suspend fun refreshList() {
        withContext(Dispatchers.IO) {
            try {
                val apiCircuito = apiRepository.getAllCircuitos()
                val apiPiloto = apiRepository2.getAllPilotos()
                dbRepository.insert(apiCircuito.asEntityModelList())
                dbRepository.insertt(apiPiloto.asEntityModelList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    val allEquipos: Flow<List<Equipo>>
        get() {
            val list = dbRepository.allEquipos.map {
                it.asListEquipo()
            }
            return list
        }

    // Función para encontrar el ID del último equipo creado
    private suspend fun encontrarUltimoIdEquipo(): Int {
        val equipos = dbRepository.allEquipos.firstOrNull()
        return equipos?.maxByOrNull { it.id }?.id ?: 0
    }

    suspend fun createEquipo(equipo: Equipo) {
        withContext(Dispatchers.IO) {
            val ultimoId = encontrarUltimoIdEquipo()
            val nuevoId = ultimoId + 1
            val equipoEntity = EquipoEntity(
                nuevoId,
                equipo.nombreEquipo,
                equipo.piloto1Nombre,
                equipo.piloto1Number,
                equipo.piloto2Nombre,
                equipo.piloto2Number
            )
            dbRepository.inserttt(equipoEntity)
        }
    }
}