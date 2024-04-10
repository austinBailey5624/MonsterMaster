package com.greenwolfgames.monstermaster

import java.io.Serializable

//Class to represent the state of the game
class State : Serializable
{
    private var elementalScore = mutableMapOf<Element,Int> (
        Element.FIRE to 0,
        Element.WATER to 0,
        Element.EARTH to 0,
        Element.AIR to 0,
        Element.LIGHT to 0,
        Element.DARK to 0,
        Element.NEUTRAL to 0,
        Element.PHYSICAL to 0,
        Element.MAGICAL to 0
    )
    var starterMonster: String = ""

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
    var previousSceneName: String = ""
    var playerName: String = ""
    var portrait: PlayerPortrait = PlayerPortrait.UNASSIGNED
    var gender: Gender = Gender.MALE
    var initScene14: Boolean = true
}