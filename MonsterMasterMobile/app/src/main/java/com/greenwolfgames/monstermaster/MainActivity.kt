package com.greenwolfgames.monstermaster

import android.animation.AnimatorListenerAdapter
import android.graphics.Color
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
    private var previousColor: Int = R.color.darkGray
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
        val texts: List<TextView> = listOf(
            findViewById(R.id.text_1),
            findViewById(R.id.text_2),
            findViewById(R.id.text_3),
            findViewById(R.id.text_4),
            findViewById(R.id.text_5),
            findViewById(R.id.text_6),
            findViewById(R.id.text_7)
        )

        hideText(texts)
        initButtons(buttons)
        val firstNode: Node = NodeRetriever.getNode(1, state, this@MainActivity, state)
        previousColor = firstNode.backgroundColor
        setNode(
            firstNode, state, buttons, texts
        )
    }

    private fun hideText(texts: List<TextView>)
    {
        for (text in texts)
        {
            text.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }
    }

    private fun initButtons(buttons: List<Button>)
    {
        var skipButton: Button = findViewById(R.id.button_skip)
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
        buttons: List<Button>, texts: List<TextView>, nextNodeIndex: Int, state: State
    )
    {
        val nextNode: Node = NodeRetriever.getNode(nextNodeIndex, state, this@MainActivity, state)
        val main: ConstraintLayout = findViewById(R.id.main)
        val fadeInAnimation =
            AnimationHandler.getBackgroundAnimator( //TODO: I know this is an error, but I don't know what to tell  you, when you fix it it doesn't run
                main, Color.valueOf(previousColor), Color.valueOf(nextNode.backgroundColor)
            )
        previousColor = nextNode.backgroundColor
        fadeInAnimation.addListener(object : AnimatorListenerAdapter()
        {
            override fun onAnimationEnd(animation: android.animation.Animator)
            {
                super.onAnimationEnd(animation)
                setNode(nextNode, state, buttons, texts)
            }
        })

        val fadeOutAnimationTrigger = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        fadeOutAnimationTrigger.setAnimationListener(object : Animation.AnimationListener
        {
            override fun onAnimationStart(animation: Animation)
            {
            }

            override fun onAnimationEnd(animation: Animation)
            {
                hideButtons(buttons)
                hideText(texts)
                //TODO hideImages(images)
                fadeInAnimation.start()
            }

            override fun onAnimationRepeat(animation: Animation)
            {
            }
        })

        val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        for (i in 1..<buttons.size)
        {
            buttons[i].startAnimation(fadeOutAnimation)
        }
        for (text in texts)
        {
            text.startAnimation(fadeOutAnimation)
        }
        buttons[0].startAnimation(fadeOutAnimationTrigger)
        fadeOutAnimation.start()
    }

    private fun setNode(
        nextNode: Node, state: State, buttons: List<Button>, texts: List<TextView>
    )
    {
        setText(nextNode.prompt, texts)
        setButtons(nextNode, buttons, state, texts)
        val main = findViewById<View>(R.id.main)
        main.setBackgroundColor(nextNode.backgroundColor)
        texts[0].startAnimation(
            AnimationHandler.getFadeInAnimations(
                buttons,
                texts,
                nextNode.textColor,
                nextNode,
                this@MainActivity,
                findViewById(R.id.button_skip)
            )[0]
        )
        val skipButton: Button = findViewById(R.id.button_skip)
        skipButton.visibility = View.VISIBLE
    }

    private fun setText(prompt: List<String>, texts: List<TextView>)
    {
        setTextLayout(prompt, texts)
        setTextContent(prompt, texts)
    }

    private fun setTextLayout(prompt: List<String>, texts: List<TextView>)
    {
        if (prompt.size == 1)
        { //set the one textView that we care about
            var layoutParam = texts[0].layoutParams as ConstraintLayout.LayoutParams

            layoutParam.startToStart = R.id.background_top
            layoutParam.endToEnd = R.id.background_top
            layoutParam.topToTop = R.id.background_top
            layoutParam.bottomToBottom = R.id.background_top
            layoutParam.startToEnd = ConstraintLayout.LayoutParams.UNSET
            layoutParam.endToStart = ConstraintLayout.LayoutParams.UNSET
            layoutParam.topToBottom = ConstraintLayout.LayoutParams.UNSET
            layoutParam.bottomToTop = ConstraintLayout.LayoutParams.UNSET
            texts[0].layoutParams = layoutParam
            texts[0].visibility = View.VISIBLE

            for (i in 1..<texts.size)
            {
                layoutParam = texts[i].layoutParams as ConstraintLayout.LayoutParams
                layoutParam.startToStart = ConstraintLayout.LayoutParams.UNSET
                layoutParam.endToEnd = ConstraintLayout.LayoutParams.UNSET
                layoutParam.topToTop = ConstraintLayout.LayoutParams.UNSET
                layoutParam.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
                layoutParam.startToEnd = ConstraintLayout.LayoutParams.UNSET
                layoutParam.endToStart = ConstraintLayout.LayoutParams.UNSET
                layoutParam.topToBottom = ConstraintLayout.LayoutParams.UNSET
                layoutParam.bottomToTop = ConstraintLayout.LayoutParams.UNSET
                texts[i].layoutParams = layoutParam
                texts[i].visibility = View.GONE
            }
            return
        }
        for (i in texts.indices)
        {
            val layoutParams = texts[i].layoutParams as ConstraintLayout.LayoutParams
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
                layoutParams.topToBottom = getTextLayout(EDirection.UP, texts, i, prompt.size)
            }
            layoutParams.bottomToTop = getTextLayout(EDirection.DOWN, texts, i, prompt.size)
            layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
            texts[i].layoutParams = layoutParams
            texts[i].visibility = getTextVisibility(i, prompt.size)
        }
    }

    //index refers to the index fo the texts that is being referenced
    private fun getTextLayout(
        direction: EDirection, texts: List<TextView>, index: Int, promptSize: Int
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
                texts[index - 1].id
            }
        } //now by process of elimination, we have to be in direction down (which is the trickiest)
        if (index in 0..3)
        {
            return texts[index + 1].id
        }
        if (index == promptSize - 1)
        {
            return R.id.background_bottom
        }
        if (index < promptSize - 1)
        {
            return texts[index + 1].id
        } // if index > promptsize - 1 visiblilty will be false, and we dont have to worry about it
        return 1;
    }

    private fun getTextVisibility(index: Int, promptSize: Int): Int
    {
        if (index >= promptSize)
        {
            return View.GONE
        }
        return View.VISIBLE
    }

    private fun setTextContent(
        prompt: List<String>, texts: List<TextView>
    )
    {
        for (i in prompt.indices)
        {
            texts[i].text = prompt[i]
        }
    }

    private fun setButtons(
        node: Node, buttons: List<Button>, state: State, texts: List<TextView>
    )
    {
        Log.d("MainActivity.kt.setbuttons", "choicesCount: " + node.choices.size)
        setButtonFormat(node.choices.size, buttons)
        setButtonVisibility(node.choices.size, buttons)
        setButtonTextContent(node.choices, buttons)
        setButtonBehavior(node, buttons, state, texts)
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
            val layoutParams = buttons[i].layoutParams as ConstraintLayout.LayoutParams
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

    private fun setButtonTextContent(choices: List<Choice>, buttons: List<Button>)
    {
        for (i in choices.indices)
        {
            buttons[i].text = choices[i].text
            buttons[i].textSize = choices[i].textSize.toFloat()
        }
    }

    private fun setButtonBehavior(
        node: Node, buttons: List<Button>, state: State, texts: List<TextView>
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
                fadeOut(buttons, texts, node.choices[i].nextNodeIndex, state)
            }
        }
    }

    override fun onBackPressed()
    {
        if (false)
        {
            super.onBackPressed() //TODO: Dialog, "Would you like to exit?"
        } // Do nothing here
    }
} //@formatter: on
