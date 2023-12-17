package com.example.formulaone.data.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Equipo(
    var id: Int,
    val nombre: String,
    val piloto1: String,
    val piloto2: String
) : Parcelable