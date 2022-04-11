package com.example.kotlintrials.retrofitcrud

interface RetrofitCrudInterfacePresenter {
    fun pushData(userId: Int, title: String, body: String)
    fun updateData(userId: Int, title: String, body: String)
    fun deleteData(id :Int)
}