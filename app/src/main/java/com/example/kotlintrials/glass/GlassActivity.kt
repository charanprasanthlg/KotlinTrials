package com.example.kotlintrials.glass

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.example.kotlintrials.R

class GlassActivity : AppCompatActivity() {

    lateinit var layout : RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glass)

        layout = findViewById(R.id.layout)
        handleAnimation(layout)
    }

    private fun handleAnimation(view: View){
        val animator = ObjectAnimator.ofFloat(view, "y", 600f)
        animator.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator)
        animatorSet.start()
    }
}
