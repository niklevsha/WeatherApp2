package com.example.weatherapp2.weather.data

import com.example.weatherapp2.weather.data.model.WeatherRemoteModel
import com.example.weatherapp2.weather.domain.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(temp = this.main.temp)