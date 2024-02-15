package com.example.formulaone.data.database

import androidx.annotation.WorkerThread
import com.example.formulaone.data.database.circuito.CircuitoDao
import com.example.formulaone.data.database.circuito.CircuitoEntity
import com.example.formulaone.data.database.equipo.EquipoDao
import com.example.formulaone.data.database.equipo.EquipoEntity
import com.example.formulaone.data.database.piloto.PilotoDao
import com.example.formulaone.data.database.piloto.PilotoEntity
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
        circuitoDao.createCircuito(listCircuitoEntity)
    }

    @WorkerThread
    suspend fun insertt(listPilotoEntity: List<PilotoEntity>) {
        pilotoDao.createPiloto(listPilotoEntity)
    }

    suspend fun getAllPilotos(): Flow<List<PilotoEntity>> {
        return pilotoDao.getAllPilotos()
    }

    suspend fun inserttt(equipoEntity: EquipoEntity) {
        equipoDao.createEquipo(equipoEntity)
    }
}
