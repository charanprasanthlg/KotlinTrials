package com.example.kotlintrials.sqlitetrials.notesdetail

import android.content.Context

interface NotesDetailActivityInterfacePresenter {
    fun saveData(title: String, body: String, color:Int, context: Context)
    fun updateData(id: Int, title: String, body: String, color: Int, context: Context)
}