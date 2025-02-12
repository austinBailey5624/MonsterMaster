package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat

enum class EntropicNature
{
    ORDER,NEUTRAL,CHAOS;

    companion object
    {
        fun getTextColor(entropicNature: EntropicNature): Int
        {
            return when(entropicNature)
            {
                ORDER -> Element.getTextColor(Element.ANGEL)
                NEUTRAL -> Element.getTextColor(Element.PHYSICAL)
                CHAOS -> Element.getTextColor(Element.DEEP)
            }
        }

        fun getButtonBackgroundColor(entropicNature: EntropicNature): Int
        {
            return when(entropicNature)
            {
                ORDER -> Element.getButtonBackgroundColor(Element.ANGEL)
                NEUTRAL -> Element.getButtonBackgroundColor(Element.PHYSICAL)
                CHAOS -> Element.getButtonBackgroundColor(Element.DEEP)
            }
        }

        fun getSymbol(entropicNature: EntropicNature): Int //returns an image resource Id
        {
            return when(entropicNature)
            {
                ORDER -> R.drawable.element_order
                NEUTRAL -> R.drawable.element_neutral
                CHAOS -> R.drawable.element_chaos
            }
        }

        fun getName(context: Context, entropicNature: EntropicNature): String
        {
            return when(entropicNature)
            {
                ORDER -> ContextCompat.getString(context,R.string.order_name)
                NEUTRAL -> ContextCompat.getString(context,R.string.neutral_name)
                CHAOS -> ContextCompat.getString(context,R.string.chaos_name)
            }
        }
    }
}