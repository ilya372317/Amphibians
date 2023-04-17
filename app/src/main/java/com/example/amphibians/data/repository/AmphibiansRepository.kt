package com.example.amphibians.data.repository

import com.example.amphibians.model.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}