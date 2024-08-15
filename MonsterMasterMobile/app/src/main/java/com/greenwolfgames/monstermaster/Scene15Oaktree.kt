package com.greenwolfgames.monstermaster

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene15Oaktree : AppCompatActivity()
{
    var currentState = State()

    override fun onCreate( savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene15_oaktree)
        currentState = intent.getSerializableExtra("state") as State

        val parent = findViewById<View>(R.id.Parent)
        parent.setBackgroundColor(ContextCompat.getColor(this@Scene15Oaktree, R.color.darkBrown))

        val buttons: List<Button> = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
        )

        val color = ContextCompat.getColor(this@Scene15Oaktree, R.color.brown)
        val lessIntenseColor =
            Color.argb(164, Color.red(color), Color.green(color), Color.blue(color))
        val textBackground: ImageView = findViewById(R.id.speaker_text_background)
        textBackground.setColorFilter(lessIntenseColor)
        val speakerText: TextView = findViewById(R.id.speaker_text)
        speakerText.setTextColor(ContextCompat.getColor(this@Scene15Oaktree, R.color.darkBrown))
        setNode(0, buttons, currentState)
    }

    fun setNode(node: Int, buttons: List<Button>, currentState: State) {
        val scene15Node = getScene15Node(node)
        val prompt = findViewById<TextView>(R.id.speaker_text)
        prompt.text = scene15Node.prompt
        setTextSize(prompt)
        Utilities.orgainizeButtons(buttons, scene15Node.choices.size, findViewById(R.id.background),this@Scene15Oaktree, windowManager)
        for (i in buttons.indices) {
            if (i < scene15Node.choices.size) {
                val choice = scene15Node.choices[i]
                buttons[i].text = choice.text
                buttons[i].textSize = choice.textSize.toFloat()
                Subelement.colorButton(buttons[i], this@Scene15Oaktree, choice.element)
                buttons[i].setOnClickListener {
                    choice.stateChange(currentState)
                    setNode(choice.nextNodeIndex, buttons, currentState)
                }
                buttons[i].visibility = View.VISIBLE
            } else {
                Utilities.hideButton(buttons[i], this@Scene15Oaktree)
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

    private fun getScene15Node(index: Int): Node {
        //@formatter:OFF
        if(index == 0)
        {
            val choice1 = Choice(getString(R.string.scene15node1choice1), 0, {}, Element.NEUTRAL, 20)
            val choice2 = Choice(getString(R.string.scene15node1choice2), 0, {}, Element.NEUTRAL, 20)
            val choice3 = Choice(getString(R.string.scene15node1choice3), 0, {}, Element.NEUTRAL, 20)
            val choice4 = Choice(getString(R.string.scene15node1choice4), 0, {}, Element.NEUTRAL, 20)
            val choice5 = Choice(getString(R.string.scene15node1choice5),0,{}, Element.NEUTRAL, 20)
            return Node(index, getString(R.string.scene15node1prompt), listOf(choice1, choice2, choice3, choice4, choice5))
        }
        throw IllegalStateException("Index: $index not found in scene15Oaktree.getScene15Node")
    }
}
