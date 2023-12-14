package com.example.formulaone.data.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Piloto(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val name: String,
    val surname: String,
    val fecNac: String,
    val nation: String
) : Parcelable