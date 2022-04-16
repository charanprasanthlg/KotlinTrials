package com.example.kotlintrials.sqlitetrials.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.kotlintrials.sqlitetrials.model.NotesModel

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "notes.db"
        private const val TABLE_NAME = "all_notes"
        private const val ID = "id"
        private const val TITLE = "title"
        private const val BODY = "body"
        private const val COLOR = "color"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableNotes =
            ("CREATE TABLE " + TABLE_NAME + "("
                    + ID + " INTEGER PRIMARY KEY,"
                    + TITLE + " TEXT,"
                    + BODY + " TEXT,"
                    + COLOR + " INTEGER"
                    + ")")
        db?.execSQL(createTableNotes)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertNote(note: NotesModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(ID, note.id)
        contentValues.put(TITLE, note.title)
        contentValues.put(BODY, note.body)
        contentValues.put(COLOR, note.color)

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        Log.d("Saved", "inserted $success")
        return success
    }

    @SuppressLint("Range")
    fun getAllNotes(): ArrayList<NotesModel> {
        val notesList: ArrayList<NotesModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            Log.d("Saved" , e.printStackTrace().toString())
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id : Int
        var title : String
        var body : String
        var color : Int

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                title = cursor.getString(cursor.getColumnIndex("title"))
                body = cursor.getString(cursor.getColumnIndex("body"))
                color = cursor.getInt(cursor.getColumnIndex("color"))

                val note = NotesModel(id, title, body, color)
                notesList.add(note)
            }while (cursor.moveToNext())
        }

        Log.d("Saved", "saved $notesList")
        return notesList
    }

    fun updateNote(note : NotesModel) : Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(ID, note.id)
        contentValues.put(TITLE, note.title)
        contentValues.put(BODY, note.body)
        contentValues.put(COLOR, note.color)

        val whereClause = "id = ?"
        val whereArgs = arrayOf(note.id.toString())

        val success = db.update(TABLE_NAME, contentValues, whereClause, whereArgs)
        db.close()

        Log.d("Saved", "updated $success")
        return success
    }

    fun deleteData(id : Int) : Int {
        val db = this.writableDatabase
        //if where clause is null, all the rows in the table will be deleted
        val whereClause = "id = ?"
        val whereArgs = arrayOf(id.toString())

        val success =  db.delete(TABLE_NAME,whereClause, whereArgs) //returns no. of affected rows
        db.close()

        Log.d("Saved", "deleted $success")
        return success
    }
}