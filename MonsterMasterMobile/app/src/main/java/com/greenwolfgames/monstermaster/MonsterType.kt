package com.greenwolfgames.monstermaster

/**
 * Class to contain the infomation needed for a specific type of monster
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright: Austin Bailey 2024 All Rights Reserved
 */
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