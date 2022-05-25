package com.example.weatherapp2.weather.data

import com.example.weatherapp2.base.Either
import com.example.weatherapp2.weather.domain.WeatherModel

interface WeatherRepo {
    suspend fun getTemperature(): Either<Throwable, WeatherModel>
}