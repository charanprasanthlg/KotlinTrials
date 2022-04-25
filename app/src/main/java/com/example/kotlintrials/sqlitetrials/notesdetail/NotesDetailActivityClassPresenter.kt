package com.example.kotlintrials.sqlitetrials.notesdetail

import android.content.Context
import android.util.Log
import com.example.kotlintrials.sqlitetrials.database.SQLiteHelper
import com.example.kotlintrials.sqlitetrials.model.NotesModel

class NotesDetailActivityClassPresenter(var view: NotesDetailActivityInterfaceView) :
    NotesDetailActivityInterfacePresenter {
    override fun saveData(title: String, body: String, color:Int, context: Context) {
        val helper = SQLiteHelper(context)
        val note = NotesModel(title = title.trim(), body = body.trim(), color = color)
        val result = helper.insertNote(note)
        Log.d("Saved", "saveDATA_$result")
    }

    override fun updateData(id: Int, title: String, body: String, color: Int, context: Context) {
        val helper = SQLiteHelper(context)
        val note = NotesModel(id = id, title = title.trim(), body = body.trim(), color = color)
        val result = helper.updateNote(note)
        Log.d("Saved", "updateDATA_$result")
    }
}