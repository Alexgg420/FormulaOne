package com.example.formulaone.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CircuitoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCircuit(listCircuitoEntity: List<CircuitoEntity>)
    @Query("SELECT * FROM circuito")
    fun getAllCircuitos(): Flow<List<CircuitoEntity>>
}