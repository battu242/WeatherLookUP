package com.culler.weatherlookup.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Main(
    @SerializedName("temp")
    @Expose
    var temperature: Double,
    @SerializedName("feels_like")
    @Expose
    var feelsLike: String
) : Parcelable