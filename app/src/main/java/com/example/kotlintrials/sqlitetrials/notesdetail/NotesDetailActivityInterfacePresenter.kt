package com.example.kotlintrials.sqlitetrials.notesdetail

import android.content.Context

interface NotesDetailActivityInterfacePresenter {
    fun saveData(title : String, body : String, context: Context)
}