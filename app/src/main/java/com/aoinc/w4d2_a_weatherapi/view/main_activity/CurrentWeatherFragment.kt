package com.aoinc.w4d2_a_weatherapi.view.main_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aoinc.w4d2_a_weatherapi.R
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastVMFactory
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastViewModel

class CurrentWeatherFragment : Fragment() {

    private val forecastViewModel: ForecastViewModel by viewModels(
            factoryProducer = {ForecastVMFactory}
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.current_weather_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}