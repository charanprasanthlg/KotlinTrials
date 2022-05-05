package com.example.kotlintrials.mvvmretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R
import com.example.kotlintrials.mvvmretrofit.adapter.CountriesAdapter
import com.example.kotlintrials.mvvmretrofit.viewmodel.MvvmActivityViewModel

class MvvmActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var countriesAdapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        countriesAdapter = CountriesAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = countriesAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MvvmActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it!=null){
                countriesAdapter.setCountryList(it)
                countriesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
}