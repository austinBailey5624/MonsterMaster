package com.greenwolfgames.monstermaster

import android.content.Context
import android.util.Log
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
    val textColor: Int,
    val state: State,
    val action: () -> Unit)
{
    constructor(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        element: Element,
        context: Context,
        state: State) : this(index,
        prompt,
        cleanChoices(index, state, choices),
        listOf(),
        ContextCompat.getColor(context, Element.getBackgroundColor(element)),
        ContextCompat.getColor(context, Element.getTextColor(element)),
        state,
        {})

    constructor(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        element: Element,
        animations: List<AnimationInfo>,
        context: Context,
        state: State) : this(index,
        prompt,
        cleanChoices(index, state, choices),
        animations,
        ContextCompat.getColor(context, Element.getBackgroundColor(element)),
        ContextCompat.getColor(context, Element.getTextColor(element)),
        state,
        {})

    companion object
    {
        /**
         * This method prevents us from getting unearned affinity points by revisiting nodes over and over
         * and making the same choices over and over again
         */
        fun cleanChoices(index: Int, state: State, choices: List<Choice>): List<Choice>
        { // If we are revisiting this node
            Log.d("cleanChoices","index: $index, seenBefore: ${state.getSeenNodeBefore(index)}")
            if (state.getSeenNodeBefore(index))
            {
                choices.forEach { choice ->
                    if (!choice.shouldChangeStateOnRevisit)
                    {
                        choice.stateChange = { _: State -> }
                    }
                }
            }
            return choices
        }
    }
}