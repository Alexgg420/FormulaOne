package com.example.formulaone.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface CircuitoApi {
    @GET("api/f1/2023.json")
    suspend fun getAllCircuitos(): CircuitSuperResponse
    @GET("api/f1/2023/{round}.json")
    suspend fun getDetailCircuito(@Path("round") round:String):Races
}

@Singleton
class CircuitoService @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ergast.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: CircuitoApi = retrofit.create(CircuitoApi::class.java)
}