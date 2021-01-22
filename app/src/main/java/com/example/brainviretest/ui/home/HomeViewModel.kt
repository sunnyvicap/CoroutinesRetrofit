package com.example.brainviretest.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.brainviretest.model.AllData
import com.example.brainviretest.network.ApiInterface
import com.example.brainviretest.network.ApiRequest
import com.example.brainviretest.repository.HomeRepository
import com.example.brainviretest.ui.ListExpandableAdapter
import com.example.brainviretest.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.fixedRateTimer

class HomeViewModel : ViewModel() {

    private var homeRepository:HomeRepository = HomeRepository(ApiRequest.buildService(ApiInterface::class.java))



    fun getData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val fields = HashMap<String,String>()
            fields["start_at"] ="2018-01-01"
            fields["end_at"] ="2018-09-01"
            fields["base"] = "USD"

            emit(Resource.success(data = homeRepository.getData(fields)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }



}