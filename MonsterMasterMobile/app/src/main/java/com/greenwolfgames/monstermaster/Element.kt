package com.greenwolfgames.monstermaster

import android.content.Context
import android.widget.Button
import androidx.core.content.ContextCompat

enum class Element {
    //@formatter:off
    PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE,
    STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP,
    FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN,
    PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING,
    SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION,
    DEMON,POISON,UNDEAD,STORM,BETRAYER,UMBRAL,
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
                SAND-> R.color.yellowOrange
                LAVA -> R.color.darkPurple
                PYRO -> R.color.orange
                JUSTICE -> R.color.white
                DINO -> R.color.brown
                STEAM, AQUA, AMPHIBIOUS-> R.color.cyan
                WEATHER -> R.color.yellow
                ICE -> R.color.lighterBlue
                TERRA, COMPASSION, ROTTEN -> R.color.green
                PEGASUS -> R.color.yellowOrange
                FEY -> R.color.redOrange
                PLANT -> R.color.cyan
                SEABREEZE, BIRD, AERO, NIGHTWING -> R.color.yellow
                COCKA -> R.color.white
                PHOENIX -> R.color.yellowOrange
                LUXOR -> R.color.white
                GUARDIAN -> R.color.lighterGreen
                REDEMPTION -> R.color.gray
                ANGEL -> R.color.lightYellow
                UMBRAL -> R.color.black
                DEMON -> R.color.darkRed
                POISON -> R.color.forestGreen
                BETRAYER -> R.color.darkGray
                UNDEAD -> R.color.forestGreen
                STORM -> R.color.yellowOrange
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
                PYRO-> R.color.red
                LAVA -> R.color.purple
                DINO -> R.color.darkBrown
                SAND -> R.color.redOrange
                JUSTICE -> R.color.pink
                AQUA, WEATHER, ICE -> R.color.blue
                STEAM -> R.color.redOrange
                AMPHIBIOUS -> R.color.green
                FEY, PLANT, TERRA, PEGASUS -> R.color.forestGreen
                COMPASSION -> R.color.lighterGreen
                ROTTEN -> R.color.darkerGreen
                AERO-> R.color.brown
                NIGHTWING -> R.color.faintYellow
                SEABREEZE -> R.color.lightCyanBlue
                BIRD -> R.color.green
                COCKA -> R.color.yellow
                PHOENIX -> R.color.orange
                ANGEL, LUXOR, REDEMPTION -> R.color.whiteGray
                GUARDIAN -> R.color.green
                POISON -> R.color.darkerGreen
                UMBRAL -> R.color.darkerGray
                BETRAYER -> R.color.darkishGray
                UNDEAD -> R.color.faintGreen
                STORM -> R.color.darkYellow
                SOLAR -> R.color.pink
                LUNAR -> R.color.lightishBlue
                DEMON -> R.color.red
                DEEP-> R.color.faintPurple
                VENGEANCE -> R.color.faintRed
                NEUTRAL -> R.color.brown
                PHYSICAL -> R.color.whiteGray
                MAGICAL -> R.color.purple
            }
            return backgroundColor
        }
    }
}