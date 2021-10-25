package com.culler.weatherlookup.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    @SerializedName("main")
    @Expose
    var main: String,
    @SerializedName("description")
    @Expose
    var description: String
) : Parcelable