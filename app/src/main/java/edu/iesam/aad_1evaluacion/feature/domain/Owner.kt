package edu.iesam.aad_1evaluacion.feature.domain

import kotlinx.serialization.Serializable

@Serializable

data class Owner(
    val dni : String,
    val name : String,
    val subname : String
)
