package com.example.kotlintrials.retrofitcrud

interface RetrofitCrudContract {
    interface View {
        fun initView()
        fun validateData(type: String)
        fun showToast(message: String)
    }

    interface Presenter {
        fun pushData(userId: Int, title: String, body: String)
        fun updateData(userId: Int, title: String, body: String)
        fun deleteData(id :Int)
    }
}