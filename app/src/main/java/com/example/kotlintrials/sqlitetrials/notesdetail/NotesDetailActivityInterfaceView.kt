package com.example.kotlintrials.sqlitetrials.notesdetail

interface NotesDetailActivityInterfaceView {
    fun initView()
    fun getNotesData()
    fun selectColor()
    fun showToast(message : String)
    fun pushData(type : String)
}