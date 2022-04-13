package com.example.kotlintrials.sqlitetrials.model

import java.util.*

data class NotesModel(var id : Int = getAutoID(), var title : String = "", var body : String = "", var color : Int = getAutoColor()){

    companion object{
        fun getAutoID():Int{
            val random = Random()
            return random.nextInt(100)
        }

        fun getAutoColor():Int{
            val colorList = arrayListOf(0xfffff6e7.toInt(), 0xfff2f8ff.toInt(), 0xffe5ffe6.toInt(), 0xfff6f6f6.toInt())
            return colorList.random()
        }
    }
}