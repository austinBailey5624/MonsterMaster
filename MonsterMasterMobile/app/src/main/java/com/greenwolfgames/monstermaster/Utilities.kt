package com.greenwolfgames.monstermaster

import android.content.Context
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
    }
}