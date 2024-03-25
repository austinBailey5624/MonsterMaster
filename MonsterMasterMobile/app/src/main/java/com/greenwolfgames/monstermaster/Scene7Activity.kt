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

class Scene7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene7_dark_forest_stream)
        val extras = intent.extras
        //disable back button
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false
        val currentState = extras?.getSerializable("state") as State

        val button: Button = findViewById(R.id.scene8button1)
        Utilities.hideButton(button,this@Scene7Activity)
        button.setOnClickListener {
            currentState.addScore(Element.EARTH,1)
            val intent = Intent(this,Scene11Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.scene8button2)
        Utilities.hideButton(button2,this@Scene7Activity)
        button2.setOnClickListener {
            currentState.addScore(Element.AIR,1)
            val intent = Intent(this,Scene11Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
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
                button.startAnimation(fadeInAnimations[7])
                button2.startAnimation(fadeInAnimations[7])
                Element.colorButton(button,this@Scene7Activity,Element.EARTH)
                Element.colorButton(button2,this@Scene7Activity,Element.AIR)
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
    override fun onBackPressed() {
        if(false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}