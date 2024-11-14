package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat

open class Node(val index: Int, val prompt: List<String>, val choices: List<Choice>, val animationInfos: List<AnimationInfo>, val backgroundColor: Int, val textColor: Int)
{
    constructor(index: Int, prompt: List<String>, choices: List<Choice>, backgroundColor: Int, textColor: Int) : this(index, prompt, choices, listOf(), backgroundColor, textColor)
    constructor(index: Int, prompt: List<String>, choices: List<Choice>, context: Context) : this(index, prompt, choices, listOf(), ContextCompat.getColor(context, Element.getBackgroundColor(Element.NEUTRAL)),
        ContextCompat.getColor(context, Element.getTextColor(Element.NEUTRAL)))
}