package com.greenwolfgames.monstermaster

import android.content.Context
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
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

        fun orgainizeButtons(buttons: List<Button>, numButtons: Int, top: View, context: Context, windowManager: WindowManager)
        {
            if (buttons.size < numButtons) {
                throw IllegalStateException("NumButtons " + numButtons + " is greater than actual num buttons" + buttons.size);
            }
            if (numButtons < 1) {
                throw IllegalStateException("NumButtons $numButtons is less than 1")
            }
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            val totalHeightUsed =
                displayMetrics.heightPixels / 4.5;//(displayMetrics.heightPixels - findViewById<ImageView>(R.id.background).height) / 2
            val totalWidthUsed = displayMetrics.widthPixels

            val topParams = top.layoutParams as ConstraintLayout.LayoutParams
            topParams.bottomToTop = buttons[0].id
            top.layoutParams = topParams

            if (numButtons == 1) {
                for (i in 1 until buttons.size) {
                    Utilities.hideButton(buttons[i], context)
                    buttons[i].visibility = View.GONE
                }
                buttons[0].layoutParams.width = totalWidthUsed
                buttons[0].layoutParams.height = totalHeightUsed.toInt()
                buttons[0].textSize = 20f
                val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
                params.bottomToBottom = R.id.Parent
                params.topToBottom = top.id
                params.startToStart = R.id.Parent
                params.endToEnd = R.id.Parent
                params.verticalBias = 0f;
                params.horizontalBias = 0.5f;
                buttons[0].layoutParams = params

            }
            if (numButtons == 2) {
                for (i in 2 until buttons.size) {
                    hideButton(buttons[i], context)
                    buttons[i].visibility = View.GONE
                }
                buttons[0].textSize = 20f
                val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
                params.width = totalWidthUsed
                params.height = (totalHeightUsed / 2).toInt()
                params.bottomToTop = buttons[1].id
                params.topToBottom = top.id
                params.startToStart = R.id.Parent
                params.endToEnd = R.id.Parent
                params.verticalBias = 0f;
                params.horizontalBias = 0.5f;
                buttons[0].layoutParams = params

                buttons[1].layoutParams.width = totalWidthUsed
                buttons[1].layoutParams.height = (totalHeightUsed / 2).toInt()
                buttons[1].textSize = 20f
                val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
                params2.bottomToBottom = R.id.Parent
                params2.topToBottom = buttons[0].id
                params2.startToStart = R.id.Parent
                params2.endToEnd = R.id.Parent
                params2.verticalBias = 0f;
                params2.horizontalBias = 0.5f
                buttons[1].layoutParams = params2

            }
            if (numButtons == 3) {
                for (i in 3 until buttons.size) {
                    hideButton(buttons[i], context)
                    buttons[i].visibility = View.GONE
                }
                buttons[0].layoutParams.width = totalWidthUsed
                buttons[0].layoutParams.height = (totalHeightUsed / 3).toInt()
                buttons[0].textSize = 17f
                val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
                params.bottomToTop = buttons[1].id
                params.topToBottom = top.id
                params.startToStart = R.id.Parent
                params.endToEnd = R.id.Parent
                params.verticalBias = 0f;
                buttons[0].layoutParams = params

                buttons[1].layoutParams.width = totalWidthUsed
                buttons[1].layoutParams.height = (totalHeightUsed / 3).toInt()
                buttons[1].textSize = 17f
                val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
                params2.bottomToTop = buttons[2].id
                params2.topToBottom = buttons[0].id
                params2.startToStart = R.id.Parent
                params2.endToEnd = R.id.Parent
                params2.verticalBias = 0f;
                buttons[1].layoutParams = params2

                buttons[2].layoutParams.width = totalWidthUsed
                buttons[2].layoutParams.height = (totalHeightUsed / 3).toInt()
                buttons[2].textSize = 17f
                val params3 = buttons[2].layoutParams as ConstraintLayout.LayoutParams
                params3.bottomToBottom = R.id.Parent
                params3.topToBottom = buttons[1].id
                params3.startToStart = R.id.Parent
                params3.endToEnd = R.id.Parent
                params3.verticalBias = 0f
                buttons[2].layoutParams = params3

            }
            if (numButtons == 4) {

                hideButton(buttons[2], context)
                buttons[2].visibility = View.GONE
                hideButton(buttons[5], context)
                buttons[5].visibility = View.GONE

                buttons[0].layoutParams.width = totalWidthUsed / 2
                buttons[0].layoutParams.height = (totalHeightUsed / 2).toInt()
                buttons[0].textSize = 15f
                val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
                params.bottomToTop = buttons[1].id
                params.topToBottom = top.id
                params.startToStart = R.id.Parent
                params.endToStart = buttons[3].id
//                params.verticalBias = 1f;
//                params.horizontalBias = 1f;
                buttons[0].layoutParams = params

                buttons[1].layoutParams.width = totalWidthUsed / 2
                buttons[1].layoutParams.height = (totalHeightUsed / 2).toInt()
                buttons[1].textSize = 15f
                val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
                params2.bottomToBottom = R.id.Parent
                params2.topToBottom = buttons[0].id
                params2.startToStart = R.id.Parent
                params2.endToStart = buttons[4].id
//                params2.verticalBias = 1f;
//                params2.horizontalBias = 1f;
                buttons[1].layoutParams = params2

                buttons[3].layoutParams.width = totalWidthUsed / 2
                buttons[3].layoutParams.height = (totalHeightUsed / 2).toInt()
                buttons[3].textSize = 15f
                val params3 = buttons[3].layoutParams as ConstraintLayout.LayoutParams
                params3.bottomToTop = buttons[4].id
                params3.topToBottom = top.id
                params3.startToEnd = buttons[0].id
                params3.endToEnd = R.id.Parent
//                params3.verticalBias = 1f
//                params3.horizontalBias = 1f
                buttons[3].layoutParams = params3

                buttons[4].layoutParams.width = totalWidthUsed / 2
                buttons[4].layoutParams.height = (totalHeightUsed / 2).toInt()
                buttons[4].textSize = 15f
                val params4 = buttons[4].layoutParams as ConstraintLayout.LayoutParams
                params4.bottomToBottom = R.id.Parent
                params4.topToBottom = buttons[3].id
                params4.startToEnd = buttons[1].id
                params4.endToEnd = R.id.Parent
//                params4.verticalBias = 1f
//                params4.horizontalBias = 1f
                buttons[4].layoutParams = params4
            }
            if (numButtons == 5) {
                buttons[0].textSize = 12f
                val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
                params.width = totalWidthUsed / 2
                params.height = (totalHeightUsed / 3).toInt()
                params.bottomToTop = buttons[1].id
                params.topToBottom = top.id
                params.startToStart = R.id.Parent
                params.endToStart = buttons[3].id
                params.verticalBias = 0f
                params.horizontalBias = 1f
                buttons[0].layoutParams = params

                buttons[1].textSize = 12f
                val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
                params2.width = totalWidthUsed / 2
                params2.height = (totalHeightUsed / 3).toInt()
                params2.bottomToTop = buttons[2].id
                params2.topToBottom = buttons[0].id
                params2.startToStart = R.id.Parent
                params2.endToStart = buttons[4].id
                params2.verticalBias = 0f
                params2.horizontalBias = 1f
                buttons[1].layoutParams = params2

                buttons[2].textSize = 12f
                val params3 = buttons[2].layoutParams as ConstraintLayout.LayoutParams
                params3.width = totalWidthUsed
                params3.height = (totalHeightUsed / 3).toInt()
                params3.bottomToBottom = R.id.Parent
                params3.topToBottom = buttons[1].id
                params3.startToStart = R.id.Parent
                params3.endToEnd = R.id.Parent
                params3.verticalBias = 0f
                params3.horizontalBias = 0.5f
                buttons[2].layoutParams = params3

                buttons[3].textSize = 12f
                val params4 = buttons[3].layoutParams as ConstraintLayout.LayoutParams
                params4.width = totalWidthUsed / 2
                params4.height = (totalHeightUsed / 3).toInt()
                params4.bottomToTop = buttons[4].id
                params4.topToBottom = top.id
                params4.startToEnd = buttons[0].id
                params4.endToEnd = R.id.Parent
                params4.verticalBias = 0f
                params4.horizontalBias = 0f
                buttons[3].layoutParams = params4

                buttons[4].textSize = 12f
                val params5 = buttons[4].layoutParams as ConstraintLayout.LayoutParams
                params5.width = totalWidthUsed / 2
                params5.height = (totalHeightUsed / 3).toInt()
                params5.bottomToTop = buttons[2].id
                params5.topToBottom = buttons[3].id
                params5.startToEnd = buttons[1].id
                params5.endToEnd = R.id.Parent
                params5.verticalBias = 0f
                params5.horizontalBias = 0f
                buttons[4].layoutParams = params5

                hideButton(buttons[5], context)
                buttons[5].visibility = View.GONE
            }
            if (numButtons == 6) {
                buttons[0].textSize = 12f
                val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
                params.width = totalWidthUsed / 2
                params.height = (totalHeightUsed / 3).toInt()
                params.bottomToTop = buttons[1].id
                params.topToBottom = top.id
                params.startToStart = R.id.Parent
                params.endToStart = buttons[3].id
                params.verticalBias = 0f
                params.horizontalBias = 1f
                buttons[0].layoutParams = params

                buttons[1].textSize = 12f
                val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
                params2.width = totalWidthUsed / 2
                params2.height = (totalHeightUsed / 3).toInt()
                params2.bottomToTop = buttons[2].id
                params2.topToBottom = buttons[0].id
                params2.startToStart = R.id.Parent
                params2.endToStart = buttons[4].id
                params2.verticalBias = 0f
                params2.horizontalBias = 1f
                buttons[1].layoutParams = params2

                buttons[2].textSize = 12f
                val params3 = buttons[2].layoutParams as ConstraintLayout.LayoutParams
                params3.width = totalWidthUsed / 2
                params3.height = (totalHeightUsed / 3).toInt()
                params3.bottomToBottom = R.id.Parent
                params3.topToBottom = buttons[1].id
                params3.startToStart = R.id.Parent
                params3.endToStart = buttons[5].id
                params3.verticalBias = 0f
                params3.horizontalBias = 1f
                buttons[2].layoutParams = params3

                buttons[3].textSize = 12f
                val params4 = buttons[3].layoutParams as ConstraintLayout.LayoutParams
                params4.width = totalWidthUsed / 2
                params4.height = (totalHeightUsed / 3).toInt()
                params4.bottomToTop = buttons[4].id
                params4.topToBottom = top.id
                params4.startToEnd = buttons[0].id
                params4.endToEnd = R.id.Parent
                params4.verticalBias = 0f
                params4.horizontalBias = 0f
                buttons[3].layoutParams = params4

                buttons[4].textSize = 12f
                val params5 = buttons[4].layoutParams as ConstraintLayout.LayoutParams
                params5.width = totalWidthUsed / 2
                params5.height = (totalHeightUsed / 3).toInt()
                params5.bottomToTop = buttons[5].id
                params5.topToBottom = buttons[3].id
                params5.startToEnd = buttons[1].id
                params5.endToEnd = R.id.Parent
                params5.verticalBias = 0f
                params5.horizontalBias = 0f
                buttons[4].layoutParams = params5

                buttons[5].textSize = 12f
                val params6 = buttons[5].layoutParams as ConstraintLayout.LayoutParams
                params6.width = totalWidthUsed / 2
                params6.height = (totalHeightUsed / 3).toInt()
                params6.bottomToBottom = R.id.Parent
                params6.topToBottom = buttons[4].id
                params6.startToEnd = buttons[2].id
                params6.endToEnd = R.id.Parent
                params6.verticalBias = 0f
                params6.horizontalBias = 0f
                buttons[5].layoutParams = params6
            }
            if (numButtons > 6) {
                throw IllegalStateException("Illegal number of Buttons, max 6 actual: $numButtons")
            }

            for (i in 0 until numButtons) {
                buttons[i].visibility = View.VISIBLE
            }

            for (element in buttons) {
                if (element.visibility != View.GONE) {
                    adjustButtonTextSize(element)
                }
            }
        }

        private fun adjustButtonTextSize(button: Button) {
            val text = button.text.toString()
            if (text.length > 30) {
                button.textSize = 12f
            } else if (text.length > 20) {
                button.textSize = 14f
            } else if (text.length > 12){
                button.textSize = 16f
            }
            else {
                button.textSize = 18f
            }
        }
    }
}