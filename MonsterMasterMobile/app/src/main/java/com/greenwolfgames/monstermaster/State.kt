package com.greenwolfgames.monstermaster

import android.os.Parcel
import android.os.Parcelable
import android.util.Log

/**
 * Class to represent the state of the game. All game state should be represented in this class or
 * in a member variable of this class
 * @Author: Austin Bailey
 * @Year: 2024-2025
 *
 * @Copyright Austin Bailey 2024-2025 All Rights Reserved
 */
class State public constructor() : Parcelable
{
    var playerName: String = "defaultPlayerName"
    var currentGold: Int = 0
    var totalGoldEver: Int = 0
    var totalGoldDonated: Int = 0
    var playerPortraitImageId: Int = R.drawable.main_character_brown_hair_male
    var gender: Gender = Gender.MALE
    private var playerBattleActor: BattleActor

    init
    {
        playerBattleActor = BattleActor.getBasicBattleActor()
    }

    fun getPlayerBattleActor(): BattleActor
    {
        playerBattleActor.element = getMainCharacterElement()
        return playerBattleActor
    }

    //@formatter:off
    private var elementalScore = mutableMapOf<Element, Int>(
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
        Element.MAGICAL to 0,
        Element.INITIAL to 0).withDefault { 0 }

    var questStage = mutableMapOf<Quest, Int>(
        Quest.CHORES to 0,
        Quest.AMNESIA to 0,
        Quest.KYLER_REDEMPTION to 0,
        Quest.MORNS_ERRAND to 0,
        Quest.WRITING_LESSON to 0,
        Quest.SELL_AMULET to 0,
        Quest.EXPLORE to 0,
        Quest.MICHAEL_ATTITUDE to 0).withDefault { 0 }

    var nodeIndexByVisitedBefore = mutableMapOf<Int, Boolean>().withDefault { false }

    constructor(parcel: Parcel) :this() {
        playerName = parcel.readString().toString()
        currentGold = parcel.readInt()
        totalGoldEver = parcel.readInt()
        totalGoldDonated = parcel.readInt()
        playerPortraitImageId = parcel.readInt()
    }

    //@formatter:on
    fun addScore(element: Element, score: Int)
    {
        elementalScore[element] = elementalScore[element]!! + score
    }

    fun addScore(element: Element)
    {
        elementalScore[element] = elementalScore[element]!! + 1
    }

    fun getScore(element: Element): Int
    {
        return elementalScore[element]!!
    }

    fun getQuestStage(quest: Quest): Int
    {
        return questStage[quest]!!
    }

    fun setQuestStage(quest: Quest, stage: Int)
    {
        questStage[quest] = stage
    }

    fun visitNode(nodeIndex: Int) {
        nodeIndexByVisitedBefore[nodeIndex] = true
        Log.d("State", "Visited node $nodeIndex. Current map: $nodeIndexByVisitedBefore")
    }

    fun getSeenNodeBefore(nodeIndex: Int): Boolean {
        val seenBefore = nodeIndexByVisitedBefore.getOrDefault(nodeIndex, false)
        Log.d("State", "Checking node $nodeIndex: seenBefore = $seenBefore")
        return seenBefore
    }

    fun addGold(addedGold: Int)
    {
        totalGoldEver += addedGold
        currentGold += addedGold
    }

    fun removeGold(removedGold: Int)
    {
        currentGold -= removedGold
    }

    fun setChoresStage_WritingLessonFinished()
    {
        if (questStage[Quest.CHORES]!! < 3)
        {
            questStage[Quest.CHORES] = 3
        }
        if (questStage[Quest.CHORES]!! == 4)
        {
            questStage[Quest.CHORES] = 6
        }
        if (questStage[Quest.CHORES]!! == 5)
        {
            questStage[Quest.CHORES] = 8
        }
        if (questStage[Quest.CHORES]!! == 7)
        {
            questStage[Quest.CHORES] = 9
        }
    }

    fun initChoresQuestline()
    {
        questStage[Quest.MORNS_ERRAND] = 1
        questStage[Quest.SELL_AMULET] = 1
        if (questStage[Quest.WRITING_LESSON]!! == 2)
        {
            questStage[Quest.CHORES] = 2
        }
        else
        {
            questStage[Quest.CHORES] = 1
            questStage[Quest.WRITING_LESSON] = 1
        }
    }

    fun canAccessMenu(): Boolean
    {
        return nodeIndexByVisitedBefore.getOrDefault(79, false)
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
        if (this.gender == Gender.MALE)
        {
            this.gender = Gender.FEMALE
        }
        else if (this.gender == Gender.FEMALE)
        {
            this.gender = Gender.NEUTRAL
        }
        else if (this.gender == Gender.NEUTRAL)
        {
            this.gender = Gender.MALE
        }
    }

    fun getMainCharacterElement(): Element
    {
        return Element.getAllColoredElements().maxByOrNull { getElementalScoreForMainCharacterElementCalculation(it) } ?: throw NoSuchElementException("List is empty")
    }

    /**
     * Calculates the elemental score for an individual element in the element calculation.
     * 40% of this score is determined by the affinity of the matching element
     * 25% of this score is determined by the average score of elements whose primary nature
     *    matches the parameters primary nature
     * 10% of this score is determined by the average score of the elements whose secondary nature
     *    matches the parameters primary nature
     * 17.5% of this score is determined by the average score of the elements whose primary nature
     *     matches the paramaters secondary nature
     * 7.5% of this score is determiend by the average score of the elements whose secondary nature
     *     matches the parameters secondary nature
     *
     * Note: Target elements may belong in arbitrarily groups of this calcuation and can be 'counted'
     * more than once as a result. this is design.
     */
    fun getElementalScoreForMainCharacterElementCalculation(element: Element): Double
    {
        var score = 0.0
        score += .4 * elementalScore.get(element)!!
        score += .25 * Element.getMatchingPrimaryNature(Element.getPrimaryNature(element)).mapNotNull { elementalScore[it] }.average()
        score += .1 * Element.getMatchingSecondaryNature(Element.getSecondaryNature(element)).mapNotNull { elementalScore[it] }.average()
        score += .175 * Element.getMatchingPrimaryNature(Element.getSecondaryNature(element)).mapNotNull{ elementalScore[it]}.average()
        score += .075 * Element.getMatchingSecondaryNature(Element.getSecondaryNature(element)).mapNotNull{ elementalScore[it]}.average()
        return score
    }

    override fun writeToParcel(parcel: Parcel, flags: Int)
    {
        parcel.writeString(playerName)
        parcel.writeInt(currentGold)
        parcel.writeInt(totalGoldEver)
        parcel.writeInt(totalGoldDonated)
        parcel.writeInt(playerPortraitImageId)
    }

    override fun describeContents(): Int
    {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<State>
    {
        override fun createFromParcel(parcel: Parcel): State
        {
            return State(parcel)
        }

        override fun newArray(size: Int): Array<State?>
        {
            return arrayOfNulls(size)
        }
    }
}