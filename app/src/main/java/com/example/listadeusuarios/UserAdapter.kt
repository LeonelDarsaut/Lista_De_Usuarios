package com.example.listadeusuarios

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadeusuarios.databinding.ItemBinding




class UserAdapter(

    private var UsuarioDetalle: (Usuario) -> Unit
    ) : RecyclerView.Adapter<usuariosVH>() {

    private var Usuarios: List<Usuario> = emptyList()

    fun establecerUsuarios(nuevosUsuarios: List<Usuario>){

        this.Usuarios = nuevosUsuarios
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): usuariosVH {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return usuariosVH(binding)


    }



    override fun onBindViewHolder(holder: usuariosVH, position: Int) {
        val usuario = Usuarios [position]
        holder.user(usuario)
        holder.itemView.setOnClickListener { UsuarioDetalle(usuario) }
    }



    override fun getItemCount(): Int {

        return Usuarios.size

    }



}




