package com.greenwolfgames.monstermaster

class Scene14Choice(val text: String, val nextNodeIndex: Int, var stateChange: (State) -> Unit = {}, val element: Element) {
    fun getText(): String {
        return text
    }

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
