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

        fun getNature(deity: Deity): Nature
        {
            return when(deity)
            {
                ANU, BENNU, ACHERON -> Nature.LIGHT
                VELHU, NEPTUNE, ILLIAN -> Nature.WATER
                SID, GAIA, WEBSPINNER -> Nature.EARTH
                GABRIEL, BACCHUS, MUIR -> Nature.AIR
                AHROS, MARS, MALACATHE -> Nature.FIRE
                PYTHION, THANATOS, ENEMY -> Nature.DARKNESS
            }
        }

        fun getEntropicNature(deity: Deity): EntropicNature
        {
            return when(deity)
            {
                ANU, VELHU, SID, GABRIEL, AHROS, PYTHION -> EntropicNature.ORDER
                BENNU, NEPTUNE, GAIA, BACCHUS, MARS, THANATOS -> EntropicNature.NEUTRAL
                ACHERON, ILLIAN, WEBSPINNER, MUIR, MALACATHE, ENEMY -> EntropicNature.CHAOS
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

        fun getSymbol(deity: Deity): Int //image resource Id
        {
            return when(deity)
            {
                ANU -> R.drawable.deity_anu
                VELHU -> R.drawable.deity_velhu
                SID -> R.drawable.deity_sid
                GABRIEL -> R.drawable.deity_gabriel
                AHROS -> R.drawable.deity_ahros
                PYTHION -> R.drawable.deity_pythion

                BENNU -> R.drawable.deity_bennu
                NEPTUNE -> R.drawable.deity_neptune
                GAIA -> R.drawable.deity_gaia
                BACCHUS -> R.drawable.deity_bacchus
                MARS -> R.drawable.deity_mars
                THANATOS -> R.drawable.deity_thanatos

                ACHERON -> R.drawable.deity_acheron
                ILLIAN -> R.drawable.deity_illian
                WEBSPINNER -> R.drawable.deity_webspinner
                MUIR -> R.drawable.deity_muir
                MALACATHE -> R.drawable.deity_malacathe
                ENEMY -> R.drawable.deity_enemy
            }
        }

        fun getDeityRelationshipStatus(deity: Deity, context: Context, state: State): String
        {
            val score: Int = state.getScore(deity)
            if(score < -999)//if we are enemies
            {
                return getDeityEnemyTitle(deity,context)
            }
            if(score < -300)//if we are unfriendly
            {
                return getDeityUnfriendlyTitle(deity,context)
            }
            if(score < -100)
            {
                return getDeityIrritatedTitle(deity, context)
            }
            if (score < 100)
            {
                return ContextCompat.getString(context,R.string.unknown)
            }
            if(score < 300)
            {
                return ContextCompat.getString(context,R.string.interested)
            }
            if(score < 999)
            {
                return ContextCompat.getString(context,R.string.friendly)
            }
            return ContextCompat.getString(context,R.string.ally)
        }

        fun getDeityEnemyTitle(deity: Deity, context: Context): String
        {
            return when(deity)
            {
                ANU -> ContextCompat.getString(context,R.string.anu_enemy)
                VELHU -> ContextCompat.getString(context,R.string.velhu_enemy)
                SID -> ContextCompat.getString(context,R.string.sid_enemy)
                GABRIEL -> ContextCompat.getString(context,R.string.gabriel_enemy)
                AHROS -> ContextCompat.getString(context,R.string.ahros_enemy)
                PYTHION -> ContextCompat.getString(context,R.string.pythion_enemy)

                BENNU,NEPTUNE,GAIA,BACCHUS,MARS,THANATOS,ACHERON,ILLIAN,WEBSPINNER,MUIR,MALACATHE,ENEMY-> ContextCompat.getString(context,R.string.enemy)
            }
        }

        fun getDeityUnfriendlyTitle(deity: Deity, context: Context): String
        {
            return when(deity)
            {
                ANU -> ContextCompat.getString(context,R.string.anu_unfriendly)
                VELHU -> ContextCompat.getString(context,R.string.velhu_unfriendly)
                SID -> ContextCompat.getString(context,R.string.sid_unfriendly)
                GABRIEL -> ContextCompat.getString(context,R.string.gabriel_unfriendly)
                AHROS -> ContextCompat.getString(context,R.string.ahros_unfriendly)
                PYTHION -> ContextCompat.getString(context,R.string.pythion_unfriendly)

                BENNU,NEPTUNE,GAIA,BACCHUS,MARS,THANATOS,ACHERON,ILLIAN,WEBSPINNER,MUIR,MALACATHE,ENEMY-> ContextCompat.getString(context,R.string.unfriendly)

            }
        }

        fun getDeityIrritatedTitle(deity: Deity, context: Context): String
        {
            return when(deity)
            {
                ANU -> ContextCompat.getString(context,R.string.anu_irritated)
                VELHU -> ContextCompat.getString(context,R.string.velhu_irritated)
                SID -> ContextCompat.getString(context,R.string.sid_irritated)
                GABRIEL -> ContextCompat.getString(context,R.string.gabriel_irritated)
                AHROS -> ContextCompat.getString(context,R.string.ahros_irritated)
                PYTHION -> ContextCompat.getString(context,R.string.pythion_irritated)

                BENNU,NEPTUNE,GAIA,BACCHUS,MARS,THANATOS,ACHERON,ILLIAN,WEBSPINNER,MUIR,MALACATHE,ENEMY-> ContextCompat.getString(context,R.string.irritated)

            }
        }
    }
}