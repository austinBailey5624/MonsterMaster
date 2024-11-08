package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false
        val state = State()

        val buttons: List<Button> = listOf(
            findViewById(R.id.button_1),
            findViewById(R.id.button_2),
            findViewById(R.id.button_3),
            findViewById(R.id.button_4),
            findViewById(R.id.button_5),
            findViewById(R.id.button_6)
        )
        val cinematicTexts: List<TextView> = listOf(
            findViewById(R.id.cinematic_text_1),
            findViewById(R.id.cinematic_text_2),
            findViewById(R.id.cinematic_text_3),
            findViewById(R.id.cinematic_text_4),
            findViewById(R.id.cinematic_text_5),
            findViewById(R.id.cinematic_text_6),
            findViewById(R.id.cinematic_text_7)
        )

        hideCinematicText(cinematicTexts)
        initButtons(buttons) //        Log.d("ButtonColor" + )
        setNode(1, state, buttons, cinematicTexts)
    }

    private fun hideCinematicText(cinematicTexts: List<TextView>)
    {
        for (text in cinematicTexts)
        {
            text.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }
    }

    private fun initButtons(buttons: List<Button>)
    {
        var skipButton: Button = findViewById(R.id.button_skip_animation)
        skipButton.visibility = View.VISIBLE
        skipButton.setOnClickListener {
            skipButton.visibility = View.GONE
            Log.d("Skip Button Clicked", "The Skip button was clicked")
        }
        hideButtons(buttons)
    }

    private fun hideButtons(buttons: List<Button>)
    {
        for (button in buttons)
        {
            button.setTextColor(ContextCompat.getColor(this, R.color.invisible))
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))
        }
    }

    private fun fadeOut(
        buttons: List<Button>, cinematicTexts: List<TextView>, nextNodeIndex: Int, state: State
    )
    {
        val fadeOutAnimationTrigger = AnimationUtils.loadAnimation(this, R.anim.fade_out_fast)
        fadeOutAnimationTrigger.setAnimationListener(object : Animation.AnimationListener
        {
            override fun onAnimationStart(animation: Animation)
            {
            }

            override fun onAnimationEnd(animation: Animation)
            {
                hideButtons(buttons)
                hideCinematicText(cinematicTexts)
                setNode(nextNodeIndex, state, buttons, cinematicTexts)
            }

            override fun onAnimationRepeat(animation: Animation)
            {
            }
        })

//        val fadeInAnimationTrigger = AnimationUtils.loadAnimation()
        val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out_fast)
        for (i in 1..buttons.size - 1)
        {
            buttons[i].startAnimation(fadeOutAnimation)
        }
        for (text in cinematicTexts)
        {
            text.startAnimation(fadeOutAnimation)
        }
        buttons[0].startAnimation(fadeOutAnimationTrigger)
        fadeOutAnimation.start()
    }

    private fun setNode(
        index: Int, state: State, buttons: List<Button>, cinematicTexts: List<TextView>
    )
    {
        val currentNode: CinematicNode = CinematicNodeRetriever.getCinematicNode(index, state, this@MainActivity)
        setCinematicTexts(currentNode.prompt, cinematicTexts)
        setButtons(currentNode, buttons, state, cinematicTexts)
        val main = findViewById<View>(R.id.main)
        main.setBackgroundColor(currentNode.backgroundColor)
        cinematicTexts[0].startAnimation(
            AnimationHandler.getFadeInAnimations(
                buttons, cinematicTexts, currentNode.textColor, currentNode, this@MainActivity, findViewById(R.id.button_skip_animation)
            )[0]
        )
        val skipButton: Button = findViewById(R.id.button_skip_animation)
        skipButton.visibility = View.VISIBLE
    }

    private fun setCinematicTexts(
        prompt: List<String>, cinematicTexts: List<TextView>
    )
    {
        if (prompt.size > 7 || prompt.size < 5)
        {
            throw IllegalStateException("Invalid number of cinematic texts, expected between 5 and 7, actual: " + prompt.size)
        }
        setCinematicTextLayout(prompt, cinematicTexts)
        setCinematicTextContent(prompt, cinematicTexts)
    }

    private fun setCinematicTextLayout(prompt: List<String>, cinematicTexts: List<TextView>)
    {
        for (i in cinematicTexts.indices)
        {
            val layoutParams = cinematicTexts[i].layoutParams as ConstraintLayout.LayoutParams
            layoutParams.startToStart = R.id.background_top
            layoutParams.startToEnd = ConstraintLayout.LayoutParams.UNSET
            layoutParams.endToEnd = R.id.background_top
            layoutParams.endToStart = ConstraintLayout.LayoutParams.UNSET
            if (i == 0)
            {
                layoutParams.topToTop = R.id.background_top
                layoutParams.topToBottom = ConstraintLayout.LayoutParams.UNSET
            }
            else
            {
                layoutParams.topToTop = ConstraintLayout.LayoutParams.UNSET
                layoutParams.topToBottom =
                    getCinematicTextLayout(EDirection.UP, cinematicTexts, i, prompt.size)
            }
            layoutParams.bottomToTop =
                getCinematicTextLayout(EDirection.DOWN, cinematicTexts, i, prompt.size)
            layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
            cinematicTexts[i].layoutParams = layoutParams
            cinematicTexts[i].visibility = getCinematicTextVisibility(i, prompt.size)
        }
    }

    //index refers to the index fo the cinematicTexts that is being referenced
    private fun getCinematicTextLayout(
        direction: EDirection, cinematicTexts: List<TextView>, index: Int, promptSize: Int
    ): Int
    {
        if (direction == EDirection.LEFT || direction == EDirection.RIGHT)
        {
            return R.id.background_top
        }
        if (direction == EDirection.UP)
        {
            return if (index == 0)
            {
                R.id.background_top
            }
            else
            {
                cinematicTexts[index - 1].id
            }
        } //now by process of elimination, we have to be in direction down (which is the trickiest)
        if (index in 0..3)
        {
            return cinematicTexts[index + 1].id
        }
        if (index == promptSize - 1)
        {
            return R.id.background_bottom
        }
        if (index < promptSize - 1)
        {
            return cinematicTexts[index + 1].id
        } // if index > promptsize - 1 visiblilty will be false, and we dont have to worry about it
        return 1;
    }

    private fun getCinematicTextVisibility(index: Int, promptSize: Int): Int
    {
        if (index >= promptSize)
        {
            return View.GONE
        }
        return View.VISIBLE
    }

    private fun setCinematicTextContent(
        prompt: List<String>, cinematicTexts: List<TextView>
    )
    {
        for (i in prompt.indices)
        {
            cinematicTexts[i].text = prompt[i]
        }
    }

    private fun setButtons(
        node: CinematicNode, buttons: List<Button>, state: State, cinematicTexts: List<TextView>
    )
    {
        Log.d("MainActivity.kt.setbuttons", "choicesCount: " + node.choices.size)
        setButtonFormat(node.choices.size, buttons)
        setButtonVisibility(node.choices.size, buttons)
        setButtonTextContent(node.choices, buttons, state)
        setButtonBehavior(node, buttons, state, cinematicTexts)
    }

    private fun setButtonFormat(choiceSize: Int, buttons: List<Button>)
    { //@formatter:off
        Log.d("MainActivity.kt.setButtonFormat",  "\n parentID: " + R.id.background_bottom
                + "\n Button 0: " + buttons[0].id
                + "\n Button 1: " + buttons[1].id
                + "\n Button 2: " + buttons[2].id
                + "\n Button 3: " + buttons[3].id
                + "\n Button 4: " + buttons[4].id
                + "\n Button 5: " + buttons[5].id)
        for(i in buttons.indices)
        {
            var layoutParams = buttons[i].layoutParams as ConstraintLayout.LayoutParams
            layoutParams.topToTop = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.TOP_TO_TOP, buttons, R.id.background_bottom)
            layoutParams.topToBottom = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.TOP_TO_BOTTOM, buttons, R.id.background_bottom)
            layoutParams.bottomToTop = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.BOTTOM_TO_TOP, buttons, R.id.background_bottom)
            layoutParams.bottomToBottom = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.BOTTOM_TO_BOTTOM, buttons, R.id.background_bottom)
            layoutParams.startToStart = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.START_TO_START, buttons, R.id.background_bottom)
            layoutParams.startToEnd = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.START_TO_END, buttons, R.id.background_bottom)
            layoutParams.endToEnd = ButtonLayoutResolver.getButtonLayout(choiceSize, i, ELayoutMode.END_TO_END, buttons, R.id.background_bottom)
            layoutParams.endToStart = ButtonLayoutResolver.getButtonLayout(choiceSize,i,ELayoutMode.END_TO_START,buttons, R.id.background_bottom)

            Log.d("MainActivity.setButtonFormat",
                "\n    Current Button Index: " + i
                        + "\n    top to top: " + layoutParams.topToTop.toString()
                        + "\n    top to bottom: " + layoutParams.topToBottom.toString()
                        + "\n    bottomToTop: " + layoutParams.bottomToTop.toString()
                        + "\n    bottom to bottom: " + layoutParams.bottomToBottom.toString()
                        + "\n    start to start: " + layoutParams.startToStart.toString()
                        + "\n    start to end: " + layoutParams.startToEnd.toString()
                        + "\n    end to end: " + layoutParams.endToEnd.toString()
                        + "\n    end to Start: " + layoutParams.endToStart.toString()
            )
            //@formatter:on
            buttons[i].layoutParams = layoutParams
        }
    }

    private fun setButtonVisibility(choiceSize: Int, buttons: List<Button>)
    {
        for (i in buttons.indices)
        {
            if (i < choiceSize)
            {
                buttons[i].visibility = View.VISIBLE
                Log.d("asdf", "Buttons i visible$i")
            }
            else
            {
                buttons[i].visibility = View.GONE
                Log.d("asdf", "Buttons, i invisible$i")
            }
        }
    }

    private fun setButtonTextContent(choices: List<Choice>, buttons: List<Button>, state: State)
    {
        for (i in choices.indices)
        {
            buttons[i].text = choices[i].text
            buttons[i].textSize = choices[i].textSize.toFloat()
        }
    }

    private fun setButtonBehavior(
        node: CinematicNode, buttons: List<Button>, state: State, cinematicTexts: List<TextView>
    )
    {
        for (i in node.choices.indices)
        {
            buttons[i].setOnClickListener() {
                Log.d(
                    "Button Click Event",
                    "Button " + i + " clicked, moving to node: " + node.choices[i].nextNodeIndex
                )
                node.choices[i].stateChange(state)
                fadeOut(buttons, cinematicTexts, node.choices[i].nextNodeIndex, state)
            }
        }
    }




    override fun onBackPressed()
    {
       if(false)
       {
            super.onBackPressed()
            //TODO: Dialog, "Would you like to exit?"
        }
        // Do nothing here
     }
}
    //@formatter: on
