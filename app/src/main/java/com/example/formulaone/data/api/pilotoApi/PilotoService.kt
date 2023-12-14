package com.example.formulaone.data.api.pilotoApi

import com.example.formulaone.data.api.circuitoApi.CircuitSuperResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

interface PilotoApi {
    @GET("api/f1/2023/drivers.json")
    suspend fun getAllPilotos(): Root
    @GET("api/f1/2023/drivers/{driverId}.json")
    suspend fun getDetailPiloto(@Path("driverId") driverId:String): Root
}

@Singleton
class PilotoService @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ergast.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: PilotoApi = retrofit.create(PilotoApi::class.java)
}