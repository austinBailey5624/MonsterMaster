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

class Scene2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene2_forest)
        val extras = intent.extras
        //disable back button
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false

        val currentState = extras?.getSerializable("state") as State

        val button3: Button = findViewById(R.id.button3)
        button3.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        button3.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))
        button3.setOnClickListener {
            currentState.redScore++
            val intent = Intent(this, Scene4Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }

        val button4: Button = findViewById(R.id.button4)
        button4.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))
        button4.setOnClickListener {
            currentState.blueScore++
            val intent = Intent(this, Scene5Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.textView),
            findViewById(R.id.textView2),
            findViewById(R.id.textView3),
            findViewById(R.id.textView4),
            findViewById(R.id.textView5),
            findViewById(R.id.textView6),
            findViewById(R.id.textView7)
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
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[7].setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                button3.startAnimation(fadeInAnimations[8])
                button4.startAnimation(fadeInAnimations[8])

                button3.setTextColor(ContextCompat.getColor(this@Scene2Activity, R.color.red))
                button3.setBackgroundColor(ContextCompat.getColor(this@Scene2Activity, R.color.yellowOrange))

                button4.setTextColor(ContextCompat.getColor(this@Scene2Activity, R.color.blue))
                button4.setBackgroundColor(ContextCompat.getColor(this@Scene2Activity, R.color.cyan))

            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in 0..6)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i+1])
                    textViews[i].setTextColor(ContextCompat.getColor(this@Scene2Activity, R.color.whiteGray))
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        textViews[0].startAnimation(fadeInAnimations[0])
        val slowFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slow)
        val faintLight: ImageView = findViewById(R.id.imageView2)
        faintLight.startAnimation(slowFadeInAnimation)
    }

    override fun onBackPressed() {
        if(false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}