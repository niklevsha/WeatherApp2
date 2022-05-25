package com.example.weatherapp2

import android.app.Application
import com.example.weatherapp2.di.networkModule
import com.example.weatherapp2.di.weatherModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(weatherModule, networkModule)
        }
    }
}