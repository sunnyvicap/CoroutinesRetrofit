package com.example.brainviretest.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Utilities {

    companion object{

        const val BASE_URL= "https://api.exchangeratesapi.io/"


        fun formatData(strdate: String):String{

            val originalFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val targetFormat: DateFormat = SimpleDateFormat("DD/MMM/yyyy",Locale.ENGLISH)
            val date: Date = originalFormat.parse(strdate)!!


            return targetFormat.format(date)
        }
    }
}