package com.greenwolfgames.monstermaster

import android.content.Context
import android.graphics.Color
import android.widget.Button
import androidx.core.content.ContextCompat

enum class Subelement {
    //@formatter:off
    PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE,
    STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP,
    FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN,
    PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING,
    SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION,
    DEMON,POISON,UNDEAD,STORM,BETRAYAR,UMBRAL;
    //@formatter:on

    companion object {
        fun fromString(s: String): Subelement {
            return valueOf(s)
        }

        fun colorButton(button: Button, context: Context, subelement: Subelement): Button {
            val textColor = getTextColor(subelement)
            val buttonBackgroundColor = getButtonBackgroundColor(subelement)

            button.setTextColor(
                ContextCompat.getColor(context, textColor)
            )
            button.setBackgroundColor(ContextCompat.getColor(context, buttonBackgroundColor))
            return button
        }

        fun getTextColor(subelement: Subelement): Int {
            val textColor = when (subelement) {
                PYRO, LAVA, DINO, SAND, JUSTICE, VENGEANCE -> R.color.yellowOrange
                STEAM, AQUA, AMPHIBIOUS, WEATHER, ICE -> R.color.cyan
                FEY, PLANT, TERRA, PEGASUS, COMPASSION, ROTTEN -> R.color.green
                PHOENIX, SEABREEZE, BIRD, AERO, COCKA, NIGHTWING -> R.color.yellow
                SOLAR, GUARDIAN, ANGEL, LUXOR, REDEMPTION -> R.color.white
                DEMON, POISON, UNDEAD, STORM, BETRAYAR, UMBRAL -> R.color.black
                LUNAR -> R.color.lightCyan
                DEEP -> R.color.lightishBlue
            }
            return textColor
        }

        fun getButtonBackgroundColor(subelement: Subelement): Int {
            val backgroundColor = when (subelement) {
                PYRO, LAVA, DINO, SAND, JUSTICE, VENGEANCE -> R.color.red
                STEAM, AQUA, AMPHIBIOUS, WEATHER, ICE, DEEP -> R.color.blue
                FEY, PLANT, TERRA, PEGASUS, COMPASSION, ROTTEN -> R.color.forestGreen
                PHOENIX, SEABREEZE, BIRD, AERO, COCKA, NIGHTWING -> R.color.brown
                GUARDIAN, ANGEL, LUXOR, REDEMPTION -> R.color.whiteGray
                POISON, UNDEAD, STORM, BETRAYAR, UMBRAL -> R.color.gray
                SOLAR -> R.color.pink
                LUNAR -> R.color.lightishBlue
                DEMON -> R.color.red
                DEEP -> R.color.black
            }
            return backgroundColor
        }

        fun getBackgroundColor(subelement: Subelement): Int {

            return R.color.black;

        }
    }
}