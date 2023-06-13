package com.example.ejercicioparaexamenfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioparaexamenfinal.databinding.ItemListadoBinding

class ProfesorAdapter(private val profesorList: MutableList<Profesor>) :
    RecyclerView.Adapter<ProfesorAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfesorAdapter.ViewHolder {
        mContext = parent.context //inicializar el contexto
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_listado, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfesorAdapter.ViewHolder, position: Int) {
        var item = profesorList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return profesorList.size
    }

    fun add(profesor: Profesor) {
        profesorList.add(profesor)
        notifyItemInserted(profesorList.size - 1)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListadoBinding.bind(view)

        fun bind(profesor: Profesor) {
            binding.textViewNombre.text = profesor.name
            binding.textViewEmail.text = profesor.email
            //  binding.texViewAnti.text = profesor.turno
        }
    }
}