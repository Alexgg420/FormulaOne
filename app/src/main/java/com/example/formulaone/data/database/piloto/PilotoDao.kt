package com.example.formulaone.data.database.piloto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface PilotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createPiloto(listPilotoEntity: List<PilotoEntity>)

    @Query("SELECT * FROM piloto")
    fun getAllPilotos(): Flow<List<PilotoEntity>>

    @Transaction
    @Query("SELECT * FROM piloto")
    fun getPilotosWithEquipo(): List<PilotoEquipo>
}
