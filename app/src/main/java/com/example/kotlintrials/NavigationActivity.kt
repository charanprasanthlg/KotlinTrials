package com.example.kotlintrials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.kotlintrials.charts.ChartsActivity
import com.example.kotlintrials.coroutines.CoroutinesActivity
import com.example.kotlintrials.flowscoroutines.FlowsActivity
import com.example.kotlintrials.glass.GlassActivity
import com.example.kotlintrials.retrofitapigetrequest.RetrofitApiActivity
import com.example.kotlintrials.retrofitcrud.RetrofitCrudActivity
import com.example.kotlintrials.sqlitetrials.notes.NotesActivity
import com.example.kotlintrials.swipecards.SwipeCardActivity
import com.example.kotlintrials.tiktok.TikTokStyledActivity

class NavigationActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var retrofitBtn: Button
    lateinit var coroutineBtn: Button
    lateinit var retrofitCrudActivityBtn: Button
    lateinit var swipeCardsActivityBtn: Button
    lateinit var tabbedActivityBtn: Button
    lateinit var chartActivityBtn: Button
    lateinit var sqliteActivityBtn: Button
    lateinit var recyclerViewBtn: Button
    lateinit var glassActivityBtn: Button
    lateinit var flowsActivityBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        retrofitBtn = findViewById(R.id.retrofitButton)
        coroutineBtn = findViewById(R.id.coroutineBtn)
        retrofitCrudActivityBtn = findViewById(R.id.retrofitCrudActivityBtn)
        tabbedActivityBtn = findViewById(R.id.tabbedActivityBtn)
        swipeCardsActivityBtn = findViewById(R.id.swipeCardsActivityBtn)
        chartActivityBtn = findViewById(R.id.chartActivityBtn)
        sqliteActivityBtn = findViewById(R.id.sqliteActivityBtn)
        recyclerViewBtn = findViewById(R.id.recyclerViewBtn)
        glassActivityBtn = findViewById(R.id.glassActivityBtn)
        flowsActivityBtn = findViewById(R.id.flowsActivityBtn)

        retrofitBtn.setOnClickListener(this)
        coroutineBtn.setOnClickListener(this)
        retrofitCrudActivityBtn.setOnClickListener(this)
        tabbedActivityBtn.setOnClickListener(this)
        swipeCardsActivityBtn.setOnClickListener(this)
        chartActivityBtn.setOnClickListener(this)
        sqliteActivityBtn.setOnClickListener(this)
        recyclerViewBtn.setOnClickListener(this)
        glassActivityBtn.setOnClickListener(this)
        flowsActivityBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.recyclerViewBtn -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            R.id.retrofitButton -> {
                startActivity(Intent(this, RetrofitApiActivity::class.java))
            }
            R.id.coroutineBtn -> {
                startActivity(Intent(this, CoroutinesActivity::class.java))
            }
            R.id.retrofitCrudActivityBtn -> {
                startActivity(Intent(this, RetrofitCrudActivity::class.java))
            }
            R.id.tabbedActivityBtn -> {
                startActivity(Intent(this, TikTokStyledActivity::class.java))
            }
            R.id.swipeCardsActivityBtn -> {
                startActivity(Intent(this, SwipeCardActivity::class.java))
            }
            R.id.chartActivityBtn -> {
                startActivity(Intent(this, ChartsActivity::class.java))
            }
            R.id.sqliteActivityBtn -> {
                startActivity(Intent(this, NotesActivity::class.java))
            }
            R.id.glassActivityBtn -> {
                startActivity(Intent(this, GlassActivity::class.java))
            }
            R.id.flowsActivityBtn -> {
                startActivity(Intent(this, FlowsActivity::class.java))
            }
        }
    }
}