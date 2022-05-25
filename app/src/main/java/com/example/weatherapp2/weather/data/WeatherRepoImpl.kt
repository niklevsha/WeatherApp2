package com.example.weatherapp2.weather.data

import com.example.weatherapp2.base.Either
import com.example.weatherapp2.base.attempt
import com.example.weatherapp2.weather.domain.WeatherModel

class WeatherRepoImpl(private val remoteSource: WeatherRemoteSource): WeatherRepo {
    override suspend fun getTemperature(): Either<Throwable, WeatherModel> {
        return  attempt {remoteSource.getWeather().toDomain()}
    }
}