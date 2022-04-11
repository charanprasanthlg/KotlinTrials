package com.example.kotlintrials.retrofitapigetrequest

import android.content.Context
import android.widget.TextView

class RetrofitApiActivityContract {
    interface View{
        fun initView()
    }
    interface Presenter{
        fun getDataFromWeb(context: Context, textView: TextView)
    }
}