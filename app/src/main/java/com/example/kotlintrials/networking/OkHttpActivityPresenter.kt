package com.example.kotlintrials.networking

import android.util.Log
import android.widget.Toast
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class OkHttpActivityPresenter(var view: OkHttpActivityContract.View, var activity: OkHttpActivity) :
    OkHttpActivityContract.Presenter {

    override fun pushData(userId: Int, title: String, body: String) {

    }

    override fun getData() {
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts/")
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body.toString()
                val gson = GsonBuilder().create()
                val result = gson.fromJson(body, OkHttpPlaceHolder::class.java)

                activity.runOnUiThread {
                    Log.d("Hello", result.toString())
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.e("failed", e.message.toString())
            }

        })
    }
}