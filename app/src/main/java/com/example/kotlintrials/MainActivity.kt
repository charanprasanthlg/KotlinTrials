package com.example.kotlintrials

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.adapters.RecyclerAdapter
import com.example.kotlintrials.coroutines.CoroutinesActivity
import com.example.kotlintrials.retrofitapigetrequest.RetrofitApiActivity
import com.example.kotlintrials.retrofitcrud.RetrofitCrudActivity
import com.example.kotlintrials.tiktok.TikTokStyledActivity


class MainActivity : AppCompatActivity(), MainActivityContract.View, View.OnClickListener {

    private var data = arrayListOf(
        "Stark",
        "Rogers",
        "Ruffalo",
        "Thor",
        "Odin",
        "Black",
        "Wanda",
        "Strange",
        "Parker",
        "Ork",
        "Goblin"
    )
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var adapter: RecyclerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var addBtn: Button
    lateinit var deleteBtn: Button
    lateinit var clearBtn: Button
    lateinit var retrofitBtn: Button
    lateinit var coroutineBtn: Button
    lateinit var retrofitCrudActivityBtn: Button
    lateinit var tabbedActivityBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        recyclerViewConstruction()

        addBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        clearBtn.setOnClickListener(this)
        retrofitBtn.setOnClickListener(this)
        coroutineBtn.setOnClickListener(this)
        retrofitCrudActivityBtn.setOnClickListener(this)
        tabbedActivityBtn.setOnClickListener(this)
    }

    override fun initView() {
        addBtn = findViewById(R.id.addBtn)
        deleteBtn = findViewById(R.id.deleteBtn)
        clearBtn = findViewById(R.id.clearBtn)
        retrofitBtn = findViewById(R.id.retrofitButton)
        coroutineBtn = findViewById(R.id.coroutineBtn)
        retrofitCrudActivityBtn = findViewById(R.id.retrofitCrudActivityBtn)
        tabbedActivityBtn = findViewById(R.id.tabbedActivityBtn)
        recyclerView = findViewById(R.id.recyclerView)
    }

    override fun recyclerViewConstruction() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = RecyclerAdapter(data)
        recyclerView.adapter = adapter
    }

    override fun onClick(v: View?) {

        when {
            v?.id?.equals(R.id.addBtn) == true -> {
                data.add("hello")
                adapter.notifyDataSetChanged()
                recyclerView.smoothScrollToPosition(data.size - 1)
            }
            v?.id?.equals(R.id.deleteBtn) == true -> {
                if (data.size > 0) {
                    data.removeAt(0)
                    adapter.notifyDataSetChanged()
                    recyclerView.smoothScrollToPosition(0)
                } else {
                    Toast.makeText(applicationContext, "no data", Toast.LENGTH_SHORT).show()
                }
            }
            v?.id?.equals(R.id.clearBtn) == true -> {
                if (data.size > 0) {
                    data.clear()
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(applicationContext, "no data", Toast.LENGTH_SHORT).show()
                }
            }
            v?.id?.equals(R.id.retrofitButton) == true -> {
                startActivity(Intent(this, RetrofitApiActivity::class.java))
            }
            v?.id?.equals(R.id.coroutineBtn) == true -> {
                startActivity(Intent(this, CoroutinesActivity::class.java))
            }
            v?.id?.equals(R.id.retrofitCrudActivityBtn) == true -> {
                startActivity(Intent(this, RetrofitCrudActivity::class.java))
            }
            v?.id?.equals(R.id.tabbedActivityBtn) == true -> {
                startActivity(Intent(this, TikTokStyledActivity::class.java))
            }
        }
    }
}

