package com.example.formulaone.data.database.equipo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createEquipo(listEquipoEntity: List<EquipoEntity>)

    @Query("SELECT * FROM equipo")
    fun getAllEquipos(): Flow<List<EquipoEntity>>
}
