package com.example.kotlintrials.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlintrials.R

class OkHttpActivity : AppCompatActivity(), OkHttpActivityContract.View{
    lateinit var editText_userId: EditText
    lateinit var editText_title: EditText
    lateinit var editText_body: EditText
    lateinit var button_submitBtn: Button
    lateinit var presenter: OkHttpActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
        initView()
//        validateData()
        presenter.getData()
    }

    override fun initView() {
        editText_userId = findViewById(R.id.editText_userId)
        editText_title = findViewById(R.id.editText_title)
        editText_body = findViewById(R.id.editText_body)
        button_submitBtn = findViewById(R.id.button_submitBtn)
        presenter = OkHttpActivityPresenter(this, OkHttpActivity())
    }

    override fun validateData() {
        val userID = editText_userId.text.toString()
        val title = editText_title.text.toString()
        val body = editText_body.text.toString()
        if (TextUtils.isEmpty(userID) || TextUtils.isEmpty(title) || TextUtils.isEmpty(body)) {
            Toast.makeText(applicationContext, "Fill all the fields", Toast.LENGTH_LONG).show()
        } else {
            presenter.pushData(userId = userID.toInt(), title = title, body = body)
        }
    }
}