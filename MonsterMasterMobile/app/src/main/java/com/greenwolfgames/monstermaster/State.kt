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
    var uiElement: Element = Element.INITIAL
    var uiMonsterType: MonsterType =  MonsterType(0,"","",0,0,0,0,0,Element.INITIAL)
    var uiDeity: Deity = Deity.BENNU
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

    private var deityScore = mutableMapOf<Deity, Int>(
        Deity.ANU to 0,
        Deity.VELHU to 0,
        Deity.SID to 0,
        Deity.GABRIEL to 0,
        Deity.AHROS to 0,
        Deity.PYTHION to 0,
        Deity.BENNU to 0,
        Deity.NEPTUNE to 0,
        Deity.GAIA to 0,
        Deity.BACCHUS to 0,
        Deity.MARS to 0,
        Deity.THANATOS to 0,
        Deity.ACHERON to 0,
        Deity.ILLIAN to 0,
        Deity.WEBSPINNER to 0,
        Deity.MUIR to 0,
        Deity.MALACATHE to 0,
        Deity.ENEMY to 0).withDefault { 0 }


    var questStage = mutableMapOf<Int, Int>().withDefault { 0 }

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

    fun addScore(deity: Deity)
    {
        deityScore[deity] = deityScore[deity]!! +1
    }

    fun getScore(element: Element): Int
    {
        return elementalScore[element]!!
    }

    fun getScore(deity: Deity): Int
    {
        return deityScore[deity]!!
    }

    fun getQuestStage(questIndex: Int): Int
    {
        return questStage[questIndex]!!
    }

    fun setQuestStage(questIndex: Int, stage: Int)
    {
        questStage[questIndex] = stage
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

    fun getUIElement(): Element {
        return uiElement
    }

    fun getUIMonsterType(): MonsterType {
        return uiMonsterType
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
        if (questStage[1]!! < 3)
        {
            questStage[1] = 3
        }
        if (questStage[1]!! == 4)
        {
            questStage[1] = 6
        }
        if (questStage[1]!! == 5)
        {
            questStage[1] = 8
        }
        if (questStage[1]!! == 7)
        {
            questStage[1] = 9
        }
    }

    fun initChoresQuestline()
    {
        questStage[4] = 1
        questStage[6] = 1
        if (questStage[5]!! == 2)
        {
            questStage[1] = 2
        }
        else
        {
            questStage[1] = 1
            questStage[5] = 1
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

    fun getMainCharacterMaxElementalScore(): Double
    {
        return Element.getAllColoredElements().maxOf { getElementalScoreForMainCharacterElementCalculation(it) }
    }

    /**
     * Returns the rank (1 is first, to 36) of the score of the main character with the provided element
     */
    fun getMainCharacterElementalScoreRank(element: Element): Int
    {
        return getMainCharacterElementalScoresOrderedByScore().indexOf(element) +1 //plus one to fix zero indexing
    }

    fun getMainCharacterElementalScoresOrderedByScore(): List<Element>
    {
        return Element.getAllColoredElements().sortedByDescending { element ->
            getElementalScoreForMainCharacterElementCalculation(element)
        }
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