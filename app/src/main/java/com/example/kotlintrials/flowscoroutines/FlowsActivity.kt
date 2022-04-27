package com.example.kotlintrials.flowscoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.kotlintrials.R
import com.example.kotlintrials.retrofitapigetrequest.model.DataModelItem
import com.example.kotlintrials.services.ApiInterface
import com.example.kotlintrials.services.ServiceBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.pow

class FlowsActivity : AppCompatActivity(), FlowsInterfaceView {

    lateinit var flow: Flow<Int>
    lateinit var flow1: Flow<String>
    lateinit var flow2: Flow<String>

    var str = ""
    var str1 = ""
    var str2 = ""

    lateinit var button_flow: Button
    lateinit var button_zips: Button
    lateinit var button_network: Button
    lateinit var textview_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows)
        initView()
        settingUpFlow()
        settingUpZipFlow()
        performButtonClicks()
    }

    override fun initView() {
        button_flow = findViewById(R.id.button_flow)
        button_zips = findViewById(R.id.button_zips)
        button_network = findViewById(R.id.button_network)
        textview_text = findViewById(R.id.textview_text)
    }

    override fun settingUpFlow() {
        flow = flow {
            Log.d("Saved", "Start flow")
            (1..64).forEach {
                delay(500)
                Log.d("Saved", "Emitting $it")
                emit(it)
            }
        }.map {
            it.toDouble().pow(5.0).toInt()
        }.flowOn(Dispatchers.Main)
    }

    override fun settingUpZipFlow() {
        flow1 = flowOf("Chennai", "Coimbatore", "Trichy", "Salem", "Mangalore")
            .onEach { delay(500) }
            .flowOn(Dispatchers.IO)
        flow2 = flowOf("Canada", "Dublin", "Trinity", "Lanka", "Madagascar")
            .onEach { delay(500) }
            .flowOn(Dispatchers.IO)
    }

    override fun settingUpDataFromNetwork(){

        val api = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getComments()

            if(response.isSuccessful){
                Log.d("Saved", response.body().toString())
                str += response.body().toString() + "\n"
            }
        }
        textview_text.text = str
    }

    override fun performButtonClicks() {
        button_flow.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                flow.collect {
                    Log.d("Saved", it.toString())
                    str += it.toString() + "\n"
                    textview_text.text = str
                }
            }
        }
        button_zips.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                flow1.zip(flow2) { firstString, secondString ->
                    "$firstString $secondString"
                }.collect {
                    Log.d("Saved", it)
                    str += it + "\n"
                    textview_text.text = str
                }
            }
        }
        button_network.setOnClickListener {
            settingUpDataFromNetwork()
        }
    }
}