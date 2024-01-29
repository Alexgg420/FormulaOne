package com.example.formulaone.data.local

import androidx.annotation.WorkerThread
import com.example.formulaone.data.local.CircuitoDao
import com.example.formulaone.data.local.CircuitoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CircuitoDBRepository @Inject constructor(private val circuitoDao: CircuitoDao, private val pilotoDao: PilotoDao, private val equipoDao: EquipoDao) {
    val allCircuitos: Flow<List<CircuitoEntity>> = circuitoDao.getAllCircuitos()
    val allPilotos: Flow<List<PilotoEntity>> = pilotoDao.getAllPilotos()
    val allEquipos: Flow<List<EquipoEntity>> = equipoDao.getAllEquipos()

    @WorkerThread
    suspend fun insert(listCircuitoEntity: List<CircuitoEntity>) {
        circuitoDao.createCircuit(listCircuitoEntity)
    }

    @WorkerThread
    suspend fun insertt(listPilotoEntity: List<PilotoEntity>) {
        pilotoDao.createPiloto(listPilotoEntity)
    }

    @WorkerThread
    suspend fun inserttt(listEquipoEntity: List<EquipoEntity>) {
        equipoDao.createEquipo(listEquipoEntity)
    }
}
