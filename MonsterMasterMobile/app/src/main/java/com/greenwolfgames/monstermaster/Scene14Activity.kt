package com.greenwolfgames.monstermaster

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class Scene14Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene14_players_room_initial)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val parent = findViewById<View>(R.id.Parent)
        parent.setBackgroundColor(ContextCompat.getColor(this@Scene14Activity, R.color.darkBrown))

        val buttons: List<Button> = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
        )

        val portraitBackground: ImageView = findViewById(R.id.portrait_background)
        val color = ContextCompat.getColor(this@Scene14Activity, R.color.brown)
        val lessIntenseColor =
            Color.argb(164, Color.red(color), Color.green(color), Color.blue(color))
        portraitBackground.setColorFilter(lessIntenseColor)
        val textBackground: ImageView = findViewById(R.id.speaker_text_background)
        textBackground.setColorFilter(lessIntenseColor)
        val speakerText: TextView = findViewById(R.id.speaker_text)
        speakerText.setTextColor(ContextCompat.getColor(this@Scene14Activity, R.color.darkBrown))


        setNode(1, buttons, currentState)
    }

    fun setNode(node: Int, buttons: List<Button>, currentState: State) {
        val scene14Node = getScene14Node(node)
        val prompt = findViewById<TextView>(R.id.speaker_text)
        prompt.text = scene14Node.prompt
        setTextSize(prompt)
        formatButtons(buttons, scene14Node.choices.size)
        for (i in 0 until buttons.size) {
            if (i < scene14Node.choices.size) {
                val choice = scene14Node.choices[i]
                buttons[i].text = choice.text
                Element.colorButton(buttons[i], this@Scene14Activity, choice.element)
                buttons[i].setOnClickListener {
                    choice.stateChange(currentState)
                    setNode(choice.nextNodeIndex, buttons, currentState)
                }
                buttons[i].visibility = View.VISIBLE
            } else {
                Utilities.hideButton(buttons[i], this@Scene14Activity)
                buttons[i].visibility = View.GONE
            }
        }
    }

    private fun setTextSize(textView: TextView) {
        val text = textView.text.toString()
        if (text.length > 120) {
            textView.textSize = 15f
        } else if (text.length > 100) {
            textView.textSize = 17f
        } else if (text.length > 70) {
            textView.textSize = 19f
        } else if (text.length > 50) {
            textView.textSize = 21f
        } else if (text.length > 35){
            textView.textSize = 23f
        } else {
            textView.textSize = 25f
        }
    }

    private fun formatButtons(buttons: List<Button>, numButtons: Int) {
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
        if (numButtons == 1) {
            buttons[0].layoutParams.width = totalWidthUsed
            buttons[0].layoutParams.height = totalHeightUsed.toInt()
            buttons[0].textSize = 20f
            val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
            params.bottomToBottom = R.id.Parent
            params.topToBottom = R.id.background
            params.startToStart = R.id.Parent
            params.endToEnd = R.id.Parent
            params.verticalBias = 0f;
            params.horizontalBias = 0.5f;
            buttons[0].layoutParams = params
            for (i in 1 until buttons.size) {
                Utilities.hideButton(buttons[i], this@Scene14Activity)
                buttons[i].visibility = View.GONE
            }
        }
        if (numButtons == 2) {
            buttons[0].textSize = 20f
            val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
            params.width = totalWidthUsed
            params.height = (totalHeightUsed / 2).toInt()
            params.bottomToTop = buttons[1].id
            params.topToBottom = R.id.background
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
            for (i in 2 until buttons.size) {
                Utilities.hideButton(buttons[i], this@Scene14Activity)
                buttons[i].visibility = View.GONE
            }
        }
        if (numButtons == 3) {
            buttons[0].layoutParams.width = totalWidthUsed
            buttons[0].layoutParams.height = (totalHeightUsed / 3).toInt()
            buttons[0].textSize = 17f
            val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
            params.bottomToTop = buttons[1].id
            params.topToBottom = R.id.background
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
            for (i in 3 until buttons.size) {
                Utilities.hideButton(buttons[i], this@Scene14Activity)
                buttons[i].visibility = View.GONE
            }
        }
        if (numButtons == 4) {
            buttons[0].layoutParams.width = totalWidthUsed / 2
            buttons[0].layoutParams.height = (totalHeightUsed / 2).toInt()
            buttons[0].textSize = 15f
            val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
            params.bottomToTop = buttons[1].id
            params.topToBottom = R.id.background
            params.startToStart = R.id.Parent
            params.endToStart = buttons[2].id
            params.verticalBias = 0f;
            params.horizontalBias = 1f;
            buttons[0].layoutParams = params

            buttons[1].layoutParams.width = totalWidthUsed / 2
            buttons[1].layoutParams.height = (totalHeightUsed / 2).toInt()
            buttons[1].textSize = 15f
            val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
            params2.bottomToBottom = R.id.Parent
            params2.topToBottom = buttons[0].id
            params2.startToStart = R.id.Parent
            params2.endToStart = buttons[3].id
            params2.verticalBias = 0f;
            params2.horizontalBias = 1f;
            buttons[1].layoutParams = params2

            buttons[2].layoutParams.width = totalWidthUsed / 2
            buttons[2].layoutParams.height = (totalHeightUsed / 2).toInt()
            buttons[2].textSize = 15f
            val params3 = buttons[2].layoutParams as ConstraintLayout.LayoutParams
            params3.bottomToTop = buttons[3].id
            params3.topToBottom = R.id.background
            params3.startToEnd = buttons[0].id
            params3.endToEnd = R.id.Parent
            params3.verticalBias = 0f
            params3.horizontalBias = 0f
            buttons[2].layoutParams = params3

            buttons[3].layoutParams.width = totalWidthUsed / 2
            buttons[3].layoutParams.height = (totalHeightUsed / 2).toInt()
            buttons[3].textSize = 15f
            val params4 = buttons[3].layoutParams as ConstraintLayout.LayoutParams
            params4.bottomToBottom = R.id.Parent
            params4.topToBottom = buttons[2].id
            params4.startToEnd = buttons[1].id
            params4.endToEnd = R.id.Parent
            params4.verticalBias = 0f
            params4.horizontalBias = 0f
            buttons[3].layoutParams = params4
            for (i in 4 until buttons.size) {
                Utilities.hideButton(buttons[i], this@Scene14Activity)
                buttons[i].visibility = View.GONE
            }
        }
        if (numButtons == 5) {
            buttons[0].textSize = 12f
            val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
            params.width = totalWidthUsed / 2
            params.height = (totalHeightUsed / 3).toInt()
            params.bottomToTop = buttons[1].id
            params.topToBottom = R.id.background
            params.startToStart = R.id.Parent
            params.endToStart = buttons[2].id
            params.verticalBias = 0f
            params.horizontalBias = 1f
            buttons[0].layoutParams = params

            buttons[1].textSize = 12f
            val params2 = buttons[1].layoutParams as ConstraintLayout.LayoutParams
            params2.width = totalWidthUsed / 2
            params2.height = (totalHeightUsed / 3).toInt()
            params2.bottomToTop = buttons[4].id
            params2.topToBottom = buttons[0].id
            params2.startToStart = R.id.Parent
            params2.endToStart = buttons[3].id
            params2.verticalBias = 0f
            params2.horizontalBias = 1f
            buttons[1].layoutParams = params2

            buttons[2].textSize = 12f
            val params3 = buttons[2].layoutParams as ConstraintLayout.LayoutParams
            params3.width = totalWidthUsed / 2
            params3.height = (totalHeightUsed / 3).toInt()
            params3.bottomToTop = buttons[3].id
            params3.topToBottom = R.id.background
            params3.startToEnd = buttons[0].id
            params3.endToEnd = R.id.Parent
            params3.verticalBias = 0f
            params3.horizontalBias = 0f
            buttons[2].layoutParams = params3

            buttons[3].textSize = 12f
            val params4 = buttons[3].layoutParams as ConstraintLayout.LayoutParams
            params4.width = totalWidthUsed / 2
            params4.height = (totalHeightUsed / 3).toInt()
            params4.bottomToTop = buttons[4].id
            params4.topToBottom = buttons[2].id
            params4.startToEnd = buttons[1].id
            params4.endToEnd = R.id.Parent
            params4.verticalBias = 0f
            params4.horizontalBias = 0f
            buttons[3].layoutParams = params4

            buttons[4].textSize = 12f
            val params5 = buttons[4].layoutParams as ConstraintLayout.LayoutParams
            params5.width = totalWidthUsed
            params5.height = (totalHeightUsed / 3).toInt()
            params5.bottomToBottom = R.id.Parent
            params5.topToBottom = buttons[1].id
            params5.startToStart = R.id.Parent
            params5.endToEnd = R.id.Parent
            params5.verticalBias = 0f
            params5.horizontalBias = 0.5f
            buttons[4].layoutParams = params5

            Utilities.hideButton(buttons[5], this@Scene14Activity)
            buttons[5].visibility = View.GONE
        }
        if (numButtons == 6) {
            buttons[0].textSize = 12f
            val params = buttons[0].layoutParams as ConstraintLayout.LayoutParams
            params.width = totalWidthUsed / 2
            params.height = (totalHeightUsed / 3).toInt()
            params.bottomToTop = buttons[1].id
            params.topToBottom = R.id.background
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
            params4.topToBottom = R.id.background
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

    private fun getScene14Node(index: Int): Scene14Node {
        //@formatter:OFF
        if(index == 1)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node1choice1),2, {state -> state.addScore(Element.DARK, 1)}, Element.DARK)
            val choice2 = Scene14Choice(getString(R.string.scene14node1choice2),3, {state -> state.addScore(Element.WATER, 1)}, Element.WATER)
            val choice3 = Scene14Choice(getString(R.string.scene14node1choice3),4, {state -> state.addScore(Element.AIR, 1)}, Element.AIR)
            val choice4 = Scene14Choice(getString(R.string.scene14node1choice4),2, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE)
            val choice5 = Scene14Choice(getString(R.string.scene14node1choice5),4, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH)
            val choice6 = Scene14Choice(getString(R.string.scene14node1choice6),5, {}, Element.NEUTRAL)
            val choices = listOf(choice1, choice2, choice3, choice4, choice5, choice6)
            return Scene14Node(index, getString(R.string.scene14node1prompt),choices)
        }
        if(index == 2)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node2choice1),6, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE)
            val choice2 = Scene14Choice(getString(R.string.scene14node2choice2),4, {state -> state.addScore(Element.WATER, 1)}, Element.WATER)
            val choice3 = Scene14Choice(getString(R.string.scene14node2choice3),4, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH)
            return Scene14Node(index, getString(R.string.scene14node2prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 3)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node3choice1),6, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE)
            val choice2 = Scene14Choice(getString(R.string.scene14node3choice2), 4, {state -> state.addScore(Element.WATER, 1)}, Element.WATER)
            val choice3 = Scene14Choice(getString(R.string.scene14node3choice3), 4, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH)
            return Scene14Node(index, getString(R.string.scene14node3prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 4)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node4choice1), 7, {}, Element.NEUTRAL)
            val choice2 = Scene14Choice(getString(R.string.scene14node4choice2), 8, {}, Element.NEUTRAL)
            val choice3 = Scene14Choice(getString(R.string.scene14node4choice3), 9, {state -> state.addScore(Element.DARK,1)}, Element.DARK)
            val choice4 = Scene14Choice(getString(R.string.scene14node4choice4), 0, {state -> state.addScore(Element.EARTH,1)}, Element.EARTH)
            val choice5 = Scene14Choice(getString(R.string.scene14node4choice5), 0, {state -> state.addScore(Element.AIR, 1)}, Element.AIR)
            return Scene14Node(index, getString(R.string.scene14node4prompt), listOf(choice1, choice2, choice3, choice4, choice5))
        }
        if(index == 5)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node5choice1), 4, {}, Element.NEUTRAL)
            val choice2 = Scene14Choice(getString(R.string.scene14node5choice2), 14, {}, Element.NEUTRAL)
            return Scene14Node(index, getString(R.string.scene14node5prompt), listOf(choice1, choice2))
        }
        if(index == 6)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node6choice1), 7, {}, Element.NEUTRAL)
            val choice2 = Scene14Choice(getString(R.string.scene14node6choice2), 8,{}, Element.NEUTRAL)
            val choice3 = Scene14Choice(getString(R.string.scene14node6choice3), 9, {state -> state.addScore(Element.DARK, 1)}, Element.DARK)
            val choice4 = Scene14Choice(getString(R.string.scene14node6choice4), 0, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH)
            val choice5 = Scene14Choice(getString(R.string.scene14node6choice5), 0, {state -> state.addScore(Element.AIR, 1)}, Element.AIR)
            val choice6 = Scene14Choice(getString(R.string.scene14node6choice6),10, {state -> state.addScore(Element.DARK, 1)}, Element.DARK)
            return Scene14Node(index, getString(R.string.scene14node6prompt), listOf(choice1, choice2, choice3, choice4, choice5, choice6))
        }
        if(index == 7)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node7choice1), 11, {}, Element.NEUTRAL)
            val choice2 = Scene14Choice(getString(R.string.scene14node7choice2), 12, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT)
            return Scene14Node(index, getString(R.string.scene14node7prompt), listOf(choice1, choice2))
        }
        if(index == 8)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node8choice1), 13, {}, Element.NEUTRAL)
            val choice2 = Scene14Choice(getString(R.string.scene14node8choice2), 13, {state -> state.addScore(Element.AIR)}, Element.AIR)
            val choice3 = Scene14Choice(getString(R.string.scene14node8choice3),13, {state -> state.addScore(Element.WATER)}, Element.WATER)
            return Scene14Node(index, getString(R.string.scene14node8prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 9)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node9choice1), 7)
            val choice2 = Scene14Choice(getString(R.string.scene14node9choice2),8)
            val choice3 = Scene14Choice(getString(R.string.scene14node9choice3),0)
            return Scene14Node(index, getString(R.string.scene14node9prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 10)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node10choice1),8)
            val choice2 = Scene14Choice(getString(R.string.scene14node10choice2), 0)
            return Scene14Node(index, getString(R.string.scene14node10prompt), listOf(choice1, choice2))
        }
        if(index == 11)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node11choice1), 0)
            val choice2 = Scene14Choice(getString(R.string.scene14node11choice2), 15)
            return Scene14Node(index, getString(R.string.scene14node11prompt), listOf(choice1, choice2))
        }
        if(index == 12)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node12choice1), 16)
            val choice2 = Scene14Choice(getString(R.string.scene14node12choice2), 17, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT)
            val choice3 = Scene14Choice(getString(R.string.scene14node12choice3),11)
            return Scene14Node(index, getString(R.string.scene14node12prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 13)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node13choice1), 0)
            return Scene14Node(index, getString(R.string.scene14node13prompt), listOf(choice1))
        }
        if(index == 14)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node14choice1), 4)
            val choice2 = Scene14Choice(getString(R.string.scene14node14choice2),18)
            val choice3 = Scene14Choice(getString(R.string.scene14node14choice3), 19)
            return Scene14Node(index, getString(R.string.scene14node14prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 15)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node15choice1), 0)
            return Scene14Node(index, getString(R.string.scene14node15prompt), listOf(choice1))
        }
        if(index == 16)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node16choice1), 11)
            val choice2 = Scene14Choice(getString(R.string.scene14node16prompt), 17, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT)
            return Scene14Node(index, getString(R.string.scene14node16prompt), listOf(choice1, choice2))
        }
        if(index == 17)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node17choice1), 0)
            val choice2 = Scene14Choice(getString(R.string.scene14node17choice2), 15)
            return Scene14Node(index, getString(R.string.scene14node17prompt), listOf(choice1, choice2))
        }
        if(index == 18)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node18choice1), 0)
            return Scene14Node(index, getString(R.string.scene14node18prompt), listOf(choice1))
        }
        if(index == 19)
        {
            val choice1 = Scene14Choice(getString(R.string.scene14node19choice1), 0)
            return Scene14Node(index, getString(R.string.scene14node19prompt), listOf(choice1))
        }
        throw IllegalStateException("Index" + index + "not found in Scene14Activity.getScene14Node(");
        //@formatter:ON
    }

    override fun onBackPressed() {
        if (false) {
            super.onBackPressed()
        }
    }
}