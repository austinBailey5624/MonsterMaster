package com.greenwolfgames.monstermaster

class Scene14Choice(val text: String, val nextNodeIndex: Int, var stateChange: (State) -> Unit = {}, val element: Element) {

    constructor(text: String, nextNodeIndex: Int) : this(text, nextNodeIndex, {}, Element.NEUTRAL)

}
