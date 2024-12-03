package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat

/**
 * Class to manage a Node in the Graph that is my game. Nodes will have prompts to the user and 0 to arbitrary choices
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright: Austin Bailey 2024 All Rights Reserved
 */
open class Node(
    val index: Int,
    val prompt: List<String>,
    val choices: List<Choice>,
    val animationInfos: List<AnimationInfo>,
    val backgroundColor: Int,
    val textColor: Int
)
{
    constructor(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        backgroundColor: Int,
        textColor: Int
    ) : this(index, prompt, choices, listOf(), backgroundColor, textColor)

    constructor(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        animationInfos: List<AnimationInfo>,
        context: Context
    ) : this(
        index,
        prompt,
        choices,
        animationInfos,
        ContextCompat.getColor(context, Element.getBackgroundColor(Element.NEUTRAL)),
        ContextCompat.getColor(context, Element.getTextColor(Element.NEUTRAL))
    )

    constructor(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        element: Element,
        context: Context
    ) : this(
        index,
        prompt,
        choices,
        listOf(),
        ContextCompat.getColor(context,Element.getBackgroundColor(element)),
        ContextCompat.getColor(context,Element.getTextColor(element))
    )

    constructor(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        element: Element,
        animations: List<AnimationInfo>,
        context: Context
    ) : this(
        index,
        prompt,
        choices,
        animations,
        ContextCompat.getColor(context,Element.getBackgroundColor(element)),
        ContextCompat.getColor(context,Element.getTextColor(element))
    )
}