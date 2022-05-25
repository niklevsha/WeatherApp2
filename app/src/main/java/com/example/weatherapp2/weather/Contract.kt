package com.example.weatherapp2.weather
import com.example.weatherapp2.base.Event
data class ViewState(
    val isLoading: Boolean,
    val temperature: Float
)

sealed class UiEvent(): Event {
    object OnButtonClicked: UiEvent()
}

sealed class DataEvent(): Event {
    data class OnWeatherFetchSucceed(val temperature: Float): DataEvent()
}