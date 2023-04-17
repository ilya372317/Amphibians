package com.example.amphibians.data.di

import com.example.amphibians.data.apiService.AmphibiansApiService
import com.example.amphibians.data.repository.AmphibiansRepository
import com.example.amphibians.data.repository.NetworkAmphibiansRepository
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType

class DefaultApplicationContainer() : ApplicationContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService : AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansRepository: AmphibiansRepository
        get() = NetworkAmphibiansRepository(retrofitService)
}
