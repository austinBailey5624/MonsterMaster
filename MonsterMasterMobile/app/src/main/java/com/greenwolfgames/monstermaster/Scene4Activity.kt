package com.greenwolfgames.monstermaster

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene4_forest_fire)
        val extras = intent.extras

        //disable back button
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false

        val currentState = extras?.getSerializable("state") as State

        val button: Button = findViewById(R.id.button)
        Utilities.hideButton(button, this@Scene4Activity)
        button.setOnClickListener {
            currentState.addScore(Element.EARTH, 1)
            val intent = Intent(this,Scene8Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.scene8button2)
        Utilities.hideButton(button2, this@Scene4Activity)
        button2.setOnClickListener {
            currentState.addScore(Element.AIR, 1)
            val intent = Intent(this,Scene8Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
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
                Element.colorButton(button, this@Scene4Activity, Element.EARTH)
                Element.colorButton(button2, this@Scene4Activity, Element.AIR)
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
                            this@Scene4Activity,
                            R.color.whiteGray
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

    override fun onBackPressed() {
        if (false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}