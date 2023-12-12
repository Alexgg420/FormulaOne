package com.example.formulaone.data.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Circuito(
    val round: String,
    val grandPrixName: String,
    val circuitoName: String,
    val circuitoCountry: String,
    val circuitoLocal: String,
    val date: String,
    val time: String
) : Parcelable