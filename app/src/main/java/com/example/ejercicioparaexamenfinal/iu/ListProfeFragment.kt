package com.example.ejercicioparaexamenfinal.iu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioparaexamenfinal.Profesor
import com.example.ejercicioparaexamenfinal.ProfesorAdapter
import com.example.ejercicioparaexamenfinal.databinding.FragmentListProfeBinding
import com.google.firebase.firestore.FirebaseFirestore


class ListProfeFragment : Fragment() {
    private lateinit var binding: FragmentListProfeBinding
    private lateinit var mAdapter: ProfesorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListProfeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configButton()
    }


    private fun configButton() {
        binding.imageList.setOnClickListener {
            mostrar()
            configRecycler()
        }
        binding.imageView2.setOnClickListener {
            mostrarFiltOne()
            configRecycler()
        }
    }

    private fun mostrarFiltOne() {
        TODO("Not yet implemented")
    }

    private fun configRecycler() {
        mAdapter = ProfesorAdapter(mutableListOf())
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    private fun mostrar() {
        val mFirebaseFirestore = FirebaseFirestore.getInstance()
        mFirebaseFirestore.collection("profesor")
            .get()
            .addOnSuccessListener {
                for (document in it) {
                    val profesor = document.toObject(Profesor::class.java)
                    profesor.id = document.id  //la id del producto es el id de firebase
                    mAdapter.add(profesor)
                }
            }
            .addOnFailureListener {
                Toast.makeText(
                    requireActivity(),
                    "Error al consultar los datos",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }
}