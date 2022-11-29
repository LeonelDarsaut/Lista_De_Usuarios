package com.example.listadeusuarios
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  androidx.fragment.app.Fragment
import com.example.listadeusuarios.databinding.BienvenidaBinding

class Fragment: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.bienvenida, container, false )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val main: View = view.findViewById(R.id.contenedor)
        main.setOnClickListener {

            val intent = Intent(activity, UserdetalleActivity::class.java)

            startActivity(intent)
        }

    }

}