package com.example.kotlintrials.glass

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import androidx.core.view.size
import com.example.kotlintrials.R
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class GlassActivity : AppCompatActivity() {

    lateinit var layout: RelativeLayout
    var xDown = 0F
    var yDown = 0F
    val move = 200F
    var ratio = 1.0F
    var baseDist : Int = 0
    var baseRatio : Float = 0F

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glass)

        layout = findViewById(R.id.layout)
        handleAnimation(layout)

        layout.setOnTouchListener { _, event ->

            when (event?.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    xDown = event.x
                    yDown = event.y
                }
                MotionEvent.ACTION_MOVE -> {

                    val movedX: Float = event.x
                    val movedY: Float = event.y

                    val distanceX = movedX - xDown
                    val distanceY = movedY - yDown

                    layout.x = layout.x + distanceX
                    layout.y = layout.y + distanceY
                }
            }

//            if(event?.actionMasked == MotionEvent.ACTION_POINTER_DOWN){
//                baseDist = getDist(event)
//                baseRatio = ratio
//            }else {
//                val scale : Float = (getDist(event)-baseDist) / move
//                val factor : Float = 2.0.pow(scale.toDouble()).toFloat()
//                ratio = min(1024.0F, max(0.1F, baseRatio * factor))
//                layout.layoutParams = ratio.
//            }
//
//            if(event.pointerCount == 2){
//                var action = event.action
//                var mainAction = actionMotionEvent.ACTIONMASK
//            }

            true
        }
    }

//    private fun getDist(event: MotionEvent): Int {
//
//    }

    private fun handleAnimation(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "y", 600f)
        animator.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator)
        animatorSet.start()
    }
}
