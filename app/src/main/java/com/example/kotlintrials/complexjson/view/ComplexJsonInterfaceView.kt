package com.example.kotlintrials.complexjson.view

interface ComplexJsonInterfaceView {
    fun initView()
    fun getDataFromPresenter()
    fun configureRecyclerView()
    fun showToast(message : String)
}