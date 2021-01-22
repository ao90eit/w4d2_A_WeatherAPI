package com.aoinc.w4d2_a_weatherapi.util

class Constants {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val REQUEST_PATH = "data/2.5/onecall"

        const val APP_ID_KEY = "appid"
        const val APP_ID_VALUE = "125dfbf5cbd91ceda990a63f9dca01f9"

        const val LATITUDE_KEY = "lat"
        const val LONGITUDE_KEY = "lon"
        const val EXCLUDE_KEY = "exclude"
        const val UNITS_KEY = "units"
        const val LANG_KEY = "lang"


        const val VISIBILITY_ICON_URL = "https://openweathermap.org/img/wn/%s@4x.png"
    }
}