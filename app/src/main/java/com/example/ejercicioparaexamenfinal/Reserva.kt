package com.example.ejercicioparaexamenfinal

import com.google.firebase.firestore.Exclude

data class Reserva (
    @get: Exclude var id: String?=null,
            var cliente: String? = null,
            var dia: String? = null,
            var hora: String? = null,
            var especialista: String? = null

)