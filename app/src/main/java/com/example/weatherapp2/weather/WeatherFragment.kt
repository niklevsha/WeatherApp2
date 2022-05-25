package com.example.weatherapp2.weather

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.weatherapp2.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment: Fragment(R.layout.fragment_weather) {

    private val viewModel: WeatherViewModel by viewModel()
    val progressBar: ProgressBar by lazy {requireView().findViewById(R.id.progressBarLoading)}
    val buttonTemp: Button by lazy {requireView().findViewById(R.id.buttonTemp)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        buttonTemp.setOnClickListener{
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }
    }
    private fun render(state: ViewState) {
        if(state.temperature != 0f) {
            buttonTemp.text = state.temperature.toString()
        }
        progressBar.isVisible = state.isLoading
    }
}