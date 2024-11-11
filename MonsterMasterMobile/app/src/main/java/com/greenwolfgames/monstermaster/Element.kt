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
                PYRO -> R.color.orange
                LAVA -> R.color.orange
                DINO -> R.color.darkBrown
                SAND -> R.color.redOrange
                JUSTICE -> R.color.lightPink
                VENGEANCE -> R.color.black

                STEAM -> R.color.pink
                AQUA -> R.color.cyan
                AMPHIBIOUS -> R.color.green
                WEATHER -> R.color.yellow
                ICE -> R.color.white
                DEEP -> R.color.purple

                FEY -> R.color.forestGreen
                PLANT -> R.color.green
                TERRA -> R.color.green
                PEGASUS -> R.color.yellow
                COMPASSION -> R.color.lighterGreen
                ROTTEN -> R.color.forestGreen

                PHOENIX -> R.color.yellowOrange
                SEABREEZE -> R.color.lightCyanBlue
                BIRD -> R.color.forestGreen
                AERO -> R.color.yellow
                COCKA -> R.color.white
                NIGHTWING -> R.color.black

                SOLAR -> R.color.yellow
                LUNAR -> R.color.lighterBlue
                GUARDIAN -> R.color.lighterGreen
                ANGEL -> R.color.yellow
                LUXOR -> R.color.white
                REDEMPTION -> R.color.whiteGray

                DEMON -> R.color.red
                POISON -> R.color.green
                UNDEAD -> R.color.lightGreen
                STORM -> R.color.yellow
                BETRAYER -> R.color.grayerWhite
                UMBRAL -> R.color.black

                NEUTRAL -> R.color.darkBrown
                PHYSICAL -> R.color.darkGray
                MAGICAL -> R.color.darkPurple
            }
            return textColor
        }

        fun getButtonBackgroundColor(element: Element): Int {
            val backgroundColor = when (element) {

                PYRO -> R.color.red
                LAVA -> R.color.lightBlue
                DINO -> R.color.lightBrown
                SAND -> R.color.lightBrown
                JUSTICE -> R.color.red
                VENGEANCE -> R.color.red

                STEAM -> R.color.lightishBlue
                AQUA -> R.color.lightBlue
                AMPHIBIOUS -> R.color.darkerBlue
                WEATHER -> R.color.cyan
                ICE -> R.color.blue
                DEEP -> R.color.darkPurple

                FEY -> R.color.darkRed
                PLANT -> R.color.blue
                TERRA -> R.color.forestGreen
                PEGASUS -> R.color.green
                COMPASSION -> R.color.lightGreen
                ROTTEN -> R.color.black

                PHOENIX -> R.color.redOrange
                SEABREEZE -> R.color.lighterBlue
                BIRD -> R.color.greenYellow
                AERO -> R.color.darkYellow
                COCKA -> R.color.yellow
                NIGHTWING -> R.color.yellow

                SOLAR -> R.color.red
                LUNAR -> R.color.blue
                GUARDIAN -> R.color.lightGreen
                ANGEL -> R.color.darkYellow
                LUXOR -> R.color.whiteGray
                REDEMPTION -> R.color.black

                DEMON -> R.color.black
                POISON -> R.color.darkBlue
                UNDEAD -> R.color.darkerGreen
                STORM -> R.color.darkYellow
                BETRAYER -> R.color.darkishGray
                UMBRAL -> R.color.darkishGray

                NEUTRAL -> R.color.brown
                MAGICAL -> R.color.pink
                PHYSICAL -> R.color.gray
            }
            return backgroundColor
        }

        fun getBackgroundColor(element: Element): Int{

            val backgroundColor = when(element)
            {
                PYRO -> R.color.darkRed
                LAVA -> R.color.purple
                DINO -> R.color.darkBrown
                SAND -> R.color.pink
                JUSTICE -> R.color.pink
                VENGEANCE -> R.color.darkRed

                STEAM -> R.color.lightBlue
                AQUA -> R.color.darkerBlue
                AMPHIBIOUS -> R.color.darkCyan
                WEATHER -> R.color.darkCyan
                ICE -> R.color.lightCyanBlue
                DEEP -> R.color.pink

                FEY -> R.color.brown
                PLANT -> R.color.darkCyan
                TERRA -> R.color.lightGreen
                PEGASUS -> R.color.greenYellow
                COMPASSION -> R.color.green
                ROTTEN -> R.color.darkerGreen

                PHOENIX -> R.color.red
                SEABREEZE -> R.color.lightBlue
                BIRD -> R.color.yellow
                AERO -> R.color.lighterYellow
                COCKA -> R.color.darkYellow
                NIGHTWING -> R.color.darkYellow

                SOLAR -> R.color.orange
                LUNAR -> R.color.darkerBlue
                GUARDIAN -> R.color.green
                ANGEL -> R.color.lighterYellow
                LUXOR -> R.color.grayerWhite
                REDEMPTION -> R.color.darkishGray

                DEMON -> R.color.darkRed
                POISON -> R.color.darkerBlue
                UNDEAD -> R.color.black
                STORM -> R.color.darkishGray
                BETRAYER -> R.color.darkerGray
                UMBRAL -> R.color.gray

                NEUTRAL -> R.color.beige
                MAGICAL -> R.color.purple
                PHYSICAL -> R.color.grayerWhite
            }
            return backgroundColor
        }
    }
}