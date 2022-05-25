package com.example.weatherapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp2.weather.WeatherFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, WeatherFragment()).commit()
    }
}