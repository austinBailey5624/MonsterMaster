package com.greenwolfgames.monstermaster

import android.animation.AnimatorListenerAdapter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

/**
 * Class to manage the elements of the activity_main.xml layout
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright: Austin Bailey 2024 All Rights Reserved
 */
class MainActivity : AppCompatActivity()
{
    private var previousColor: Int = R.color.darkGray
    private var previousNodeAnimations: List<AnimationInfo> = listOf()
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
        val images: List<ImageView> = listOf(
            findViewById(R.id.image_1),
            findViewById(R.id.image_2),
            findViewById(R.id.image_3),
            findViewById(R.id.image_4)
        )
        val textInput: TextInputEditText = findViewById(R.id.text_input)


        setTextAutoResizing(texts)
        setButtonAutoResizing(buttons)
        hideText(texts)
        hideImages(images)
        initButtons(buttons)
        val firstNode: Node = NodeRetriever.getNode(1, state, this@MainActivity, state)
        previousColor = firstNode.backgroundColor
        setNode(firstNode, state, buttons, texts, images, textInput)
    }

    private fun setTextAutoResizing(texts: List<TextView>)
    {
        for(text in texts)
        {
            text.setAutoSizeTextTypeUniformWithConfiguration(
                12,  // Minimum text size in sp
                33, // Maximum text size in sp
                2,   // Step granularity in sp
                TypedValue.COMPLEX_UNIT_SP
            )
        }
    }

    private fun setButtonAutoResizing(buttons: List<Button>)
    {
        for(button in buttons)
        {
            button.setAutoSizeTextTypeUniformWithConfiguration(
                12,
                60,
                2,
                TypedValue.COMPLEX_UNIT_SP
            )
        }
    }

    private fun hideText(texts: List<TextView>)
    {
        for (text in texts)
        {
            text.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }
    }

    private fun hideImages(images: List<ImageView>)
    {
        for(imageView in images)
        {
            imageView.visibility = View.GONE
        }
    }

    private fun initButtons(buttons: List<Button>)
    {
        val skipButton: Button = findViewById(R.id.button_skip)
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
        buttons: List<Button>,
        texts: List<TextView>,
        images: List<ImageView>,
        nextNodeIndex: Int,
        state: State,
        textInput: TextInputEditText
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
                setNode(nextNode, state, buttons, texts, images, textInput)
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
                hideText(texts) //TODO hideImages(images)
                fadeInAnimation.start()
            }

            override fun onAnimationRepeat(animation: Animation)
            {
            }
        })

        val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        for(button in buttons)
        {
            button.startAnimation(fadeOutAnimation)
        }
        for (text in texts)
        {
            text.startAnimation(fadeOutAnimation)
        }
        for(image in images)
        {
            var shouldRemove = true
            for(animationInfo in nextNode.animationInfos)
            {
                if(animationInfo.imageId == image.tag)
                {
                    shouldRemove = false
                }
            }
            if (shouldRemove)
            {
                image.visibility = View.GONE
            }
        }
        buttons[0].startAnimation(fadeOutAnimationTrigger)
        fadeOutAnimation.start()
    }

    private fun setNode(
        nextNode: Node,
        state: State,
        buttons: List<Button>,
        texts: List<TextView>,
        images: List<ImageView>,
        textInput: TextInputEditText
    )
    {
        Log.d("MainActivity.Set Node", "Setting node index: " + nextNode.index)

        setText(nextNode.prompt, texts)
        setButtons(nextNode, buttons, state, texts, images, textInput)
        setTextInput(nextNode, textInput)
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

        //if we need to update our animations
        for( i in nextNode.animationInfos.indices)
        {
            setUpAnimation(images[i], nextNode.animationInfos[i])
        }
        //hide all the images we aren't using
        for(i in nextNode.animationInfos.size..<images.size)
        {
            images[i].visibility = View.GONE
        }
        previousNodeAnimations = nextNode.animationInfos
    }

    private fun setUpAnimation(image: ImageView, animationInfo: AnimationInfo)
    { //@formatter:off
        //If the image is already animated and present
        if(image.tag == animationInfo.animationId)
        {
            return;//do nothing
        }

        image.setImageResource(animationInfo.imageId)
        image.tag = animationInfo.imageId

        image.layoutParams = animationInfo.layoutParam
        image.visibility = View.VISIBLE
        image.scaleType = animationInfo.imageScaleType

        //@formatter:on
        image.startAnimation(AnimationUtils.loadAnimation(this@MainActivity, animationInfo.animationId))
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
        Log.d(
            "MainActivity Text Layout",
            "\n  parentID:" + R.id.background_top + "\n" + "  text 1 ID: " + R.id.text_1 + "\n" + "  text 2 ID: " + R.id.text_2 + "\n" + "  text 3 ID: " + R.id.text_3 + "\n" + "  text 4 ID: " + R.id.text_4 + "\n" + "  text 5 ID: " + R.id.text_5 + "\n" + "  text 6 ID: " + R.id.text_6 + "\n" + "  text 7 ID: " + R.id.text_7 + "\n"
        )
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
            Log.d(
                "MainActivity Text Layout",
                "  text $i startToStart   : " + layoutParams.startToStart + "\n" + "  text $i startToEnd    : " + layoutParams.startToEnd + "\n" + "  text $i endToEnd      : " + layoutParams.endToEnd + "\n" + "  text $i endToStart    : " + layoutParams.endToStart + "\n" + "  text $i topToTop      : " + layoutParams.topToTop + "\n" + "  text $i topToBottom   : " + layoutParams.topToBottom + "\n" + "  text $i bottomToTop   : " + layoutParams.bottomToTop + "\n" + "  text $i bottomToBottom: " + layoutParams.bottomToBottom
            )

            texts[i].layoutParams = layoutParams

            texts[i].visibility = getTextVisibility(i, prompt.size)
        }
    }

    //index refers to the index of the texts that is being referenced
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
            Log.d("MainActivity Text Visibility", "text index: $index is invisible(Gone)")
            return View.GONE
        }
        Log.d("MainActivity Text Visibility", "text index: $index is visible")
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

    private fun setTextInput(nextNode: Node, textInput: TextInputEditText)
    {
        if (nextNode.index in 18..53)
        {
            textInput.visibility = View.VISIBLE
        }
        else
        {
            textInput.visibility = View.GONE
        }
    }

    private fun setButtons(
        node: Node,
        buttons: List<Button>,
        state: State,
        texts: List<TextView>,
        images: List<ImageView>,
        textInput: TextInputEditText
    )
    {
        Log.d("MainActivity.kt.setbuttons", "choicesCount: " + node.choices.size)

        if (nodeRequiresTextInput(node))
        {
            setButtonFormatWithInput(buttons[0], textInput)
        }
        else
        {
            setButtonFormat(node.choices.size, buttons, textInput)
        }
        setButtonVisibility(node.choices.size, buttons)
        setButtonTextContent(node.choices, buttons)
        setButtonBehavior(node, buttons, state, texts, images, textInput)
    }

    private fun nodeRequiresTextInput(node: Node): Boolean
    {
        return node.index in 18..53
    }

    private fun setButtonFormatWithInput(button: Button, textInput: TextInputEditText)
    { //Assume a single button, the input will be above it
        val inputLayout = textInput.layoutParams as ConstraintLayout.LayoutParams

        inputLayout.topToTop = R.id.background_bottom
        inputLayout.topToBottom = ConstraintLayout.LayoutParams.UNSET
        inputLayout.bottomToTop = button.id
        inputLayout.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
        inputLayout.startToStart = R.id.background_bottom
        inputLayout.startToEnd = ConstraintLayout.LayoutParams.UNSET
        inputLayout.endToStart = ConstraintLayout.LayoutParams.UNSET
        inputLayout.endToEnd = R.id.background_bottom

        textInput.layoutParams = inputLayout

        val buttonLayout = button.layoutParams as ConstraintLayout.LayoutParams

        buttonLayout.topToTop = ConstraintLayout.LayoutParams.UNSET
        buttonLayout.topToBottom = textInput.id
        buttonLayout.bottomToTop = ConstraintLayout.LayoutParams.UNSET
        buttonLayout.bottomToBottom = R.id.background_bottom
        buttonLayout.startToStart = R.id.background_bottom
        buttonLayout.startToEnd = ConstraintLayout.LayoutParams.UNSET
        buttonLayout.endToStart = ConstraintLayout.LayoutParams.UNSET
        buttonLayout.endToEnd = R.id.background_bottom

        button.layoutParams = buttonLayout

        textInput.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
    }

    private fun setButtonFormat(
        choiceSize: Int,
        buttons: List<Button>,
        textInput: TextInputEditText
    )
    {
        textInput.visibility = View.GONE //@formatter:off
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
            if(choiceSize == 3 && i == 2 || choiceSize == 5 && i == 4)
            {
                layoutParams.matchConstraintDefaultWidth =
                    ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                layoutParams.matchConstraintPercentWidth = 0.5f
            }
            else
            {
                layoutParams.matchConstraintDefaultWidth =
                    ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                layoutParams.matchConstraintPercentWidth = 0f
            }

            Log.d("MainActivity.setButtonFormat",
                "\n    Current Button Index: " + i
                        + "\n    top to top:      " + layoutParams.topToTop.toString()
                        + "\n    top to bottom   : " + layoutParams.topToBottom.toString()
                        + "\n    bottomToTop     : " + layoutParams.bottomToTop.toString()
                        + "\n    bottom to bottom: " + layoutParams.bottomToBottom.toString()
                        + "\n    start to start  : " + layoutParams.startToStart.toString()
                        + "\n    start to end    : " + layoutParams.startToEnd.toString()
                        + "\n    end to end      : " + layoutParams.endToEnd.toString()
                        + "\n    end to Start    : " + layoutParams.endToStart.toString()
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
                Log.d("MainActivity button Visibility", "Button $i: visible")
            }
            else
            {
                buttons[i].visibility = View.GONE
                Log.d("MainActivity button Visibility", "Button $i: invisible(Gone)")
            }
        }
    }

    private fun setButtonTextContent(choices: List<Choice>, buttons: List<Button>)
    {
        for (i in choices.indices)
        {
            buttons[i].text = choices[i].text
        }
    }

    private fun setButtonBehavior(
        node: Node,
        buttons: List<Button>,
        state: State,
        texts: List<TextView>,
        images: List<ImageView>,
        textInput: TextInputEditText
    )
    { //if we are in a node where we need a special button behavior where we retrieve the player name
        if (nodeRequiresTextInput(node))
        {
            buttons[0].setOnClickListener() {
                var temp: String = textInput.text.toString()
                if (temp != "")
                {
                    Log.d("Name Input", "Player entered Name, unrinsed version: $temp")
                    if (temp.length > 12)
                    {
                        temp = temp.substring(0, 12)
                    }
                    temp.lowercase()
                    temp =
                        temp.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                    Log.d("Name Input", "Player enetered Name, rinsed version: $temp")
                    state.playerName = temp.trim()
                    node.choices[0].stateChange(state)
                    fadeOut(buttons, texts, images, node.choices[0].nextNodeIndex, state, textInput)
                }
                else
                { //TODO: Prompt the user to input their name
                }
            }
        }
        else
        {
            for (i in node.choices.indices)
            {
                buttons[i].setOnClickListener() {
                    Log.d(
                        "Button Click Event",
                        "Button " + i + " clicked, moving to node: " + node.choices[i].nextNodeIndex
                    )
                    node.choices[i].stateChange(state)
                    fadeOut(buttons, texts, images, node.choices[i].nextNodeIndex, state, textInput)
                }
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
