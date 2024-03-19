package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene6Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene6_dark_forest_fire)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val button: Button = findViewById(R.id.button)

        button.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))

        button.setOnClickListener {
            currentState.greenScore++
        }

        val button2: Button = findViewById(R.id.button2)

        button2.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        button2.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))

        button2.setOnClickListener {
            currentState.yellowScore++
        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.textView8),
            findViewById(R.id.textView9),
            findViewById(R.id.textView10),
            findViewById(R.id.textView11),
            findViewById(R.id.textView12),
            findViewById(R.id.textView13),
        )

        for (textView in textViews) {
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
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[6].setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                button.startAnimation(fadeInAnimations[7])
                button2.startAnimation(fadeInAnimations[7])

                button.setTextColor(ContextCompat.getColor(this@Scene6Activity, R.color.green))
                button.setBackgroundColor(
                    ContextCompat.getColor(
                        this@Scene6Activity,
                        R.color.forestGreen
                    )
                )

                button2.setTextColor(ContextCompat.getColor(this@Scene6Activity, R.color.yellow))
                button2.setBackgroundColor(
                    ContextCompat.getColor(
                        this@Scene6Activity,
                        R.color.brown
                    )
                )

            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        for (i in 0..5) {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i + 1])
                    textViews[i].setTextColor(
                        ContextCompat.getColor(
                            this@Scene6Activity,
                            R.color.gray
                        )
                    )
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        textViews[0].startAnimation(fadeInAnimations[0])

        val slowFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slow)
        val fire: ImageView = findViewById(R.id.imageView)
        fire.startAnimation(slowFadeInAnimation)
    }
}