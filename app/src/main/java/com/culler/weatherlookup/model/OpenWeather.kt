package com.culler.weatherlookup.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class OpenWeather(
    @SerializedName("list")
    @Expose
    var openWeathers: List<WeatherInformation>
) : Parcelable
