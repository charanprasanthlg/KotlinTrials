package com.example.kotlintrials.networking

interface OkHttpActivityContract {
    interface View{
        fun initView()
        fun validateData()
    }
    interface Presenter{
        fun getData()
        fun pushData(userId : Int, title : String, body : String)
    }
}