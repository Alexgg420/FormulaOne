package com.example.formulaone.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CircuitoEntity::class], version = 1)
abstract class CircuitoDatabase(): RoomDatabase() {

    abstract fun circuitoDao(): CircuitoDao

    companion object {
        @Volatile
        private var _INSTANCE: CircuitoDatabase? = null

        fun getInstance(context: Context): CircuitoDatabase {
            return _INSTANCE ?: synchronized(this) {
                _INSTANCE ?: buildDatabase(context).also {
                    database -> _INSTANCE = database
                }
            }
        }

        private fun buildDatabase(context: Context): CircuitoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CircuitoDatabase::class.java,
                "circuito_db"
            ).build()
        }
    }
}