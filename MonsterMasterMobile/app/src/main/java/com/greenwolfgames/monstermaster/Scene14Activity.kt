package com.greenwolfgames.monstermaster

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        val portrait_background: ImageView = findViewById(R.id.portrait_background)
        val color = ContextCompat.getColor(this@Scene14Activity, R.color.brown)
        val lessIntenseColor =
            Color.argb(164, Color.red(color), Color.green(color), Color.blue(color))
        portrait_background.setColorFilter(lessIntenseColor)
        val textBackground: ImageView = findViewById(R.id.speaker_text_background)
        textBackground.setColorFilter(lessIntenseColor)

        setNode(1, buttons, currentState)
    }

    fun setNode(node: Int, buttons: List<Button>, currentState: State)
    {
        val scene14Node = getScene14Node(node)
        val prompt = findViewById<TextView>(R.id.speaker_text)
        prompt.text = scene14Node.prompt
        for(i in 0 until buttons.size)
        {
            if(i < scene14Node.choices.size)
            {
                val choice = scene14Node.choices[i]
                buttons[i].text = choice.text
                Element.colorButton(buttons[i], this@Scene14Activity, choice.element)
                buttons[i].setOnClickListener {
                    choice.stateChange(currentState)
                    setNode(choice.nextNodeIndex, buttons, currentState)
                }
            }
            else
            {
                Utilities.hideButton(buttons[i], this@Scene14Activity)
            }
        }
    }

    fun getScene14Node(index: Int): Scene14Node {
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
            val choice2 = Scene14Choice(getString(R.string.scene14node8choice2), 12, {state -> state.addScore(Element.AIR)}, Element.AIR)
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