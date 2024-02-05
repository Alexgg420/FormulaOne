package com.example.formulaone.data.database.circuito

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CircuitoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCircuito(listCircuitoEntity: List<CircuitoEntity>)

    @Query("SELECT * FROM circuito")
    fun getAllCircuitos(): Flow<List<CircuitoEntity>>
}
