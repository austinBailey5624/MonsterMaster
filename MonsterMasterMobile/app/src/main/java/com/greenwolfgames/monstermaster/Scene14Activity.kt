//package com.greenwolfgames.monstermaster
//
//import android.content.Intent
//import android.graphics.Color
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat
//
//class Scene14Activity : AppCompatActivity() {
//
//    var currentState = State()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_scene14_players_room_initial)
//        val extras = intent.extras
//        currentState = extras?.getSerializable("state") as State
//
//
//        val parent = findViewById<View>(R.id.Parent)
//        parent.setBackgroundColor(ContextCompat.getColor(this@Scene14Activity, R.color.darkBrown))
//
//        val buttons: List<Button> = listOf(
//            findViewById(R.id.button1),
//            findViewById(R.id.button2),
//            findViewById(R.id.button3),
//            findViewById(R.id.button4),
//            findViewById(R.id.button5),
//            findViewById(R.id.button6),
//        )
//
//        val portraitBackground: ImageView = findViewById(R.id.portrait_background)
//        val color = ContextCompat.getColor(this@Scene14Activity, R.color.brown)
//        val lessIntenseColor =
//            Color.argb(164, Color.red(color), Color.green(color), Color.blue(color))
//        portraitBackground.setColorFilter(lessIntenseColor)
//        val textBackground: ImageView = findViewById(R.id.speaker_text_background)
//        textBackground.setColorFilter(lessIntenseColor)
//        val speakerText: TextView = findViewById(R.id.speaker_text)
//        speakerText.setTextColor(ContextCompat.getColor(this@Scene14Activity, R.color.darkBrown))
//
//        if(currentState.initScene14)
//        {
//            setNode(1, buttons, currentState)
//        }
//        else
//        {
//            setNode(0, buttons, currentState)
//        }
//    }
//
//    fun setNode(node: Int, buttons: List<Button>, currentState: State) {
//        val scene14Node = getScene14Node(node)
//        val prompt = findViewById<TextView>(R.id.speaker_text)
//        prompt.text = scene14Node.prompt
//        setTextSize(prompt)
//        Utilities.orgainizeButtons(buttons, scene14Node.choices.size, findViewById(R.id.background),this@Scene14Activity, windowManager)
//        for (i in buttons.indices) {
//            if (i < scene14Node.choices.size) {
//                val choice = scene14Node.choices[i]
//                buttons[i].text = choice.text
//                buttons[i].textSize = choice.textSize.toFloat()
//                Subelement.colorButton(buttons[i], this@Scene14Activity, choice.element)
//                buttons[i].setOnClickListener {
//                    choice.stateChange(currentState)
//                    setNode(choice.nextNodeIndex, buttons, currentState)
//                }
//                buttons[i].visibility = View.VISIBLE
//            } else {
//                Utilities.hideButton(buttons[i], this@Scene14Activity)
//                buttons[i].visibility = View.GONE
//            }
//        }
//    }
//
//    private fun setTextSize(textView: TextView) {
//        val text = textView.text.toString()
//        if (text.length > 120) {
//            textView.textSize = 15f
//        } else if (text.length > 100) {
//            textView.textSize = 17f
//        } else if (text.length > 70) {
//            textView.textSize = 19f
//        } else if (text.length > 50) {
//            textView.textSize = 21f
//        } else if (text.length > 35){
//            textView.textSize = 23f
//        } else {
//            textView.textSize = 25f
//        }
//    }
//
//    private fun getScene14Node(index: Int): Node {
//        //@formatter:OFF
//        if(index == 0)
//        {
//            val portrait = findViewById<ImageView>(R.id.portrait)
//            portrait.visibility = View.GONE
//            val portrait_background = findViewById<ImageView>(R.id.portrait_background)
//            portrait_background.visibility = View.GONE
//            val actor_image = findViewById<ImageView>(R.id.actor_image)
//            actor_image.visibility = View.INVISIBLE;
//            val speaker_text_background = findViewById<ImageView>(R.id.speaker_text_background)
//            speaker_text_background.layoutParams.width = 350
//            val speaker_text = findViewById<TextView>(R.id.speaker_text)
//            speaker_text.layoutParams.width = 330
//
//            currentState.initScene14 = false
//            val choice1 = Choice(getString(R.string.scene14node0choice2), 1, {state -> val intent = Intent(this, Scene14ActivityMirror::class.java);intent.putExtra("state", currentState);startActivity(intent)}, Element.NEUTRAL, 26)
//            return Node(index, getString(R.string.scene14node0prompt), listOf(choice1))
//        }
//        if(index == 1)//scene55
//        {
//            val choice1 = Choice(getString(R.string.scene14node1choice1),scene56, {state -> state.addScore(Element.DARK, 1)}, Element.DARK, 12)
//            val choice2 = Choice(getString(R.string.scene14node1choice2),57, {state -> state.addScore(Element.WATER, 1)}, Element.WATER, 12)
//            val choice3 = Choice(getString(R.string.scene14node1choice3),58, {state -> state.addScore(Element.AIR, 1)}, Element.AIR, 12)
//            val choice4 = Choice(getString(R.string.scene14node1choice4),56, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE, 12)
//            val choice5 = Choice(getString(R.string.scene14node1choice5),58, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH, 12)
//            val choice6 = Choice(getString(R.string.scene14node1choice6),59, {}, Element.NEUTRAL,16)
//            val choices = listOf(choice1, choice2, choice3, choice4, choice5, choice6)
//            return Node(index, getString(R.string.scene14node1prompt),choices)
//        }
//        if(index == 2)56
//        {
//            val choice1 = Choice(getString(R.string.scene14node2choice1),60, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE, 18)
//            val choice2 = Choice(getString(R.string.scene14node2choice2),58, {state -> state.addScore(Element.WATER, 1)}, Element.WATER, 18)
//            val choice3 = Choice(getString(R.string.scene14node2choice3),58, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH, 18)
//            return Node(index, getString(R.string.scene14node2prompt), listOf(choice1, choice2, choice3))
//        }
//        if(index == 3)57
//        {
//            val choice1 = Choice(getString(R.string.scene14node3choice1),60, {state -> state.addScore(Element.FIRE, 1)}, Element.FIRE, 24)
//            val choice2 = Choice(getString(R.string.scene14node3choice2),58, {state -> state.addScore(Element.WATER, 1)}, Element.WATER,20)
//            val choice3 = Choice(getString(R.string.scene14node3choice3),58, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH,20)
//            return Node(index, getString(R.string.scene14node3prompt), listOf(choice1, choice2, choice3))
//        }
//        if(index == 4)58
//        {
//            val choice1 = Choice(getString(R.string.scene14node4choice1), 61, {}, Element.NEUTRAL,18)
//            val choice2 = Choice(getString(R.string.scene14node4choice2), 62, {}, Element.NEUTRAL,18)
//            val choice3 = Choice(getString(R.string.scene14node4choice3), 63, {state -> state.addScore(Element.DARK,1)}, Element.DARK,14)
//            val choice4 = Choice(getString(R.string.scene14node4choice4), 0, {state -> state.addScore(Element.EARTH,1)}, Element.EARTH,18)
//            val choice5 = Choice(getString(R.string.scene14node4choice5), 0, {state -> state.addScore(Element.AIR, 1)}, Element.AIR,16)
//            return Node(index, getString(R.string.scene14node4prompt), listOf(choice1, choice2, choice3, choice4, choice5))
//        }
//        if(index == 5)59
//        {
//            val choice1 = Choice(getString(R.string.scene14node5choice1), 58, {}, Element.NEUTRAL)
//            val choice2 = Choice(getString(R.string.scene14node5choice2), 68, {}, Element.NEUTRAL)
//            return Node(index, getString(R.string.scene14node5prompt), listOf(choice1, choice2))
//        }
//        if(index == 6)60
//        {
//            val choice1 = Choice(getString(R.string.scene14node6choice1), 61, {}, Element.NEUTRAL, 18)
//            val choice2 = Choice(getString(R.string.scene14node6choice2), 62,{}, Element.NEUTRAL, 18)
//            val choice3 = Choice(getString(R.string.scene14node6choice3), 63, {state -> state.addScore(Element.DARK, 1)}, Element.DARK, 14)
//            val choice4 = Choice(getString(R.string.scene14node6choice4), 0, {state -> state.addScore(Element.EARTH, 1)}, Element.EARTH, 18)
//            val choice5 = Choice(getString(R.string.scene14node6choice5), 0, {state -> state.addScore(Element.AIR, 1)}, Element.AIR, 16)
//            val choice6 = Choice(getString(R.string.scene14node6choice6), 64, {state -> state.addScore(Element.DARK, 1)}, Element.DARK, 16)
//            return Node(index, getString(R.string.scene14node6prompt), listOf(choice1, choice2, choice3, choice4, choice5, choice6))
//        }
//        if(index == 7)61
//        {
//            val choice1 = Choice(getString(R.string.scene14node7choice1), 65, {}, Element.NEUTRAL, 20)
//            val choice2 = Choice(getString(R.string.scene14node7choice2), 66, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT, 20)
//            return Node(index, getString(R.string.scene14node7prompt), listOf(choice1, choice2))
//        }
//        if(index == 8)62
//        {
//            val choice1 = Choice(getString(R.string.scene14node8choice1), 67, {}, Element.NEUTRAL,22)
//            val choice2 = Choice(getString(R.string.scene14node8choice2), 67, {state -> state.addScore(Element.AIR)}, Element.AIR,28)
//            val choice3 = Choice(getString(R.string.scene14node8choice3), 67, {state -> state.addScore(Element.WATER)}, Element.WATER,28)
//            return Node(index, getString(R.string.scene14node8prompt), listOf(choice1, choice2, choice3))
//        }
//        if(index == 9)63
//        {
//            val choice1 = Choice(getString(R.string.scene14node9choice1),61,20)
//            val choice2 = Choice(getString(R.string.scene14node9choice2),62,20)
//            val choice3 = Choice(getString(R.string.scene14node9choice3),62,20)
//            return Node(index, getString(R.string.scene14node9prompt), listOf(choice1, choice2, choice3))
//        }
//        if(index == 10)64
//        {
//            val choice1 = Choice(getString(R.string.scene14node10choice1),62, 22)
//            val choice2 = Choice(getString(R.string.scene14node10choice2), 0, 25)
//            return Node(index, getString(R.string.scene14node10prompt), listOf(choice1, choice2))
//        }
//        if(index == 11)65
//        {
//            val choice1 = Choice(getString(R.string.scene14node11choice1), 0, 22)
//            val choice2 = Choice(getString(R.string.scene14node11choice2), 69, 22)
//            return Node(index, getString(R.string.scene14node11prompt), listOf(choice1, choice2))
//        }
//        if(index == 12)66
//        {
//            val choice1 = Choice(getString(R.string.scene14node12choice1), 70)
//            val choice2 = Choice(getString(R.string.scene14node12choice2), 71, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT)
//            val choice3 = Choice(getString(R.string.scene14node12choice3), 65)
//            return Node(index, getString(R.string.scene14node12prompt), listOf(choice1, choice2, choice3))
//        }
//        if(index == 13)67
//        {
//            val choice1 = Choice(getString(R.string.scene14node13choice1), 0, 26)
//            return Node(index, getString(R.string.scene14node13prompt), listOf(choice1))
//        }
//        if(index == 14)68
//        {
//            val choice1 = Choice(getString(R.string.scene14node14choice1), 58,18)
//            val choice2 = Choice(getString(R.string.scene14node14choice2), 72, 20)
//            val choice3 = Choice(getString(R.string.scene14node14choice3), 73,16)
//            return Node(index, getString(R.string.scene14node14prompt), listOf(choice1, choice2, choice3))
//        }
//        if(index == 15)69
//        {
//            val choice1 = Choice(getString(R.string.scene14node15choice1), 0, 22)
//            return Node(index, getString(R.string.scene14node15prompt), listOf(choice1))
//        }
//        if(index == 16)70
//        {
//            val choice1 = Choice(getString(R.string.scene14node16choice1), 65, 22)
//            val choice2 = Choice(getString(R.string.scene14node16prompt), 71, {state -> state.addScore(Element.LIGHT)}, Element.LIGHT, 16)
//            return Node(index, getString(R.string.scene14node16prompt), listOf(choice1, choice2))
//        }
//        if(index == 17)71
//        {
//            val choice1 = Choice(getString(R.string.scene14node17choice1), 0, 25)
//            val choice2 = Choice(getString(R.string.scene14node17choice2), 69, 20)
//            return Node(index, getString(R.string.scene14node17prompt), listOf(choice1, choice2))
//        }
//        if(index == 18)72
//        {
//            val choice1 = Choice(getString(R.string.scene14node18choice1), 0, 25)
//            return Node(index, getString(R.string.scene14node18prompt), listOf(choice1))
//        }
//        if(index == 19)73
//        {
//            val choice1 = Choice(getString(R.string.scene14node19choice1), 0, 25)
//            return Node(index, getString(R.string.scene14node19prompt), listOf(choice1))
//        }
//        throw IllegalStateException("Index: " + index + "not found in Scene14Activity.getScene14Node(");
//        //@formatter:ON
//    }
//
//    override fun onBackPressed() {
//        if (false) {
//            super.onBackPressed()
//        }
//    }
//}