package com.example.kotlintrials.sqlitetrials.notesdetail

import android.content.Context
import android.util.Log
import com.example.kotlintrials.sqlitetrials.database.SQLiteHelper
import com.example.kotlintrials.sqlitetrials.model.NotesModel

class NotesDetailActivityClassPresenter(var view: NotesDetailActivityInterfaceView) : NotesDetailActivityInterfacePresenter{
    override fun saveData(title: String, body: String, context: Context) {
        val helper = SQLiteHelper(context)
        val note = NotesModel(title = title, body = body)
        val result = helper.insertNote(note)
        Log.d("Saved", "R_$result")
    }
}