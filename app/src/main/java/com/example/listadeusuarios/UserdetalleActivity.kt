package com.example.listadeusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.listadeusuarios.databinding.UserdetalleBinding
import kotlinx.android.synthetic.main.userdetalle.*

class UserdetalleActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_USER = "UsernameActivity:name"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val Detalle = UserdetalleBinding.inflate(layoutInflater)

        setContentView(Detalle.root)

        val name = intent.getParcelableExtra<Usuario>(EXTRA_USER)

        if (name  != null){

        Detalle.nombre.text = name.name
        Detalle.numero.text = name.email
            Detalle.postal.text = name.dob
            Glide.with(this).load(name.picture).into(Detalle.imagen2)

        }


    }
}