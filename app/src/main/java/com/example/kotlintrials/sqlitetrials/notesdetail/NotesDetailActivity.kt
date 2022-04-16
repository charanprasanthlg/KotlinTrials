package com.example.kotlintrials.sqlitetrials.notesdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import com.example.kotlintrials.R
import com.example.kotlintrials.sqlitetrials.notes.NotesActivity

class NotesDetailActivity : AppCompatActivity(), NotesDetailActivityInterfaceView,
    View.OnClickListener {

    lateinit var imageView_backBtn: ImageView
    lateinit var relativeLayout_headerLayout: RelativeLayout
    lateinit var textView_saveBtn: TextView
    lateinit var editText_title: EditText
    lateinit var editText_body: EditText

    lateinit var titleString: String
    lateinit var bodyString: String

    lateinit var noteType: String

    var color: Int? = null
    var id: Int? = null

    lateinit var presenter: NotesDetailActivityClassPresenter

    var saved = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_detail)

        initView()
        getNotesData()
        imageView_backBtn.setOnClickListener(this)
        textView_saveBtn.setOnClickListener(this)

        editText_title.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saved = false
                Log.d("Saved", "ET_$saved")
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        editText_body.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saved = false
                Log.d("Saved", "EB_$saved")
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun initView() {
        imageView_backBtn = findViewById(R.id.imageView_backBtn)
        textView_saveBtn = findViewById(R.id.textView_saveBtn)
        editText_title = findViewById(R.id.editText_title)
        editText_body = findViewById(R.id.editText_body)
        relativeLayout_headerLayout = findViewById(R.id.relativeLayout_headerLayout)
        presenter = NotesDetailActivityClassPresenter(this)
    }

    override fun getNotesData() {
        val bundle = intent.extras
        val titleStr = bundle!!.getString("title")
        val bodyStr = bundle.getString("body")
        noteType = bundle.getString("type")!!
        color = bundle.getInt("color")
        id = bundle.getInt("id")

        editText_title.setText(titleStr)
        editText_body.setText(bodyStr)
        relativeLayout_headerLayout.setBackgroundColor(color!!)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.imageView_backBtn -> onBackPressed()
            R.id.textView_saveBtn -> pushData("saveBtn")
        }
    }

    override fun onBackPressed() {
        if (saved) {
            super.onBackPressed()
        } else {
            pushData("backBtn")
        }
    }

    override fun pushData(type: String) {
        titleString = editText_title.text.toString()
        bodyString = editText_body.text.toString()

        if (titleString.isNotEmpty() || bodyString.isNotEmpty()) {

            if (titleString.isEmpty()) titleString = ""
            if (bodyString.isEmpty()) bodyString = ""

            when (noteType) {
                "new" -> {
                    presenter.saveData(titleString, bodyString, this)
                    saved = true
                }
                "old" -> {
                    if (id != null && color != null) {
                        presenter.updateData(
                            id = id!!,
                            title = titleString,
                            body = bodyString,
                            color = color!!,
                            context = this
                        )
                        saved = true
                    } else {
                        showToast("ID or color is null")
                    }
                }
            }

            when (type) {
                "backBtn" -> showToast("Note Saved. Press back again to go back.")
                "saveBtn" -> showToast("Note Saved")
            }
        } else {
            when (type) {
                "backBtn" -> {
                    val intent = Intent(applicationContext, NotesActivity::class.java)
                    startActivity(intent)
                }
                "saveBtn" -> showToast("Both title and body are empty")
            }
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}