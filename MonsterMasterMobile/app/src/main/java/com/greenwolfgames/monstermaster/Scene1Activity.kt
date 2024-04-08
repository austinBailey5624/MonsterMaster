package com.greenwolfgames.monstermaster

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class Scene1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene1_initial)
        var state = State()

        setNode(1, state)
    }

    fun setNode(node: Int, currentState: State) {
        val scene1Node = getScene1Node(node, currentState)

        var buttons: List<Button> = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
        )

        val buttons2x2: List<Button> = listOf(
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
            findViewById(R.id.button10)
        )

        for (button in buttons2x2) {
            button.visibility = View.GONE
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

        for (i in textViews.indices) {
            textViews[i].setTextColor(ContextCompat.getColor(this, R.color.invisible))
            if (i < scene1Node.prompt.size) {
                Log.d(
                    "Scene1Activity.kt.setNode",
                    "Setting visible text to box $i" + scene1Node.prompt[i]
                )
                textViews[i].text = scene1Node.prompt[i]
                textViews[i].visibility = View.VISIBLE
            } else {
                Log.d("Scene1Activity.kt.setNode", "hiding text box $i")
                textViews[i].visibility = View.GONE
            }
        }
        for (i in textViews.indices) {
            if (i < scene1Node.prompt.size) {
                val params = textViews[i].layoutParams as ConstraintLayout.LayoutParams
                if (i == 0) {
                    params.topToTop = R.id.Parent
                } else {
                    params.topToBottom = textViews[i - 1].id
                }
                if (i == scene1Node.prompt.size - 1) {
                    if (scene1Node.choices.size == 4) {
                        params.bottomToTop = buttons2x2[0].id
                    } else {
                        params.bottomToTop = buttons[0].id
                    }
                } else {
                    params.bottomToTop = textViews[i + 1].id
                }
                textViews[i].layoutParams = params
            }
        }

        if (scene1Node.choices.size == 4) {
            val layoutParams = buttons2x2[0].layoutParams as ConstraintLayout.LayoutParams
            layoutParams.topToBottom = textViews[scene1Node.prompt.size - 1].id
            buttons2x2[0].layoutParams = layoutParams
            val layoutParams2 = buttons2x2[2].layoutParams as ConstraintLayout.LayoutParams
            layoutParams.topToBottom = textViews[scene1Node.prompt.size - 1].id
            buttons2x2[2].layoutParams = layoutParams2
        } else {
            Utilities.orgainizeButtons(
                buttons,
                scene1Node.choices.size,
                textViews[scene1Node.prompt.size - 1],
                this@Scene1Activity,
                windowManager
            )
        }


        val fadeOutFastAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out_fast)
        val fadeOutFastAnimationTrigger = AnimationUtils.loadAnimation(this, R.anim.fade_out_fast)
        if (scene1Node.choices.size == 4) {
            for (button in buttons) {
                button.visibility = View.GONE
            }
            for (button in buttons2x2) {
                button.visibility = View.VISIBLE
            }
            for (i in buttons2x2.indices) {
                if (i < scene1Node.choices.size) {
                    Log.d(
                        "Scene1Activity.kt.setNode",
                        "Setting visible button to box $i" + scene1Node.choices[i].text
                    )
                    val choice = scene1Node.choices[i]
                    buttons2x2[i].text = choice.text
                    Utilities.hideButton(buttons2x2[i], this@Scene1Activity)
                    buttons2x2[i].setOnClickListener {
                        choice.stateChange(currentState)
                        fadeOutFastAnimationTrigger.setAnimationListener(object :
                            Animation.AnimationListener {
                            override fun onAnimationStart(animation: Animation) {}
                            override fun onAnimationEnd(animation: Animation) {
                                setNode(choice.nextNodeIndex, currentState)
                            }

                            override fun onAnimationRepeat(animation: Animation?) {}
                        })
                        for (j in buttons2x2.indices) {
                            if (buttons2x2[j].visibility != View.GONE && j != 0) {
                                buttons2x2[j].startAnimation(fadeOutFastAnimation)
                            }
                        }
                        for (j in textViews.indices) {
                            if (textViews[j].visibility != View.GONE) {
                                textViews[j].startAnimation(fadeOutFastAnimation)
                            }
                        }
                        buttons2x2[0].startAnimation(fadeOutFastAnimationTrigger)
                    }
                    buttons2x2[i].visibility = View.VISIBLE
                } else {
                    Utilities.hideButton(buttons2x2[i], this@Scene1Activity)
                    Log.d("Scene1Activity.kt.setNode", "Hiding button index $i")
                    buttons2x2[i].visibility = View.GONE
                }
            }
        } else {

            for (i in buttons.indices) {
                if (i < scene1Node.choices.size) {
                    Log.d(
                        "Scene1Activity.kt.setNode",
                        "Setting visible button to box $i" + scene1Node.choices[i].text
                    )
                    val choice = scene1Node.choices[i]
                    buttons[i].text = choice.text
                    Utilities.hideButton(buttons[i], this@Scene1Activity)
                    buttons[i].setOnClickListener {
                        choice.stateChange(currentState)
                        fadeOutFastAnimationTrigger.setAnimationListener(object :
                            Animation.AnimationListener {
                            override fun onAnimationStart(animation: Animation) {}
                            override fun onAnimationEnd(animation: Animation) {
                                setNode(choice.nextNodeIndex, currentState)
                            }

                            override fun onAnimationRepeat(animation: Animation?) {}
                        })
                        for (j in buttons.indices) {
                            if (buttons[j].visibility != View.GONE && j != 0) {
                                buttons[j].startAnimation(fadeOutFastAnimation)
                            }
                        }
                        for (j in textViews.indices) {
                            if (textViews[j].visibility != View.GONE) {
                                textViews[j].startAnimation(fadeOutFastAnimation)
                            }
                        }
                        buttons[0].startAnimation(fadeOutFastAnimationTrigger)
                    }
                    buttons[i].visibility = View.VISIBLE
                } else {
                    Utilities.hideButton(buttons[i], this@Scene1Activity)
                    Log.d("Scene1Activity.kt.setNode", "Hiding button index $i")
                    buttons[i].visibility = View.GONE
                }
            }
        }


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

        fadeInAnimations[scene1Node.prompt.size].setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                if (scene1Node.choices.size == 4) {
                    for (i in buttons2x2.indices) {
                        if (buttons2x2[i].visibility != View.GONE) {
                            buttons2x2[i].startAnimation(fadeInAnimations[scene1Node.prompt.size + 1])
                            Subelement.colorButton(
                                buttons2x2[i],
                                this@Scene1Activity,
                                scene1Node.choices[i].element
                            )
                        }
                    }
                } else {
                    for (i in buttons.indices) {
                        if (buttons[i].visibility != View.GONE) {
                            buttons[i].startAnimation(fadeInAnimations[scene1Node.prompt.size + 1])
                            Subelement.colorButton(
                                buttons[i],
                                this@Scene1Activity,
                                scene1Node.choices[i].element
                            )
                        }
                    }
                }
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        for (i in scene1Node.prompt.indices) {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    textViews[i].startAnimation(fadeInAnimations[i + 1])
                    textViews[i].setTextColor(scene1Node.textColor)
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }

        val image = findViewById<ImageView>(R.id.scene1ImageView)
        image.visibility = View.VISIBLE
        if (scene1Node.Image == Scene1Image.NONE) {
            image.visibility = View.INVISIBLE
        }
        if (scene1Node.Image == Scene1Image.LIGHT_FROM_ABOVE) {
            image.setImageResource(R.drawable.faint_light_from_above)
        }
        if (scene1Node.Image == Scene1Image.RIVER) {
            image.setImageResource(R.drawable.river)
        }
        if (scene1Node.Image == Scene1Image.FLAME) {
            image.setImageResource(R.drawable.flame_bottom_left)
        }
        if (scene1Node.Image == Scene1Image.SUN) {
            image.setImageResource(R.drawable.sunshine_upper_left)
        }
        if (scene1Node.Image == Scene1Image.MOON) {
            image.setImageResource(R.drawable.moonshine_upper_left)
        }
        if (scene1Node.Image == Scene1Image.MAGIC_GLYPH) {
            image.setImageResource(R.drawable.magic_glyph)
            val partialFadeInAnimation: Animation =
                AnimationUtils.loadAnimation(this, R.anim.partial_fade_in)
            val partialFadeOutAnimation: Animation =
                AnimationUtils.loadAnimation(this, R.anim.partial_fade_out)

            partialFadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    image.startAnimation(partialFadeOutAnimation)
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })

            partialFadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    image.startAnimation(partialFadeInAnimation)
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
            image.startAnimation(partialFadeInAnimation)
        } else if (scene1Node.Image != Scene1Image.NONE) {
            val slowFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_slow)
            image.startAnimation(slowFadeInAnimation)
        }
        textViews[0].startAnimation(fadeInAnimations[0])
        val parent = findViewById<View>(R.id.Parent)
        parent.setBackgroundColor(scene1Node.backgroundColor)
    }


    private fun getScene1Node(index: Int, currentState: State): Scene1Node {
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
        if(index == 8)
        {
            val prompts = listOf(getString(R.string.scene8item1), getString(R.string.scene8item2),
                                 getString(R.string.scene8item3), getString(R.string.scene8item4),
                                 getString(R.string.scene8item5), getString(R.string.scene8item6))
            val choices: List<Choice>
            if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
            {
                choices = listOf(Choice(getString(R.string.scene8choice1),12,{state -> state.addScore(Element.LIGHT,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene8Activity"}, Element.LIGHT),
                                 Choice(getString(R.string.scene8choice2),12,{state -> state.addScore(Element.FIRE,2); state.starterMonster = "Flarial"; state.previousSceneName="Scene8Activity"}, Element.FIRE),
                                 Choice(getString(R.string.scene8choice3Alt),12,{state -> state.addScore(Element.AIR,2); state.starterMonster = "Flapper"; state.previousSceneName="Scene8Activity"}, Element.AIR),
                                 Choice(getString(R.string.scene8choice4),12,{state -> state.addScore(Element.LIGHT,1); state.addScore(Element.FIRE,1); state.starterMonster = "Tona"; state.previousSceneName="Scene8Activity"}, Subelement.SOLAR))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene8choice1),12,{state -> state.addScore(Element.LIGHT,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene8Activity"}, Element.LIGHT),
                                 Choice(getString(R.string.scene8choice2),12,{state -> state.addScore(Element.FIRE,2); state.starterMonster = "Flarial"; state.previousSceneName="Scene8Activity"}, Element.FIRE),
                                 Choice(getString(R.string.scene8choice3),12,{state -> state.addScore(Element.EARTH,2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene8Activity"}, Element.EARTH),
                                 Choice(getString(R.string.scene8choice4),12,{state -> state.addScore(Element.LIGHT,1); state.addScore(Element.FIRE,1); state.starterMonster = "Tona"; state.previousSceneName="Scene8Activity"}, Subelement.SOLAR))
            }
            return Scene1Node(index, prompts, choices, Scene1Image.SUN, ContextCompat.getColor(this, R.color.darkBrown), ContextCompat.getColor(this, R.color.brown))
        }
        if(index == 9)
        {
            val prompts = listOf(getString(R.string.scene9item1), getString(R.string.scene9item2),
                                 getString(R.string.scene9item3), getString(R.string.scene9item4),
                                 getString(R.string.scene9item5))
            val choices: List<Choice>
            if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
            {
                choices = listOf(Choice(getString(R.string.scene9choice1),12,{state -> state.addScore(Element.LIGHT,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene9Activity"}, Element.LIGHT),
                                 Choice(getString(R.string.scene9choice2),12,{state -> state.addScore(Element.WATER,2); state.starterMonster = "Minnow"; state.previousSceneName="Scene9Activity"}, Element.WATER),
                                 Choice(getString(R.string.scene9choice3Alt),12,{state -> state.addScore(Element.AIR,2); state.starterMonster = "Flapper"; state.previousSceneName="Scene9Activity"}, Element.AIR),
                                 Choice(getString(R.string.scene9choice4),12,{state -> state.addScore(Element.LIGHT,1); state.addScore(Element.WATER,1); state.starterMonster = "Lona"; state.previousSceneName="Scene9Activity"}, Subelement.LUNAR))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene9choice1),12,{state -> state.addScore(Element.LIGHT,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene9Activity"}, Element.LIGHT),
                    Choice(getString(R.string.scene9choice2),12,{state -> state.addScore(Element.WATER,2); state.starterMonster = "Minnow"; state.previousSceneName="Scene9Activity"}, Element.WATER),
                    Choice(getString(R.string.scene9choice3),12,{state -> state.addScore(Element.EARTH,2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene9Activity"}, Element.EARTH),
                    Choice(getString(R.string.scene9choice4),12,{state -> state.addScore(Element.LIGHT,1); state.addScore(Element.WATER,1); state.starterMonster = "Lona"; state.previousSceneName="Scene9Activity"}, Subelement.LUNAR))

            }
            return Scene1Node(index, prompts, choices, Scene1Image.MOON, ContextCompat.getColor(this, R.color.lightishBlue), ContextCompat.getColor(this, R.color.lightCyanBlue))
        }
        if(index == 10)
        {
            val prompts: List<String>
            val choices: List<Choice>
            if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
            {
                prompts = listOf(getString(R.string.scene10item1), getString(R.string.scene10item2),
                                 getString(R.string.scene10item3), getString(R.string.scene10item4),
                                 getString(R.string.scene10item5), getString(R.string.scene10item6))
                choices = listOf(Choice(getString(R.string.scene10choice1),12,{state -> state.addScore(Element.FIRE);state.addScore(Element.DARK); state.starterMonster = "Spiten"; state.previousSceneName="Scene10Activity"}, Subelement.VENGEANCE),
                                 Choice(getString(R.string.scene10choice2), 12, {state -> state.addScore(Element.AIR, 2); state.starterMonster = "Flapper"; state.previousSceneName="Scene10Activity"}, Element.AIR),
                                 Choice(getString(R.string.scene10choice3),12,{state -> state.addScore(Element.FIRE, 2); state.starterMonster = "Flarial"; state.previousSceneName="Scene10Activity"}, Element.FIRE),
                                 Choice(getString(R.string.scene10choice4),12,{state -> state.addScore(Element.DARK, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene10Activity"}, Subelement.UMBRAL)
                    )
            }
            else
            {
                prompts = listOf(getString(R.string.scene10item1), getString(R.string.scene10item2),
                    getString(R.string.scene10item3), getString(R.string.scene10item4Alt),
                    getString(R.string.scene10item5), getString(R.string.scene10item6))
                choices = listOf(Choice(getString(R.string.scene10choice1),12,{state -> state.addScore(Element.FIRE);state.addScore(Element.DARK); state.starterMonster = "Spiten"; state.previousSceneName="Scene10Activity"}, Subelement.VENGEANCE),
                    Choice(getString(R.string.scene10choice2Alt), 12, {state -> state.addScore(Element.EARTH, 2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene10Activity"}, Element.EARTH),
                    Choice(getString(R.string.scene10choice3Alt),12,{state -> state.addScore(Element.FIRE, 2); state.starterMonster = "Flarial"; state.previousSceneName="Scene10Activity"}, Element.FIRE),
                    Choice(getString(R.string.scene10choice4),12,{state -> state.addScore(Element.DARK, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene10Activity"}, Subelement.UMBRAL)
                )
            }
            return Scene1Node(index, prompts, choices, Scene1Image.SUN, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.red))
        }
        if(index == 11)
        {
            val prompts = listOf(getString(R.string.scene11item1), getString(R.string.scene11item2),
                                 getString(R.string.scene11item3), getString(R.string.scene11item4),
                                 getString(R.string.scene11item5), getString(R.string.scene11item6))
            val choices: List<Choice>
            if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
            {
                 choices = listOf(Choice(getString(R.string.scene11choice1), 12, {state -> state.addScore(Element.WATER, 2); state.starterMonster = "Minnow"; state.previousSceneName="Scene11Activity"}, Element.WATER),
                    Choice(getString(R.string.scene11choice2), 12, {state -> state.addScore(Element.WATER);state.addScore(Element.DARK); state.starterMonster = "Deepfish"; state.previousSceneName="Scene11Activity"}, Subelement.DEEP),
                    Choice(getString(R.string.scene11choice3Alt), 12, {state -> state.addScore(Element.AIR, 2); state.starterMonster = "Flapper"; state.previousSceneName="Scene11Activity"}, Element.AIR),
                    Choice(getString(R.string.scene11choice4), 12, {state -> state.addScore(Element.DARK, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene11Activity"}, Element.DARK))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene11choice1), 12, {state -> state.addScore(Element.WATER, 2); state.starterMonster = "Minnow"; state.previousSceneName="Scene11Activity"}, Element.WATER),
                    Choice(getString(R.string.scene11choice2), 12, {state -> state.addScore(Element.WATER);state.addScore(Element.DARK); state.starterMonster = "Deepfish"; state.previousSceneName="Scene11Activity"}, Subelement.DEEP),
                    Choice(getString(R.string.scene11choice3), 12, {state -> state.addScore(Element.EARTH, 2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene11Activity"}, Element.EARTH),
                    Choice(getString(R.string.scene11choice4), 12, {state -> state.addScore(Element.DARK, 2); state.starterMonster = "Umbress"; state.previousSceneName="Scene11Activity"}, Element.DARK))
           }
            return Scene1Node(index, prompts, choices, Scene1Image.MOON, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.lightishBlue))
        }
        if(index == 12)
        {
            val intent = Intent(this, Scene12Activity::class.java)
            intent.putExtra("state", currentState)
            startActivity(intent)
        }
        throw IllegalStateException("Scene1Node index not found, max 12 actual: $index");
        //@formatter:on
    }
    override fun onBackPressed() {
        if(false) {
            super.onBackPressed()
        }
        // Do nothing here
    }
}