package com.example.weatherapp2.weather.data

import com.example.weatherapp2.weather.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather("Moscow")
    }
}