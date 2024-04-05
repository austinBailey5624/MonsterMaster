package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene1Activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene1_initial)
        var state = State()

        setNode(1, state)
    }

    fun setNode(node: Int, currentState: State) {
        val scene1Node = getScene1Node(node)

        val buttons: List<Button> = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
        )

        for(i in buttons.indices)
        {
            if(i < scene1Node.choices.size)
            {
                val choice = scene1Node.choices[i]
                buttons[i].text = choice.text
                Utilities.hideButton(buttons[i],this@Scene1Activity)
                buttons[i].setOnClickListener {
                    choice.stateChange(currentState)
                    setNode(choice.nextNodeIndex, currentState)
                }
                buttons[i].visibility = View.VISIBLE
            }
            else
            {
                Utilities.hideButton(buttons[i],this@Scene1Activity)
                buttons[i].visibility = View.GONE
            }
        }

        val textViews: List<TextView> = listOf(
            findViewById(R.id.scene1text1),
            findViewById(R.id.scene1text2),
            findViewById(R.id.scene1text3),
            findViewById(R.id.scene1text4),
            findViewById(R.id.scene1text5),
            findViewById(R.id.scene1text6),
            findViewById(R.id.scene1text7)
        )
        var lastTextView = textViews[0]
        for(i in 0 until scene1Node.prompt.size)
        {
            Log.d(i.toString(), "asdf$i")
            if(textViews[i] == null)
            {
                Log.d("textViews[$i]", "is null")
            }
            if(i < textViews.size) {
                textViews[i].text = scene1Node.prompt[i]
                textViews[i].setTextColor(scene1Node.textColor)
                lastTextView = textViews[i]
            }
        }
        for(textView in textViews)
        {
            textView.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }

        Utilities.orgainizeButtons(buttons, scene1Node.choices.size, lastTextView,this@Scene1Activity, windowManager)
        val fadeInAnimations: List<Animation> = listOf(
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[scene1Node.prompt.size].setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                for(i in buttons.indices)
                {
                    if(buttons[i].visibility != View.GONE)
                    {
                        buttons[i].startAnimation(fadeInAnimations[scene1Node.prompt.size + 1])
                        Element.colorButton(buttons[i],this@Scene1Activity,scene1Node.choices[i].element)
                    }
                }
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in scene1Node.prompt.indices)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i+1])
                    textViews[i].setTextColor(scene1Node.textColor)
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }


        Utilities.orgainizeButtons(buttons, scene1Node.choices.size, lastTextView,this@Scene1Activity, windowManager)
//        for (i in 0 until buttons.size) {
//            if (i < scene1Node.choices.size) {
//                val choice = scene1Node.choices[i]
//                buttons[i].text = choice.text
//                Element.colorButton(buttons[i], this@Scene1Activity, choice.element)
//                buttons[i].setOnClickListener {
//                    choice.stateChange(currentState)
//                    setNode(choice.nextNodeIndex, buttons, currentState)
//                }
//                buttons[i].visibility = View.VISIBLE
//            } else {
//                Utilities.hideButton(buttons[i], this@Scene1Activity)
//                buttons[i].visibility = View.GONE
//            }
//        }
        //TODO handle images

                textViews[0].startAnimation(fadeInAnimations[0])
        val parent = findViewById<View>(R.id.Parent)
        parent.setBackgroundColor(scene1Node.backgroundColor)
    }


    private fun getScene1Node(index: Int): Scene1Node {
        //@formatter:off
        if(index == 1)
        {
            val prompts = listOf(getString(R.string.scene1item1), getString(R.string.scene1item2),
                                 getString(R.string.scene1item3), getString(R.string.scene1item4),
                                 getString(R.string.scene1item5), getString(R.string.scene1item6),
                                 getString(R.string.scene1item7))
            val choices = listOf(Choice(getString(R.string.scene1choice1),2, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT ),
                                 Choice(getString(R.string.scene1choice2),3, {state -> state.addScore(Element.DARK)}, Element.DARK ))
            return Scene1Node(index, prompts, choices, Scene1Image.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.gray))
        }
        if(index == 2)
        {
            val prompts = listOf(getString(R.string.scene2item1), getString(R.string.scene2item2),
                                 getString(R.string.scene2item3), getString(R.string.scene2item4),
                                 getString(R.string.scene2item5))
            val choices = listOf(Choice(getString(R.string.scene2choice1),4, {state -> state.addScore(Element.FIRE)}, Element.FIRE ),
                                 Choice(getString(R.string.scene2choice2),5, {state -> state.addScore(Element.WATER)}, Element.WATER))
            return Scene1Node(index, prompts, choices, Scene1Image.LIGHT_FROM_ABOVE, ContextCompat.getColor(this, R.color.darkGray), ContextCompat.getColor(this, R.color.whiteGray))
        }
        if(index == 3)
        {
            val prompts = listOf(getString(R.string.scene3item1), getString(R.string.scene3item2),
                                 getString(R.string.scene3item3), getString(R.string.scene3item4),
                                 getString(R.string.scene3item5), getString(R.string.scene3item6))
            val choices = listOf(Choice(getString(R.string.scene3choice1), 6, {state -> state.addScore(Element.FIRE)}, Element.FIRE),
                                 Choice(getString(R.string.scene3choice2), 7, {state -> state.addScore(Element.WATER)}, Element.WATER))
            return Scene1Node(index, prompts, choices, Scene1Image.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.darkishGray))
        }
        if(index == 4)
        {
            val prompts = listOf(getString(R.string.scene4item1), getString(R.string.scene4item2),
                                 getString(R.string.scene4item3), getString(R.string.scene4item4),
                                 getString(R.string.scene4item5))
            val choices = listOf(Choice(getString(R.string.scene4choice1), 8, {state -> state.addScore(Element.EARTH)}, Element.EARTH),
                                 Choice(getString(R.string.scene4choice2), 8, {state -> state.addScore(Element.AIR)}, Element.AIR))
            return Scene1Node(index, prompts, choices, Scene1Image.FLAME, ContextCompat.getColor(this, R.color.faintRed), ContextCompat.getColor(this, R.color.redOrange))
        }
        if(index == 5)
        {
            val prompts = listOf(getString(R.string.scene5item1), getString(R.string.scene5item2),
                                 getString(R.string.scene5item3), getString(R.string.scene5item4),
                                 getString(R.string.scene5item5), getString(R.string.scene5item6))
            val choices = listOf(Choice(getString(R.string.scene5choice1), 9, {state -> state.addScore(Element.EARTH)}, Element.EARTH),
                                 Choice(getString(R.string.scene5choice2), 9, {state -> state.addScore(Element.AIR)}, Element.AIR))
            return Scene1Node(index, prompts, choices, Scene1Image.RIVER, ContextCompat.getColor(this, R.color.faintBlue), ContextCompat.getColor(this, R.color.cyan))
        }
        if(index == 6)
        {
            val prompts = listOf(getString(R.string.scene6item1), getString(R.string.scene6item2),
                                 getString(R.string.scene6item3), getString(R.string.scene6item4),
                                 getString(R.string.scene6item5))
            val choices = listOf(Choice(getString(R.string.scene6choice1), 10, {state -> state.addScore(Element.EARTH)}, Element.EARTH),
                                 Choice(getString(R.string.scene6choice2), 10, {state -> state.addScore(Element.AIR)}, Element.AIR))
            return Scene1Node(index, prompts, choices, Scene1Image.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.darkRed))
        }
        if(index == 7)
        {
            val prompts = listOf(getString(R.string.scene7item1), getString(R.string.scene7item2),
                                 getString(R.string.scene7item3), getString(R.string.scene7item4),
                                 getString(R.string.scene7item5))
            val choices = listOf(Choice(getString(R.string.scene7choice1), 11, {state -> state.addScore(Element.EARTH)}, Element.EARTH),
                                 Choice(getString(R.string.scene7choice2), 11, {state -> state.addScore(Element.AIR)}, Element.AIR))
            return Scene1Node(index, prompts, choices, Scene1Image.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.lightishBlue))
        }
        throw IllegalStateException("Scene1Node index not found, max 12 actual: $index");
        //@formatter:on
    }
}