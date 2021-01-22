package com.example.brainviretest.network

import com.example.brainviretest.model.AllData
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.time.temporal.IsoFields

interface ApiInterface {


    @GET("/history?")
    suspend fun getData(@QueryMap fields:  Map<String, String> ) : AllData
}