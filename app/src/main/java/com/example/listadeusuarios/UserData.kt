
package com.example.listadeusuarios

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



data class ResultadoRandomUser (

    val results: List <Usuarios>

    )

data class Usuarios (

    val gender: String,
    val name: Names,
    val email: String,
    val phone: String,
    val picture: Pictures,
    val nat: String

        )


data class Names (

    val title: String,
    val first: String,
    val last: String,
        )

data class Pictures (

    val large: String,
    val medium: String,
    val thumbnail: String

        )



    @Parcelize
    data class Usuario(

        val name: String,
        val email: String,
        val dob: String,
        val picture: String,
        val largePicture: String

    ) : Parcelable
