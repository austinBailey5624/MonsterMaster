package com.greenwolfgames.monstermaster

class Scene14Choice(val text: String, val nextNodeIndex: Int, var stateChange: (State) -> Unit = {}, val element: Element) {

    constructor(text: String, nextNodeIndex: Int) : this(text, nextNodeIndex, {}, Element.NEUTRAL)
    fun getText(): String {
        return text
    }

    //NOTE: index 0 represent ending the conversation
    fun getNextNodeIndex(): Int {
        return nextNodeIndex
    }

    fun getStateChange(): (State) -> Unit {
        return stateChange
    }

    fun getElement(): Element {
        return element
    }
}
