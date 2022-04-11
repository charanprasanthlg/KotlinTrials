package com.example.kotlintrials.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.kotlintrials.R

class CoroutinesActivity : AppCompatActivity(), CoroutinesActivityInteractor.View, View.OnClickListener {

    lateinit var textView : TextView
    lateinit var showDialogBtn: Button
    lateinit var showDialogWithCoroutineLaunchBtn: Button
    lateinit var showDialogWithCoroutineAsyncBtn: Button
    lateinit var presenter: CoroutinesActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        initView()
        showDialogBtn.setOnClickListener(this)
        showDialogWithCoroutineLaunchBtn.setOnClickListener(this)
        showDialogWithCoroutineAsyncBtn.setOnClickListener(this)
    }

    override fun initView() {
        textView = findViewById(R.id.textView)
        showDialogBtn = findViewById(R.id.showDialogBtn)
        showDialogWithCoroutineLaunchBtn = findViewById(R.id.showDialogWithCoroutineLaunchBtn)
        showDialogWithCoroutineAsyncBtn = findViewById(R.id.showDialogWithCoroutineAsyncBtn)
        presenter = CoroutinesActivityPresenter(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.showDialogBtn -> presenter.showDialogBox(this)
            R.id.showDialogWithCoroutineLaunchBtn -> presenter.showDialogBoxFromCoroutineLaunch(this)
            R.id.showDialogWithCoroutineAsyncBtn -> presenter.showDialogBoxFromCoroutineAsync(this)
        }
    }
}