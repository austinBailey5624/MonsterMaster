package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene11_deep_pool)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val button1: Button = findViewById(R.id.scene11button1)
        val button2: Button = findViewById(R.id.scene11button2)
        val button3: Button = findViewById(R.id.scene11button3)
        val button4: Button = findViewById(R.id.scene11button4)

        val buttons: List<Button> = listOf(
            button1,
            button2,
            button3,
            button4
        )

        for(button in buttons)
        {
            Utilities.hideButton(button,this@Scene11Activity)
        }
        button1.setOnClickListener {
            currentState.addScore(Element.WATER,2)
            currentState.starterMonster="Minnow"
        }
        button2.setOnClickListener {
            currentState.addScore(Element.WATER,1)
            currentState.addScore(Element.DARK,1)
            currentState.starterMonster="Deepfish"
        }
        if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH)) {
            button3.setText(R.string.scene11choice3Alt)
            button3.setOnClickListener {
                currentState.addScore(Element.AIR, 2)
                currentState.starterMonster = "Flapper"
            }
        }
        else {
            button3.setText(R.string.scene11choice3)
            button3.setOnClickListener {
                currentState.addScore(Element.EARTH,2)
                currentState.starterMonster = "Bulbapup"
            }
            button3.setText(R.string.scene10choice3Alt)
        }
        button4.setOnClickListener {
            currentState.addScore(Element.DARK,1)
            currentState.starterMonster="Umbress"
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
                for(button in buttons)
                {
                    button.startAnimation(fadeInAnimations[7])
                }
                Element.colorButton(button1,this@Scene11Activity,Element.WATER)
                button2.setTextColor(ContextCompat.getColor(this@Scene11Activity, R.color.lightishBlue))
                button2.setBackgroundColor(ContextCompat.getColor(this@Scene11Activity, R.color.black))

                if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
                {
                    Element.colorButton(button3,this@Scene11Activity,Element.AIR)
                }
                else {
                    Element.colorButton(button3,this@Scene11Activity,Element.EARTH)
                }
                Element.colorButton(button4,this@Scene11Activity,Element.DARK)
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in 0..5) {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i + 1])
                    textViews[i].setTextColor(
                        ContextCompat.getColor(
                            this@Scene11Activity,
                            R.color.lightishBlue
                        )
                    )
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        textViews[0].startAnimation(fadeInAnimations[0])
    }
    override fun onBackPressed() {
        if(false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}