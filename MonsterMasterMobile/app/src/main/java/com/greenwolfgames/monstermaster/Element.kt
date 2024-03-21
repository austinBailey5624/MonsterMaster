package com.greenwolfgames.monstermaster

import android.content.Context
import android.widget.Button
import androidx.core.content.ContextCompat

enum class Element {

    FIRE, WATER, EARTH, AIR, LIGHT, DARK;

    companion object {

        fun colorButton(button: Button, context: Context, element: Element): Button {
            val textColor = when (element) {
                Element.FIRE -> R.color.red
                Element.WATER -> R.color.blue
                Element.EARTH -> R.color.green
                Element.AIR -> R.color.yellow
                Element.LIGHT -> R.color.white
                Element.DARK -> R.color.black
            }

            val backgroundColor = when (element) {
                Element.FIRE -> R.color.orange
                Element.WATER -> R.color.cyan
                Element.EARTH -> R.color.forestGreen
                Element.AIR -> R.color.brown
                Element.LIGHT -> R.color.whiteGray
                Element.DARK -> R.color.gray
            }
            button.setTextColor(
                ContextCompat.getColor(context,textColor))
            button.setBackgroundColor(ContextCompat.getColor(context,backgroundColor))
            return button
        }
    }
}