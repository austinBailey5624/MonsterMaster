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
        Utilities.orgainizeButtons(buttons, scene14Node.choices.size, findViewById(R.id.background),this@Scene14Activity, windowManager)
        for (i in buttons.indices) {
            if (i < scene14Node.choices.size) {
                val choice = scene14Node.choices[i]
                buttons[i].text = choice.text
                buttons[i].textSize = choice.textSize.toFloat()
                Subelement.colorButton(buttons[i], this@Scene14Activity, choice.element)
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

    private fun getScene14Node(index: Int): Node {
        //@formatter:OFF
        if(index == 1)
        {
            val choice1 = Choice(getString(R.string.scene14node1choice1),2, {state -> state.addScore(Element.DARK, 1)}, Element.DARK, 16)
            val choice2 = Choice(getString(R.string.scene14node1choice2),3, {state -> state.addScore(Element.WATER, 1)}, Element.WATER, 16)
            val choice3 = Choice(getString(R.string.scene14node1choice3),4, {state -> state.addScore(Element.AIR, 1)}, Element.AIR, 16)
            val choice4 = Choice(getString(R.string.scene14node1choice4),2, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE, 16)
            val choice5 = Choice(getString(R.string.scene14node1choice5),4, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH, 16)
            val choice6 = Choice(getString(R.string.scene14node1choice6),5, {}, Element.NEUTRAL,18)
            val choices = listOf(choice1, choice2, choice3, choice4, choice5, choice6)
            return Node(index, getString(R.string.scene14node1prompt),choices)
        }
        if(index == 2)
        {
            val choice1 = Choice(getString(R.string.scene14node2choice1),6, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE, 18)
            val choice2 = Choice(getString(R.string.scene14node2choice2),4, {state -> state.addScore(Element.WATER, 1)}, Element.WATER, 18)
            val choice3 = Choice(getString(R.string.scene14node2choice3),4, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH, 18)
            return Node(index, getString(R.string.scene14node2prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 3)
        {
            val choice1 = Choice(getString(R.string.scene14node3choice1),6, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE, 24)
            val choice2 = Choice(getString(R.string.scene14node3choice2), 4, {state -> state.addScore(Element.WATER, 1)}, Element.WATER,20)
            val choice3 = Choice(getString(R.string.scene14node3choice3), 4, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH,20)
            return Node(index, getString(R.string.scene14node3prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 4)
        {
            val choice1 = Choice(getString(R.string.scene14node4choice1), 7, {}, Element.NEUTRAL,18)
            val choice2 = Choice(getString(R.string.scene14node4choice2), 8, {}, Element.NEUTRAL,18)
            val choice3 = Choice(getString(R.string.scene14node4choice3), 9, {state -> state.addScore(Element.DARK,1)}, Element.DARK,14)
            val choice4 = Choice(getString(R.string.scene14node4choice4), 0, {state -> state.addScore(Element.EARTH,1)}, Element.EARTH,18)
            val choice5 = Choice(getString(R.string.scene14node4choice5), 0, {state -> state.addScore(Element.AIR, 1)}, Element.AIR,16)
            return Node(index, getString(R.string.scene14node4prompt), listOf(choice1, choice2, choice3, choice4, choice5))
        }
        if(index == 5)
        {
            val choice1 = Choice(getString(R.string.scene14node5choice1), 4, {}, Element.NEUTRAL)
            val choice2 = Choice(getString(R.string.scene14node5choice2), 14, {}, Element.NEUTRAL)
            return Node(index, getString(R.string.scene14node5prompt), listOf(choice1, choice2))
        }
        if(index == 6)
        {
            val choice1 = Choice(getString(R.string.scene14node6choice1), 7, {}, Element.NEUTRAL, 18)
            val choice2 = Choice(getString(R.string.scene14node6choice2), 8,{}, Element.NEUTRAL, 18)
            val choice3 = Choice(getString(R.string.scene14node6choice3), 9, {state -> state.addScore(Element.DARK, 1)}, Element.DARK, 14)
            val choice4 = Choice(getString(R.string.scene14node6choice4), 0, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH, 18)
            val choice5 = Choice(getString(R.string.scene14node6choice5), 0, {state -> state.addScore(Element.AIR, 1)}, Element.AIR, 16)
            val choice6 = Choice(getString(R.string.scene14node6choice6),10, {state -> state.addScore(Element.DARK, 1)}, Element.DARK, 16)
            return Node(index, getString(R.string.scene14node6prompt), listOf(choice1, choice2, choice3, choice4, choice5, choice6))
        }
        if(index == 7)
        {
            val choice1 = Choice(getString(R.string.scene14node7choice1), 11, {}, Element.NEUTRAL, 20)
            val choice2 = Choice(getString(R.string.scene14node7choice2), 12, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT, 20)
            return Node(index, getString(R.string.scene14node7prompt), listOf(choice1, choice2))
        }
        if(index == 8)
        {
            val choice1 = Choice(getString(R.string.scene14node8choice1), 13, {}, Element.NEUTRAL,22)
            val choice2 = Choice(getString(R.string.scene14node8choice2), 13, {state -> state.addScore(Element.AIR)}, Element.AIR,28)
            val choice3 = Choice(getString(R.string.scene14node8choice3),13, {state -> state.addScore(Element.WATER)}, Element.WATER,28)
            return Node(index, getString(R.string.scene14node8prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 9)
        {
            val choice1 = Choice(getString(R.string.scene14node9choice1), 7,20)
            val choice2 = Choice(getString(R.string.scene14node9choice2),8,20)
            val choice3 = Choice(getString(R.string.scene14node9choice3),0,20)
            return Node(index, getString(R.string.scene14node9prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 10)
        {
            val choice1 = Choice(getString(R.string.scene14node10choice1),8, 22)
            val choice2 = Choice(getString(R.string.scene14node10choice2), 0, 25)
            return Node(index, getString(R.string.scene14node10prompt), listOf(choice1, choice2))
        }
        if(index == 11)
        {
            val choice1 = Choice(getString(R.string.scene14node11choice1), 0, 22)
            val choice2 = Choice(getString(R.string.scene14node11choice2), 15, 22)
            return Node(index, getString(R.string.scene14node11prompt), listOf(choice1, choice2))
        }
        if(index == 12)
        {
            val choice1 = Choice(getString(R.string.scene14node12choice1), 16)
            val choice2 = Choice(getString(R.string.scene14node12choice2), 17, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT)
            val choice3 = Choice(getString(R.string.scene14node12choice3),11)
            return Node(index, getString(R.string.scene14node12prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 13)
        {
            val choice1 = Choice(getString(R.string.scene14node13choice1), 0, 26)
            return Node(index, getString(R.string.scene14node13prompt), listOf(choice1))
        }
        if(index == 14)
        {
            val choice1 = Choice(getString(R.string.scene14node14choice1), 4,18)
            val choice2 = Choice(getString(R.string.scene14node14choice2),18, 20)
            val choice3 = Choice(getString(R.string.scene14node14choice3), 19,16)
            return Node(index, getString(R.string.scene14node14prompt), listOf(choice1, choice2, choice3))
        }
        if(index == 15)
        {
            val choice1 = Choice(getString(R.string.scene14node15choice1), 0, 22)
            return Node(index, getString(R.string.scene14node15prompt), listOf(choice1))
        }
        if(index == 16)
        {
            val choice1 = Choice(getString(R.string.scene14node16choice1), 11, 22)
            val choice2 = Choice(getString(R.string.scene14node16prompt), 17, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT, 16)
            return Node(index, getString(R.string.scene14node16prompt), listOf(choice1, choice2))
        }
        if(index == 17)
        {
            val choice1 = Choice(getString(R.string.scene14node17choice1), 0, 25)
            val choice2 = Choice(getString(R.string.scene14node17choice2), 15, 20)
            return Node(index, getString(R.string.scene14node17prompt), listOf(choice1, choice2))
        }
        if(index == 18)
        {
            val choice1 = Choice(getString(R.string.scene14node18choice1), 0, 25)
            return Node(index, getString(R.string.scene14node18prompt), listOf(choice1))
        }
        if(index == 19)
        {
            val choice1 = Choice(getString(R.string.scene14node19choice1), 0, 25)
            return Node(index, getString(R.string.scene14node19prompt), listOf(choice1))
        }
        throw IllegalStateException("Index: " + index + "not found in Scene14Activity.getScene14Node(");
        //@formatter:ON
    }

    override fun onBackPressed() {
        if (false) {
            super.onBackPressed()
        }
    }
}