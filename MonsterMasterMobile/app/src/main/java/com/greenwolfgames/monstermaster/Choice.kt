package com.greenwolfgames.monstermaster

class Choice(val text: String, val nextNodeIndex: Int, var stateChange: (State) -> Unit = {}, val element: Subelement, val textSize: Int) {

    constructor(text: String, nextNodeIndex: Int, stateChange: (State) -> Unit, element: Subelement) : this(text, nextNodeIndex, stateChange, element, 18)

    constructor(text: String, nextNodeIndex: Int, stateChange: (State) -> Unit, element: Element, textSize: Int) : this(text, nextNodeIndex, stateChange, getPureSubelement(element), textSize)
    constructor(text: String, nextNodeIndex: Int) : this(text, nextNodeIndex, {}, Subelement.NEUTRAL)
    constructor(text: String, nextNodeIndex: Int, textSize: Int) : this(text, nextNodeIndex, {}, Subelement.NEUTRAL, textSize)
    constructor(text: String, nextNodeIndex: Int, stateChange: (State) -> Unit, element: Element) : this(text, nextNodeIndex, stateChange, getPureSubelement(element))


    companion object {
        fun getPureSubelement(element: Element): Subelement
        {
            return when (element) {
                Element.FIRE -> Subelement.PYRO
                Element.WATER -> Subelement.AQUA
                Element.EARTH -> Subelement.TERRA
                Element.AIR -> Subelement.AERO
                Element.LIGHT -> Subelement.LUXOR
                Element.DARK -> Subelement.UMBRAL
                Element.NEUTRAL -> Subelement.NEUTRAL
                Element.PHYSICAL -> Subelement.PHYSICAL
                Element.MAGICAL -> Subelement.MAGICAL
            }
        }
    }
}