package com.example.amphibians.data.di

import com.example.amphibians.data.repository.AmphibiansRepository

interface ApplicationContainer {
    val amphibiansRepository: AmphibiansRepository
}
