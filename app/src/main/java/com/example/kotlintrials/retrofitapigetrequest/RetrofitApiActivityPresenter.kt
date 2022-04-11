package com.example.kotlintrials.retrofitapigetrequest

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.example.kotlintrials.model.DataModelItem
import com.example.kotlintrials.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitApiActivityPresenter(var view: RetrofitApiActivityContract.View) :
    RetrofitApiActivityContract.Presenter {
    override fun getDataFromWeb(context: Context, textView: TextView) {
        var apiData = ""

        ServiceBuilder.instance.getDataFromApi()
            .enqueue(object : Callback<List<DataModelItem>?> {
                override fun onResponse(
                    call: Call<List<DataModelItem>?>,
                    response: Response<List<DataModelItem>?>
                ) {
                    val responseBody = response.body()!!

                    for (DataModel in responseBody) {
                        apiData += (DataModel.title + "\n\n")
                        textView.text = apiData
                    }
                }

                override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}