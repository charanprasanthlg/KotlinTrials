package com.example.kotlintrials.complexjson.presenter

import android.util.Log
import com.example.kotlintrials.complexjson.models.TestItem
import com.example.kotlintrials.complexjson.view.ComplexJsonInterfaceView
import com.example.kotlintrials.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComplexJsonClassPresenter(var view : ComplexJsonInterfaceView) : ComplexJsonInterfacePresenter {
    override fun getData(): ArrayList<TestItem> {
        val itemList = ArrayList<TestItem>(0)
        ServiceBuilder.instance.getUserDataFromApi()
            .enqueue(object : Callback<List<TestItem>?> {
                override fun onResponse(call: Call<List<TestItem>?>, response: Response<List<TestItem>?>) {
                    val responseBody = response.body()!!
                    Log.d("Saved", response.body()!!.toString())
                    for (Test in responseBody) {
                        itemList.add(Test)
                    }
                }

                override fun onFailure(call: Call<List<TestItem>?>, t: Throwable) {
                    view.showToast(t.message.toString())
                }
            })
        Log.d("Saved", itemList.toString())
        return itemList
    }
}