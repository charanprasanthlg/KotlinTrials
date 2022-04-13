package com.example.kotlintrials.sqlitetrials.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R
import com.example.kotlintrials.adapters.RecyclerAdapter
import com.example.kotlintrials.sqlitetrials.database.SQLiteHelper
import com.example.kotlintrials.sqlitetrials.model.NotesModel
import com.example.kotlintrials.sqlitetrials.notesdetail.NotesDetailActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class NotesActivity : AppCompatActivity(), NotesActivityInterfaceView {

    lateinit var presenter: NotesActivityClassPresenter
    lateinit var recyclerView_notes: RecyclerView
    lateinit var fab_addNote: ExtendedFloatingActionButton
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var textView_noData: TextView
    lateinit var adapter: NotesAdapter
    lateinit var notesList: ArrayList<NotesModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        initView()
        recyclerViewConstruction()

        fab_addNote.setOnClickListener {
            val intent = Intent(applicationContext, NotesDetailActivity::class.java)
            intent.putExtra("title", "")
            intent.putExtra("body", "")
            intent.putExtra("type", "new")
            startActivity(intent)
        }
    }

    override fun initView() {
        presenter = NotesActivityClassPresenter(this)
        recyclerView_notes = findViewById(R.id.recyclerView_notes)
        fab_addNote = findViewById(R.id.fab_addNote)
        textView_noData = findViewById(R.id.textView_noData)
    }

    override fun recyclerViewConstruction() {

        val helper = SQLiteHelper(this)

        notesList = helper.getAllNotes()

        if (notesList.isEmpty()) {

            textView_noData.visibility = View.VISIBLE
            recyclerView_notes.visibility = View.GONE

        } else {

            textView_noData.visibility = View.GONE
            recyclerView_notes.visibility = View.VISIBLE

            linearLayoutManager = LinearLayoutManager(this)
            recyclerView_notes.layoutManager = linearLayoutManager

            adapter = NotesAdapter(notesList)
            recyclerView_notes.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        recyclerViewConstruction()
    }
}