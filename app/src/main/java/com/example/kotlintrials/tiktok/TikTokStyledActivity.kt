package com.example.kotlintrials.tiktok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlintrials.R
import com.example.kotlintrials.adapters.TikTokAdapter

class TikTokStyledActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tik_tok_styled)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val videos = arrayListOf(
            "https://firebasestorage.googleapis.com/v0/b/authentication-2bdb7.appspot.com/o/pexels-rodnae-productions-7515918.mp4?alt=media&token=346c7971-18a5-446c-9cda-a9f60daafe58",
            "https://firebasestorage.googleapis.com/v0/b/authentication-2bdb7.appspot.com/o/VID_29270409_072930_600%5B1%5D.mp4?alt=media&token=7be9fa01-d996-410e-bfcb-161e67954934",
            "https://firebasestorage.googleapis.com/v0/b/authentication-2bdb7.appspot.com/o/Snapchat-1938895666%5B1%5D.mp4?alt=media&token=ce345c86-6c9d-47e3-9568-98edbf87bf26",
            "https://player.vimeo.com/external/296210754.hd.mp4?s=08c03c14c04f15d65901f25b542eb2305090a3d7&profile_id=175&oauth2_token_id=57447761",
            "https://player.vimeo.com/external/295482071.hd.mp4?s=8716a11fe2222114283a29f8fe49ce8071017332&profile_id=175&oauth2_token_id=57447761",
            "https://player.vimeo.com/external/226685105.hd.mp4?s=b6a194faf216cac660ec198e72b4e939cd74dee3&profile_id=170&oauth2_token_id=57447761",
            "https://player.vimeo.com/external/236075858.hd.mp4?s=539faad12f040eb5afd8de3160db1220f1a5bac0&profile_id=175&oauth2_token_id=57447761",
            "https://player.vimeo.com/external/289258217.hd.mp4?s=5cf87d7670d96bbd2c110f4dc97fd5116f4468ad&profile_id=170&oauth2_token_id=57447761"
        )

        viewPager.adapter = TikTokAdapter(videos)
    }
}