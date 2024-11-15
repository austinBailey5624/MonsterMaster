package com.greenwolfgames.monstermaster

import java.io.Serializable

//Class to represent the state of the game
class State : Serializable
{
    private var elementalScore = mutableMapOf<Element,Int> (
        Element.PYRO to 0,
        Element.LAVA to 0,
        Element.DINO to 0,
        Element.SAND to 0,
        Element.JUSTICE to 0,
        Element.VENGEANCE to 0,
        Element.STEAM to 0,
        Element.AQUA to 0,
        Element.AMPHIBIOUS to 0,
        Element.WEATHER to 0,
        Element.ICE to 0,
        Element.DEEP to 0,
        Element.FEY to 0,
        Element.PLANT to 0,
        Element.TERRA to 0,
        Element.PEGASUS to 0,
        Element.COMPASSION to 0,
        Element.ROTTEN to 0,
        Element.PHOENIX to 0,
        Element.SEABREEZE to 0,
        Element.BIRD to 0,
        Element.AERO to 0,
        Element.COCKA to 0,
        Element.NIGHTWING to 0,
        Element.SOLAR to 0,
        Element.LUNAR to 0,
        Element.GUARDIAN to 0,
        Element.ANGEL to 0,
        Element.LUXOR to 0,
        Element.REDEMPTION to 0,
        Element.DEMON to 0,
        Element.POISON to 0,
        Element.UNDEAD to 0,
        Element.STORM to 0,
        Element.BETRAYER to 0,
        Element.UMBRAL to 0,
        Element.NEUTRAL to 0,
        Element.PHYSICAL to 0,
        Element.MAGICAL to 0
    )

    var nodeIndexByVisitedBefore = mutableMapOf<Int, Boolean> ().withDefault{false}

    fun addScore(element: Element, score: Int)
    {
        elementalScore[element] = elementalScore[element]!! + score
    }

    fun addScore(element:Element)
    {
        elementalScore[element] = elementalScore[element]!! + 1
    }

    fun getScore(element: Element): Int
    {
        return elementalScore[element]!!
    }

    fun getSeenNodeBefore(nodeIndex: Int): Boolean
    {
        return nodeIndexByVisitedBefore[nodeIndex] ?: false
    }

    fun visitNode(nodeIndex: Int)
    {
        nodeIndexByVisitedBefore[nodeIndex] = true
    }

    var playerName: String = "defaultPlayerName"
    val currentGold: Int = 0
    val totalGoldEver: Int = 0
    val totalGoldDonated: Int = 0
    private var amnesiac: Boolean = false;
    var playerPortraitImageId: Int = R.drawable.main_character_brown_hair_male
    var gender: Gender = Gender.MALE


    fun setAmnesiac(isAmnesiac: Boolean)
    {
        this.amnesiac = isAmnesiac
    }

    fun cyclePortrait()
    {
        when (this.playerPortraitImageId)
        {
            R.drawable.main_character_brown_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_hair_male
            }
            R.drawable.main_character_black_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_asian_male
            }
            R.drawable.main_character_asian_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_male
            }
            R.drawable.main_character_black_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_blonde_hair_male
            }
            R.drawable.main_character_blonde_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_male
            }
            R.drawable.main_character_brown_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_hair_female
            }
            R.drawable.main_character_black_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_asian_female
            }
            R.drawable.main_character_asian_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_female
            }
            R.drawable.main_character_black_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_blonde_hair_female
            }
            R.drawable.main_character_blonde_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_female
            }
        }
    }

    fun cyclePortraitBack()
    {
        when (this.playerPortraitImageId)
        {
            R.drawable.main_character_brown_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_blonde_hair_male
            }
            R.drawable.main_character_black_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_male
            }
            R.drawable.main_character_asian_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_hair_male
            }
            R.drawable.main_character_black_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_asian_male
            }
            R.drawable.main_character_blonde_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_male
            }
            R.drawable.main_character_brown_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_blonde_hair_female
            }
            R.drawable.main_character_black_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_female
            }
            R.drawable.main_character_asian_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_hair_female
            }
            R.drawable.main_character_black_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_female
            }
            R.drawable.main_character_blonde_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_female
            }
        }
    }

    fun cyclePortraitGender()
    {
        when (this.playerPortraitImageId)
        {
            R.drawable.main_character_brown_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_female
            }
            R.drawable.main_character_black_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_hair_female
            }
            R.drawable.main_character_asian_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_asian_female
            }
            R.drawable.main_character_black_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_female
            }
            R.drawable.main_character_blonde_hair_male ->
            {
                this.playerPortraitImageId = R.drawable.main_character_blonde_hair_female
            }
            R.drawable.main_character_brown_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_brown_hair_male
            }
            R.drawable.main_character_black_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_male
            }
            R.drawable.main_character_asian_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_asian_male
            }
            R.drawable.main_character_black_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_black_male
            }
            R.drawable.main_character_blonde_hair_female ->
            {
                this.playerPortraitImageId = R.drawable.main_character_blonde_hair_male
            }
        }
    }

    fun cycleGender()
    {
        if(this.gender == Gender.MALE)
        {
            this.gender = Gender.FEMALE
        }
        else if(this.gender == Gender.FEMALE)
        {
            this.gender = Gender.NEUTRAL
        }
        else if(this.gender == Gender.NEUTRAL)
        {
            this.gender = Gender.MALE
        }
    }
}