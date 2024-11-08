package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString

class CinematicNodeRetriever
{
    companion object
    {
        //@formatter:off
        public fun getCinematicNode(index: Int, currentState: State, context: Context): CinematicNode
        {
            //Choose Between light or dark
            if(index == 1)
            {
                val prompts = listOf(getString(context, R.string.scene1item1), getString(context, R.string.scene1item2),
                    getString(context, R.string.scene1item3), getString(context, R.string.scene1item4),
                    getString(context, R.string.scene1item5), getString(context, R.string.scene1item6),
                    getString(context, R.string.scene1item7))
                val choices = listOf(Choice(getString(context, R.string.scene1choice1),2, {state -> state.addScore(Element.LUXOR)}, Element.LUXOR,24),
                    Choice(getString(context, R.string.scene1choice2),3, {state -> state.addScore(Element.UMBRAL)}, Element.UMBRAL,24 ))
                return CinematicNode(index, prompts, choices, ECinematicImage.NONE, ContextCompat.getColor(context, R.color.darkGray), ContextCompat.getColor(context, R.color.gray))
            }
            //Chose Light, now choose Fire or Water
            if(index == 2)
            {
                val prompts = listOf(getString(context, R.string.scene2item1), getString(context, R.string.scene2item2),
                    getString(context, R.string.scene2item3), getString(context, R.string.scene2item4),
                    getString(context, R.string.scene2item5))
                val choices = listOf(Choice(getString(context, R.string.scene2choice1),4, {state -> state.addScore(Element.PYRO)}, Element.PYRO, 24 ),
                    Choice(getString(context, R.string.scene2choice2),5, {state -> state.addScore(Element.AQUA)}, Element.AQUA, 24))
                return CinematicNode(index, prompts, choices, ECinematicImage.LIGHT_FROM_ABOVE, ContextCompat.getColor(context, R.color.gray), ContextCompat.getColor(context, R.color.whiteGray))
            }
            //Chose Darkness, now choose Fire or Water
            if(index == 3)
            {
                val prompts = listOf(getString(context, R.string.scene3item1), getString(context, R.string.scene3item2),
                    getString(context, R.string.scene3item3), getString(context, R.string.scene3item4),
                    getString(context, R.string.scene3item5), getString(context, R.string.scene3item6))
                val choices = listOf(Choice(getString(context, R.string.scene3choice1), 6, {state -> state.addScore(Element.PYRO)}, Element.PYRO, 22),
                    Choice(getString(context, R.string.scene3choice2), 7, {state -> state.addScore(Element.AQUA)}, Element.AQUA, 22))
                return CinematicNode(index, prompts, choices, ECinematicImage.NONE, ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.darkishGray))
            }
            // Chose Light and Fire, now choose Air or Earth
            if(index == 4)
            {
                val prompts = listOf(getString(context, R.string.scene4item1), getString(context, R.string.scene4item2),
                    getString(context, R.string.scene4item3), getString(context, R.string.scene4item4),
                    getString(context, R.string.scene4item5))
                val choices = listOf(Choice(getString(context, R.string.scene4choice1), 8, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene4choice2), 8, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
                return CinematicNode(index, prompts, choices, ECinematicImage.FLAME, ContextCompat.getColor(context, R.color.darkBrown), ContextCompat.getColor(context, R.color.brown))
            }
            //Chose light and water, now choose Air or Earth
            if(index == 5)
            {
                val prompts = listOf(getString(context, R.string.scene5item1), getString(context, R.string.scene5item2),
                    getString(context, R.string.scene5item3), getString(context, R.string.scene5item4),
                    getString(context, R.string.scene5item5), getString(context, R.string.scene5item6))
                val choices = listOf(Choice(getString(context, R.string.scene5choice1), 9, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene5choice2), 9, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
                return CinematicNode(index, prompts, choices, ECinematicImage.RIVER, ContextCompat.getColor(context, R.color.lightishBlue), ContextCompat.getColor(context, R.color.lighterBlue))
            }
            //Chose Darkness and Fire, now choose Air or Earth
            if(index == 6)
            {
                val prompts = listOf(getString(context, R.string.scene6item1), getString(context, R.string.scene6item2),
                    getString(context, R.string.scene6item3), getString(context, R.string.scene6item4),
                    getString(context, R.string.scene6item5))
                val choices = listOf(Choice(getString(context, R.string.scene6choice1), 10, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene6choice2), 10, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
                return CinematicNode(index, prompts, choices, ECinematicImage.FLAME, ContextCompat.getColor(context, R.color.faintRed), ContextCompat.getColor(context, R.color.darkRed))
            }
            //Chose Darkness and Water, now choose Air or Earth
            if(index == 7)
            {
                val prompts = listOf(getString(context, R.string.scene7item1), getString(context, R.string.scene7item2),
                    getString(context, R.string.scene7item3), getString(context, R.string.scene7item4),
                    getString(context, R.string.scene7item5))
                val choices = listOf(Choice(getString(context, R.string.scene7choice1), 11, {state -> state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene7choice2), 11, {state -> state.addScore(Element.AERO)}, Element.AERO, 20))
                return CinematicNode(index, prompts, choices, ECinematicImage.RIVER, ContextCompat.getColor(context, R.color.faintBlue), ContextCompat.getColor(context, R.color.lightishBlue))
            }
            //Chose Light and Fire, with an option of either Earth or Air, in either case, commit to one of the three elements you've chosen
            if(index == 8)
            {
                val prompts = listOf(getString(context, R.string.scene8item1), getString(context, R.string.scene8item2),
                    getString(context, R.string.scene8item3), getString(context, R.string.scene8item4),
                    getString(context, R.string.scene8item5), getString(context, R.string.scene8item6))
                val choices: List<Choice>
                if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    choices = listOf(Choice(getString(context, R.string.scene8choice1),12,{state -> state.addScore(Element.LUXOR,2)}, Element.LUXOR,20),
                        Choice(getString(context, R.string.scene8choice2),12,{state -> state.addScore(Element.PYRO,2)}, Element.PYRO,20),
                        Choice(getString(context, R.string.scene8choice3),12,{state -> state.addScore(Element.TERRA,2)}, Element.TERRA,20))
                }
                else
                {
                    choices = listOf(Choice(getString(context, R.string.scene8choice1),12,{state -> state.addScore(Element.LUXOR,2)}, Element.LUXOR,20),
                        Choice(getString(context, R.string.scene8choice2),12,{state -> state.addScore(Element.PYRO,2)}, Element.PYRO,20),
                        Choice(getString(context, R.string.scene8choice3Alt),12,{state -> state.addScore(Element.AERO,2)}, Element.AERO,20))
                }


                return CinematicNode(index, prompts, choices, ECinematicImage.SUN, ContextCompat.getColor(context, R.color.darkBrown), ContextCompat.getColor(context, R.color.brown))
            }
            //Chose Light water and either air or earth, in either case, commit to one of the three elements you've chosen
            if(index == 9)
            {
                val prompts = listOf(getString(context, R.string.scene9item1), getString(context, R.string.scene9item2),
                    getString(context, R.string.scene9item3), getString(context, R.string.scene9item4),
                    getString(context, R.string.scene9item5))
                val choices: List<Choice>
                if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    choices = listOf(Choice(getString(context, R.string.scene9choice1),12,{state -> state.addScore(Element.LUXOR,2)}, Element.LUXOR),
                        Choice(getString(context, R.string.scene9choice2),12,{state -> state.addScore(Element.AQUA,2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene9choice3),12,{state -> state.addScore(Element.TERRA,2)}, Element.TERRA))
                }
                else
                {
                    choices = listOf(Choice(getString(context, R.string.scene9choice1),12,{state -> state.addScore(Element.LUXOR,2)}, Element.LUXOR),
                        Choice(getString(context, R.string.scene9choice2),12,{state -> state.addScore(Element.AQUA,2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene9choice3Alt),12,{state -> state.addScore(Element.AERO,2)}, Element.AERO))
                }

                return CinematicNode(index, prompts, choices, ECinematicImage.MAGIC_GLYPH, ContextCompat.getColor(context, R.color.lightishBlue), ContextCompat.getColor(context, R.color.lightCyanBlue))
            }
            //Chose darkness and fire, and either air or earth, in either case, commit to one of the three elements you've chosen
            if(index == 10)
            {
                val prompts: List<String>
                val choices: List<Choice>
                if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    prompts = listOf(getString(context, R.string.scene10item1), getString(context, R.string.scene10item2),
                        getString(context, R.string.scene10item3), getString(context, R.string.scene10item4),
                        getString(context, R.string.scene10item5), getString(context, R.string.scene10item6))
                    choices = listOf(Choice(getString(context, R.string.scene10choice1), 12, {state -> state.addScore(Element.UMBRAL, 2)}, Element.TERRA),
                        Choice(getString(context, R.string.scene10choice2),12,{state -> state.addScore(Element.PYRO, 2)}, Element.PYRO),
                        Choice(getString(context, R.string.scene10choice3),12,{state -> state.addScore(Element.TERRA, 2)}, Element.UMBRAL)
                    )
                }
                else
                {
                    prompts = listOf(getString(context, R.string.scene10item1), getString(context, R.string.scene10item2),
                        getString(context, R.string.scene10item3), getString(context, R.string.scene10item4Alt),
                        getString(context, R.string.scene10item5), getString(context, R.string.scene10item6))
                    choices = listOf(Choice(getString(context, R.string.scene10choice1),12,{state -> state.addScore(Element.UMBRAL, 2)}, Element.PYRO),
                        Choice(getString(context, R.string.scene10choice2Alt),12,{state -> state.addScore(Element.PYRO, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene10choice3Alt), 12, {state -> state.addScore(Element.AERO, 2)}, Element.AERO))
                }
                return CinematicNode(index, prompts, choices, ECinematicImage.SUN, ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.red))
            }
            //Choose Darkness and Water, and either air or earth, in either case, commit to one of the three elements you've chosen
            if(index == 11)
            {
                val prompts = listOf(getString(context, R.string.scene11item1), getString(context, R.string.scene11item2),
                    getString(context, R.string.scene11item3), getString(context, R.string.scene11item4),
                    getString(context, R.string.scene11item5), getString(context, R.string.scene11item6))
                val choices: List<Choice>
                if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    choices = listOf(Choice(getString(context, R.string.scene11choice1), 12, {state -> state.addScore(Element.UMBRAL, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene11choice2), 12, {state -> state.addScore(Element.AQUA, 2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene11choice3), 12, {state -> state.addScore(Element.TERRA, 2); state.starterMonster = "Bulbapup"; state.previousSceneName="Scene11Activity"}, Element.TERRA))
                }
                else
                {
                    choices = listOf(Choice(getString(context, R.string.scene11choice1), 12, {state -> state.addScore(Element.UMBRAL, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene11choice2), 12, {state -> state.addScore(Element.AQUA, 2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene11choice3Alt), 12, {state -> state.addScore(Element.AERO, 2)}, Element.AERO))
                }

                return CinematicNode(index, prompts, choices, ECinematicImage.MOON, ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.lightishBlue))
            }
            if(index == 12)
            {
                //                            val intent = Intent(context, Scene12Activity::class.java)
                //                            intent.putExtra("state", currentState)
                //                            startActivity(intent)
                //note: We've already started the next activity, this is to fix a bug where we click to fast
                return CinematicNode(index, listOf(), listOf(), ECinematicImage.NONE, ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.black))
            }
            throw IllegalStateException("Scene1Node index not found, max 12 actual: $index");
        }
    }
}