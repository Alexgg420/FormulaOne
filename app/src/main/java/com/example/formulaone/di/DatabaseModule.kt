package com.example.formulaone.di

import android.content.Context
import com.example.formulaone.data.local.CircuitoDao
import com.example.formulaone.data.local.CircuitoDatabase
import com.example.formulaone.data.local.PilotoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {
    @Singleton
    @Provides
    fun provideCircuitoDatabase(@ApplicationContext context: Context):CircuitoDatabase {
        return CircuitoDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideCircuitoDao(database: CircuitoDatabase): CircuitoDao {
        return database.circuitoDao()
    }

    @Singleton
    @Provides
    fun providePilotoDao(database: CircuitoDatabase): PilotoDao {
        return database.pilotoDao()
    }
}