package com.example.amphibians.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("img_src")
    val imgSrc: String
)
