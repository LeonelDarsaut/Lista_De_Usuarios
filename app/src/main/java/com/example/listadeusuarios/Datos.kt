package com.example.listadeusuarios

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RepositorioDatos(val context: Context) {

    private val Datos: UserService

    init {
        val moshi: Moshi = Moshi.Builder()      // Builder -> objeto constructor
            .add(KotlinJsonAdapterFactory())    // Agregamos esto para que Moshi pueda convertir clases de Kotlin a Json automáticamente
            .build()


        val conversorMoshi = MoshiConverterFactory.create(moshi)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/1.4/")
            .addConverterFactory(conversorMoshi)
            .build()


        Datos = retrofit.create(UserService::class.java)
    }

        fun obtenerUsuarios(

            callbackResultados: (List<Usuario>) -> Unit,
            callbackThrowable: (Throwable) -> Unit

        ) {

            val call = Datos.UserRandom(
                Resultados = 20,
                Incluir = "name,gender,age,email,phone,picture,nat",
                Dato = "noinfo"
            )

            call.enqueue(object : Callback<ResultadoRandomUser> {

                override fun onResponse(
                    call: Call<ResultadoRandomUser>,
                    response: Response<ResultadoRandomUser>
                ) {
                    if (response.isSuccessful) {

                        val resultado = response.body()
                        val RandomUsers = if (resultado?.results == null) {
                            emptyList()
                        } else {
                            resultado.results
                        }

                        val Usuarios = ArrayList<Usuario>()
                        for (RandomUser in RandomUsers) {
                            val Usuario = RandomUserAUser(RandomUser)
                            Usuarios.add(Usuario)
                        }

                        retrasar {

                            callbackResultados(Usuarios.shuffled())

                        }

                    }
                }
                override fun onFailure(call: Call<ResultadoRandomUser>, t: Throwable) {
                    retrasar {
                        callbackThrowable(t)
                    }
                }
            })

        }

    private fun RandomUserAUser(Usuario: Usuarios): Usuario {
        return Usuario(
            name = Usuario.name.first,
            email = Usuario.email,
            dob = Usuario.phone,
            picture = Usuario.picture.large,
            largePicture = Usuario.picture.large
        )
    }

    private fun retrasar(hacer: () -> Unit) {

        val thread = Thread {

            Thread.sleep(2200)

            Handler(Looper.getMainLooper()).post(hacer)
        }
        thread.start()
    }


}