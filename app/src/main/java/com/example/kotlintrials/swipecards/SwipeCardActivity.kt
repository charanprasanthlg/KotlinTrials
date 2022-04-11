package com.example.kotlintrials.swipecards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.kotlintrials.R

class SwipeCardActivity : AppCompatActivity(), SwipeCardsView {

    lateinit var swipeCardsModelList: ArrayList<SwipeCardsModel>
    lateinit var swipeCardsAdapter: SwipeCardsAdapter
    lateinit var viewPager: ViewPager
    lateinit var imageView_backgroundImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_card)

        initView()
        loadCards()

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Glide.with(applicationContext)
                    .load(swipeCardsModelList[position].imgUrl)
                    .into(imageView_backgroundImage)
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {
                Log.d("Result___", state.toString())
            }
        })
    }

    override fun initView() {
        swipeCardsModelList = ArrayList()
        viewPager = findViewById(R.id.viewPager)
        imageView_backgroundImage = findViewById(R.id.imageView_backgroundImage)
    }

    override fun loadCards() {
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/aerobics_rect.png?alt=media&token=7cf45b52-7249-43e8-96c1-a2d698e3c84f",
                "Aerobics",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/badminton_rect.png?alt=media&token=c949f8bf-99a6-4e2d-8641-d4a2b4122b9e",
                "Badminton",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/boxing_rect.jpg?alt=media&token=4edfe7dc-3d8b-4194-9e20-8c94ead4166f",
                "Boxing",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/crossfit_rect.png?alt=media&token=cef1ae8e-afe8-4408-89de-5383380f6fa0",
                "Crossfit",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/football_rect.jpg?alt=media&token=dd49464d-d72c-4ecb-866e-e0a8273009cd",
                "Football",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/karate_rect.png?alt=media&token=2f375b8b-fed0-4d86-825c-a102bf9fd43d",
                "Karate",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/taekwondo_rect.png?alt=media&token=e3415c0d-4dec-4156-99f9-ec618131f0bb",
                "Taekwondo",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )
        swipeCardsModelList.add(
            SwipeCardsModel(
                "https://firebasestorage.googleapis.com/v0/b/unshape-db.appspot.com/o/tennis_rect.jpg?alt=media&token=a73c95f8-976c-4503-bf4c-b9bfad990148",
                "Tennis",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            )
        )

        swipeCardsAdapter = SwipeCardsAdapter(this, swipeCardsModelList)
        viewPager.adapter = swipeCardsAdapter
        viewPager.setPadding(100, 0, 100, 0)
    }
}