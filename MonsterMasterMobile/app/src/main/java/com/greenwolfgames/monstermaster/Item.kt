package com.greenwolfgames.monstermaster

/**
 * Class to contain the information needed for a specific item
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright: Austin Bailey 2025 All Rights Reserved
 */
class Item(
    val index: Int,
    val name: String,
    val description: String,
    val value: Double,
    val use: String,
    val howToObtain: String
)
{
    enum class EItemType
    {
        WEAPON,ARMOR,ACCESSORY,USEABLE,KEY
    }
}