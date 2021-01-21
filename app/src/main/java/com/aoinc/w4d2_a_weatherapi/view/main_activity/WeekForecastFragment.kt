package com.aoinc.w4d2_a_weatherapi.view.main_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.aoinc.w4d2_a_weatherapi.R
import com.aoinc.w4d2_a_weatherapi.model.Forecast
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastVMFactory
import com.aoinc.w4d2_a_weatherapi.viewmodel.ForecastViewModel

class WeekForecastFragment : Fragment() {

//    @BindView(R.id.week_forecast_recyclerView)
    private lateinit var weekForecastRecyclerView: RecyclerView
    private val weekForecastRecyclerAdapter: WeekForecastRecyclerAdapter = WeekForecastRecyclerAdapter(listOf())

    private val forecastViewModel: ForecastViewModel by viewModels(
            factoryProducer = { ForecastVMFactory }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.week_forecast_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ButterKnife.bind(this, view)
        weekForecastRecyclerView = view.findViewById(R.id.week_forecast_recyclerView)
        weekForecastRecyclerView.adapter = weekForecastRecyclerAdapter
    }
}