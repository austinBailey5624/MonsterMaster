package com.greenwolfgames.monstermaster

import android.widget.ImageView

/**
 * Class to manage displaying the status bar for battleActors
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @elementSymbol: An Int representing the image resource id of the element symbol for the provided battleactor
 * @health: The resource ID of the image for the healthbar
 * @mana: The resource ID of the image for the manabar
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class StatusBar(val elementSymbol: Int,val health: Int,val mana: Int)
{
    companion object
    {
        val healthBarImages: List<Int> = (1..171).map { id ->
            val resourceName = "battle_ui_healthbar_$id"
            val resourceId = R.drawable::class.java.getDeclaredField(resourceName).getInt(null)
            resourceId
        }

        val manaBarImages: List<Int> = (1..171).map { id ->
            val resourceName = "battle_ui_manabar_$id"
            val resourceId = R.drawable::class.java.getDeclaredField(resourceName).getInt(null)
            resourceId
        }

        fun getHealthBar(
            healthCurrent: Double,
            healthMax: Double): Int //Returns an image resource id
        {
            if(healthCurrent >= healthMax)
            {
                return R.drawable.battle_ui_healthbar_172
            }
            if(healthCurrent<=0.0)
            {
                return R.drawable.battle_ui_healthbar_0
            }
            val fraction = healthCurrent / healthMax
            val index = (fraction * 171).toInt().coerceIn(0, 171)

            return healthBarImages[index]
        }

        fun getManaBar(
            manaCurrent: Double,
            manaMax:Double):Int //returns an image resource id
        {
            if(manaCurrent >= manaMax)
            {
                return R.drawable.battle_ui_manabar_172
            }
            if(manaCurrent<=0.0)
            {
                return R.drawable.battle_ui_manabar_0
            }
            val fraction = manaCurrent / manaMax
            val index = (fraction * 171).toInt().coerceIn(1,171)
            return manaBarImages[index]
        }

        fun getStatusBar(battleActor: BattleActor): StatusBar
        {
            return StatusBar(Element.getSymbol(battleActor.element),
                getHealthBar(battleActor.hpCurrent, battleActor.hpMax),
                getManaBar(battleActor.mpCurrent, battleActor.mpMax))
        }
    }
}