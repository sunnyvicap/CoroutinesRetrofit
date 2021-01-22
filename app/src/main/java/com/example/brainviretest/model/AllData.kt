package com.example.brainviretest.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllData  (

    @SerializedName("rates")
    @Expose
    val rates : Map <String , Rates>

):Parcelable