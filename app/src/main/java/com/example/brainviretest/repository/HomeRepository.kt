package com.example.brainviretest.repository

import com.example.brainviretest.network.ApiInterface

class HomeRepository(val apiInterface: ApiInterface ) {



    suspend fun  getData(query : Map<String,String>) = apiInterface.getData(query)
}