package com.greenwolfgames.monstermaster

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene13Activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene13_wake_up)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val button: Button = findViewById(R.id.button)

        Utilities.hideButton(button, this@Scene13Activity)

        button.setOnClickListener {
            val intent = Intent(this, Scene14Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.textView),
            findViewById(R.id.textView2),
            findViewById(R.id.textView3),
            findViewById(R.id.textView4)
        )

        for(textView in textViews)
        {
            textView.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }

        for(i in 0 .. 2)
        {
            textViews[i].setText(currentState.playerName);
        }

        val fadeInAnimations: List<Animation> = listOf(
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[4].setAnimationListener(object: Animation.AnimationListener
        {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                Element.colorButton(button, this@Scene13Activity, Element.LIGHT)
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in 0 .. 3)
        {
            fadeInAnimations[i].setAnimationListener(object: Animation.AnimationListener
            {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i+1])
                    textViews[i].setTextColor(ContextCompat.getColor(this@Scene13Activity, R.color.whiteGray))
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }
        textViews[0].startAnimation(fadeInAnimations[0])
    }
}