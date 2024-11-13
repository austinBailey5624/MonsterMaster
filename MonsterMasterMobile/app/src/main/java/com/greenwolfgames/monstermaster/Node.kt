package com.greenwolfgames.monstermaster

open class Node(val index: Int, val prompt: List<String>, val choices: List<Choice>, val animationInfos: List<AnimationInfo>, val backgroundColor: Int, val textColor: Int)
{
    constructor(index: Int, prompt: List<String>, choices: List<Choice>, backgroundColor: Int, textColor: Int) : this(index, prompt, choices, listOf(), backgroundColor, textColor)
}