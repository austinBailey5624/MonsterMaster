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
        val currentNode: CinematicNode = getCinematicNode(index, state)
        setCinematicTexts(currentNode.prompt, cinematicTexts)
        setButtons(currentNode.choices, buttons, state, cinematicTexts)
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
        choices: List<Choice>, buttons: List<Button>, state: State, cinematicTexts: List<TextView>
    )
    {
        Log.d("MainActivity.kt.setbuttons", "choicesCount: " + choices.size)
        setButtonFormat(choices.size, buttons)
        setButtonVisibility(choices.size, buttons)
        setButtonTextContent(choices, buttons, state)
        setButtonBehavior(choices, buttons, state, cinematicTexts)
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
        choices: List<Choice>, buttons: List<Button>, state: State, cinematicTexts: List<TextView>
    )
    {
        for (i in choices.indices)
        {
            buttons[i].setOnClickListener() {
                Log.d(
                    "Button Click Event",
                    "Button " + i + " clicked, moving to node: " + choices[i].nextNodeIndex
                )
                choices[i].stateChange(state)
                fadeOut(buttons, cinematicTexts, choices[i].nextNodeIndex, state)
            }
        }
    }


    //@formatter:off
    private fun getCinematicNode(index: Int, currentState: State): CinematicNode
    {
        //Choose Between light or dark
        if(index == 1)
        {
            val prompts = listOf(getString(R.string.scene1item1), getString(R.string.scene1item2),
                                 getString(R.string.scene1item3), getString(R.string.scene1item4),
                                 getString(R.string.scene1item5), getString(R.string.scene1item6),
                                 getString(R.string.scene1item7))
            val choices = listOf(Choice(getString(R.string.scene1choice1),2, {state -> state.addScore(Element.LUXOR)}, Element.LUXOR,24 ),
                                 Choice(getString(R.string.scene1choice2),3, {state -> state.addScore(Element.UMBRAL)}, Element.UMBRAL,24 ))
            return CinematicNode(index, prompts, choices, ECinematicImage.NONE, ContextCompat.getColor(this, R.color.darkGray), ContextCompat.getColor(this, R.color.gray))
        }
        //Chose Light, now choose Fire or Water
        if(index == 2)
        {
            val prompts = listOf(getString(R.string.scene2item1), getString(R.string.scene2item2),
                                 getString(R.string.scene2item3), getString(R.string.scene2item4),
                                 getString(R.string.scene2item5))
            val choices = listOf(Choice(getString(R.string.scene2choice1),4, {state -> state.addScore(Element.PYRO)}, Element.PYRO, 24 ),
                                 Choice(getString(R.string.scene2choice2),5, {state -> state.addScore(Element.AQUA)}, Element.AQUA, 24))
            return CinematicNode(index, prompts, choices, ECinematicImage.LIGHT_FROM_ABOVE, ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.whiteGray))
        }
        //Chose Darkness, now choose Fire or Water
        if(index == 3)
        {
            val prompts = listOf(getString(R.string.scene3item1), getString(R.string.scene3item2),
                                 getString(R.string.scene3item3), getString(R.string.scene3item4),
                                 getString(R.string.scene3item5), getString(R.string.scene3item6))
            val choices = listOf(Choice(getString(R.string.scene3choice1), 6, {state -> state.addScore(Element.PYRO)}, Element.PYRO, 22),
                                 Choice(getString(R.string.scene3choice2), 7, {state -> state.addScore(Element.AQUA)}, Element.AQUA, 22))
            return CinematicNode(index, prompts, choices, ECinematicImage.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.darkishGray))
        }
        // Chose Light and Fire, now choose Air or Earth
        if(index == 4)
        {
            val prompts = listOf(getString(R.string.scene4item1), getString(R.string.scene4item2),
                                 getString(R.string.scene4item3), getString(R.string.scene4item4),
                                 getString(R.string.scene4item5))
            val choices = listOf(Choice(getString(R.string.scene4choice1), 8, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                                 Choice(getString(R.string.scene4choice2), 8, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.FLAME, ContextCompat.getColor(this, R.color.brown), ContextCompat.getColor(this, R.color.darkBrown))
        }
        //Chose light and water, now choose Air or Earth
        if(index == 5)
        {
            val prompts = listOf(getString(R.string.scene5item1), getString(R.string.scene5item2),
                                 getString(R.string.scene5item3), getString(R.string.scene5item4),
                                 getString(R.string.scene5item5), getString(R.string.scene5item6))
            val choices = listOf(Choice(getString(R.string.scene5choice1), 9, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                                 Choice(getString(R.string.scene5choice2), 9, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.RIVER, ContextCompat.getColor(this, R.color.lightishBlue), ContextCompat.getColor(this, R.color.lighterBlue))
        }
        //Chose Darkness and Fire, now choose Air or Earth
        if(index == 6)
        {
            val prompts = listOf(getString(R.string.scene6item1), getString(R.string.scene6item2),
                                 getString(R.string.scene6item3), getString(R.string.scene6item4),
                                 getString(R.string.scene6item5))
            val choices = listOf(Choice(getString(R.string.scene6choice1), 10, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                                 Choice(getString(R.string.scene6choice2), 10, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.FLAME, ContextCompat.getColor(this, R.color.faintRed), ContextCompat.getColor(this, R.color.darkRed))
        }
        //Chose Darkness and Water, now choose Air or Earth
        if(index == 7)
        {
            val prompts = listOf(getString(R.string.scene7item1), getString(R.string.scene7item2),
                                 getString(R.string.scene7item3), getString(R.string.scene7item4),
                                 getString(R.string.scene7item5))
            val choices = listOf(Choice(getString(R.string.scene7choice1), 11, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                                 Choice(getString(R.string.scene7choice2), 11, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.RIVER, ContextCompat.getColor(this, R.color.faintBlue), ContextCompat.getColor(this, R.color.lightishBlue))
        }
        //Chose Light and Fire, with an option of either Earth or Air, in either case, commit to one of the three elements you've chosen
        if(index == 8)
        {
            val prompts = listOf(getString(R.string.scene8item1), getString(R.string.scene8item2),
                                 getString(R.string.scene8item3), getString(R.string.scene8item4),
                                 getString(R.string.scene8item5), getString(R.string.scene8item6))
            val choices: List<Choice>
            if(currentState.getScore(Element.AERO) > currentState.getScore(Element.TERRA))
            {
                choices = listOf(Choice(getString(R.string.scene8choice1),12,{state -> state.addScore(Element.LUXOR,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene8Activity"}, Element.LUXOR,20),
                                 Choice(getString(R.string.scene8choice2),12,{state -> state.addScore(Element.PYRO,2); state.starterMonster = "Flarial"; state.previousSceneName="Scene8Activity"}, Element.PYRO,20),
                                 Choice(getString(R.string.scene8choice3Alt),12,{state -> state.addScore(Element.AERO,2); state.starterMonster = "Flapper"; state.previousSceneName="Scene8Activity"}, Element.AERO,20))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene8choice1),12,{state -> state.addScore(Element.LUXOR,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene8Activity"}, Element.LUXOR,20),
                                 Choice(getString(R.string.scene8choice2),12,{state -> state.addScore(Element.PYRO,2); state.starterMonster = "Flarial"; state.previousSceneName="Scene8Activity"}, Element.PYRO,20),
                                 Choice(getString(R.string.scene8choice3),12,{state -> state.addScore(Element.TERRA,2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene8Activity"}, Element.TERRA,20))
            }
            return CinematicNode(index, prompts, choices, ECinematicImage.SUN, ContextCompat.getColor(this, R.color.darkBrown), ContextCompat.getColor(this, R.color.brown))
        }
        //Chose Light water and either air or earth, in either case, commit to one of the three elements you've chosen
        if(index == 9)
        {
            val prompts = listOf(getString(R.string.scene9item1), getString(R.string.scene9item2),
                                 getString(R.string.scene9item3), getString(R.string.scene9item4),
                                 getString(R.string.scene9item5))
            val choices: List<Choice>
            if(currentState.getScore(Element.AERO) > currentState.getScore(Element.TERRA))
            {
                choices = listOf(Choice(getString(R.string.scene9choice1),12,{state -> state.addScore(Element.LUXOR,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene9Activity"}, Element.LUXOR),
                                 Choice(getString(R.string.scene9choice2),12,{state -> state.addScore(Element.AQUA,2); state.starterMonster = "Minnow"; state.previousSceneName="Scene9Activity"}, Element.AQUA),
                                 Choice(getString(R.string.scene9choice3Alt),12,{state -> state.addScore(Element.AERO,2); state.starterMonster = "Flapper"; state.previousSceneName="Scene9Activity"}, Element.AERO))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene9choice1),12,{state -> state.addScore(Element.LUXOR,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene9Activity"}, Element.LUXOR),
                    Choice(getString(R.string.scene9choice2),12,{state -> state.addScore(Element.AQUA,2); state.starterMonster = "Minnow"; state.previousSceneName="Scene9Activity"}, Element.AQUA),
                    Choice(getString(R.string.scene9choice3),12,{state -> state.addScore(Element.TERRA,2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene9Activity"}, Element.TERRA))

            }
            return CinematicNode(index, prompts, choices, ECinematicImage.MAGIC_GLYPH, ContextCompat.getColor(this, R.color.lightishBlue), ContextCompat.getColor(this, R.color.lightCyanBlue))
        }
        //Chose darkness and fire, and either air or earth, in either case, commit to one of the three elements you've chosen
        if(index == 10)
        {
            val prompts: List<String>
            val choices: List<Choice>
            if(currentState.getScore(Element.AERO) > currentState.getScore(Element.TERRA))
            {
                prompts = listOf(getString(R.string.scene10item1), getString(R.string.scene10item2),
                                 getString(R.string.scene10item3), getString(R.string.scene10item4),
                                 getString(R.string.scene10item5), getString(R.string.scene10item6))
                choices = listOf(Choice(getString(R.string.scene10choice3),12,{state -> state.addScore(Element.PYRO, 2); state.starterMonster = "Flarial"; state.previousSceneName="Scene10Activity"}, Element.PYRO),
                                 Choice(getString(R.string.scene10choice4),12,{state -> state.addScore(Element.UMBRAL, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene10Activity"}, Element.UMBRAL),
                                 Choice(getString(R.string.scene10choice2), 12, {state -> state.addScore(Element.AERO, 2); state.starterMonster = "Flapper"; state.previousSceneName="Scene10Activity"}, Element.AERO))
            }
            else
            {
                prompts = listOf(getString(R.string.scene10item1), getString(R.string.scene10item2),
                    getString(R.string.scene10item3), getString(R.string.scene10item4Alt),
                    getString(R.string.scene10item5), getString(R.string.scene10item6))
                choices = listOf(Choice(getString(R.string.scene10choice2Alt), 12, {state -> state.addScore(Element.TERRA, 2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene10Activity"}, Element.TERRA),
                    Choice(getString(R.string.scene10choice3Alt),12,{state -> state.addScore(Element.PYRO, 2); state.starterMonster = "Flarial"; state.previousSceneName="Scene10Activity"}, Element.PYRO),
                    Choice(getString(R.string.scene10choice4),12,{state -> state.addScore(Element.UMBRAL, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene10Activity"}, Element.UMBRAL)
                )
            }
            return CinematicNode(index, prompts, choices, ECinematicImage.SUN, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.red))
        }
        //Choose Darkness and Water, and either air or earth, in either case, commit to one of the three elements you've chosen
        if(index == 11)
        {
            val prompts = listOf(getString(R.string.scene11item1), getString(R.string.scene11item2),
                                 getString(R.string.scene11item3), getString(R.string.scene11item4),
                                 getString(R.string.scene11item5), getString(R.string.scene11item6))
            val choices: List<Choice>
            if(currentState.getScore(Element.AERO) > currentState.getScore(Element.TERRA))
            {
                 choices = listOf(Choice(getString(R.string.scene11choice4), 12, {state -> state.addScore(Element.UMBRAL, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene11Activity"}, Element.UMBRAL),
                    Choice(getString(R.string.scene11choice1), 12, {state -> state.addScore(Element.AQUA, 2); state.starterMonster = "Minnow"; state.previousSceneName="Scene11Activity"}, Element.AQUA),
                    Choice(getString(R.string.scene11choice3Alt), 12, {state -> state.addScore(Element.AERO, 2); state.starterMonster = "Flapper"; state.previousSceneName="Scene11Activity"}, Element.AERO))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene11choice4), 12, {state -> state.addScore(Element.UMBRAL, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene11Activity"}, Element.UMBRAL),
                    Choice(getString(R.string.scene11choice1), 12, {state -> state.addScore(Element.AQUA, 2); state.starterMonster = "Minnow"; state.previousSceneName="Scene11Activity"}, Element.AQUA),
                    Choice(getString(R.string.scene11choice3), 12, {state -> state.addScore(Element.TERRA, 2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene11Activity"}, Element.TERRA))
           }
            return CinematicNode(index, prompts, choices, ECinematicImage.MOON, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.lightishBlue))
        }
        if(index == 12)
        {
//                            val intent = Intent(this, Scene12Activity::class.java)
//                            intent.putExtra("state", currentState)
//                            startActivity(intent)
            //note: We've already started the next activity, this is to fix a bug where we click to fast
            return CinematicNode(index, listOf(), listOf(), ECinematicImage.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.black))
        }
        throw IllegalStateException("Scene1Node index not found, max 12 actual: $index");
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
