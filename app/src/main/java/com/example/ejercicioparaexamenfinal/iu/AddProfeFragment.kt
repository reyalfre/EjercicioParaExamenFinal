package com.example.ejercicioparaexamenfinal.iu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ejercicioparaexamenfinal.Profesor
import com.example.ejercicioparaexamenfinal.ProfesorAdapter
import com.example.ejercicioparaexamenfinal.R
import com.example.ejercicioparaexamenfinal.databinding.FragmentAddProfeBinding
import com.google.firebase.firestore.FirebaseFirestore


class AddProfeFragment : Fragment() {
    private lateinit var mBinding: FragmentAddProfeBinding

    private lateinit var mAdapter: ProfesorAdapter
    lateinit var profesorValor: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentAddProfeBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configButton()

    }

    private fun configButton() {
        mBinding.floatingAction.setOnClickListener {
            var profesor = Profesor(
                name = mBinding.edittextName.text.toString().trim(),
                email = mBinding.edittextEmail.text.toString().trim(),

                )
            grabarDatos(profesor)
        }
    }

    private fun grabarDatos(profesor: Profesor) {
        val mFirebaseFirestore = FirebaseFirestore.getInstance()

        mFirebaseFirestore.collection("profesor")

            .add(profesor)
            .addOnSuccessListener {
                Toast.makeText(requireActivity(), "Completado, se ha añadido", Toast.LENGTH_SHORT)
                    .show()
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Error no añadido", Toast.LENGTH_SHORT).show()
            }
    }
}