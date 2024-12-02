package com.greenwolfgames.monstermaster

/**
 * Extensible class to represent a choice the character makes in the game
 * @Author Austin Bailey
 * @Year 2024
 *
 * @Copyright Austin Bailey 2024 All Rights Reserved
 */
open class Choice(val text: String, val nextNodeIndex: Int, val stateChange: (State) -> Unit = {}, val element: Element) {
    constructor(text: String, nextNodeIndex: Int) : this(text, nextNodeIndex, {}, Element.NEUTRAL)
    constructor(text: String, nextNodeIndex: Int, stateChange: (State) -> Unit = {}) : this(text, nextNodeIndex,stateChange, Element.NEUTRAL )
    constructor(text: String, nextNodeIndex: Int, state: State, element: Element) : this(text, nextNodeIndex, getStateChange(state,element), element)


    companion object
    {
        fun getStateChange(state: State, element:Element): (State) -> Unit =
        {
            _: State -> state.addScore(element)
        }
    }
}
