package com.example.kotlintrials.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlintrials.R
import java.util.ArrayList
import kotlin.random.Random

class RecyclerAdapter(private val data: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = position.toString() + ". " + data[position]
        holder.layout.setOnClickListener { data.removeAt(position) }
        Glide.with(holder.layout).load(randomImage()).into(holder.img);
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.text)
        var layout: LinearLayout = itemView.findViewById(R.id.layout)
        var img: ImageView = itemView.findViewById(R.id.img)
    }

    private fun randomImage(): String {
        val list = listOf(
            "https://picsum.photos/500/300",
            "https://picsum.photos/600/300",
            "https://picsum.photos/700/400",
            "https://picsum.photos/500/500",
            "https://picsum.photos/600/200",
            "https://picsum.photos/1100/900",
            "https://picsum.photos/500/300",
            "https://picsum.photos/670/380",
            "https://picsum.photos/1500/970",
            "https://picsum.photos/580/200",
            "https://picsum.photos/500/300",
            "https://picsum.photos/600/300",
            "https://picsum.photos/700/400",
            "https://picsum.photos/500/500",
            "https://picsum.photos/600/200",
            "https://picsum.photos/1100/900",
            "https://picsum.photos/500/300",
            "https://picsum.photos/670/380",
            "https://picsum.photos/1500/970",
            "https://picsum.photos/580/200",
            "https://picsum.photos/500/300",
            "https://picsum.photos/500/300",
            "https://picsum.photos/600/300",
            "https://picsum.photos/700/400",
            "https://picsum.photos/500/500",
            "https://picsum.photos/600/200",
            "https://picsum.photos/1100/900",
            "https://picsum.photos/500/300",
            "https://picsum.photos/670/380",
            "https://picsum.photos/1500/970",
            "https://picsum.photos/580/200",
            "https://picsum.photos/500/300",
            "https://picsum.photos/600/300",
            "https://picsum.photos/700/400",
            "https://picsum.photos/500/500",
            "https://picsum.photos/600/200",
            "https://picsum.photos/1100/900",
            "https://picsum.photos/500/300",
            "https://picsum.photos/670/380",
            "https://picsum.photos/1500/970",
            "https://picsum.photos/580/200",
            "https://picsum.photos/500/300"
        )
        val randomIndex = Random.nextInt(list.size)

        return list[randomIndex]
    }
}
