package com.example.listadeusuarios

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.listadeusuarios.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var lista: ActivityMainBinding
    lateinit var Adapter: UserAdapter

    private lateinit var repoDatos: RepositorioDatos

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        lista = ActivityMainBinding.inflate(layoutInflater)
        repoDatos = RepositorioDatos(this)
        setContentView(lista.root)
        Adapter = UserAdapter{ Detalle -> NavegarAlDetalle(Detalle)
        }
        lista.lista.adapter = Adapter

        refrescando()
        refrescar()

    }


    private fun NavegarAlDetalle(usuario: Usuario) {

        val intent = Intent(this, UserdetalleActivity::class.java)
        intent.putExtra(UserdetalleActivity.EXTRA_USER, usuario)

        startActivity(intent)

    }

    private fun refrescar() {

        lista.refrescar.setColorSchemeResources(R.color.purple_500, R.color.verde, R.color.gris, R.color.white)

        lista.refrescar.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this,
            R.color.black))

        lista.refrescar.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {

            override fun onRefresh() {
               refrescando()
            }

        })

    }




        private fun refrescando (){

     repoDatos.obtenerUsuarios(

         callbackResultados = { Usuarios ->

             lista.refrescar.isRefreshing = false

             Adapter.establecerUsuarios(Usuarios)

         },

         callbackThrowable = {
             t -> lista.refrescar.isRefreshing = false
             Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show()

         }

     )


 }


    }





