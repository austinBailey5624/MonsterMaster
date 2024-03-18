package com.greenwolfgames.monstermaster

import java.io.Serializable

//Class to represent the state of the game
class State : Serializable
{
    var nextScenario = 1
    var redScore: Int = 0
    var blueScore: Int = 0
    var greenScore: Int = 0
    var yellowScore: Int = 0
    var whiteScore: Int = 0
    var blackScore: Int = 0
}