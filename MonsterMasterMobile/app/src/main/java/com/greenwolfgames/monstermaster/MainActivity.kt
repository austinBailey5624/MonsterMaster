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
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this) {}.isEnabled = false
        var state = State()

        var buttons: List<Button> = listOf(
            findViewById(R.id.button_1),
            findViewById(R.id.button_2),
            findViewById(R.id.button_3),
            findViewById(R.id.button_4),
            findViewById(R.id.button_5),
            findViewById(R.id.button_6)
        )
        var cinematicTexts: List<TextView> = listOf(
            findViewById(R.id.cinematic_text_1),
            findViewById(R.id.cinematic_text_2),
            findViewById(R.id.cinematic_text_3),
            findViewById(R.id.cinematic_text_4),
            findViewById(R.id.cinematic_text_5),
            findViewById(R.id.cinematic_text_6),
            findViewById(R.id.cinematic_text_7)
        )
        hideCinematicText(cinematicTexts)
        hideButtons(buttons)

        cinematicTexts[0].startAnimation(getFadeInAnimations(buttons, cinematicTexts)[0])

    }
    //    override fun onBackPressed() {
    //        if(false) {
    //            super.onBackPressed()
    //        }
    //        // Do nothing here


    private fun hideCinematicText(cinematicTexts: List<TextView>)
    {
        for (text in cinematicTexts)
        {
            text.setTextColor(ContextCompat.getColor(this, R.color.invisible))
        }
    }

    private fun hideButtons(buttons: List<Button>)
    {
        for (button in buttons)
        {
            button.setTextColor(ContextCompat.getColor(this, R.color.invisible))
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.invisible))
        }
    }

    private fun getFadeInAnimations(buttons: List<Button>, cinematicTexts: List<TextView>): List<Animation>
    {
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

        //@formatter:off
        fadeInAnimations[7].setAnimationListener(object : Animation.AnimationListener
        {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation)
            {
                buttons[1].startAnimation(fadeInAnimations[8])
                buttons[2].startAnimation(fadeInAnimations[8])
                Element.colorButton(buttons[1], this@MainActivity, Element.LIGHT)
                Element.colorButton(buttons[2], this@MainActivity, Element.DARK)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        for (i in cinematicTexts.indices)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener
            {
                override fun onAnimationStart(animation: Animation) { }

                override fun onAnimationEnd(animation: Animation)
                {
                    cinematicTexts[i].startAnimation(fadeInAnimations[i + 1])
                    cinematicTexts[i].setTextColor(ContextCompat.getColor(this@MainActivity, R.color.whiteGray))
                }

                override fun onAnimationRepeat(animation: Animation) { }
            })
        }
        //@formatter:on
        return fadeInAnimations
    }



    //@formatter:off
    private fun getCinematicNode(index: Int, currentState: State): CinematicNode
    {
        if(index == 1)
        {
            val prompts = listOf(getString(R.string.scene1item1), getString(R.string.scene1item2),
                                 getString(R.string.scene1item3), getString(R.string.scene1item4),
                                 getString(R.string.scene1item5), getString(R.string.scene1item6),
                                 getString(R.string.scene1item7))
            val choices = listOf(Choice(getString(R.string.scene1choice1),2, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT,24 ),
                                 Choice(getString(R.string.scene1choice2),3, {state -> state.addScore(Element.DARK)}, Element.DARK,24 ))
            return CinematicNode(index, prompts, choices, ECinematicImage.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.gray))
        }
        if(index == 2)
        {
            val prompts = listOf(getString(R.string.scene2item1), getString(R.string.scene2item2),
                                 getString(R.string.scene2item3), getString(R.string.scene2item4),
                                 getString(R.string.scene2item5))
            val choices = listOf(Choice(getString(R.string.scene2choice1),4, {state -> state.addScore(Element.FIRE)}, Element.FIRE, 24 ),
                                 Choice(getString(R.string.scene2choice2),5, {state -> state.addScore(Element.WATER)}, Element.WATER, 24))
            return CinematicNode(index, prompts, choices, ECinematicImage.LIGHT_FROM_ABOVE, ContextCompat.getColor(this, R.color.darkGray), ContextCompat.getColor(this, R.color.whiteGray))
        }
        if(index == 3)
        {
            val prompts = listOf(getString(R.string.scene3item1), getString(R.string.scene3item2),
                                 getString(R.string.scene3item3), getString(R.string.scene3item4),
                                 getString(R.string.scene3item5), getString(R.string.scene3item6))
            val choices = listOf(Choice(getString(R.string.scene3choice1), 6, {state -> state.addScore(Element.FIRE)}, Element.FIRE, 22),
                                 Choice(getString(R.string.scene3choice2), 7, {state -> state.addScore(Element.WATER)}, Element.WATER, 22))
            return CinematicNode(index, prompts, choices, ECinematicImage.NONE, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.darkishGray))
        }
        if(index == 4)
        {
            val prompts = listOf(getString(R.string.scene4item1), getString(R.string.scene4item2),
                                 getString(R.string.scene4item3), getString(R.string.scene4item4),
                                 getString(R.string.scene4item5))
            val choices = listOf(Choice(getString(R.string.scene4choice1), 8, {state -> state.addScore(Element.EARTH)}, Element.EARTH, 26),
                                 Choice(getString(R.string.scene4choice2), 8, {state -> state.addScore(Element.AIR)}, Element.AIR, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.FLAME, ContextCompat.getColor(this, R.color.faintRed), ContextCompat.getColor(this, R.color.redOrange))
        }
        if(index == 5)
        {
            val prompts = listOf(getString(R.string.scene5item1), getString(R.string.scene5item2),
                                 getString(R.string.scene5item3), getString(R.string.scene5item4),
                                 getString(R.string.scene5item5), getString(R.string.scene5item6))
            val choices = listOf(Choice(getString(R.string.scene5choice1), 9, {state -> state.addScore(Element.EARTH)}, Element.EARTH, 26),
                                 Choice(getString(R.string.scene5choice2), 9, {state -> state.addScore(Element.AIR)}, Element.AIR, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.RIVER, ContextCompat.getColor(this, R.color.faintBlue), ContextCompat.getColor(this, R.color.cyan))
        }
        if(index == 6)
        {
            val prompts = listOf(getString(R.string.scene6item1), getString(R.string.scene6item2),
                                 getString(R.string.scene6item3), getString(R.string.scene6item4),
                                 getString(R.string.scene6item5))
            val choices = listOf(Choice(getString(R.string.scene6choice1), 10, {state -> state.addScore(Element.EARTH)}, Element.EARTH, 26),
                                 Choice(getString(R.string.scene6choice2), 10, {state -> state.addScore(Element.AIR)}, Element.AIR, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.FLAME, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.darkRed))
        }
        if(index == 7)
        {
            val prompts = listOf(getString(R.string.scene7item1), getString(R.string.scene7item2),
                                 getString(R.string.scene7item3), getString(R.string.scene7item4),
                                 getString(R.string.scene7item5))
            val choices = listOf(Choice(getString(R.string.scene7choice1), 11, {state -> state.addScore(Element.EARTH)}, Element.EARTH, 26),
                                 Choice(getString(R.string.scene7choice2), 11, {state -> state.addScore(Element.AIR)}, Element.AIR, 20))
            return CinematicNode(index, prompts, choices, ECinematicImage.RIVER, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.lightishBlue))
        }
        if(index == 8)
        {
            val prompts = listOf(getString(R.string.scene8item1), getString(R.string.scene8item2),
                                 getString(R.string.scene8item3), getString(R.string.scene8item4),
                                 getString(R.string.scene8item5), getString(R.string.scene8item6))
            val choices: List<Choice>
            if(currentState.getScore(Element.AIR) > currentState.getScore(Element.EARTH))
            {
                choices = listOf(Choice(getString(R.string.scene8choice1),12,{state -> state.addScore(Element.LIGHT,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene8Activity"}, Element.LIGHT,20),
                                 Choice(getString(R.string.scene8choice2),12,{state -> state.addScore(Element.FIRE,2); state.starterMonster = "Flarial"; state.previousSceneName="Scene8Activity"}, Element.FIRE,20),
                                 Choice(getString(R.string.scene8choice3Alt),12,{state -> state.addScore(Element.AIR,2); state.starterMonster = "Flapper"; state.previousSceneName="Scene8Activity"}, Element.AIR,20),
                                 Choice(getString(R.string.scene8choice4),12,{state -> state.addScore(Element.LIGHT,1); state.addScore(Element.FIRE,1); state.starterMonster = "Tona"; state.previousSceneName="Scene8Activity"}, Subelement.SOLAR,20))
            }
            else
            {
                choices = listOf(Choice(getString(R.string.scene8choice1),12,{state -> state.addScore(Element.LIGHT,2); state.starterMonster = "Lumin"; state.previousSceneName="Scene8Activity"}, Element.LIGHT,20),
                                 Choice(getString(R.string.scene8choice2),12,{state -> state.addScore(Element.FIRE,2); state.starterMonster = "Flarial"; state.previousSceneName="Scene8Activity"}, Element.FIRE,20),
                                 Choice(getString(R.string.scene8choice3),12,{state -> state.addScore(Element.EARTH,2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene8Activity"}, Element.EARTH,20),
                                 Choice(getString(R.string.scene8choice4),12,{state -> state.addScore(Element.LIGHT,1); state.addScore(Element.FIRE,1); state.starterMonster = "Tona"; state.previousSceneName="Scene8Activity"}, Subelement.SOLAR,20))
            }
            return CinematicNode(index, prompts, choices, ECinematicImage.SUN, ContextCompat.getColor(this, R.color.darkBrown), ContextCompat.getColor(this, R.color.brown))
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
            return CinematicNode(index, prompts, choices, ECinematicImage.MAGIC_GLYPH, ContextCompat.getColor(this, R.color.lightishBlue), ContextCompat.getColor(this, R.color.lightCyanBlue))
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
            return CinematicNode(index, prompts, choices, ECinematicImage.SUN, ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.red))
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
}
    //@formatter: on
