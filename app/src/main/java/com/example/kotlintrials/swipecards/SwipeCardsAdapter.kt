package com.example.kotlintrials.swipecards

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.kotlintrials.R


class SwipeCardsAdapter(
    private val context: Context,
    private val swipeCardModelArrayList: ArrayList<SwipeCardsModel>
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return swipeCardModelArrayList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.card_layout, container, false)

        val model = swipeCardModelArrayList[position]

        val imageView_cardImage = view.findViewById<ImageView>(R.id.imageView_cardImage)
        val textView_title = view.findViewById<TextView>(R.id.textView_title)
        val textView_subTitle = view.findViewById<TextView>(R.id.textView_subTitle)
        val cardView_cards = view.findViewById<CardView>(R.id.cardView_cards)

        Glide.with(context).load(model.imgUrl).into(imageView_cardImage)
        textView_title.text = model.title
        textView_subTitle.text = model.subTitle
        cardView_cards.setOnClickListener {
            showDialog(
                imgURl = model.imgUrl,
                title = model.title,
                subTitle = model.subTitle
            )
        }

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun showDialog(imgURl: String, title: String, subTitle: String) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.swipe_card_dialog)
        dialog.window!!.setBackgroundDrawableResource(R.drawable.dialog_background)

        val imageView_cardImage: ImageView = dialog.findViewById(R.id.imageView_cardImage)
        val textView_title: TextView = dialog.findViewById(R.id.textView_title)
        val textView_subTitle: TextView = dialog.findViewById(R.id.textView_subTitle)
        val closeBtn: RelativeLayout = dialog.findViewById(R.id.closeBtn)

        Glide.with(context).load(imgURl).into(imageView_cardImage)
        textView_title.text = title
        textView_subTitle.text = subTitle

        closeBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
}