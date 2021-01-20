package com.aoinc.w4d2_a_weatherapi.network

import com.aoinc.w4d2_a_weatherapi.model.Forecast
import com.aoinc.w4d2_a_weatherapi.util.Constants
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface OpenWeatherAPI {

    @GET(Constants.REQUEST_PATH)    // test url, query built in
    fun getForecast(@QueryMap queryMap: Map<String, String>): Observable<Forecast>
}