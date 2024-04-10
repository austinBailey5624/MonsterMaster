package com.greenwolfgames.monstermaster

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Scene14ActivityMirror : AppCompatActivity() {

    var currentState = State()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene14_mirror)
        val extras = intent.extras
        currentState = extras?.getSerializable("state") as State


        val parent = findViewById<View>(R.id.Parent)
        parent.setBackgroundColor(ContextCompat.getColor(this@Scene14ActivityMirror, R.color.darkBrown))

        val buttons: List<Button> = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
        )

        val color = ContextCompat.getColor(this@Scene14ActivityMirror, R.color.brown)
        val lessIntenseColor =
            Color.argb(164, Color.red(color), Color.green(color), Color.blue(color))
        val textBackground: ImageView = findViewById(R.id.speaker_text_background)
        textBackground.setColorFilter(lessIntenseColor)
        val speakerText: TextView = findViewById(R.id.speaker_text)
        speakerText.setTextColor(ContextCompat.getColor(this@Scene14ActivityMirror, R.color.darkBrown))

        setPortraitFromState()

        val node = getNode()
        val prompt = findViewById<TextView>(R.id.speaker_text)
//        prompt.text = node.prompt
        setTextSize(prompt)
        Utilities.orgainizeButtons(buttons, node.choices.size, findViewById(R.id.invisible_button_aligner),this@Scene14ActivityMirror, windowManager)
        for (i in buttons.indices) {
            if (i < node.choices.size) {
                val choice = node.choices[i]
                buttons[i].text = choice.text
                buttons[i].textSize = choice.textSize.toFloat()
                Subelement.colorButton(buttons[i], this@Scene14ActivityMirror, choice.element)
                buttons[i].setOnClickListener {
                    choice.stateChange(currentState)
                }
                buttons[i].visibility = View.VISIBLE
            } else {
                Utilities.hideButton(buttons[i], this@Scene14ActivityMirror)
                buttons[i].visibility = View.GONE
            }
        }
    }

    private fun setPortraitFromState()
    {
        val playerAvatar: ImageView = findViewById(R.id.playerAvatar)
        //@formatter:OFF
        if(currentState.portrait == PlayerPortrait.UNASSIGNED || currentState.portrait == PlayerPortrait.BROWN_HAIR_MALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror,R.drawable.main_character_brown_hair_male))
        }
        else if(currentState.portrait == PlayerPortrait.BROWN_HAIR_FEMALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_brown_hair_female))
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_MALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_blonde_hair_male))
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_FEMALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_blonde_hair_female))
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_MALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_black_hair_male))
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_FEMALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_black_hair_female))
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_MALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_asian_male))
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_FEMALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_asian_female))
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_MALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_black_male))
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_FEMALE)
        {
            playerAvatar.setImageDrawable(ContextCompat.getDrawable(this@Scene14ActivityMirror, R.drawable.main_character_black_female))
        }
        else
        {
            throw IllegalStateException("Portrait not assigned correctly.")
        }
        //@formatter:ON
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

    private fun getNode(): Node
    { //@formatter:OFF
        val choice1 = Choice(getString(R.string.scene14mirror_change_avatar),0,{state -> changePortraitLeft()},Subelement.NEUTRAL, 18)
        val choice2 = Choice(getString(R.string.scene14mirror_change_pronouns),0,{state -> changePronouns()}, Subelement.NEUTRAL, 18)
        val choice3 = Choice(getString(R.string.scene14mirror_back),0,{state -> backButtonPressed()},Subelement.NEUTRAL, 26)
        val choice4 = Choice(getString(R.string.scene14mirror_change_avatar),0,{state -> changePortraitRight()},Subelement.NEUTRAL, 18)
        val choice5 = Choice(getString(R.string.scene14mirror_change_gender),0,{state -> changePortraitGender()},Subelement.NEUTRAL, 18)
        return Node(0,"", listOf(choice1,choice2,choice3,choice4,choice5))
        //@formatter:ON
    }

    private fun backButtonPressed()
    {
        if(currentState.portrait == PlayerPortrait.UNASSIGNED)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_MALE
        }
        currentState.initScene14 = false
        val intent = Intent(this, Scene14Activity::class.java)
        intent.putExtra("state", currentState)
        startActivity(intent)
    }

    private fun changePortraitLeft()
    {
        if(currentState.portrait == PlayerPortrait.UNASSIGNED || currentState.portrait == PlayerPortrait.BROWN_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BLONDE_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.ASIAN_MALE
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_MALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_MALE)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BROWN_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLONDE_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.ASIAN_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_FEMALE
        }
        else
        {
            throw IllegalStateException("Portrait not assigned correctly on Left Button Push.")
        }
        setPortraitFromState()
    }

    private fun changePortraitRight()
    {
        if(currentState.portrait == PlayerPortrait.UNASSIGNED || currentState.portrait == PlayerPortrait.BROWN_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_MALE
        }
        else if(currentState.portrait  == PlayerPortrait.BLACK_MALE)
        {
            currentState.portrait = PlayerPortrait.ASIAN_MALE
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_MALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BLONDE_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_FEMALE)
        {
            currentState.portrait = PlayerPortrait.ASIAN_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLONDE_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BROWN_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_FEMALE
        }
        else
        {
            throw IllegalStateException("Portrait not Assigned correctly on Right Button Push")
        }
        setPortraitFromState()
    }

    private fun changePortraitGender()
    {
        if(currentState.portrait == PlayerPortrait.UNASSIGNED || currentState.portrait == PlayerPortrait.BROWN_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BROWN_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BROWN_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BLONDE_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLONDE_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLONDE_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_MALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_HAIR_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_HAIR_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_HAIR_MALE
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_MALE)
        {
            currentState.portrait = PlayerPortrait.ASIAN_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.ASIAN_FEMALE)
        {
            currentState.portrait = PlayerPortrait.ASIAN_MALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_MALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_FEMALE
        }
        else if(currentState.portrait == PlayerPortrait.BLACK_FEMALE)
        {
            currentState.portrait = PlayerPortrait.BLACK_MALE
        }
        else
        {
            throw IllegalStateException("Portrait not Assigned correctly on Gender Button Push. CurrentStatePortrait: ${currentState.portrait}")
        }
        setPortraitFromState()
    }

    private fun changePronouns()
    {
        var speakerText: TextView = findViewById(R.id.speaker_text)
        if (currentState.gender == Gender.MALE)
        {
            currentState.gender = Gender.FEMALE
            speakerText.setText(getString(R.string.scene14mirror_pronouns_female))
        }
        else if (currentState.gender == Gender.FEMALE)
        {
            currentState.gender = Gender.NEUTRAL
            speakerText.setText(getString(R.string.scene14mirror_pronouns_neutral))
        }
        else if (currentState.gender == Gender.NEUTRAL)
        {
            currentState.gender = Gender.MALE
            speakerText.setText(getString(R.string.scene14mirror_pronouns_male))
        }
    }
    override fun onBackPressed() {
        if (false) {
            super.onBackPressed()
        }
    }
}