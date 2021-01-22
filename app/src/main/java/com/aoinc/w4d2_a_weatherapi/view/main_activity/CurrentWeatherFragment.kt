package com.aoinc.w4d2_a_weatherapi.view.main_activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import butterknife.BindView
import butterknife.ButterKnife
import com.aoinc.w4d2_a_weatherapi.R
import com.aoinc.w4d2_a_weatherapi.util.Constants
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastVMFactory
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastViewModel
import com.bumptech.glide.Glide

class CurrentWeatherFragment : Fragment() {

    @BindView(R.id.current_visibility_imageView)
    lateinit var currentVisibility: ImageView

    @BindView(R.id.current_high_temp_textView)
    lateinit var currentHigh: TextView

    @BindView(R.id.current_low_temp_textView)
    lateinit var currentLow: TextView

    @BindView(R.id.current_rain_value_textView)
    lateinit var currentChanceRain: TextView

    @BindView(R.id.current_temp_textView)
    lateinit var currentTemp: TextView

    private val forecastViewModel: ForecastViewModel by viewModels(
            factoryProducer = {ForecastVMFactory}
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.current_weather_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButterKnife.bind(this, view)

        forecastViewModel.forecastData.observe(viewLifecycleOwner, {
            Log.d("weather_forecast", "Forecast returned...\n$it")

            it.apply {
                currentTemp.text = current.temp.toInt().toString()
                currentHigh.text = daily[0].temp.max.toInt().toString()
                currentLow.text = daily[0].temp.min.toInt().toString()
                currentChanceRain.text = (daily[0].pop * 100).toInt().toString()

                Glide.with(view.context)
                        .load(String.format(Constants.VISIBILITY_ICON_URL, current.weather[0].icon))
                        .into(currentVisibility)
            }
        })
    }
}