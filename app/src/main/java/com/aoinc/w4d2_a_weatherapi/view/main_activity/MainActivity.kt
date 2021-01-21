package com.aoinc.w4d2_a_weatherapi.view.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.aoinc.w4d2_a_weatherapi.R
import com.aoinc.w4d2_a_weatherapi.util.Constants
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastVMFactory
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastViewModel

class MainActivity : AppCompatActivity() {

    private val forecastViewModel: ForecastViewModel by viewModels(
            factoryProducer = {ForecastVMFactory}
    )

    private val currentWeatherFragment: CurrentWeatherFragment = CurrentWeatherFragment()
    private val weekForecastFragment: WeekForecastFragment = WeekForecastFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastViewModel.forecastData.observe(this, Observer {
            Log.d("weather_forecast", "Forecast returned...\n$it")
        })

        // TEST OPEN WEATHER REQUEST
//        getForecast(latitude = "33.908951", longitude = "-84.4789859",
//                exclude = "minutely,hourly,alerts", units = "metric", lang = "es")
        getForecast(latitude = "33.908951", longitude = "-84.4789859",
                exclude = "minutely,hourly,alerts", units ="imperial")

        addFragment(R.id.current_weather_frame, currentWeatherFragment)
        addFragment(R.id.week_forecast_frame, weekForecastFragment)
    }

    private fun getForecast(latitude: String, longitude: String,
                            exclude: String = "", units: String = "", lang: String = "") {

        val queryMap: Map<String, String> = mapOf(
            Constants.LATITUDE_KEY to latitude,
            Constants.LONGITUDE_KEY to longitude,
            Constants.EXCLUDE_KEY to exclude,
            Constants.UNITS_KEY to units,
            Constants.LANG_KEY to lang,
            Constants.APP_ID_KEY to Constants.APP_ID_VALUE
        ).filter { it.value.isNotEmpty() }

        Log.d("TAG_X", queryMap.toString())
        forecastViewModel.getForecast(queryMap)
    }

    private fun addFragment(frameView : Int, fragment : Fragment) {
        supportFragmentManager.beginTransaction()
                .add(frameView, fragment)
                .commit();
    }

//    private fun addFragmentToBackstack(frameView : Int, fragment : Fragment) {
//        supportFragmentManager.beginTransaction()
//                .add(frameView, fragment)
//                .addToBackStack(fragment.tag)
//                .commit();
//    }
}