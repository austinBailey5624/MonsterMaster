package com.greenwolfgames.monstermaster

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
    }
}