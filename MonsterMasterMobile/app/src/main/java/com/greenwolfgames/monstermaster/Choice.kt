package com.greenwolfgames.monstermaster

open class Choice(val text: String, val nextNodeIndex: Int, val stateChange: (State) -> Unit = {}, val element: Element) {
    constructor(text: String, nextNodeIndex: Int) : this(text, nextNodeIndex, {}, Element.NEUTRAL)
    constructor(text: String, nextNodeIndex: Int, stateChange: (State) -> Unit = {}) : this(text, nextNodeIndex,stateChange, Element.NEUTRAL )
}
