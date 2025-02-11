package com.greenwolfgames.monstermaster

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import androidx.core.content.ContextCompat

/**
 * Enum to help organize elements and so element specific variables can be retrieved
 * @Author: Austin Bailey
 * @Year: 2024-2025
 *
 * @Copyright Austin Bailey 2024-2025 All Rights Reserved
 */
enum class Element
{
    //@formatter:off
    PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE,
    STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP,
    FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN,
    PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING,
    SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION,
    DEMON,POISON,UNDEAD,STORM,BETRAYER,UMBRAL,
    NEUTRAL, PHYSICAL, MAGICAL, INITIAL;


    companion object
    {
        fun getAllColoredElements(): List<Element>
        {
            return listOf(PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE,
                STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP,
                FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN,
                PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING,
                SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION,
                DEMON,POISON,UNDEAD,STORM,BETRAYER,UMBRAL)
        }

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
                SAND -> R.color.darkRed
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
                ANGEL -> R.color.darkYellow
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
             return when (element)
             {
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
                ANGEL -> R.color.yellow
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
        }

        fun getBackgroundColor(element: Element): Int
        {
            return when(element)
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
        }

        fun getMatchingPrimaryNature(nature: Nature): List<Element>
        {
            return when(nature)
            {
                Nature.FIRE -> listOf(PYRO,LAVA,DINO,SAND,JUSTICE,VENGEANCE)
                Nature.WATER -> listOf(STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP)
                Nature.EARTH -> listOf(FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN)
                Nature.AIR -> listOf(PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING)
                Nature.LIGHT -> listOf(SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION)
                Nature.DARKNESS -> listOf(DEMON,POISON,UNDEAD,STORM,BETRAYER,UMBRAL)
            }
        }

        fun getMatchingSecondaryNature(nature: Nature): List<Element>
        {
            return when(nature)
            {
                Nature.FIRE -> listOf(PYRO,STEAM,FEY,PHOENIX,SOLAR,DEMON)
                Nature.WATER -> listOf(LAVA,AQUA,PLANT,SEABREEZE,LUNAR,POISON)
                Nature.EARTH -> listOf(DINO,AMPHIBIOUS,TERRA,BIRD,GUARDIAN,UNDEAD)
                Nature.AIR -> listOf(SAND,WEATHER,PEGASUS,AERO,ANGEL,STORM)
                Nature.LIGHT -> listOf(JUSTICE,ICE,COMPASSION,COCKA,LUXOR,BETRAYER)
                Nature.DARKNESS -> listOf(VENGEANCE,DEEP,ROTTEN,NIGHTWING,REDEMPTION,UMBRAL)
            }
        }
        //@formatter:on
        fun getPrimaryNature(element: Element): Nature
        {
            return when(element)
            {
                PYRO, LAVA, DINO, SAND, JUSTICE, VENGEANCE -> Nature.FIRE
                STEAM,AQUA,AMPHIBIOUS,WEATHER,ICE,DEEP -> Nature.WATER
                FEY,PLANT,TERRA,PEGASUS,COMPASSION,ROTTEN -> Nature.EARTH
                PHOENIX,SEABREEZE,BIRD,AERO,COCKA,NIGHTWING -> Nature.AIR
                SOLAR,LUNAR,GUARDIAN,ANGEL,LUXOR,REDEMPTION -> Nature.LIGHT
                DEMON,POISON,UNDEAD,STORM,BETRAYER,UMBRAL -> Nature.DARKNESS
                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has no nature")
            }
        }

        fun getSecondaryNature(element: Element): Nature
        {
            return when(element)
            {
                PYRO,STEAM,FEY,PHOENIX,SOLAR,DEMON -> Nature.FIRE
                LAVA,AQUA,PLANT,SEABREEZE,LUNAR,POISON -> Nature.WATER
                DINO,AMPHIBIOUS,TERRA,BIRD,GUARDIAN,UNDEAD -> Nature.EARTH
                SAND,WEATHER,PEGASUS,AERO,ANGEL,STORM -> Nature.AIR
                JUSTICE,ICE,COMPASSION,COCKA,LUXOR,BETRAYER -> Nature.LIGHT
                VENGEANCE,DEEP,ROTTEN,NIGHTWING,REDEMPTION,UMBRAL -> Nature.DARKNESS
                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has no nature")
            }
        }

        fun getSymbol(element: Element): Int //returns a image resource Id
        {
            return when(element)
            {
                PYRO -> R.drawable.element_pyro
                LAVA -> R.drawable.element_lava
                DINO -> R.drawable.element_dino
                SAND -> R.drawable.element_sand
                JUSTICE -> R.drawable.element_justice
                VENGEANCE -> R.drawable.element_vengeance

                STEAM -> R.drawable.element_steam
                AQUA -> R.drawable.element_aqua
                AMPHIBIOUS -> R.drawable.element_amphibious
                WEATHER -> R.drawable.element_weather
                ICE -> R.drawable.element_ice
                DEEP -> R.drawable.element_deep

                FEY -> R.drawable.element_fey
                PLANT -> R.drawable.element_plant
                TERRA -> R.drawable.element_terra
                PEGASUS -> R.drawable.element_pegasus
                COMPASSION -> R.drawable.element_compassion
                ROTTEN -> R.drawable.element_rotten

                PHOENIX -> R.drawable.element_phoenix
                SEABREEZE -> R.drawable.element_seabreeze
                BIRD -> R.drawable.element_bird
                AERO -> R.drawable.element_aero
                COCKA -> R.drawable.element_cocka
                NIGHTWING -> R.drawable.element_nightwing

                SOLAR -> R.drawable.element_solar
                LUNAR -> R.drawable.element_lunar
                GUARDIAN -> R.drawable.element_guaridan
                ANGEL -> R.drawable.element_angel
                LUXOR -> R.drawable.element_luxor
                REDEMPTION -> R.drawable.element_redemption

                DEMON -> R.drawable.element_demon
                POISON -> R.drawable.element_poison
                UNDEAD -> R.drawable.element_undead
                STORM -> R.drawable.element_storm
                BETRAYER -> R.drawable.element_betrayer
                UMBRAL -> R.drawable.element_umbral

                MAGICAL -> R.drawable.element_magical
                PHYSICAL -> R.drawable.element_physical

                NEUTRAL, INITIAL -> throw IllegalStateException("Element $element has no symbol")
            }
        }

        fun getMonsterHierarchyType(element: Element): EMonsterHierarchyType
        {
            return when(element)
            {
                PYRO -> EMonsterHierarchyType.QUADENT
                LAVA -> EMonsterHierarchyType.TRIDENT
                DINO -> EMonsterHierarchyType.TRIDENT
                SAND -> EMonsterHierarchyType.TRIDENT
                JUSTICE -> EMonsterHierarchyType.BIDENT
                VENGEANCE -> EMonsterHierarchyType.BIDENT

                STEAM -> EMonsterHierarchyType.BIDENT
                AQUA -> EMonsterHierarchyType.QUADENT
                AMPHIBIOUS -> EMonsterHierarchyType.TRIDENT
                WEATHER -> EMonsterHierarchyType.TRIDENT
                ICE -> EMonsterHierarchyType.QUADENT
                DEEP -> EMonsterHierarchyType.QUADENT

                FEY -> EMonsterHierarchyType.TRIDENT
                PLANT -> EMonsterHierarchyType.TRIDENT
                TERRA -> EMonsterHierarchyType.QUINDENT
                PEGASUS -> EMonsterHierarchyType.BIDENT
                COMPASSION -> EMonsterHierarchyType.BIDENT
                ROTTEN -> EMonsterHierarchyType.TRIDENT

                PHOENIX -> EMonsterHierarchyType.BIDENT
                SEABREEZE -> EMonsterHierarchyType.BIDENT
                BIRD -> EMonsterHierarchyType.BIDENT
                AERO -> EMonsterHierarchyType.QUADENT
                COCKA -> EMonsterHierarchyType.TRIDENT
                NIGHTWING -> EMonsterHierarchyType.TRIDENT

                SOLAR -> EMonsterHierarchyType.TRIDENT
                LUNAR -> EMonsterHierarchyType.BIDENT
                GUARDIAN -> EMonsterHierarchyType.BIDENT
                ANGEL -> EMonsterHierarchyType.BIDENT
                LUXOR -> EMonsterHierarchyType.QUADENT
                REDEMPTION -> EMonsterHierarchyType.TRIDENT

                DEMON -> EMonsterHierarchyType.TRIDENT
                POISON -> EMonsterHierarchyType.TRIDENT
                UNDEAD -> EMonsterHierarchyType.BIDENT
                STORM -> EMonsterHierarchyType.TRIDENT
                BETRAYER -> EMonsterHierarchyType.BIDENT
                UMBRAL -> EMonsterHierarchyType.QUADENT

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has no Monster Hierarchy Type")
            }
        }

        fun getName(context:Context, element:Element): String
        {
            return when(element)
            {
                PYRO -> ContextCompat.getString(context,R.string.pyro_name)
                LAVA -> ContextCompat.getString(context,R.string.lava_name)
                DINO -> ContextCompat.getString(context,R.string.dino_name)
                SAND -> ContextCompat.getString(context,R.string.sand_name)
                JUSTICE -> ContextCompat.getString(context,R.string.justice_name)
                VENGEANCE -> ContextCompat.getString(context,R.string.vengeance_name)

                STEAM -> ContextCompat.getString(context,R.string.steam_name)
                AQUA -> ContextCompat.getString(context,R.string.aqua_name)
                AMPHIBIOUS -> ContextCompat.getString(context,R.string.amphibious_name)
                WEATHER -> ContextCompat.getString(context,R.string.weather_name)
                ICE -> ContextCompat.getString(context,R.string.ice_name)
                DEEP -> ContextCompat.getString(context,R.string.deep_name)

                FEY -> ContextCompat.getString(context,R.string.fey_name)
                PLANT -> ContextCompat.getString(context,R.string.plant_name)
                TERRA -> ContextCompat.getString(context,R.string.terra_name)
                PEGASUS -> ContextCompat.getString(context,R.string.pegasus_name)
                COMPASSION -> ContextCompat.getString(context,R.string.compassion_name)
                ROTTEN -> ContextCompat.getString(context,R.string.rotten_name)

                PHOENIX -> ContextCompat.getString(context,R.string.phoenix_name)
                SEABREEZE -> ContextCompat.getString(context,R.string.seabreeze_name)
                BIRD -> ContextCompat.getString(context,R.string.bird_name)
                AERO -> ContextCompat.getString(context,R.string.aero_name)
                COCKA -> ContextCompat.getString(context,R.string.cocka_name)
                NIGHTWING -> ContextCompat.getString(context,R.string.nightwing_name)

                SOLAR -> ContextCompat.getString(context,R.string.solar_name)
                LUNAR -> ContextCompat.getString(context,R.string.lunar_name)
                GUARDIAN -> ContextCompat.getString(context,R.string.guardian_name)
                ANGEL -> ContextCompat.getString(context,R.string.angel_name)
                LUXOR -> ContextCompat.getString(context,R.string.luxor_name)
                REDEMPTION -> ContextCompat.getString(context,R.string.redemption_name)

                DEMON -> ContextCompat.getString(context,R.string.demon_name)
                POISON -> ContextCompat.getString(context,R.string.poison_name)
                UNDEAD -> ContextCompat.getString(context,R.string.undead_name)
                STORM -> ContextCompat.getString(context,R.string.storm_name)
                BETRAYER -> ContextCompat.getString(context,R.string.betrayer_name)
                UMBRAL -> ContextCompat.getString(context,R.string.umbral_name)

                NEUTRAL -> ContextCompat.getString(context,R.string.neutral_name)
                PHYSICAL -> ContextCompat.getString(context,R.string.physical_name)
                MAGICAL -> ContextCompat.getString(context,R.string.magical_name)
                INITIAL -> ContextCompat.getString(context,R.string.initial_name)
            }
        }

        fun getInfantMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
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

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has no infant monster")
            }
        }

        fun getPhysicalAdolescentMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 2)
                LAVA -> MonsterTypeManager.getMonsterType(context, 14)
                DINO -> MonsterTypeManager.getMonsterType(context, 24)
                SAND -> MonsterTypeManager.getMonsterType(context, 34)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 44)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 51)

                STEAM -> MonsterTypeManager.getMonsterType(context, 58)
                AQUA -> MonsterTypeManager.getMonsterType(context, 65)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 77)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 87)
                ICE -> MonsterTypeManager.getMonsterType(context, 97)
                DEEP -> MonsterTypeManager.getMonsterType(context, 109)

                FEY -> MonsterTypeManager.getMonsterType(context, 121)
                PLANT -> MonsterTypeManager.getMonsterType(context, 131)
                TERRA -> MonsterTypeManager.getMonsterType(context, 141)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 155)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 162)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 169)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 179)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 186)
                BIRD -> MonsterTypeManager.getMonsterType(context, 193)
                AERO -> MonsterTypeManager.getMonsterType(context, 200)
                COCKA -> MonsterTypeManager.getMonsterType(context, 212)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 222)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 232)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 242)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 249)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 256)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 263)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 275)

                DEMON -> MonsterTypeManager.getMonsterType(context, 285)
                POISON -> MonsterTypeManager.getMonsterType(context, 295)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 305)
                STORM -> MonsterTypeManager.getMonsterType(context, 312)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 322)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 329)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getBalancedAdolescentMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 3)
                LAVA -> MonsterTypeManager.getMonsterType(context,15)
                DINO -> MonsterTypeManager.getMonsterType(context, 25)
                SAND -> MonsterTypeManager.getMonsterType(context, 35)
                JUSTICE,VENGEANCE -> throw IllegalStateException("Element $element has no Balanced Adolescent Monster")

                STEAM -> throw IllegalStateException("Element $element has no Balanced Adolescent Monster")
                AQUA -> MonsterTypeManager.getMonsterType(context, 66)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 78)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 88)
                ICE -> MonsterTypeManager.getMonsterType(context, 98)
                DEEP -> MonsterTypeManager.getMonsterType(context, 110)

                FEY -> MonsterTypeManager.getMonsterType(context, 122)
                PLANT -> MonsterTypeManager.getMonsterType(context, 132)
                TERRA -> MonsterTypeManager.getMonsterType(context, 142)
                PEGASUS,COMPASSION -> throw IllegalStateException("Element $element has no Balanced Adolescent Monster")
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 170)

                PHOENIX,SEABREEZE,BIRD -> throw IllegalStateException("Element $element has no Balanced Adolescent Monster")
                AERO -> MonsterTypeManager.getMonsterType(context, 201)
                COCKA -> MonsterTypeManager.getMonsterType(context, 213)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 223)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 233)
                LUNAR, GUARDIAN, ANGEL -> throw IllegalStateException("Element $element has no Balanced Adolescent Monster")
                LUXOR -> MonsterTypeManager.getMonsterType(context, 264)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 276)

                DEMON -> MonsterTypeManager.getMonsterType(context, 286)
                POISON -> MonsterTypeManager.getMonsterType(context, 296)
                UNDEAD,BETRAYER -> throw IllegalStateException("Element $element has no Balanced Adolescent Monster")
                STORM -> MonsterTypeManager.getMonsterType(context, 313)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 330)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getMagicalAdolescentMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 4)
                LAVA -> MonsterTypeManager.getMonsterType(context,16)
                DINO -> MonsterTypeManager.getMonsterType(context, 26)
                SAND -> MonsterTypeManager.getMonsterType(context, 36)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 45)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 52)

                STEAM -> MonsterTypeManager.getMonsterType(context, 59)
                AQUA -> MonsterTypeManager.getMonsterType(context, 67)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 79)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 89)
                ICE -> MonsterTypeManager.getMonsterType(context, 99)
                DEEP -> MonsterTypeManager.getMonsterType(context, 111)

                FEY -> MonsterTypeManager.getMonsterType(context, 123)
                PLANT -> MonsterTypeManager.getMonsterType(context, 133)
                TERRA -> MonsterTypeManager.getMonsterType(context, 143)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 156)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 163)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 171)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 180)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 187)
                BIRD -> MonsterTypeManager.getMonsterType(context, 194)
                AERO -> MonsterTypeManager.getMonsterType(context, 202)
                COCKA -> MonsterTypeManager.getMonsterType(context, 214)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 224)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 234)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 243)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 250)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 257)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 265)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 277)

                DEMON -> MonsterTypeManager.getMonsterType(context, 287)
                POISON -> MonsterTypeManager.getMonsterType(context, 297)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 306)
                STORM -> MonsterTypeManager.getMonsterType(context, 314)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 323)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 331)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getPhysicalAdultMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 5)
                LAVA -> MonsterTypeManager.getMonsterType(context, 17)
                DINO -> MonsterTypeManager.getMonsterType(context, 27)
                SAND -> MonsterTypeManager.getMonsterType(context, 37)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 46)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 53)

                STEAM -> MonsterTypeManager.getMonsterType(context, 60)
                AQUA -> MonsterTypeManager.getMonsterType(context, 68)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 80)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 90)
                ICE -> MonsterTypeManager.getMonsterType(context, 100)
                DEEP -> MonsterTypeManager.getMonsterType(context, 112)

                FEY -> MonsterTypeManager.getMonsterType(context, 124)
                PLANT -> MonsterTypeManager.getMonsterType(context, 134)
                TERRA -> MonsterTypeManager.getMonsterType(context, 144)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 157)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 164)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 172)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 181)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 188)
                BIRD -> MonsterTypeManager.getMonsterType(context, 195)
                AERO -> MonsterTypeManager.getMonsterType(context, 203)
                COCKA -> MonsterTypeManager.getMonsterType(context, 215)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 225)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 235)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 244)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 251)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 258)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 266)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 278)

                DEMON -> MonsterTypeManager.getMonsterType(context, 288)
                POISON -> MonsterTypeManager.getMonsterType(context, 298)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 307)
                STORM -> MonsterTypeManager.getMonsterType(context, 315)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 324)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 332)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getBalancedAdultMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 6)
                LAVA -> MonsterTypeManager.getMonsterType(context, 18)
                DINO -> MonsterTypeManager.getMonsterType(context, 28)
                SAND -> MonsterTypeManager.getMonsterType(context, 38)
                JUSTICE, VENGEANCE -> throw IllegalStateException("Element $element has no Balanced Adult Monster")

                STEAM -> throw IllegalStateException("Element $element has no Balanced Adult Monster")
                AQUA -> MonsterTypeManager.getMonsterType(context, 69)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 81)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 91)
                ICE -> MonsterTypeManager.getMonsterType(context, 101)
                DEEP -> MonsterTypeManager.getMonsterType(context, 113)

                FEY -> MonsterTypeManager.getMonsterType(context, 125)
                PLANT -> MonsterTypeManager.getMonsterType(context, 135)
                TERRA -> MonsterTypeManager.getMonsterType(context, 145)
                PEGASUS,COMPASSION -> throw IllegalStateException("Element $element has no Balanced Adult Monster")
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 173)

                PHOENIX,SEABREEZE,BIRD -> throw IllegalStateException("Element $element has no Balanced Adult Monster")
                AERO -> MonsterTypeManager.getMonsterType(context, 204)
                COCKA -> MonsterTypeManager.getMonsterType(context, 216)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 226)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 236)
                LUNAR,GUARDIAN,ANGEL -> throw IllegalStateException("Element $element has no Balanced Adult Monster")
                LUXOR -> MonsterTypeManager.getMonsterType(context, 267)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 279)

                DEMON -> MonsterTypeManager.getMonsterType(context, 289)
                POISON -> MonsterTypeManager.getMonsterType(context, 299)
                UNDEAD,BETRAYER -> throw IllegalStateException("Element $element has no Balanced Adult Monster")
                STORM -> MonsterTypeManager.getMonsterType(context, 316)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 333)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getMysticAdultMonster(context: Context, element:Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 7)
                LAVA,DINO,SAND,JUSTICE, VENGEANCE -> throw IllegalStateException("Element $element has no Mystic Adult Monster")

                STEAM,AMPHIBIOUS,WEATHER -> throw IllegalStateException("Element $element has no Mystic Adult Monster")
                AQUA -> MonsterTypeManager.getMonsterType(context, 70)
                ICE -> MonsterTypeManager.getMonsterType(context, 102)
                DEEP -> MonsterTypeManager.getMonsterType(context, 114)

                FEY,PLANT -> throw IllegalStateException("Element $element has no Mystic Adult Monster")
                TERRA -> MonsterTypeManager.getMonsterType(context, 147)
                PEGASUS,COMPASSION,ROTTEN -> throw IllegalStateException("Element $element has no Mystic Adult Monster")

                PHOENIX,SEABREEZE,BIRD,COCKA,NIGHTWING -> throw IllegalStateException("Element $element has no Mystic Adult Monster")
                AERO -> MonsterTypeManager.getMonsterType(context, 205)

                SOLAR,LUNAR,GUARDIAN,ANGEL,REDEMPTION -> throw IllegalStateException("Element $element has no Mystic Adult Monster")
                LUXOR -> MonsterTypeManager.getMonsterType(context, 268)

                DEMON,POISON,UNDEAD,STORM,BETRAYER -> throw IllegalStateException("Element $element has no Mystic Adult Monster")
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 334)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getMagicalAdultMonster(context:Context, element:Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 8)
                LAVA -> MonsterTypeManager.getMonsterType(context, 19)
                DINO -> MonsterTypeManager.getMonsterType(context, 29)
                SAND -> MonsterTypeManager.getMonsterType(context, 39)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 47)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 54)

                STEAM -> MonsterTypeManager.getMonsterType(context, 61)
                AQUA -> MonsterTypeManager.getMonsterType(context, 71)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 82)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 92)
                ICE -> MonsterTypeManager.getMonsterType(context, 103)
                DEEP -> MonsterTypeManager.getMonsterType(context, 115)

                FEY -> MonsterTypeManager.getMonsterType(context, 126)
                PLANT -> MonsterTypeManager.getMonsterType(context, 136)
                TERRA -> MonsterTypeManager.getMonsterType(context, 148)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 158)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 165)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 174)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 182)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 189)
                BIRD -> MonsterTypeManager.getMonsterType(context, 196)
                AERO -> MonsterTypeManager.getMonsterType(context, 206)
                COCKA -> MonsterTypeManager.getMonsterType(context, 217)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 227)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 237)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 245)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 252)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 259)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 269)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 280)

                DEMON -> MonsterTypeManager.getMonsterType(context, 290)
                POISON -> MonsterTypeManager.getMonsterType(context, 300)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 308)
                STORM -> MonsterTypeManager.getMonsterType(context, 317)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 325)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 335)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getPhysicalElderMonster(context:Context, element:Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 9)
                LAVA -> MonsterTypeManager.getMonsterType(context, 20)
                DINO -> MonsterTypeManager.getMonsterType(context, 30)
                SAND -> MonsterTypeManager.getMonsterType(context, 40)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 48)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 55)

                STEAM -> MonsterTypeManager.getMonsterType(context, 62)
                AQUA -> MonsterTypeManager.getMonsterType(context, 72)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 83)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 93)
                ICE -> MonsterTypeManager.getMonsterType(context, 104)
                DEEP -> MonsterTypeManager.getMonsterType(context, 116)

                FEY -> MonsterTypeManager.getMonsterType(context, 127)
                PLANT -> MonsterTypeManager.getMonsterType(context, 137)
                TERRA -> MonsterTypeManager.getMonsterType(context, 149)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 159)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 166)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 175)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 183)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 190)
                BIRD -> MonsterTypeManager.getMonsterType(context, 197)
                AERO -> MonsterTypeManager.getMonsterType(context, 207)
                COCKA -> MonsterTypeManager.getMonsterType(context, 218)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 228)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 238)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 246)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 253)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 260)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 270)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 281)

                DEMON -> MonsterTypeManager.getMonsterType(context, 291)
                POISON -> MonsterTypeManager.getMonsterType(context, 301)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 309)
                STORM -> MonsterTypeManager.getMonsterType(context, 318)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 326)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 336)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getBalancedElderMonster(context:Context, element:Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 10)
                LAVA -> MonsterTypeManager.getMonsterType(context, 21)
                DINO -> MonsterTypeManager.getMonsterType(context, 31)
                SAND -> MonsterTypeManager.getMonsterType(context, 41)
                JUSTICE, VENGEANCE -> throw IllegalStateException("Element $element has no Balanced Elder Monster")

                STEAM -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                AQUA -> MonsterTypeManager.getMonsterType(context, 73)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 84)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 94)
                ICE -> MonsterTypeManager.getMonsterType(context, 105)
                DEEP -> MonsterTypeManager.getMonsterType(context, 117)

                FEY -> MonsterTypeManager.getMonsterType(context, 128)
                PLANT -> MonsterTypeManager.getMonsterType(context, 138)
                TERRA -> MonsterTypeManager.getMonsterType(context, 150)
                PEGASUS, COMPASSION -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 176)

                PHOENIX,SEABREEZE,BIRD -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                AERO -> MonsterTypeManager.getMonsterType(context, 208)
                COCKA -> MonsterTypeManager.getMonsterType(context, 219)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 229)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 239)
                LUNAR,GUARDIAN,ANGEL -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                LUXOR -> MonsterTypeManager.getMonsterType(context, 271)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 282)

                DEMON -> MonsterTypeManager.getMonsterType(context, 292)
                POISON -> MonsterTypeManager.getMonsterType(context, 302)
                UNDEAD,BETRAYER -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                STORM -> MonsterTypeManager.getMonsterType(context, 319)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 337)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getMysticElderMonster(context: Context, element:Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 11)
                LAVA,DINO,SAND,JUSTICE,VENGEANCE -> throw IllegalStateException("Element $element has no Mystic Elder Monster")

                STEAM,AMPHIBIOUS,WEATHER -> throw IllegalStateException("Element $element has no Mystic Elder Monster")
                AQUA -> MonsterTypeManager.getMonsterType(context, 74)
                ICE -> MonsterTypeManager.getMonsterType(context, 106)
                DEEP -> MonsterTypeManager.getMonsterType(context, 118)

                FEY,PLANT -> throw IllegalStateException("Element $element has no Mystic Elder Monster")
                TERRA -> MonsterTypeManager.getMonsterType(context, 152)
                PEGASUS, COMPASSION, ROTTEN -> throw IllegalStateException("Element $element has no Mystic Elder Monster")

                PHOENIX,SEABREEZE,BIRD,COCKA,NIGHTWING -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                AERO -> MonsterTypeManager.getMonsterType(context, 209)

                SOLAR,LUNAR,GUARDIAN,ANGEL,REDEMPTION -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                LUXOR -> MonsterTypeManager.getMonsterType(context, 272)

                DEMON,POISON,UNDEAD,STORM,BETRAYER -> throw IllegalStateException("Element $element has no Balanced Elder Monster")
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 338)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }

        fun getMagicalElderMonster(context: Context, element: Element): MonsterType
        {
            return when(element)
            {
                PYRO -> MonsterTypeManager.getMonsterType(context, 12)
                LAVA -> MonsterTypeManager.getMonsterType(context, 22)
                DINO -> MonsterTypeManager.getMonsterType(context, 32)
                SAND -> MonsterTypeManager.getMonsterType(context, 42)
                JUSTICE -> MonsterTypeManager.getMonsterType(context, 49)
                VENGEANCE -> MonsterTypeManager.getMonsterType(context, 56)

                STEAM -> MonsterTypeManager.getMonsterType(context, 63)
                AQUA -> MonsterTypeManager.getMonsterType(context, 75)
                AMPHIBIOUS -> MonsterTypeManager.getMonsterType(context, 85)
                WEATHER -> MonsterTypeManager.getMonsterType(context, 95)
                ICE -> MonsterTypeManager.getMonsterType(context, 107)
                DEEP -> MonsterTypeManager.getMonsterType(context, 119)

                FEY -> MonsterTypeManager.getMonsterType(context, 129)
                PLANT -> MonsterTypeManager.getMonsterType(context, 139)
                TERRA -> MonsterTypeManager.getMonsterType(context, 153)
                PEGASUS -> MonsterTypeManager.getMonsterType(context, 160)
                COMPASSION -> MonsterTypeManager.getMonsterType(context, 167)
                ROTTEN -> MonsterTypeManager.getMonsterType(context, 177)

                PHOENIX -> MonsterTypeManager.getMonsterType(context, 184)
                SEABREEZE -> MonsterTypeManager.getMonsterType(context, 191)
                BIRD -> MonsterTypeManager.getMonsterType(context, 198)
                AERO -> MonsterTypeManager.getMonsterType(context, 210)
                COCKA -> MonsterTypeManager.getMonsterType(context, 220)
                NIGHTWING -> MonsterTypeManager.getMonsterType(context, 230)

                SOLAR -> MonsterTypeManager.getMonsterType(context, 240)
                LUNAR -> MonsterTypeManager.getMonsterType(context, 247)
                GUARDIAN -> MonsterTypeManager.getMonsterType(context, 254)
                ANGEL -> MonsterTypeManager.getMonsterType(context, 261)
                LUXOR -> MonsterTypeManager.getMonsterType(context, 273)
                REDEMPTION -> MonsterTypeManager.getMonsterType(context, 283)

                DEMON -> MonsterTypeManager.getMonsterType(context,293)
                POISON -> MonsterTypeManager.getMonsterType(context, 303)
                UNDEAD -> MonsterTypeManager.getMonsterType(context, 310)
                STORM -> MonsterTypeManager.getMonsterType(context, 320)
                BETRAYER -> MonsterTypeManager.getMonsterType(context, 327)
                UMBRAL -> MonsterTypeManager.getMonsterType(context, 339)

                NEUTRAL, PHYSICAL, MAGICAL, INITIAL -> throw IllegalStateException("Element $element has monsters")
            }
        }
    }
}