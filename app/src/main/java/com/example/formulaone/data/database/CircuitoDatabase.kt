package com.example.formulaone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.formulaone.data.database.circuito.CircuitoDao
import com.example.formulaone.data.database.circuito.CircuitoEntity
import com.example.formulaone.data.database.equipo.EquipoDao
import com.example.formulaone.data.database.equipo.EquipoEntity
import com.example.formulaone.data.database.piloto.PilotoDao
import com.example.formulaone.data.database.piloto.PilotoEntity

@Database(entities = [CircuitoEntity::class, PilotoEntity::class, EquipoEntity::class], version = 4)
abstract class CircuitoDatabase : RoomDatabase() {

    abstract fun circuitoDao(): CircuitoDao

    abstract fun pilotoDao(): PilotoDao

    abstract fun equipoDao(): EquipoDao

    companion object {
        @Volatile
        private var INSTANCE: CircuitoDatabase? = null

        fun getInstance(context: Context): CircuitoDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }
        }

        private fun buildDatabase(context: Context): CircuitoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CircuitoDatabase::class.java,
                "circuito_db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}
