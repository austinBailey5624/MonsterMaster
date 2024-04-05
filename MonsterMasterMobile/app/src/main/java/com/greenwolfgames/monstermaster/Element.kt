package com.greenwolfgames.monstermaster

import android.content.Context
import android.widget.Button
import androidx.core.content.ContextCompat

enum class Element {

    FIRE, WATER, EARTH, AIR, LIGHT, DARK, NEUTRAL, PHYSICAL, MAGICAL;

    companion object {

        fun colorButton(button: Button, context: Context, element: Element): Button {
            val textColor = when (element) {
                Element.FIRE -> R.color.yellowOrange
                Element.WATER -> R.color.cyan
                Element.EARTH -> R.color.green
                Element.AIR -> R.color.yellow
                Element.LIGHT -> R.color.white
                Element.DARK -> R.color.black
                Element.NEUTRAL -> R.color.darkBrown
                Element.PHYSICAL -> R.color.darkGray
                Element.MAGICAL -> R.color.darkPurple
            }

            val backgroundColor = when (element) {
                Element.FIRE -> R.color.red
                Element.WATER -> R.color.blue
                Element.EARTH -> R.color.forestGreen
                Element.AIR -> R.color.lightBrown
                Element.LIGHT -> R.color.whiteGray
                Element.DARK -> R.color.gray
                Element.NEUTRAL -> R.color.brown
                Element.PHYSICAL -> R.color.whiteGray
                Element.MAGICAL -> R.color.purple
            }
            button.setTextColor(
                ContextCompat.getColor(context,textColor))
            button.setBackgroundColor(ContextCompat.getColor(context,backgroundColor))
            return button
        }
    }
}