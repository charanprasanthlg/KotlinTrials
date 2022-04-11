package com.example.kotlintrials.retrofitcrud

import android.util.Log
import com.example.kotlintrials.services.ServiceBuilder
import com.example.kotlintrials.model.RetrofitCrudModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCrudActivityPresenter(var view: RetrofitCrudContract.View) :
    RetrofitCrudContract.Presenter {


    override fun pushData(userId: Int, title: String, body: String) {
        ServiceBuilder.instance.createUser(userId = userId, title = title, body = body)
            .enqueue(object :
                Callback<RetrofitCrudModel> {
                override fun onResponse(
                    call: Call<RetrofitCrudModel>,
                    response: Response<RetrofitCrudModel>
                ) {
                    view.showToast(response.body().toString())
                    Log.d("RESULT____", response.body().toString())
                }

                override fun onFailure(call: Call<RetrofitCrudModel>, t: Throwable) {
                    view.showToast(t.message.toString())
                    Log.d("RESULT____", t.message.toString())
                }
            })
    }

    override fun updateData(userId: Int, title: String, body: String) {
        ServiceBuilder.instance.updateUser(userId = userId, title = title, body = body, id = 1)
            .enqueue(object :
                Callback<RetrofitCrudModel> {
                override fun onResponse(
                    call: Call<RetrofitCrudModel>,
                    response: Response<RetrofitCrudModel>
                ) {
                    view.showToast(response.body().toString())
                    Log.d("RESULT____", response.body().toString())
                }

                override fun onFailure(call: Call<RetrofitCrudModel>, t: Throwable) {
                    view.showToast(t.message.toString())
                    Log.d("RESULT____", t.message.toString())
                }
            })
    }

    override fun deleteData(id: Int) {
        ServiceBuilder.instance.deleteUser(id).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                view.showToast(response.body().toString())
                Log.d("RESULT____", "Success  " + response.body().toString())
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                view.showToast(t.message.toString())
                Log.d("RESULT____", "Failure  " + t.message.toString())
            }
        })
    }
}