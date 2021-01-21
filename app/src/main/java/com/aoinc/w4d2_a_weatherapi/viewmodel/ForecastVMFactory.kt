package com.aoinc.w4d2_a_weatherapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ForecastVMFactory : ViewModelProvider.Factory {
    var viewModel : ForecastViewModel? = ForecastViewModel()
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}