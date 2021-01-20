package com.aoinc.w4d2_a_weatherapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aoinc.w4d2_a_weatherapi.model.Forecast
import com.aoinc.w4d2_a_weatherapi.network.OpenWeatherRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ForecastViewModel : ViewModel() {
    private val openWeatherRetrofit: OpenWeatherRetrofit = OpenWeatherRetrofit()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val forecastData: MutableLiveData<Forecast> = MutableLiveData()

    fun getForecast(queryMap: Map<String, String>) {
        compositeDisposable.add(
            openWeatherRetrofit.getForecast(queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    forecastData.postValue(it)
                    compositeDisposable.clear()
                }, {
                    Log.d("TAG_X", it.localizedMessage)
                })
        )
    }
}