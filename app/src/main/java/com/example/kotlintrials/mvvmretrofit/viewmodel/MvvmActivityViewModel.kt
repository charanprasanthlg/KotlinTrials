package com.example.kotlintrials.mvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlintrials.mvvmretrofit.model.CountryModel
import com.example.kotlintrials.mvvmretrofit.retrofit.RetroService
import com.example.kotlintrials.mvvmretrofit.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MvvmActivityViewModel : ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<CountryModel>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<CountryModel>> {
        return liveDataList
    }

    fun makeApiCall() {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        val retrofitService = retrofitInstance.create(RetroService::class.java)
        val call = retrofitService.getCountryList()
        call.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }
}