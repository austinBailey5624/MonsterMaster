package com.greenwolfgames.monstermaster

data class Choice
    (
    var content: String = "",
    var action: (currentState: State) -> Unit = {}
)