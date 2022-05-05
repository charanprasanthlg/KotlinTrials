package com.example.kotlintrials.complexjson.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R
import com.example.kotlintrials.complexjson.adapter.ItemAdapter
import com.example.kotlintrials.complexjson.models.TestItem
import com.example.kotlintrials.complexjson.presenter.ComplexJsonClassPresenter
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class ComplexJsonActivity : AppCompatActivity(), ComplexJsonInterfaceView {

    lateinit var recyclerView: RecyclerView
    private var itemList = ArrayList<TestItem>()
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var presenter : ComplexJsonClassPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complex_json)

        initView()
        getDataFromPresenter()
        getDataFromPresenter()
        configureRecyclerView()
    }

    override fun initView() {
        presenter = ComplexJsonClassPresenter(this)
        recyclerView = findViewById(R.id.recyclerView)
    }

    override fun getDataFromPresenter() {
        runBlocking {
            async {
                itemList = presenter.getData()
            }.await()
        }
    }

    override fun configureRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        Log.d("Saved", "List size : ${itemList.size}")

        itemAdapter = ItemAdapter(itemList = itemList)
        recyclerView.adapter = itemAdapter
    }

    override fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}