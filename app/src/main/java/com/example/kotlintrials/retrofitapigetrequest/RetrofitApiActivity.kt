package com.example.kotlintrials.retrofitapigetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlintrials.R

class RetrofitApiActivity : AppCompatActivity(), RetrofitApiActivityContract.View {

    lateinit var textView : TextView
    lateinit var presenter: RetrofitApiActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_api)

        initView()
        presenter.getDataFromWeb(applicationContext, textView)
    }

    override fun initView() {
        textView = findViewById(R.id.textView)
        presenter = RetrofitApiActivityPresenter(this)
    }
}



