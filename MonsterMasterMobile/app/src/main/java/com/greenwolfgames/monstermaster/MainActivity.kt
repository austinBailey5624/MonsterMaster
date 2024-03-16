package com.greenwolfgames.monstermaster

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var state: State = State()
        setScenario(state)

    }


    //The following code is terrible, terrible spaghetti code. I recognize that, but cannot get the animations
    //to work the proper iterated way, becasue it keeps repeating the first one. However, I wasted too much
// //time trying to fix it and am now moving on TODO fix this to use a single iterated animation
    private fun setScenario(state: State) {
        val currentScenario: Scenario = getScenario(state.nextScenario)
        val buttons: List<Button> = listOf(findViewById(R.id.button1), findViewById(R.id.button2))
        val mainView: ConstraintLayout = findViewById(R.id.main)
        mainView.setBackgroundColor(ContextCompat.getColor(this, R.color.black))

        var buttonIndex = 0
        for (button in buttons) {
            val currentIndex = buttonIndex
            button.text = currentScenario.choices.get(buttonIndex).content
            button.setOnClickListener {
                currentScenario.choices.get(currentIndex).action(state)
            }
            button.setTextColor(ContextCompat.getColor(this, R.color.invisible))
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))
            buttonIndex++

        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.text1),
            findViewById(R.id.text2),
            findViewById(R.id.text3),
            findViewById(R.id.text4),
            findViewById(R.id.text5),
            findViewById(R.id.text6)
        )
        var textIndex = 0
        for (textView in textViews) {
            textView.text = currentScenario.statements.get(textIndex)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
            textView.setTextColor(ContextCompat.getColor(this, R.color.invisible))
            textIndex++
        }
        textViews[2].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)

        val fadeInAnimation7 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation6 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation5 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation4 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation3 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation1 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        fadeInAnimation7.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                buttons[0].startAnimation(fadeInAnimation)
                buttons[1].startAnimation(fadeInAnimation)

                buttons[0].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )
                buttons[0].setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.darkishGray
                    )
                )
                buttons[1].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.black
                    )
                )
                buttons[1].setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.darkishGray
                    )
                )

            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        fadeInAnimation6.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                textViews[5].startAnimation(fadeInAnimation7)
                textViews[5].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )

            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        fadeInAnimation5.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                textViews[4].startAnimation(fadeInAnimation6)
                textViews[4].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        fadeInAnimation4.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                textViews[3].startAnimation(fadeInAnimation5)
                textViews[3].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        fadeInAnimation3.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                textViews[2].startAnimation(fadeInAnimation4)
                textViews[2].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        fadeInAnimation2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                textViews[1].startAnimation(fadeInAnimation3)
                textViews[1].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        fadeInAnimation1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {

                textViews[0].startAnimation(fadeInAnimation2)
                textViews[0].setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.whitegray
                    )
                )
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        val textView1 = textViews[0]
        textView1.startAnimation(fadeInAnimation1)
    }


    private fun getScenario(which: Int): Scenario {
        if (which == 1) {
            val statements = mutableListOf<String>()
            statements += getString(R.string.scene1item1)
            statements += getString(R.string.scene1item2)
            statements += getString(R.string.scene1item3)
            statements += getString(R.string.scene1item4)
            statements += getString(R.string.scene1item5)
            statements += getString(R.string.scene1item6)
            val choices = mutableListOf<Choice>()
            choices += Choice(getString(R.string.scene1choice1)) { currentState ->
                currentState.whiteScore++
                currentState.nextScenario = 2
                Log.d("ChoiceExecuted", "Scene1Choice1Executed")
                setScenario(currentState)
            }
            choices += Choice(getString(R.string.scene1choice2)) { currentState ->
                currentState.blackScore++
                currentState.nextScenario = 3
            }

            val scenario = Scenario()
            scenario.statements = statements
            scenario.choices = choices
            return scenario
        }
        if (which == 2) {
            val statements = mutableListOf<String>()
            statements += getString(R.string.scene2item1)
            statements += getString(R.string.scene2item2)
            statements += getString(R.string.scene2item3)
            statements += getString(R.string.scene2item4)
            val choices = mutableListOf<Choice>()
            choices += Choice(getString(R.string.scene2choice1)) { currentState ->
                currentState.redScore++
                currentState.nextScenario = 4
            }
            choices += Choice(getString(R.string.scene2choice2)) { currentState ->
                currentState.blueScore++
                currentState.nextScenario = 5
            }

            val scenario = Scenario()
            scenario.statements = statements
            scenario.choices = choices
            return scenario

        }
        throw Exception("getScenario which value $which Not valid")
    }
}