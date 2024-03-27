package com.greenwolfgames.monstermaster

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene10_demon_bird)
        val extras = intent.extras
        //disable back button
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false
        val currentState = extras?.getSerializable("state") as State

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

        val button1: Button = findViewById(R.id.scene10button1)
        val button2: Button = findViewById(R.id.scene10button2)
        val button3: Button = findViewById(R.id.scene10button3)
        val button4: Button = findViewById(R.id.scene10button4)

        val buttons: List<Button> = listOf(
            button1,
            button2,
            button3,
            button4
        )

        for(button in buttons)
        {
            Utilities.hideButton(button,this@Scene10Activity)
        }
        button1.setOnClickListener {
            currentState.addScore(Element.FIRE,1)
            currentState.addScore(Element.DARK,1)
            currentState.starterMonster="Spiten"
            currentState.previousSceneName="Scene10Activity"
            val intent = Intent(this, Scene12Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }
        if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH)) {
            button2.setText(R.string.scene10choice2)
            button2.setOnClickListener {
                currentState.addScore(Element.AIR, 2)
                currentState.starterMonster = "Flapper"
                currentState.previousSceneName="Scene10Activity"
                val intent = Intent(this, Scene12Activity::class.java)
                intent.putExtra("state", currentState)
                startActivity(intent)
            }
            button3.setText( R.string.scene10choice3)

        }
        else {
            button2.setText(R.string.scene10choice2Alt)
            button2.setOnClickListener {
                currentState.addScore(Element.EARTH,2)
                currentState.starterMonster = "Bulbapup"
                currentState.previousSceneName="Scene10Activity"
                val intent = Intent(this, Scene12Activity::class.java)
                intent.putExtra("state", currentState)
                startActivity(intent)
            }
            button3.setText(R.string.scene10choice3Alt)
            textViews[3].text = getString(R.string.scene10item4Alt)
        }
        button3.setOnClickListener{
            currentState.addScore(Element.FIRE, 2)
            currentState.starterMonster = "Flarial"
            currentState.previousSceneName="Scene10Activity"
            val intent = Intent(this, Scene12Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }
        button4.setOnClickListener {
            currentState.addScore(Element.DARK,1)
            currentState.starterMonster="Umbress"
            currentState.previousSceneName="Scene10Activity"
            val intent = Intent(this, Scene12Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
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
                Subelement.colorButton(button1,this@Scene10Activity,Subelement.DEMON)
                if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
                {
                    Element.colorButton(button2,this@Scene10Activity,Element.AIR)
                }
                else {
                    Element.colorButton(button2,this@Scene10Activity,Element.EARTH)
                }
                Element.colorButton(button3,this@Scene10Activity,Element.FIRE)
                Element.colorButton(button4,this@Scene10Activity,Element.DARK)
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
                            this@Scene10Activity,
                            R.color.redOrange
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