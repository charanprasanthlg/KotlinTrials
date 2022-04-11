package com.example.kotlintrials.retrofitcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlintrials.R

class RetrofitCrudActivity : AppCompatActivity(), RetrofitCrudContract.View {

    lateinit var editText_userId: EditText
    lateinit var editText_title: EditText
    lateinit var editText_body: EditText
    lateinit var button_submitBtn: Button
    lateinit var button_updateBtn: Button
    lateinit var button_deleteBtn: Button
    lateinit var presenter: RetrofitCrudActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_crud)
        initView()

        button_submitBtn.setOnClickListener {
            validateData("create")
        }

        button_updateBtn.setOnClickListener {
            validateData("update")
        }

        button_deleteBtn.setOnClickListener {
            validateData("delete")
        }
    }

    override fun initView() {
        editText_userId = findViewById(R.id.editText_userId)
        editText_title = findViewById(R.id.editText_title)
        editText_body = findViewById(R.id.editText_body)
        button_submitBtn = findViewById(R.id.button_submitBtn)
        button_updateBtn = findViewById(R.id.button_updateBtn)
        button_deleteBtn = findViewById(R.id.button_deleteBtn)
        presenter = RetrofitCrudActivityPresenter(this)
    }

    override fun validateData(type: String) {
        val userID = editText_userId.text.toString()
        val title = editText_title.text.toString()
        val body = editText_body.text.toString()
        if (TextUtils.isEmpty(userID) || TextUtils.isEmpty(title) || TextUtils.isEmpty(body)) {
            Toast.makeText(applicationContext, "Fill all the fields", Toast.LENGTH_LONG).show()
        } else {
            when(type){
                "create" -> presenter.pushData(userId = userID.toInt(), title = title, body = body)
                "update" -> presenter.updateData(userId = userID.toInt(), title = title, body = body)
                "delete" -> presenter.deleteData(id = 1)
            }
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }


}