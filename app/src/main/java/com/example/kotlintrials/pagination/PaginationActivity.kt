package com.example.kotlintrials.pagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R

class PaginationActivity : AppCompatActivity() {

    val numberList: MutableList<String> = ArrayList()
    var page = 1
    var isLoading = false
    private val limit = 10

    lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    lateinit var adapter: NumberAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagination)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        getPage()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCCount = linearLayoutManager.childCount
                val pastVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                if (!isLoading) {
                    if (visibleItemCCount + pastVisibleItem >= total) {
                        page++
                        getPage()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun getPage() {
        isLoading = true
        progressBar.visibility = View.VISIBLE
        val start = (page - 1) * limit
        val end = page * limit

        for (i in start..end) {
            numberList.add("Item: $i")
        }
        Handler().postDelayed({
            if (::adapter.isInitialized) {
                adapter.notifyDataSetChanged()
            } else {
                adapter = NumberAdapter(this)
                recyclerView.adapter = adapter
            }
            isLoading = false
            progressBar.visibility = View.GONE
        }, 5000)
    }

    class NumberAdapter(private val activity: PaginationActivity) :
        RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(activity).inflate(R.layout.pagination_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = activity.numberList[position]
        }

        override fun getItemCount(): Int {
            return activity.numberList.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView = itemView.findViewById(R.id.textView)
        }
    }
}