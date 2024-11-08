package com.greenwolfgames.monstermaster

import android.view.animation.Animation

class CinematicChoice(
    text: String,
    nextNodeIndex: Int,
    stateChange: (State) -> Unit = {},
    element: Element,
    textSize: Int,
    val backgroundAnimation: Animation
) : Choice(text, nextNodeIndex, stateChange, element, textSize)
{

}
