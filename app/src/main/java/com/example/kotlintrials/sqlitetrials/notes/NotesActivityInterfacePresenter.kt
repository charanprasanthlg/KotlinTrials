package com.example.kotlintrials.sqlitetrials.notes

import android.content.Context

interface NotesActivityInterfacePresenter {
    fun deleteData(id: Int, context: Context)
}