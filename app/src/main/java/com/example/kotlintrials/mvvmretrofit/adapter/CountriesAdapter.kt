package com.example.kotlintrials.mvvmretrofit.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R
import com.example.kotlintrials.mvvmretrofit.model.CountryModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountriesAdapter(val activity : Activity) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private var countriesList : List<CountryModel>? = null

    fun setCountryList(countriesList : List<CountryModel>){
        this.countriesList = countriesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countriesList!![position], activity)
    }

    override fun getItemCount(): Int {
        if(countriesList == null) return 0
        else return countriesList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
        var tvName = itemView.findViewById<TextView>(R.id.tvName)
        var tvCapital = itemView.findViewById<TextView>(R.id.tvCapital)
        var tvRegion = itemView.findViewById<TextView>(R.id.tvRegion)

        fun bind(data: CountryModel, activity : Activity){
            tvName.text = data.name
            tvCapital.text = "Capital : " + data.capital
            tvRegion.text = "Region : " + data.region
            GlideToVectorYou.justLoadImage(activity, Uri.parse(data.flag), flagImage)
        }
    }
}