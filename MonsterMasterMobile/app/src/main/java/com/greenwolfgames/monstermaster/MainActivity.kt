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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this) {
        }.isEnabled = false
//        var state = State()
//
//        val button1: Button = findViewById(R.id.button1)
//        Utilities.hideButton(button1,this@MainActivity)
//        button1.setOnClickListener {
//            state.addScore(Element.LIGHT,1)
////            val intent = Intent(this, Scene2Activity::class.java)
////            intent.putExtra("state", state)
////            startActivity(intent)
//        }
//
//        val button2: Button = findViewById(R.id.button2)
//        Utilities.hideButton(button2, this@MainActivity)
//        button2.setOnClickListener {
//            state.addScore(Element.DARK,1)
////            val intent = Intent(this, Scene3Activity::class.java)
////            intent.putExtra("state", state)
////            startActivity(intent)
//        }
//
//        val textViews: List<TextView> = listOf(
//            findViewById(R.id.text1),
//            findViewById(R.id.text2),
//            findViewById(R.id.text3),
//            findViewById(R.id.text4),
//            findViewById(R.id.text5),
//            findViewById(R.id.text6),
//            findViewById(R.id.text7)
//        )
//        for(textView in textViews)
//        {
//            textView.setTextColor(ContextCompat.getColor(this, R.color.invisible))
//        }
//        val fadeInAnimations: List<Animation> = listOf(
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
//            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
//        )
//
//        fadeInAnimations[7].setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation) {}
//            override fun onAnimationEnd(animation: Animation) {
//                button1.startAnimation(fadeInAnimations[8])
//                button2.startAnimation(fadeInAnimations[8])
//                Element.colorButton(button1,this@MainActivity,Element.LIGHT)
//                Element.colorButton(button2,this@MainActivity,Element.DARK)
//            }
//            override fun onAnimationRepeat(animation: Animation) {}
//        })
//
//        for(i in 0..6)
//        {
//            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation) {}
//                override fun onAnimationEnd(animation: Animation) {
//                    textViews[i].startAnimation(fadeInAnimations[i+1])
//                    textViews[i].setTextColor(ContextCompat.getColor(this@MainActivity, R.color.whiteGray))
//                }
//                override fun onAnimationRepeat(animation: Animation) {}
//            })
//        }
//
//        textViews[0].startAnimation(fadeInAnimations[0])
//    }
//    override fun onBackPressed() {
//        if(false) {
//            super.onBackPressed()
//        }
//        // Do nothing here
    }
}