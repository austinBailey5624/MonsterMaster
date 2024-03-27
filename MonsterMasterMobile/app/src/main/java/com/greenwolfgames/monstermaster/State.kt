package com.greenwolfgames.monstermaster

import java.io.Serializable

//Class to represent the state of the game
class State : Serializable
{
    var elementalScore = mutableMapOf<Element,Int> (
        Element.FIRE to 0,
        Element.WATER to 0,
        Element.EARTH to 0,
        Element.AIR to 0,
        Element.LIGHT to 0,
        Element.DARK to 0
    )
    var starterMonster: String = ""

    fun addScore(element: Element, score: Int)
    {
        elementalScore[element] = elementalScore[element]!! + score
    }

    fun getScore(element: Element): Int
    {
        return elementalScore[element]!!
    }
    var previousSceneName: String = ""
    var playerName: String = ""
}