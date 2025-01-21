package com.greenwolfgames.monstermaster

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import androidx.core.content.ContextCompat

/**
 * Enum to help organize elements and so element specific variables can be retrieved
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright Austin Bailey 2024 All Rights Reserved
 */
enum class Element {
    //@formatter:off
    PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE,
    STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP,
    FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN,
    PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING,
    SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION,
    DEMON,POISON,UNDEAD,STORM,BETRAYER,UMBRAL,
    NEUTRAL, PHYSICAL, MAGICAL, INITIAL;
    //@formatter:on

    companion object
    {
        fun colorButton(button: Button, context: Context, element: Element): Button
        {
            button.backgroundTintList = null
            button.setBackgroundResource(0)
            button.background = null
            val textColor = getTextColor(element)
            val borderedShape = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                setColor(ContextCompat.getColor(context, getButtonBackgroundColor(element)))
                setStroke(10, ContextCompat.getColor(context, textColor))
                cornerRadius = 40f
            }
            button.elevation = 0f
            button.background = borderedShape
            button.setTextColor(
                ContextCompat.getColor(context, textColor)
            )

            return button
        }

        fun getTextColor(element: Element): Int {
            return when (element) {
                PYRO -> R.color.yellowOrange
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
                AERO -> R.color.darkishYellow
                COCKA -> R.color.darkYellow
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
                INITIAL -> R.color.gray
            }
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
                AERO -> R.color.yellow
                COCKA -> R.color.white
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
                INITIAL -> R.color.grayerWhite
            }
            return backgroundColor
        }

        fun getBackgroundColor(element: Element): Int{

            val backgroundColor = when(element)
            {
                PYRO -> R.color.darkRed
                LAVA -> R.color.purple
                DINO -> R.color.brown
                SAND -> R.color.pink
                JUSTICE -> R.color.pink
                VENGEANCE -> R.color.darkRed

                STEAM -> R.color.lightBlue
                AQUA -> R.color.darkerBlue
                AMPHIBIOUS -> R.color.darkCyan
                WEATHER -> R.color.darkCyan
                ICE -> R.color.lightCyanBlue
                DEEP -> R.color.darkerPurple

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
                COCKA -> R.color.yellow
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
                INITIAL -> R.color.darkGray
            }
            return backgroundColor
        }

        fun getInfantMonster(context: Context, element: Element): MonsterType
        {
            val infantMonster = when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 1)
                LAVA -> MonsterTypeManager.getMonsterType(context, 13)
                DINO -> MonsterTypeManager.getMonsterType(context, 23)
                SAND -> MonsterTypeManager.getMonsterType(context, 33)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 43)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 50)

                STEAM -> MonsterTypeManager.getMonsterType(context, 57)
                AQUA -> MonsterTypeManager.getMonsterType(context, 64)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 76)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 86)
                ICE -> MonsterTypeManager.getMonsterType(context, 96)
                DEEP -> MonsterTypeManager.getMonsterType(context, 108)

                FEY -> MonsterTypeManager.getMonsterType(context, 120)
                PLANT -> MonsterTypeManager.getMonsterType(context, 130)
                TERRA -> MonsterTypeManager.getMonsterType(context, 140)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 154)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 161)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 168)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 178)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 185)
                BIRD -> MonsterTypeManager.getMonsterType(context, 192)
                AERO -> MonsterTypeManager.getMonsterType(context, 199)
                COCKA -> MonsterTypeManager.getMonsterType(context, 211)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 221)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 231)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 241)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 248)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 255)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 262)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 274)

                DEMON -> MonsterTypeManager.getMonsterType(context, 284)
                POISON -> MonsterTypeManager.getMonsterType(context, 294)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 304)
                STORM -> MonsterTypeManager.getMonsterType(context, 311)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 321)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 328)

                NEUTRAL -> throw IllegalStateException("Element Neutral has no infant monster")
                MAGICAL -> throw IllegalStateException("Element Magical has no infant monster")
                PHYSICAL -> throw IllegalStateException("Element Physical has no infant monster")
                INITIAL -> throw IllegalStateException("Element Initial has no infant monster")
            }
            return infantMonster
        }
    }
}