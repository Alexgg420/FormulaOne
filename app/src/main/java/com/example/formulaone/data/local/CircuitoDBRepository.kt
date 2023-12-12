package com.example.formulaone.data.local

import androidx.annotation.WorkerThread
import com.example.formulaone.data.local.CircuitoDao
import com.example.formulaone.data.local.CircuitoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CircuitoDBRepository @Inject constructor(private val circuitoDao: CircuitoDao) {
    val allCircuitos: Flow<List<CircuitoEntity>> = circuitoDao.getAllCircuitos()

    @WorkerThread
    suspend fun insert(listCircuitoEntity: List<CircuitoEntity>) {
        circuitoDao.createCircuit(listCircuitoEntity)
    }
}