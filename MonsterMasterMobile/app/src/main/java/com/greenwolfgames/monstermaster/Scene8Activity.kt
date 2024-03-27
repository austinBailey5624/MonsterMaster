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

class Scene8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene8_sun_shrine)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val button1: Button = findViewById(R.id.scene8button1)
        val button2: Button = findViewById(R.id.scene8button2)
        val button3: Button = findViewById(R.id.scene8button3)
        val button4: Button = findViewById(R.id.scene8button4)

        val buttons: List<Button> = listOf(
            button1,
            button2,
            button3,
            button4
        )

        for (button in buttons) {
            Utilities.hideButton(button, this@Scene8Activity)
        }
        button1.setOnClickListener {
            currentState.addScore(Element.LIGHT, 2)
            currentState.starterMonster = "Lumin"
            currentState.previousSceneName = "Scene8Activity"
            val intent = Intent(this, Scene12Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }
        button2.setOnClickListener {
            currentState.addScore(Element.FIRE, 2)
            currentState.starterMonster = "Flarial"
            currentState.previousSceneName = "Scene8Activity"
            val intent = Intent(this, Scene12Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }
        if (currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH)) {
            button3.setText(R.string.scene8choice3Alt)
            button3.setOnClickListener {
                currentState.addScore(Element.AIR, 2)
                currentState.starterMonster = "Flapper"
                currentState.previousSceneName = "Scene8Activity"
                val intent = Intent(this, Scene12Activity::class.java)
                intent.putExtra("state", currentState)
                startActivity(intent)
            }
        } else {
            button3.setText(R.string.scene8choice3)
            button3.setOnClickListener {
                currentState.addScore(Element.EARTH, 2)
                currentState.starterMonster = "Bulbapup"
                currentState.previousSceneName = "Scene8Activity"
                val intent = Intent(this, Scene12Activity::class.java)
                intent.putExtra("state", currentState)
                startActivity(intent)
            }
        }
        button4.setOnClickListener {
            currentState.addScore(Element.LIGHT, 1)
            currentState.addScore(Element.FIRE, 1)
            currentState.starterMonster = "Tona"
            currentState.previousSceneName = "Scene8Activity"
            val intent = Intent(this, Scene12Activity::class.java)
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
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[6].setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                for (button in buttons) {
                    button.startAnimation(fadeInAnimations[7])
                }
                Element.colorButton(button1, this@Scene8Activity, Element.LIGHT)
                Element.colorButton(button2, this@Scene8Activity, Element.FIRE)
                if (currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH)) {
                    Element.colorButton(button3, this@Scene8Activity, Element.AIR)
                } else {
                    Element.colorButton(button3, this@Scene8Activity, Element.EARTH)
                }
                Subelement.colorButton(button4, this@Scene8Activity, Subelement.SOLAR)
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
                            this@Scene8Activity,
                            R.color.lightYellow
                        )
                    )
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        textViews[0].startAnimation(fadeInAnimations[0])

        val slowFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slow)
        val stream: ImageView = findViewById(R.id.imageView4)
        stream.startAnimation(slowFadeInAnimation)
    }


    override fun onBackPressed() {
        if (false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}