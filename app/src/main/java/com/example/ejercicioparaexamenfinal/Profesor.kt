package com.example.ejercicioparaexamenfinal

import com.google.firebase.firestore.Exclude

data class Profesor(
    @get: Exclude var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var turno: String? = null,
    var antiguedad: Int? = 0
)