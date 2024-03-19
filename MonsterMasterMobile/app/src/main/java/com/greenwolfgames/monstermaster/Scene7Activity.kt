package com.greenwolfgames.monstermaster

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene7_dark_forest_stream)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val button4: Button = findViewById(R.id.button4)


        button4.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))


        button4.setOnClickListener {
            currentState.greenScore++
//            val intent = Intent(this, Scene4Activity::class.java)
//            intent.putExtra("state", currentState)
//            startActivity(intent)
        }

        val button5: Button = findViewById(R.id.button5)

        button5.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        button5.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))

        button5.setOnClickListener {
            currentState.yellowScore++
        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.textView),
            findViewById(R.id.textView2),
            findViewById(R.id.textView3),
            findViewById(R.id.textView4),
            findViewById(R.id.textView5),
            findViewById(R.id.textView6)
        )

        for(textView in textViews)
        {
            textView.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }

        val fadeInAnimations: List<Animation> = listOf(
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[6].setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                button4.startAnimation(fadeInAnimations[7])
                button5.startAnimation(fadeInAnimations[7])

                button4.setTextColor(ContextCompat.getColor(this@Scene7Activity, R.color.green))
                button4.setBackgroundColor(ContextCompat.getColor(this@Scene7Activity, R.color.forestGreen))

                button5.setTextColor(ContextCompat.getColor(this@Scene7Activity, R.color.yellow))
                button5.setBackgroundColor(ContextCompat.getColor(this@Scene7Activity, R.color.brown))

            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in 0..5)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i+1])
                    textViews[i].setTextColor(ContextCompat.getColor(this@Scene7Activity, R.color.whiteGray))
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        textViews[0].startAnimation(fadeInAnimations[0])

        val slowFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slow)
        val stream: ImageView = findViewById(R.id.imageView3)
        stream.startAnimation(slowFadeInAnimation)
    }
}