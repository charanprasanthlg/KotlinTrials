package com.example.kotlintrials.sqlitetrials.notes

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R
import com.example.kotlintrials.sqlitetrials.model.NotesModel
import com.example.kotlintrials.sqlitetrials.notesdetail.NotesDetailActivity
import org.w3c.dom.Text


class NotesAdapter(
    private var notesList: ArrayList<NotesModel>,
    var presenter: NotesActivityClassPresenter
) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.notes_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardView_item.setCardBackgroundColor(notesList[position].color)
        holder.textView_title.text = notesList[position].title
        holder.textView_body.text = notesList[position].body
        holder.cardView_item.setOnClickListener {
            val intent = Intent(context, NotesDetailActivity::class.java)
            intent.putExtra("id", notesList[position].id)
            intent.putExtra("color", notesList[position].color)
            intent.putExtra("title", notesList[position].title)
            intent.putExtra("body", notesList[position].body)
            intent.putExtra("type", "old")
            context.startActivity(intent)
        }
        holder.cardView_item.setOnLongClickListener {
            showDialogBox(notesList[position].id, position, context)
            true
            //above true is for setOnLongClickListener
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView_title = itemView.findViewById<TextView>(R.id.textView_title)
        var textView_body = itemView.findViewById<TextView>(R.id.textView_body)
        var cardView_item = itemView.findViewById<CardView>(R.id.cardView_item)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showDialogBox(id: Int, position: Int, context: Context) {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_box)

        val textView = dialog.findViewById<TextView>(R.id.textview_text)
        val confirmBtn = dialog.findViewById<TextView>(R.id.confirmBtn)
        val cancelBtn = dialog.findViewById<TextView>(R.id.cancelBtn)

        textView.text = "Are you sure you want to delete this note?"

        confirmBtn.setOnClickListener {
            presenter.deleteData(id, context)
            dialog.dismiss()
            notesList.removeAt(position)
//            notifyItemRemoved(position)
            notifyDataSetChanged()
        }
        cancelBtn.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }
}