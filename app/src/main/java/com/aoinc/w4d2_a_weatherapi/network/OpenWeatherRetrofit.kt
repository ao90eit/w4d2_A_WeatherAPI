package com.aoinc.w4d2_a_weatherapi.network

import com.aoinc.w4d2_a_weatherapi.model.Forecast
import com.aoinc.w4d2_a_weatherapi.util.Constants
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class OpenWeatherRetrofit {

    private var openWeatherAPI: OpenWeatherAPI

    init {
        openWeatherAPI = createAPI(createRetrofit())
    }

    private fun createAPI(retrofit: Retrofit): OpenWeatherAPI =
        retrofit.create(OpenWeatherAPI::class.java)

    private fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    public fun getForecast(queryMap: Map<String, String>): Observable<Forecast> =
        openWeatherAPI.getForecast(queryMap)
}