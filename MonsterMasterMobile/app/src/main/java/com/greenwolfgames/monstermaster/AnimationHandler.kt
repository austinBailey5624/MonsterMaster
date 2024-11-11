package com.greenwolfgames.monstermaster

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class AnimationHandler
{
    companion object
    {
        fun getFadeInAnimations(
            buttons: List<Button>,
            cinematicTexts: List<TextView>,
            textColor: Int,
            node: Node,
            context: Context,
            skipButton: Button
        ): List<Animation>
        {
            val fadeInAnimations: List<Animation> = listOf(
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in),
                AnimationUtils.loadAnimation(context, R.anim.fade_in)
            )

            val fadeInFastAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in_fast)

        //@formatter:off
        fadeInAnimations[7].setAnimationListener(object : Animation.AnimationListener
        {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation)
            {
                animateButtons(buttons, node.choices, fadeInAnimations[8])
                colorButtons(buttons, node.choices, context)
                skipButton.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in node.prompt.indices)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener
            {
                override fun onAnimationStart(animation: Animation) { }

                override fun onAnimationEnd(animation: Animation)
                {
                    Log.d("Skip Button Status", "Skip Button Visibility: (visible: " + View.VISIBLE +", invisible: " + View.INVISIBLE + ", gone: " + View.GONE + "): "+ skipButton.visibility)
                    // case where we have pressed the skip button
                    if(skipButton.visibility == View.GONE)
                    {
                        //for all of the cinematic texts after the current text before the size last cinematic text
                        for (j in i..<cinematicTexts.size)
                        {
                            if(j < node.prompt.size)
                            {
                                cinematicTexts[j].startAnimation((fadeInFastAnimation))
                                cinematicTexts[j].setTextColor(textColor)
                            }
                            else
                            {
                                cinematicTexts[j].setTextColor(ContextCompat.getColor(context, R.color.invisible))
                            }
                        }
                        animateButtons(buttons, node.choices, fadeInFastAnimation)
                        colorButtons(buttons, node.choices, context)
                    }
                    //case where we have not pressed the skip button
                    else
                    {
                        if(i == node.prompt.size-1)
                        {
                            cinematicTexts[i].startAnimation(fadeInAnimations[7])
                            cinematicTexts[i].setTextColor(textColor)
                        }
                        else
                        {
                            cinematicTexts[i].startAnimation(fadeInAnimations[i + 1])
                            cinematicTexts[i].setTextColor(textColor)
                        }
                    }
                }
                override fun onAnimationRepeat(animation: Animation) { }
            })
        }
        //@formatter:on
            return fadeInAnimations
        }

        private fun colorButtons(buttons: List<Button>, choices: List<Choice>, context: Context)
        {
            for (i in choices.indices)
            {
                Element.colorButton(buttons[i], context, choices[i].element)
                buttons[i].visibility = View.VISIBLE
            }
            for (i in choices.size..<buttons.size)
            {
                buttons[i].visibility = View.GONE
            }
        }

        private fun animateButtons(
            buttons: List<Button>, choices: List<Choice>, animation: Animation
        )
        {
            for (i in choices.indices)
            {
                buttons[i].startAnimation(animation)
            }
        }

        fun getBackgroundAnimator(main: ConstraintLayout, fromColor: Color, toColor: Color): ObjectAnimator
        {
            val animator = ObjectAnimator.ofArgb(
                main,
                "backgroundColor",
                fromColor.toArgb(),
                toColor.toArgb()
            )
            animator.duration = 250
            return animator
        }
    }
}