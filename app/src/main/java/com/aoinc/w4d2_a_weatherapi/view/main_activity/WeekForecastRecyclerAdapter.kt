package com.aoinc.w4d2_a_weatherapi.view.main_activity

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.aoinc.w4d2_a_weatherapi.R
import com.aoinc.w4d2_a_weatherapi.model.Daily
import com.aoinc.w4d2_a_weatherapi.util.Constants
import com.aoinc.w4d2_a_weatherapi.view.main_activity.WeekForecastRecyclerAdapter.DayForecastViewHolder
import com.bumptech.glide.Glide
import java.time.LocalDateTime
import java.time.ZoneOffset

class WeekForecastRecyclerAdapter(
        private var weekForecast: List<Daily>
) : RecyclerView.Adapter<DayForecastViewHolder>() {

    fun updateForecast(newForecast: List<Daily>) {
        weekForecast = newForecast
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayForecastViewHolder =
            DayForecastViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.day_forecast_item, parent, false))

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DayForecastViewHolder, position: Int) {
        val dailyForecast = weekForecast[position]

        holder.apply {
            dayLabel.text = utcToLocal(dailyForecast.dt).dayOfWeek.toString()
            dayHigh.text = dailyForecast.temp.max.toInt().toString()
            dayLow.text = dailyForecast.temp.min.toInt().toString()
            morningTemp.text = dailyForecast.temp.morn.toInt().toString()
            nightTemp.text = dailyForecast.temp.night.toInt().toString()

            val imageURL = String.format(Constants.VISIBILITY_ICON_URL, dailyForecast.weather[0].icon)
            Glide.with(holder.itemView.context)
                    .load(imageURL)
                    .into(visibilityImage)

            rainChance.text = "${(dailyForecast.pop * 100).toInt().toString()}%"
        }
    }

    override fun getItemCount(): Int = weekForecast.size

    @RequiresApi(Build.VERSION_CODES.O)
    private fun utcToLocal(utcSeconds: Long) =
            LocalDateTime.ofEpochSecond(utcSeconds, 0, ZoneOffset.UTC)

    inner class DayForecastViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val dayLabel: TextView = itemView.findViewById(R.id.daily_forecast_day_label_textView)
        val dayHigh: TextView = itemView.findViewById(R.id.daily_high_value_textView)
        val dayLow: TextView = itemView.findViewById(R.id.daily_low_value_textView)
        val morningTemp: TextView = itemView.findViewById(R.id.daily_morning_temp_value_textView)
        val nightTemp: TextView = itemView.findViewById(R.id.daily_night_temp_value_textView)
        val visibilityImage: ImageView = itemView.findViewById(R.id.daily_visibility_imageView)
        val rainChance: TextView = itemView.findViewById(R.id.daily_rain_value_textView)
    }
}