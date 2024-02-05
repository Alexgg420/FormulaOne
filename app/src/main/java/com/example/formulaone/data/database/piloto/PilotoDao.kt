package com.example.formulaone.data.database.piloto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PilotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createPiloto(listPilotoEntity: List<PilotoEntity>)

    @Query("SELECT * FROM piloto")
    fun getAllPilotos(): Flow<List<PilotoEntity>>
}
