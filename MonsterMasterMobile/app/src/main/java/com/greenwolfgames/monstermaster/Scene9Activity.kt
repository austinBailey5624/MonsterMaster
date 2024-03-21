package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene9Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene9_magic_glyph)
        val extras = intent.extras
        //disable back button
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false
        val currentState = extras?.getSerializable("state") as State

        val button1: Button = findViewById(R.id.scene9button1)
        val button2: Button = findViewById(R.id.scene9button2)
        val button3: Button = findViewById(R.id.scene9button3)
        val button4: Button = findViewById(R.id.scene9button4)

        val buttons: List<Button> = listOf(
            button1,
            button2,
            button3,
            button4
        )

        for(button in buttons)
        {
            Utilities.hideButton(button,this@Scene9Activity)
        }
        button1.setOnClickListener {
            currentState.addScore(Element.LIGHT,2)
            currentState.starterMonster="Lumin"
        }
        button2.setOnClickListener {
            currentState.addScore(Element.WATER,2)
            currentState.starterMonster="Minnow"
        }
        if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
        {
            button3.setText(R.string.scene8choice3Alt)
            button3.setOnClickListener {
                currentState.addScore(Element.AIR,2)
                currentState.starterMonster="Flapper"
            }
        }
        else {
            button3.setText(R.string.scene8choice3)
            button3.setOnClickListener {
                currentState.addScore(Element.EARTH,2)
                currentState.starterMonster = "Bulbapup"
            }
        }
        button4.setOnClickListener {
            currentState.addScore(Element.LIGHT,1)
            currentState.addScore(Element.WATER,1)
            currentState.starterMonster="Lona"
        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.textView),
            findViewById(R.id.textView2),
            findViewById(R.id.textView3),
            findViewById(R.id.textView4),
            findViewById(R.id.textView5)
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

        fadeInAnimations[5].setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                for(button in buttons)
                {
                    button.startAnimation(fadeInAnimations[6])
                }
                Element.colorButton(button1,this@Scene9Activity,Element.LIGHT)
                Element.colorButton(button2,this@Scene9Activity,Element.WATER)
                if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
                {
                    Element.colorButton(button3,this@Scene9Activity,Element.AIR)
                }
                else {
                    Element.colorButton(button3,this@Scene9Activity,Element.EARTH)
                }
                button4.setTextColor(ContextCompat.getColor(this@Scene9Activity, R.color.lightCyan))
                button4.setBackgroundColor(ContextCompat.getColor(this@Scene9Activity, R.color.lightishBlue))
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in 0..4)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i+1])
                    textViews[i].setTextColor(ContextCompat.getColor(this@Scene9Activity, R.color.lightCyan))
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        val magicGlyphImage: ImageView = findViewById(R.id.scene9image2)

        val partialFadeInAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.partial_fade_in)
        val partialFadeOutAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.partial_fade_out)

        partialFadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                magicGlyphImage.startAnimation(partialFadeOutAnimation)
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        partialFadeOutAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                magicGlyphImage.startAnimation(partialFadeInAnimation)
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        magicGlyphImage.startAnimation(partialFadeInAnimation)

        textViews[0].startAnimation(fadeInAnimations[0])

        val slowFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slow)
        val stream: ImageView = findViewById(R.id.scene9image1)
        stream.startAnimation(slowFadeInAnimation)


    }
    override fun onBackPressed() {
        if(false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}