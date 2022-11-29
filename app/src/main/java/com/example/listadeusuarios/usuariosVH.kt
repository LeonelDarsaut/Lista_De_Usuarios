package com.example.listadeusuarios


import android.service.autofill.UserData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listadeusuarios.databinding.ItemBinding

class usuariosVH(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun user(Usuarios: Usuario){

        binding.nombre.text = Usuarios.name
        binding.fecha.text = Usuarios.email
        binding.pais.text = Usuarios.dob
        Glide.with(binding.root.context).load(Usuarios.picture).into(binding.ola)

    }




    }


