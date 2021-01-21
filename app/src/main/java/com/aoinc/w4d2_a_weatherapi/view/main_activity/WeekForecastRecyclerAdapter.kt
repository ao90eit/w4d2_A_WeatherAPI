package com.aoinc.w4d2_a_weatherapi.view.main_activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aoinc.w4d2_a_weatherapi.R
import com.aoinc.w4d2_a_weatherapi.model.Forecast
import com.aoinc.w4d2_a_weatherapi.view.main_activity.WeekForecastRecyclerAdapter.DayForecastViewHolder

class WeekForecastRecyclerAdapter(
        private var weekForecast: List<Forecast>
) : RecyclerView.Adapter<DayForecastViewHolder>() {

//    fun updateList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayForecastViewHolder =
            DayForecastViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.day_forecast_item, parent, false))

    override fun onBindViewHolder(holder: DayForecastViewHolder, position: Int) {
//        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = weekForecast.size

    inner class DayForecastViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }
}