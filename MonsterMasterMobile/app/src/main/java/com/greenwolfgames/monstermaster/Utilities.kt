package com.greenwolfgames.monstermaster

import android.content.Context
import android.graphics.Color
import android.widget.Button
import androidx.core.content.ContextCompat

class Utilities
{
    companion object {
        fun hideButton(button: Button, context: Context): Button {
            button.setTextColor(ContextCompat.getColor(context, R.color.invisible))
            button.setBackgroundColor(ContextCompat.getColor(context, R.color.invisible))
            return button
        }

        fun combineColors(color1: Color, intensity1: Float, color2: Color, intensity2: Float): Int
        {
            val red = (color1.red() * intensity1 + color2.red() * intensity2).toInt()
            val green = (color1.green() * intensity1 + color2.green() * intensity2).toInt()
            val blue = (color1.blue() * intensity1 + color2.blue() * intensity2).toInt()
            return Color.argb(255, red, green, blue)
        }
    }
}