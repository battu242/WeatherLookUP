package com.culler.weatherlookup.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherInformation(
    @SerializedName("main")
    @Expose
    var main: Main,
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>
) : Parcelable