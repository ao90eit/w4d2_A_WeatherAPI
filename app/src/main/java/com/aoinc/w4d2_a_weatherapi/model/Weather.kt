package com.aoinc.w4d2_a_weatherapi.model

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)