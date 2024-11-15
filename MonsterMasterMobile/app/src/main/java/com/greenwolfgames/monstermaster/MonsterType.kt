package com.greenwolfgames.monstermaster

class MonsterType(
    val index: Int,
    val name: String,
    val description: String,
    val previousEvolutionIndex: Int,
    val physicalEvolutionIndex: Int,
    val balancedEvolutionIndex: Int,
    val magicalEvolutionIndex: Int,
    val imageResourceId: Int,
    val element: Element
)
{}