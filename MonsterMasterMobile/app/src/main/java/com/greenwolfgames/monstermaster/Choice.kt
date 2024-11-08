package com.greenwolfgames.monstermaster

open class Choice(val text: String, val nextNodeIndex: Int, val stateChange: (State) -> Unit = {}, val element: Element, val textSize: Int) {

    constructor(text: String, nextNodeIndex: Int, stateChange: (State) -> Unit, element: Element) : this(text, nextNodeIndex, stateChange, element, 18)
    constructor(text: String, nextNodeIndex: Int) : this(text, nextNodeIndex, {}, Element.NEUTRAL)
    constructor(text: String, nextNodeIndex: Int, textSize: Int) : this(text, nextNodeIndex, {}, Element.NEUTRAL, textSize)

}
