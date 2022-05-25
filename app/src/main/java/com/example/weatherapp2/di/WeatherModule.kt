package com.example.weatherapp2.di

import com.example.weatherapp2.weather.WeatherViewModel
import com.example.weatherapp2.weather.data.WeatherApi
import com.example.weatherapp2.weather.data.WeatherRemoteSource
import com.example.weatherapp2.weather.data.WeatherRepo
import com.example.weatherapp2.weather.data.WeatherRepoImpl
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val API_KEY = "15e054a7e38f0402752ace1bbc1b6020"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
val weatherModule = module {
    viewModel {
        WeatherViewModel(get())

    }
    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }
    single<WeatherRemoteSource> {
        WeatherRemoteSource(get())
    }
    single<WeatherRepo> {
        WeatherRepoImpl(get())
    }
}
val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single<OkHttpClient> {
        OkHttpClient.Builder().build()
    }
}