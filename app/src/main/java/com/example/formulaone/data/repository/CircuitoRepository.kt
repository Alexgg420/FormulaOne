package com.example.formulaone.data.repository

import com.example.formulaone.data.api.CircuitoApiRepository
import com.example.formulaone.data.api.asEntityModelList
import com.example.formulaone.data.local.CircuitoDBRepository
import com.example.formulaone.data.local.asListCircuit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CircuitoRepository @Inject constructor(
    private val dbRepository: CircuitoDBRepository,
    private val apiRepository: CircuitoApiRepository
) {
    val allCircuitos: Flow<List<Circuito>>
        get() {
            return dbRepository.allCircuitos.map {
                listCircuitoEntity -> listCircuitoEntity.asListCircuit()
            }
        }

    suspend fun refreshList() = withContext(Dispatchers.IO){
        val circuitoApiModelList = apiRepository.getAllCircuitos()
        dbRepository.insert(circuitoApiModelList.asEntityModelList())
    }
}