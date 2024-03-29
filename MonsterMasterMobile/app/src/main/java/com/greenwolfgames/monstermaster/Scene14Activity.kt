package com.greenwolfgames.monstermaster

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene14Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene14_players_room_initial)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val parent= findViewById<ImageView>(R.id.Parent)
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
        val lessIntenseColor = Color.argb(164,Color.red(color), Color.green(color),Color.blue(color))
        portrait_background.setColorFilter(lessIntenseColor)
        val textBackground: ImageView = findViewById(R.id.speaker_text_background)
        textBackground.setColorFilter(lessIntenseColor)
    }

    fun getScene14Node(index: Int): Scene14Node
    {
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
        throw IllegalStateException("Index" + index + "not found in Scene14Activity.getScene14Node(");
    }

    override fun onBackPressed() {
        if(false)
        {
            super.onBackPressed()
        }
    }
}