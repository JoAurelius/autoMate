package com.capstone.pathfinderapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Matkul (
    val id: Int,
    val name: String,
    val code: String,
    val prof: String,
    val day: String,
    val jam: String
    ) : Parcelable