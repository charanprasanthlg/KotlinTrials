package com.example.kotlintrials.mvvmretrofit.retrofit

import com.example.kotlintrials.mvvmretrofit.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("all/")
    fun getCountryList() : Call<List<CountryModel>>
}