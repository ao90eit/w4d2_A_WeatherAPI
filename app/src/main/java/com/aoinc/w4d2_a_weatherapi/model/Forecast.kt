package com.aoinc.w4d2_a_weatherapi.model

data class Forecast(
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)