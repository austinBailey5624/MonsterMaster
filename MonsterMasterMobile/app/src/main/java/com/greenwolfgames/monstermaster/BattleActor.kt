package com.greenwolfgames.monstermaster

import kotlin.random.Random

/**
 * Class to handle all of the information needed for a character to participate in a battle
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class BattleActor(var hpCurrent: Double, var hpMax: Double, var mpCurrent: Double, var mpMax: Double, var element: Element, val level: Int, val experience: Int, var physicalUses: Int, var magicalUses: Int, var itemUses: Int)
{
    class DiceToRoll(val raw: Int,val  d4: Int,val d6: Int,val d8: Int,val d10: Int)

    fun takeDamage(damage: Double)
    {
        this.hpCurrent -= damage
    }

    companion object
    {
        fun getBasicBattleActor(): BattleActor
        {
            val basicBattleActor= BattleActor(0.0,0.0,0.0,0.0,Element.INITIAL,1,0,0,0,0);
            basicBattleActor.hpMax = getHPMax(1)
            basicBattleActor.hpCurrent = basicBattleActor.hpMax
            basicBattleActor.mpMax = getMPMax(1)
            basicBattleActor.mpCurrent = basicBattleActor.mpMax
            basicBattleActor.physicalUses = 0
            basicBattleActor.magicalUses = 0
            basicBattleActor.itemUses = 0
            return basicBattleActor
        }

        val diceToRollToAddToHPMaxOnLevelUp: List<DiceToRoll> = listOf(
            DiceToRoll(0,0,0,0,0),
            DiceToRoll(18,1,0,0,0),//Level 1, 18 +1d4
            DiceToRoll(3,1,0,0,0),//Level 2 add 3 + 1d4
            DiceToRoll(4,1,0,0,0),// Level 3
            DiceToRoll(5,1,0,0,0),//Level4
            DiceToRoll(25,0,3,0,0),//Level 5 25 + 3d6 (big bonus b/c goes from infant to adolescent
            DiceToRoll(1,0,1,0,0),//Level 6 4 + 1d6
            DiceToRoll(5,0,1,0,0),//level 7 5 + 1d6
            DiceToRoll(5,0,1,0,0),//level 8
            DiceToRoll(5,0,1,0,0),//level 9
            DiceToRoll(4,0,1,0,0),//10
            DiceToRoll(4,0,1,0,0),//11
            DiceToRoll(5,0,1,0,0),//12
            DiceToRoll(5,0,1,0,0),//13
            DiceToRoll(6,0,1,0,0),//14
            DiceToRoll(28,0,0,5,0),//Level 15 28 + 5d8
            DiceToRoll(13,0,0,2,0),//16
            DiceToRoll(13,0,0,2,0),//17
            DiceToRoll(13,0,0,2,0),//18
            DiceToRoll(13,0,0,2,0),//19
            DiceToRoll(15,0,0,2,0),//20
            DiceToRoll(13,0,0,2,0),//21
            DiceToRoll(13,0,0,2,0),//22
            DiceToRoll(13,0,0,2,0),//23
            DiceToRoll(13,0,0,2,0),//24
            DiceToRoll(45,0,0,0,10),//25
            DiceToRoll(3,3,1,0,1),//26
        )

        val expRequiredForLevelUp: List<Int> = listOf(
            0,
            1000,
            2000,
            3000,
            4000,
            5000,
            6000,
            7000,
            8000,
            9000,
            10000,
            19000,
            28000,
            37000,
            46000,
            55000,
            64000,
            73000,
            82000,
            91000,
            100000,
            130000,
            160000,
            190000,
            220000,
            250000,
            280000,
            310000,
            340000,
            370000,
            400000,
            430000,
            460000,
            490000,
            520000,
            550000,
            580000,
            610000,
            640000,
            670000,
            700000,
            730000,
            760000,
            790000,
            820000,
            850000,
            880000,
            910000,
            940000,
            970000,
            1000000
        )

        fun getExpRequiredForLevelUp(level: Int, curExp: Int): Int
        {
            return expRequiredForLevelUp[level]-curExp
        }

        fun getMPMaxIncreaseOnLevelUp(level: Int): Int
        {
            return if(level < 25)
            {
                rawValueToAddToMPMaxOnLevelUp[level]
            }
            else
            {
                4
            }
        }

        val rawValueToAddToMPMaxOnLevelUp: List<Int> = listOf(
            0,10,1,1,1,1,//Levels 1 - 5, Level 1 gain 10 mp, 2 gain 1 mp etc
            6,2,2,2,2,
            2,2,2,2,14,
            3,3,3,3,3,
            3,3,3,3,23,
        )//all values over 25 will be 4

        /** function to get the HP Max of an arbitrary (just created) battle actor of level (parameter)
         * If there currently exists a Battle actor that is levelling up, use a different method
         */
        fun getHPMax(level: Int): Double
        {
            var result = 0;
            for(i in 1..level)
            {
                if(i >= 27)
                {
                    result += rollDice(DiceToRoll(6,2,1,0,1))
                }
                else
                {
                    result += rollDice(diceToRollToAddToHPMaxOnLevelUp[i])
                }
            }
            return result.toDouble()
        }

        /** function to get the MP Max of an arbitrary (just created) battle actor of level (parameter)
         * If there currently exists a Battle actor that is levelling up, use a different method
         */
        fun getMPMax(level: Int): Double
        {
            var result = 0;
            for(i in 1 .. level)
            {
                result += getMPMaxIncreaseOnLevelUp(i)
            }
            return result.toDouble()
        }

        fun rollDice(diceToRoll: DiceToRoll): Int
        {
            return diceToRoll.raw + roll(4,diceToRoll.d4) + roll(6,diceToRoll.d6) + roll(8,diceToRoll.d8) + roll(10,diceToRoll.d10)
        }

        fun roll(numSides: Int): Int
        {
            return Random.nextInt(1,numSides+1)//the upper bound is exclusive, so we add 1
        }

        fun roll(numSides: Int, times: Int): Int
        {
            if(times == 0)
            {
                return 0;
            }
            var result = 0
            for(i in 1..times)
            {
                result += roll(numSides)
            }
            return result
        }
    }
}

