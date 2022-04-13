package com.example.kotlintrials.sqlitetrials.notes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R
import com.example.kotlintrials.sqlitetrials.model.NotesModel
import com.example.kotlintrials.sqlitetrials.notesdetail.NotesDetailActivity


class NotesAdapter(var notesList : ArrayList<NotesModel>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.notes_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.notes_layout_background)
        val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
        DrawableCompat.setTint(wrappedDrawable, notesList[position].color)

        holder.textView_title.text = notesList[position].title
        holder.textView_body.text = notesList[position].body
        holder.relativeLayout_item.setOnClickListener {
            val intent = Intent(context, NotesDetailActivity::class.java)
            intent.putExtra("title", notesList[position].title)
            intent.putExtra("body", notesList[position].body)
            intent.putExtra("type", "old")
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView_title = itemView.findViewById<TextView>(R.id.textView_title)
        var textView_body = itemView.findViewById<TextView>(R.id.textView_body)
        var relativeLayout_item = itemView.findViewById<RelativeLayout>(R.id.relativeLayout_item)
    }
}