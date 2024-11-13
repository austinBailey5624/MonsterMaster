package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString

class NodeRetriever
{
    companion object
    {
        //@formatter:off
        fun getNode(index: Int, currentState: State, context: Context, state: State): Node
        {
            //Choose Between light or dark
            if(index == 1)
            {
                val prompts = listOf(getString(context, R.string.scene1item1), getString(context, R.string.scene1item2),
                    getString(context, R.string.scene1item3), getString(context, R.string.scene1item4),
                    getString(context, R.string.scene1item5), getString(context, R.string.scene1item6),
                    getString(context, R.string.scene1item7))
                val choices = listOf(Choice(getString(context, R.string.scene1choice1),2, {state.addScore(Element.LUXOR)}, Element.LUXOR,24),
                    Choice(getString(context, R.string.scene1choice2),3, {state.addScore(Element.UMBRAL)}, Element.UMBRAL,24 ))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context, R.color.darkGray), ContextCompat.getColor(context, R.color.gray))
            }
            //Chose Light, now choose Fire or Water
            if(index == 2)
            {
                val prompts = listOf(getString(context, R.string.scene2item1), getString(context, R.string.scene2item2),
                    getString(context, R.string.scene2item3), getString(context, R.string.scene2item4),
                    getString(context, R.string.scene2item5))
                val choices = listOf(Choice(getString(context, R.string.scene2choice1),4, {state.addScore(Element.PYRO)}, Element.PYRO, 24 ),
                    Choice(getString(context, R.string.scene2choice2),5, {state.addScore(Element.AQUA)}, Element.AQUA, 24))
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_faint_light_from_above),
                    ContextCompat.getColor(context, R.color.gray), ContextCompat.getColor(context, R.color.whiteGray))
            }
            //Chose Darkness, now choose Fire or Water
            if(index == 3)
            {
                val prompts = listOf(getString(context, R.string.scene3item1), getString(context, R.string.scene3item2),
                    getString(context, R.string.scene3item3), getString(context, R.string.scene3item4),
                    getString(context, R.string.scene3item5), getString(context, R.string.scene3item6))
                val choices = listOf(Choice(getString(context, R.string.scene3choice1), 6, {state.addScore(Element.PYRO)}, Element.PYRO, 22),
                    Choice(getString(context, R.string.scene3choice2), 7, {state.addScore(Element.AQUA)}, Element.AQUA, 22))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.darkishGray))
            }
            // Chose Light and Fire, now choose Air or Earth
            if(index == 4)
            {
                val prompts = listOf(getString(context, R.string.scene4item1), getString(context, R.string.scene4item2),
                    getString(context, R.string.scene4item3), getString(context, R.string.scene4item4),
                    getString(context, R.string.scene4item5), getString(context, R.string.scene4item6))
                val choices = listOf(Choice(getString(context, R.string.scene4choice1), 8, {state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene4choice2), 8, {state.addScore(Element.AERO)}, Element.AERO, 20))
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_flame_bottom_left),
                    ContextCompat.getColor(context, R.color.darkBrown), ContextCompat.getColor(context, R.color.brown))
            }
            //Chose light and water, now choose Air or Earth
            if(index == 5)
            {
                val prompts = listOf(getString(context, R.string.scene5item1), getString(context, R.string.scene5item2),
                    getString(context, R.string.scene5item3), getString(context, R.string.scene5item4),
                    getString(context, R.string.scene5item5), getString(context, R.string.scene5item6))
                val choices = listOf(Choice(getString(context, R.string.scene5choice1), 9, {state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene5choice2), 9, {state.addScore(Element.AERO)}, Element.AERO, 20))
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_river),
                    ContextCompat.getColor(context, R.color.lightishBlue), ContextCompat.getColor(context, R.color.lighterBlue))
            }
            //Chose Darkness and Fire, now choose Air or Earth
            if(index == 6)
            {
                val prompts = listOf(getString(context, R.string.scene6item1), getString(context, R.string.scene6item2),
                    getString(context, R.string.scene6item3), getString(context, R.string.scene6item4),
                    getString(context, R.string.scene6item5))
                val choices = listOf(Choice(getString(context, R.string.scene6choice1), 10, {state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene6choice2), 10, {state.addScore(Element.AERO)}, Element.AERO, 20))
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_flame_bottom_left),
                    ContextCompat.getColor(context, R.color.faintRed), ContextCompat.getColor(context, R.color.darkRed))
            }
            //Chose Darkness and Water, now choose Air or Earth
            if(index == 7)
            {
                val prompts = listOf(getString(context, R.string.scene7item1), getString(context, R.string.scene7item2),
                    getString(context, R.string.scene7item3), getString(context, R.string.scene7item4),
                    getString(context, R.string.scene7item5))
                val choices = listOf(Choice(getString(context, R.string.scene7choice1), 11, {state.addScore(Element.TERRA)}, Element.TERRA, 26),
                    Choice(getString(context, R.string.scene7choice2), 11, {state.addScore(Element.AERO)}, Element.AERO, 20))
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_river),
                    ContextCompat.getColor(context, R.color.faintBlue), ContextCompat.getColor(context, R.color.lightishBlue))
            }
            //Chose Light and Fire, with an option of either Earth or Air, in either case, commit to one of the three elements you've chosen
            if(index == 8)
            {
                val prompts = listOf(getString(context, R.string.scene8item1), getString(context, R.string.scene8item2),
                    getString(context, R.string.scene8item3), getString(context, R.string.scene8item4),
                    getString(context, R.string.scene8item5), getString(context, R.string.scene8item6))
                val choices: List<Choice> =if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    listOf(Choice(getString(context, R.string.scene8choice1),12,{state.addScore(Element.LUXOR,2)}, Element.LUXOR,20),
                        Choice(getString(context, R.string.scene8choice2),14,{state.addScore(Element.PYRO,2)}, Element.PYRO,20),
                        Choice(getString(context, R.string.scene8choice3),16,{state.addScore(Element.TERRA,2)}, Element.TERRA,20))
                }
                else
                {
                    listOf(Choice(getString(context, R.string.scene8choice1),12,{state.addScore(Element.LUXOR,2)}, Element.LUXOR,20),
                        Choice(getString(context, R.string.scene8choice2),14,{state.addScore(Element.PYRO,2)}, Element.PYRO,20),
                        Choice(getString(context, R.string.scene8choice3Alt),17,{state.addScore(Element.AERO,2)}, Element.AERO,20))
                }
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_sunshine_upper_left),
                    ContextCompat.getColor(context, R.color.darkBrown), ContextCompat.getColor(context, R.color.brown))
            }
            //Chose Light water and either air or earth, in either case, commit to one of the three elements you've chosen
            if(index == 9)
            {
                val prompts = listOf(getString(context, R.string.scene9item1), getString(context, R.string.scene9item2),
                    getString(context, R.string.scene9item3), getString(context, R.string.scene9item4),
                    getString(context, R.string.scene9item5))
                val choices: List<Choice> =if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    listOf(Choice(getString(context, R.string.scene9choice1),12,{state.addScore(Element.LUXOR,2)}, Element.LUXOR),
                        Choice(getString(context, R.string.scene9choice2),15,{state.addScore(Element.AQUA,2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene9choice3),16,{state.addScore(Element.TERRA,2)}, Element.TERRA))
                }
                else
                {
                    listOf(Choice(getString(context, R.string.scene9choice1),12,{state.addScore(Element.LUXOR,2)}, Element.LUXOR),
                        Choice(getString(context, R.string.scene9choice2),15,{state.addScore(Element.AQUA,2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene9choice3Alt),17,{state.addScore(Element.AERO,2)}, Element.AERO))
                }

                return Node(index, prompts, choices, listOf(R.drawable.scene_object_magic_glyph),
                    ContextCompat.getColor(context, R.color.lightishBlue), ContextCompat.getColor(context, R.color.lightCyanBlue))
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
                    choices = listOf(Choice(getString(context, R.string.scene10choice1), 13, {state.addScore(Element.UMBRAL, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene10choice2),14,{state.addScore(Element.PYRO, 2)}, Element.PYRO),
                        Choice(getString(context, R.string.scene10choice3),16,{state.addScore(Element.TERRA, 2)}, Element.TERRA)
                    )
                }
                else
                {
                    prompts = listOf(getString(context, R.string.scene10item1), getString(context, R.string.scene10item2),
                        getString(context, R.string.scene10item3), getString(context, R.string.scene10item4Alt),
                        getString(context, R.string.scene10item5), getString(context, R.string.scene10item6))
                    choices = listOf(Choice(getString(context, R.string.scene10choice1),13,{state.addScore(Element.UMBRAL, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene10choice2Alt),14,{state.addScore(Element.PYRO, 2)}, Element.PYRO),
                        Choice(getString(context, R.string.scene10choice3Alt), 17, {state.addScore(Element.AERO, 2)}, Element.AERO))
                }
                return Node(index, prompts, choices, listOf(R.drawable.scene_object_sunshine_upper_left),
                    ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.red))
            }
            //Choose Darkness and Water, and either air or earth, in either case, commit to one of the three elements you've chosen
            if(index == 11)
            {
                val prompts = listOf(getString(context, R.string.scene11item1), getString(context, R.string.scene11item2),
                    getString(context, R.string.scene11item3), getString(context, R.string.scene11item4),
                    getString(context, R.string.scene11item5), getString(context, R.string.scene11item6))
                val choices: List<Choice> = if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    listOf(Choice(getString(context, R.string.scene11choice1), 13, {state.addScore(Element.UMBRAL, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene11choice2), 15, {state.addScore(Element.AQUA, 2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene11choice3), 16, {state.addScore(Element.TERRA, 2)}, Element.TERRA))
                }
                else
                {
                    listOf(Choice(getString(context, R.string.scene11choice1), 13, {state.addScore(Element.UMBRAL, 2)}, Element.UMBRAL),
                        Choice(getString(context, R.string.scene11choice2), 15, {state.addScore(Element.AQUA, 2)}, Element.AQUA),
                        Choice(getString(context, R.string.scene11choice3Alt), 16, {state.addScore(Element.AERO, 2)}, Element.AERO))
                }

                return Node(index, prompts, choices, listOf(R.drawable.scene_object_moonshine_upper_left),
                    ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.lightishBlue))
            }
            if(index == 12)
            {
                val prompts = listOf(getString(context, R.string.scene12item1),getString(context, R.string.scene12item2),
                    getString(context,R.string.scene12item3),getString(context, R.string.scene12item4),
                    getString(context,R.string.scene12item5))
                val choices = listOf(Choice(getString(context,R.string.scene12choice1),18,{state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context,R.string.scene12choice2),19,{state.addScore(Element.REDEMPTION)}, Element.REDEMPTION),
                    Choice(getString(context,R.string.scene12choice3),20,{state.addScore(Element.SOLAR)}, Element.SOLAR),
                    Choice(getString(context,R.string.scene12choice4),21,{state.addScore(Element.LUNAR)}, Element.LUNAR),
                    Choice(getString(context,R.string.scene12choice5),22,{state.addScore(Element.GUARDIAN)}, Element.GUARDIAN),
                    Choice(getString(context,R.string.scene12choice6),23,{state.addScore(Element.ANGEL)}, Element.ANGEL))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context,Element.getButtonBackgroundColor(Element.LUXOR)),
                    ContextCompat.getColor(context,Element.getTextColor(Element.LUXOR)))
            }
            if(index == 13)
            {
                val prompts = listOf(getString(context, R.string.scene13item1), getString(context, R.string.scene13item2),
                    getString(context,R.string.scene13item3), getString(context,R.string.scene13item4),
                    getString(context,R.string.scene13item5), getString(context,R.string.scene13item6))
                val choices = listOf(Choice(getString(context,R.string.scene13choice1),24,{state.addScore(Element.BETRAYER)}, Element.BETRAYER),
                    Choice(getString(context,R.string.scene13choice2),25,{state.addScore(Element.UMBRAL)}, Element.UMBRAL),
                    Choice(getString(context,R.string.scene13choice3),26,{state.addScore(Element.DEMON)}, Element.DEMON),
                    Choice(getString(context,R.string.scene13choice4),27,{state.addScore(Element.POISON)}, Element.POISON),
                    Choice(getString(context,R.string.scene13choice5),28,{state.addScore(Element.UNDEAD)}, Element.UNDEAD),
                    Choice(getString(context,R.string.scene13choice6),29,{state.addScore(Element.STORM)}, Element.STORM))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context,R.color.black),
                    ContextCompat.getColor(context,R.color.darkishGray))
            }
            if(index == 14)
            {
                val prompts = listOf(getString(context, R.string.scene14item1), getString(context, R.string.scene14item2),
                    getString(context,R.string.scene14item3),getString(context,R.string.scene14item4),
                    getString(context,R.string.scene14item5))
                val choices = listOf(Choice(getString(context,R.string.scene14choice1),30,{state.addScore(Element.JUSTICE)}, Element.JUSTICE),
                    Choice(getString(context,R.string.scene14choice2),31,{state.addScore(Element.VENGEANCE)}, Element.VENGEANCE),
                    Choice(getString(context,R.string.scene14choice3),32,{state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context,R.string.scene14choice4),33,{state.addScore(Element.LAVA)}, Element.LAVA),
                    Choice(getString(context,R.string.scene14choice5),34,{state.addScore(Element.DINO)}, Element.DINO),
                    Choice(getString(context,R.string.scene14choice6),35,{state.addScore(Element.SAND)},Element.SAND))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context,Element.getButtonBackgroundColor(Element.PYRO)),
                    ContextCompat.getColor(context,Element.getTextColor(Element.PYRO)))
            }
            if(index == 15)
            {
                val prompts = listOf(getString(context,R.string.scene15item1),getString(context,R.string.scene15item2),
                    getString(context,R.string.scene15item3), getString(context,R.string.scene15item4),
                    getString(context,R.string.scene15item5))
                val choices = listOf(Choice(getString(context,R.string.scene15choice1),36,{state.addScore(Element.ICE)}, Element.ICE),
                    Choice(getString(context,R.string.scene15choice2),37,{state.addScore(Element.DEEP)}, Element.DEEP),
                    Choice(getString(context,R.string.scene15choice3),38,{state.addScore(Element.STEAM)}, Element.STEAM),
                    Choice(getString(context,R.string.scene15choice4),39,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene15choice5),40,{state.addScore(Element.AMPHIBIOUS)},Element.AMPHIBIOUS),
                    Choice(getString(context,R.string.scene15choice6),41,{state.addScore(Element.WEATHER)},Element.WEATHER))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context,Element.getButtonBackgroundColor(Element.AQUA)),
                    ContextCompat.getColor(context,Element.getTextColor(Element.AQUA)))}
            if(index == 16)
            {
                val prompts: List<String> = if(currentState.getScore(Element.TERRA) > currentState.getScore(Element.AERO))
                {
                    listOf(getString(context,R.string.scene16item1),getString(context,R.string.scene16item2),
                        getString(context,R.string.scene16item3),getString(context,R.string.scene16item4),
                        getString(context,R.string.scene16item5))
                }
                else
                {
                    listOf(getString(context,R.string.scene16item1Alt),getString(context,R.string.scene16item2),
                        getString(context,R.string.scene16item3),getString(context,R.string.scene16item4),
                        getString(context,R.string.scene16item5))
                }
                val choices = listOf(Choice(getString(context,R.string.scene16choice1),42,{state.addScore(Element.COMPASSION)}, Element.COMPASSION),
                    Choice(getString(context,R.string.scene16choice2),43,{state.addScore(Element.ROTTEN)},Element.ROTTEN),
                    Choice(getString(context,R.string.scene16choice3),44,{state.addScore(Element.FEY)},Element.FEY),
                    Choice(getString(context,R.string.scene16choice4),45,{state.addScore(Element.PLANT)}, Element.PLANT),
                    Choice(getString(context,R.string.scene16choice5),46,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene16choice6),47,{state.addScore(Element.PEGASUS)},Element.PEGASUS))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context,Element.getButtonBackgroundColor(Element.TERRA)),
                    ContextCompat.getColor(context,Element.getTextColor(Element.TERRA)))}
            if(index == 17)
            {
                val prompts: List<String>
                if(currentState.getScore(Element.LUXOR) > currentState.getScore(Element.UMBRAL) && currentState.getScore(Element.PYRO) > currentState.getScore(Element.AQUA))
                {
                    prompts = listOf(getString(context,R.string.scene17item1),getString(context,R.string.scene17item2),
                        getString(context,R.string.scene17item3),getString(context,R.string.scene17item4),
                        getString(context,R.string.scene17item5))
                }
                else if(currentState.getScore(Element.UMBRAL) > currentState.getScore(Element.LUXOR) && currentState.getScore(Element.PYRO) > currentState.getScore(Element.AQUA))
                {
                    prompts = listOf(getString(context,R.string.scene17item1Alt1),getString(context,R.string.scene17item2),
                        getString(context,R.string.scene17item3),getString(context,R.string.scene17item4),
                        getString(context,R.string.scene17item5))
                }
                else
                {
                    prompts = listOf(getString(context,R.string.scene17item1Alt2),getString(context,R.string.scene17item2),
                        getString(context,R.string.scene17item3),getString(context,R.string.scene17item4),
                        getString(context,R.string.scene17item5))
                }
                val choices = listOf(Choice(getString(context,R.string.scene17choice1),48,{state.addScore(Element.COCKA)}, Element.COCKA),
                    Choice(getString(context,R.string.scene17choice2),49,{state.addScore(Element.NIGHTWING)},Element.NIGHTWING),
                    Choice(getString(context,R.string.scene17choice3),50,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene17choice4),51,{state.addScore(Element.SEABREEZE)}, Element.SEABREEZE),
                    Choice(getString(context,R.string.scene17choice5),52,{state.addScore(Element.BIRD)},Element.BIRD),
                    Choice(getString(context,R.string.scene17choice6),53,{state.addScore(Element.AERO)},Element.AERO))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context,Element.getButtonBackgroundColor(Element.AERO)),
                    ContextCompat.getColor(context,Element.getTextColor(Element.AERO)))
            }
            if(index == 18)
            {
                return getEnterNameNode(context, index, R.string.scene18prompt, Element.LUXOR)
            }
            if(index == 19)
            {
                return getEnterNameNode(context, index, R.string.scene19prompt, Element.REDEMPTION)
            }
            if(index == 20)
            {
                return getEnterNameNode(context, index, R.string.scene20prompt, Element.SOLAR)
            }
            if(index == 21)
            {
                return getEnterNameNode(context, index, R.string.scene21prompt, Element.LUNAR)
            }
            if(index == 22)
            {
                return getEnterNameNode(context, index, R.string.scene22prompt, Element.GUARDIAN)
            }
            if(index == 23)
            {
                return getEnterNameNode(context, index, R.string.scene23prompt, Element.ANGEL)
            }
            if(index == 24)
            {
                return getEnterNameNode(context, index, R.string.scene24prompt, Element.BETRAYER)
            }
            if(index == 25)
            {
                return getEnterNameNode(context, index, R.string.scene25prompt, Element.UMBRAL)
            }
            if(index == 26)
            {
                return getEnterNameNode(context, index, R.string.scene26prompt, Element.DEMON)
            }
            if(index == 27)
            {
                return getEnterNameNode(context, index, R.string.scene27prompt, Element.POISON)
            }
            if(index == 28)
            {
                return getEnterNameNode(context, index, R.string.scene28prompt, Element.UNDEAD)
            }
            if(index == 29)
            {
                return getEnterNameNode(context, index, R.string.scene29prompt, Element.STORM)
            }
            if(index == 30)
            {
                return getEnterNameNode(context, index, R.string.scene30prompt, Element.JUSTICE)
            }
            if(index == 31)
            {
                return getEnterNameNode(context, index, R.string.scene31prompt, Element.VENGEANCE)
            }
            if(index == 32)
            {
                return getEnterNameNode(context, index, R.string.scene32prompt, Element.PYRO)
            }
            if(index == 33)
            {
                return getEnterNameNode(context, index, R.string.scene33prompt, Element.LAVA)
            }
            if(index == 34)
            {
                return getEnterNameNode(context, index, R.string.scene34prompt, Element.DINO)
            }
            if(index == 35)
            {
                return getEnterNameNode(context, index, R.string.scene35prompt, Element.SAND)
            }
            if(index == 36)
            {
                return getEnterNameNode(context, index, R.string.scene36prompt, Element.ICE)
            }
            if(index == 37)
            {
                return getEnterNameNode(context, index, R.string.scene37prompt, Element.DEEP)
            }
            if(index == 38)
            {
                return getEnterNameNode(context, index, R.string.scene38prompt, Element.STEAM)
            }
            if(index == 39)
            {
                return getEnterNameNode(context, index, R.string.scene39prompt, Element.AQUA)
            }
            if(index == 40)
            {
                return getEnterNameNode(context, index, R.string.scene40prompt, Element.AMPHIBIOUS)
            }
            if(index == 41)
            {
                return getEnterNameNode(context, index, R.string.scene41prompt, Element.WEATHER)
            }
            if(index == 42)
            {
                return getEnterNameNode(context, index, R.string.scene42prompt, Element.COMPASSION)
            }
            if(index == 43)
            {
                return getEnterNameNode(context, index, R.string.scene43prompt, Element.ROTTEN)
            }
            if(index == 44)
            {
                return getEnterNameNode(context, index, R.string.scene44prompt, Element.FEY)
            }
            if(index == 45)
            {
                return getEnterNameNode(context, index, R.string.scene45prompt, Element.PLANT)
            }
            if(index == 46)
            {
                return getEnterNameNode(context, index, R.string.scene46prompt, Element.TERRA)
            }
            if(index == 47)
            {
                return getEnterNameNode(context, index, R.string.scene47prompt, Element.PEGASUS)
            }
            if(index == 48)
            {
                return getEnterNameNode(context, index, R.string.scene48prompt, Element.COCKA)
            }
            if(index == 49)
            {
                return getEnterNameNode(context, index, R.string.scene49prompt, Element.NIGHTWING)
            }
            if(index == 50)
            {
                return getEnterNameNode(context, index, R.string.scene50prompt, Element.PHOENIX)
            }
            if(index == 51)
            {
                return getEnterNameNode(context, index, R.string.scene51prompt, Element.SEABREEZE)
            }
            if(index == 52)
            {
                return getEnterNameNode(context, index, R.string.scene52prompt, Element.BIRD)
            }
            if(index == 53)
            {
                return getEnterNameNode(context, index, R.string.scene53prompt, Element.AERO)
            }
            if(index == 54)
            {
                val prompts: List<String> = listOf(getString(context,R.string.scene54item1),state.playerName,
                    getString(context,R.string.scene54item2), state.playerName,
                    getString(context,R.string.scene54item3),state.playerName)
                val choices = listOf(Choice(getString(context,R.string.scene54choice), 55, {state -> state}, Element.PHYSICAL))
                return Node(index, prompts, choices, listOf(), ContextCompat.getColor(context, Element.getBackgroundColor(Element.PHYSICAL)),
                    ContextCompat.getColor(context, Element.getTextColor(Element.PHYSICAL)))
            }
            throw IllegalStateException("Scene1Node index not found, max 54 actual: $index");
        }

        private fun getEnterNameNode(context: Context, index: Int, promptIndex: Int, element: Element): Node
        {
            val prompts: List<String> = listOf(getString(context, promptIndex))
            val choices = listOf(Choice(getString(context,R.string.enter_name),54,{state -> state},element))
            return Node(index, prompts, choices, listOf(Element.getInfantMonster(context, element).imageResourceId), ContextCompat.getColor(context, Element.getBackgroundColor(element)),
                ContextCompat.getColor(context, Element.getTextColor(element)))
        }
    }
}