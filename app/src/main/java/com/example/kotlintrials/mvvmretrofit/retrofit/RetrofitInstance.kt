package com.example.kotlintrials.mvvmretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        fun getRetrofitInstance(): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl("https://restcountries.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}