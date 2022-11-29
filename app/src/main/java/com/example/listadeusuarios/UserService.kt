package com.example.listadeusuarios


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface UserService {

    @GET (" ")
    fun UserRandom(
        @Query("results")
        Resultados: Int,


        @Query ("inc")
        Incluir: String,

        @QueryName

        Dato: String

        ): Call<ResultadoRandomUser>

}