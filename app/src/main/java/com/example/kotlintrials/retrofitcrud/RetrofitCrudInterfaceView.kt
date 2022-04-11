package com.example.kotlintrials.retrofitcrud

interface RetrofitCrudInterfaceView {
    fun initView()
    fun validateData(type: String)
    fun showToast(message: String)
}