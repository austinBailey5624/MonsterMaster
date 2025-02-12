package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat

enum class Deity
{
    ANU,VELHU,SID,GABRIEL,AHROS,PYTHION,
    BENNU,NEPTUNE,GAIA,BACCHUS,MARS,THANATOS,
    ACHERON,ILLIAN,WEBSPINNER,MUIR,MALACATHE,ENEMY;

    companion object
    {
        fun getElement(deity: Deity): Element
        {
            return when(deity)
            {
                ANU -> Element.LUXOR
                VELHU -> Element.LUNAR
                SID -> Element.COMPASSION
                GABRIEL -> Element.ANGEL
                AHROS -> Element.JUSTICE
                PYTHION -> Element.REDEMPTION

                BENNU -> Element.PHOENIX
                NEPTUNE -> Element.AQUA
                GAIA -> Element.TERRA
                BACCHUS -> Element.FEY
                MARS -> Element.PYRO
                THANATOS -> Element.UNDEAD

                ACHERON -> Element.BETRAYER
                ILLIAN -> Element.DEEP
                WEBSPINNER -> Element.POISON
                MUIR -> Element.NIGHTWING
                MALACATHE -> Element.DEMON
                ENEMY -> Element.UMBRAL
            }
        }

        fun getName(context: Context, deity: Deity): String
        {
            return when(deity)
            {
                ANU -> ContextCompat.getString(context,R.string.anu_name)
                VELHU -> ContextCompat.getString(context,R.string.velhu_name)
                SID -> ContextCompat.getString(context,R.string.sid_name)
                GABRIEL -> ContextCompat.getString(context,R.string.gabriel_name)
                AHROS -> ContextCompat.getString(context,R.string.ahros_name)
                PYTHION -> ContextCompat.getString(context,R.string.pythion_name)

                BENNU -> ContextCompat.getString(context,R.string.bennu_name)
                NEPTUNE -> ContextCompat.getString(context,R.string.neptune_name)
                GAIA -> ContextCompat.getString(context,R.string.gaia_name)
                BACCHUS -> ContextCompat.getString(context,R.string.bacchus_name)
                MARS -> ContextCompat.getString(context,R.string.mars_name)
                THANATOS -> ContextCompat.getString(context,R.string.thanatos_name)

                ACHERON -> ContextCompat.getString(context,R.string.acheron_name)
                ILLIAN -> ContextCompat.getString(context,R.string.illian_name)
                WEBSPINNER -> ContextCompat.getString(context,R.string.webspinner_name)
                MUIR -> ContextCompat.getString(context,R.string.muir_name)
                MALACATHE -> ContextCompat.getString(context,R.string.malacathe_name)
                ENEMY -> ContextCompat.getString(context,R.string.enemy_name)
            }
        }

        fun getDescription(context: Context, deity: Deity): String
        {
            return when(deity)
            {
                ANU -> ContextCompat.getString(context,R.string.anu_description)
                VELHU -> ContextCompat.getString(context,R.string.velhu_description)
                SID -> ContextCompat.getString(context,R.string.sid_description)
                GABRIEL -> ContextCompat.getString(context,R.string.gabriel_description)
                AHROS -> ContextCompat.getString(context,R.string.ahros_description)
                PYTHION -> ContextCompat.getString(context,R.string.pythion_description)

                BENNU -> ContextCompat.getString(context,R.string.bennu_description)
                NEPTUNE -> ContextCompat.getString(context,R.string.neptune_description)
                GAIA -> ContextCompat.getString(context,R.string.gaia_description)
                BACCHUS -> ContextCompat.getString(context,R.string.bacchus_description)
                MARS -> ContextCompat.getString(context,R.string.mars_description)
                THANATOS -> ContextCompat.getString(context,R.string.thanatos_description)

                ACHERON -> ContextCompat.getString(context,R.string.acheron_description)
                ILLIAN -> ContextCompat.getString(context,R.string.illian_description)
                WEBSPINNER -> ContextCompat.getString(context,R.string.webspinner_description)
                MUIR -> ContextCompat.getString(context,R.string.muir_description)
                MALACATHE -> ContextCompat.getString(context,R.string.malacathe_description)
                ENEMY -> ContextCompat.getString(context,R.string.enemy_description)
            }
        }
    }
}