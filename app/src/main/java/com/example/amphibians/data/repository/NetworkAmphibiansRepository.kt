package com.example.amphibians.data.repository

import com.example.amphibians.data.apiService.AmphibiansApiService
import com.example.amphibians.model.Amphibian

class NetworkAmphibiansRepository(private val retrofitService: AmphibiansApiService) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return retrofitService.getAmphibians()
    }
}