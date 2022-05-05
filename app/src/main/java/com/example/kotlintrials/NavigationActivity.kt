package com.example.kotlintrials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.kotlintrials.charts.ChartsActivity
import com.example.kotlintrials.complexjson.view.ComplexJsonActivity
import com.example.kotlintrials.coroutines.CoroutinesActivity
import com.example.kotlintrials.flowscoroutines.FlowsActivity
import com.example.kotlintrials.glass.GlassActivity
import com.example.kotlintrials.mvvmretrofit.view.MvvmActivity
import com.example.kotlintrials.pagination.PaginationActivity
import com.example.kotlintrials.retrofitapigetrequest.RetrofitApiActivity
import com.example.kotlintrials.retrofitcrud.RetrofitCrudActivity
import com.example.kotlintrials.sqlitetrials.notes.NotesActivity
import com.example.kotlintrials.swipecards.SwipeCardActivity
import com.example.kotlintrials.tiktok.TikTokStyledActivity
import com.google.firebase.messaging.FirebaseMessaging

class NavigationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var retrofitBtn: Button
    private lateinit var coroutineBtn: Button
    private lateinit var retrofitCrudActivityBtn: Button
    private lateinit var swipeCardsActivityBtn: Button
    private lateinit var tabbedActivityBtn: Button
    private lateinit var chartActivityBtn: Button
    private lateinit var sqliteActivityBtn: Button
    private lateinit var recyclerViewBtn: Button
    private lateinit var glassActivityBtn: Button
    private lateinit var flowsActivityBtn: Button
    private lateinit var mvvmActivityBtn: Button
    private lateinit var paginationActivityBtn: Button
    private lateinit var complexJsonActivityBtn: Button

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
        mvvmActivityBtn = findViewById(R.id.mvvmActivityBtn)
        paginationActivityBtn = findViewById(R.id.paginationActivityBtn)
        complexJsonActivityBtn = findViewById(R.id.complexJsonActivityBtn)

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
        mvvmActivityBtn.setOnClickListener(this)
        paginationActivityBtn.setOnClickListener(this)
        complexJsonActivityBtn.setOnClickListener(this)

        generateToken()
    }

    private fun generateToken() {

        //init service(optional)
        //FirebaseMessaging.getInstance().isAutoInitEnabled = true;

        //accessing token
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            Log.d("Tokennn", "TT___" + task.result)
        }

        //refreshing token
        FirebaseMessaging.getInstance().deleteToken().addOnSuccessListener {
            Log.d("Tokennn", "deleted")
            FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                Log.d("Tokennn", "TT___" + task.result)
            }
        }
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
            R.id.mvvmActivityBtn -> {
                startActivity(Intent(this, MvvmActivity::class.java))
            }
            R.id.paginationActivityBtn -> {
                startActivity(Intent(this, PaginationActivity::class.java))
            }
            R.id.complexJsonActivityBtn -> {
                startActivity(Intent(this, ComplexJsonActivity::class.java))
            }
        }
    }
}