package com.example.kotlintrials.complexjson.presenter

import com.example.kotlintrials.complexjson.models.TestItem

interface ComplexJsonInterfacePresenter {
    fun getData() : ArrayList<TestItem>
}