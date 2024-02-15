package com.example.formulaone.data.repository

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Equipo(
    var id: Int,
    val nombreEquipo: String,
    val piloto1Nombre: String,
    val piloto1Number: Int,
    val piloto2Nombre: String,
    val piloto2Number: Int,
) : Parcelable