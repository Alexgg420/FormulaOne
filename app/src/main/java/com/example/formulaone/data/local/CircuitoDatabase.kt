package com.example.formulaone.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CircuitoEntity::class, PilotoEntity::class], version = 2)
abstract class CircuitoDatabase : RoomDatabase() {

    abstract fun circuitoDao(): CircuitoDao

    abstract fun pilotoDao(): PilotoDao

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
