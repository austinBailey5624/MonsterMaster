package com.greenwolfgames.monstermaster

import android.content.Context
import android.graphics.Color
import android.widget.Button
import androidx.core.content.ContextCompat

enum class Element {
    //@formatter:off
    PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE,
    STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP,
    FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN,
    PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING,
    SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION,
    DEMON,POISON,UNDEAD,STORM,BETRAYAR,UMBRAL,
    NEUTRAL, PHYSICAL, MAGICAL;
    //@formatter:on

    companion object {
        fun fromString(s: String): Element {
            return valueOf(s)
        }

        fun colorButton(button: Button, context: Context, element: Element): Button {
            val textColor = getTextColor(element)
            val buttonBackgroundColor = getButtonBackgroundColor(element)

            button.setTextColor(
                ContextCompat.getColor(context, textColor)
            )
            button.setBackgroundColor(ContextCompat.getColor(context, buttonBackgroundColor))
            return button
        }

        fun getTextColor(element: Element): Int {
            val textColor = when (element) {
                PYRO, LAVA, DINO, SAND, JUSTICE -> R.color.yellowOrange
                STEAM, AQUA, AMPHIBIOUS, WEATHER, ICE -> R.color.cyan
                FEY, PLANT, TERRA, PEGASUS, COMPASSION, ROTTEN -> R.color.green
                PHOENIX, SEABREEZE, BIRD, AERO, COCKA, NIGHTWING -> R.color.yellow
                GUARDIAN, ANGEL, LUXOR, REDEMPTION -> R.color.white
                DEMON, POISON, UNDEAD, STORM, BETRAYAR, UMBRAL -> R.color.black
                SOLAR -> R.color.lightPink
                VENGEANCE -> R.color.red
                LUNAR -> R.color.lightCyan
                DEEP -> R.color.lightishBlue
                NEUTRAL -> R.color.darkBrown
                PHYSICAL -> R.color.darkGray
                MAGICAL -> R.color.darkPurple
            }
            return textColor
        }

        fun getButtonBackgroundColor(element: Element): Int {
            val backgroundColor = when (element) {
                PYRO, LAVA, DINO, SAND, JUSTICE -> R.color.red
                STEAM, AQUA, AMPHIBIOUS, WEATHER, ICE -> R.color.blue
                FEY, PLANT, TERRA, PEGASUS, COMPASSION, ROTTEN -> R.color.forestGreen
                PHOENIX, SEABREEZE, BIRD, AERO, COCKA, NIGHTWING -> R.color.brown
                GUARDIAN, ANGEL, LUXOR, REDEMPTION -> R.color.whiteGray
                POISON, UNDEAD, STORM, BETRAYAR, UMBRAL -> R.color.gray
                SOLAR -> R.color.pink
                LUNAR -> R.color.lightishBlue
                DEMON -> R.color.red
                DEEP, VENGEANCE -> R.color.black
                NEUTRAL -> R.color.brown
                PHYSICAL -> R.color.whiteGray
                MAGICAL -> R.color.purple
            }
            return backgroundColor
        }

//        fun getBackgroundColor(element:Element)
    }
}