package com.example.kotlintrials.sqlitetrials.notes

import android.content.Context
import android.util.Log
import com.example.kotlintrials.sqlitetrials.database.SQLiteHelper

class NotesActivityClassPresenter(var view: NotesActivityInterfaceView) : NotesActivityInterfacePresenter {
    override fun deleteData(id: Int, context: Context) {
        val helper = SQLiteHelper(context)
        val result = helper.deleteData(id = id)
        Log.d("Saved", "deleteDATA_$result")
    }
}