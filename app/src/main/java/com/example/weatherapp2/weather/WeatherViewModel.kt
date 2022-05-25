package com.example.weatherapp2.weather

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.weatherapp2.base.BaseViewModel
import com.example.weatherapp2.base.Event
import com.example.weatherapp2.weather.data.WeatherRepo
import com.example.weatherapp2.weather.data.WeatherRepoImpl
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepo) : BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState {
        return ViewState(isLoading = true, temperature = 0f)
    }

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    repository.getTemperature().fold(
                        onError = {
                            Log.d("ERROR", "ERROR=${it.localizedMessage}")
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(it.temp))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
            else -> return null
        }
    }
}