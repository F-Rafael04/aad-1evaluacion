package edu.iesam.aad_1evaluacion.feature.domain

import kotlinx.serialization.Serializable

@Serializable

data class Car(
    val id : String,
    val mark : String,
    val model : String,
    val plate : String,
    val owner: Owner
)
