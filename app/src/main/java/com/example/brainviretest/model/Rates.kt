package com.example.brainviretest.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Rates(
    @SerializedName("CAD")
    val cAD: Float,
    @SerializedName("HKD")
    val hKD: Float,
    @SerializedName("ISK")

    val iSK: Float,
    @SerializedName("PHP")

    val pHP: Float,
    @SerializedName("DKK")

    val dKK: Float,
    @SerializedName("HUF")

    val hUF: Float,
    @SerializedName("CZK")

    val cZK: Float,
    @SerializedName("GBP")

    val gBP: Float,
    @SerializedName("RON")

    val rON: Float,
    @SerializedName("SEK")

    val sEK: Float,
    @SerializedName("IDR")

    val iDR: Float,
    @SerializedName("INR")

    val iNR: Float,
    @SerializedName("BRL")

    val bRL: Float,
    @SerializedName("RUB")

    val rUB: Float,
    @SerializedName("HRK")

    val hRK: Float,
    @SerializedName("JPY")

    val jPY: Float,
    @SerializedName("THB")

    val tHB: Float,
    @SerializedName("CHF")

    val cHF: Float,
    @SerializedName("EUR")

    val eUR: Float,
    @SerializedName("MYR")

    val mYR: Float,
    @SerializedName("BGN")

    val bGN: Float,
    @SerializedName("TRY")

    val tRY: Float,
    @SerializedName("CNY")

    val cNY: Float,
    @SerializedName("NOK")

    val nOK: Float,
    @SerializedName("NZD")

    val nZD: Float,
    @SerializedName("ZAR")

    val zAR: Float,
    @SerializedName("USD")

    val uSD: Int,
    @SerializedName("MXN")

    val mXN: Float,
    @SerializedName("SGD")

    val sGD: Float,
    @SerializedName("AUD")

    val aUD: Float,
    @SerializedName("ILS")

    val iLS: Float,
    @SerializedName("KRW")

    val kRW: Float,
    @SerializedName("PLN")

    val pLN: Float

) : Parcelable