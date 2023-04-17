package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.di.ApplicationContainer
import com.example.amphibians.data.di.DefaultApplicationContainer

class AmphibiansApplication : Application() {
    lateinit var container : ApplicationContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer()
    }
}