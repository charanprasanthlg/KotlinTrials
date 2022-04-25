package com.example.kotlintrials

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.adapters.RecyclerAdapter
import com.example.kotlintrials.charts.ChartsActivity
import com.example.kotlintrials.coroutines.CoroutinesActivity
import com.example.kotlintrials.retrofitapigetrequest.RetrofitApiActivity
import com.example.kotlintrials.retrofitcrud.RetrofitCrudActivity
import com.example.kotlintrials.sqlitetrials.notes.NotesActivity
import com.example.kotlintrials.swipecards.SwipeCardActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        recyclerViewConstruction()

        addBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        clearBtn.setOnClickListener(this)
    }

    override fun initView() {
        addBtn = findViewById(R.id.addBtn)
        deleteBtn = findViewById(R.id.deleteBtn)
        clearBtn = findViewById(R.id.clearBtn)
        recyclerView = findViewById(R.id.recyclerView)
    }

    override fun recyclerViewConstruction() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = RecyclerAdapter(data)
        recyclerView.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.addBtn -> {
                data.add("hello")
                adapter.notifyDataSetChanged()
                recyclerView.smoothScrollToPosition(data.size - 1)
            }
            R.id.deleteBtn -> {
                if (data.size > 0) {
                    data.removeAt(0)
                    adapter.notifyDataSetChanged()
                    recyclerView.smoothScrollToPosition(0)
                } else {
                    Toast.makeText(applicationContext, "no data", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.clearBtn -> {
                if (data.size > 0) {
                    data.clear()
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(applicationContext, "no data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

