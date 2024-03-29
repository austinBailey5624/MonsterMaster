package com.greenwolfgames.monstermaster

class Scene14Node(val index: Int, val prompt: String, val choices: List<Scene14Choice>)
{

    fun getIndex(): Int {
        return index
    }

    fun getPrompt(): String {
        return prompt
    }

    fun getChoices(): List<Scene14Choice> {
        return choices
    }
}