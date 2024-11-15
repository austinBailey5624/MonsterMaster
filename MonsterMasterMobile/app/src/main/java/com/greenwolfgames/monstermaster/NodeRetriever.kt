package com.greenwolfgames.monstermaster

import android.content.Context
import android.widget.ImageView
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
                val choices = listOf(Choice(getString(context, R.string.scene1choice1),2, {state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context, R.string.scene1choice2),3, {state.addScore(Element.UMBRAL)}, Element.UMBRAL))
                return Node(index, prompts, choices, listOf(),
                    ContextCompat.getColor(context, R.color.darkGray), ContextCompat.getColor(context, R.color.gray))
            }
            //Chose Light, now choose Fire or Water
            if(index == 2)
            {
                val prompts = listOf(getString(context, R.string.scene2item1), getString(context, R.string.scene2item2),
                    getString(context, R.string.scene2item3), getString(context, R.string.scene2item4),
                    getString(context, R.string.scene2item5))
                val choices = listOf(Choice(getString(context, R.string.scene2choice1),4, {state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context, R.string.scene2choice2),5, {state.addScore(Element.AQUA)}, Element.AQUA))
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_faint_light_from_above,
                    R.anim.fade_in_very_slow, R.id.main)),
                    ContextCompat.getColor(context, R.color.gray), ContextCompat.getColor(context, R.color.whiteGray))
            }
            //Chose Darkness, now choose Fire or Water
            if(index == 3)
            {
                val prompts = listOf(getString(context, R.string.scene3item1), getString(context, R.string.scene3item2),
                    getString(context, R.string.scene3item3), getString(context, R.string.scene3item4),
                    getString(context, R.string.scene3item5), getString(context, R.string.scene3item6))
                val choices = listOf(Choice(getString(context, R.string.scene3choice1), 6, {state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context, R.string.scene3choice2), 7, {state.addScore(Element.AQUA)}, Element.AQUA))
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_trees,
                    R.anim.fade_in_very_slow, R.id.main)),
                    ContextCompat.getColor(context, R.color.black), ContextCompat.getColor(context, R.color.darkishGray))
            }
            // Chose Light and Fire, now choose Air or Earth
            if(index == 4)
            {
                val prompts = listOf(getString(context, R.string.scene4item1), getString(context, R.string.scene4item2),
                    getString(context, R.string.scene4item3), getString(context, R.string.scene4item4),
                    getString(context, R.string.scene4item5), getString(context, R.string.scene4item6))
                val choices = listOf(Choice(getString(context, R.string.scene4choice1), 8, {state.addScore(Element.TERRA)}, Element.TERRA),
                    Choice(getString(context, R.string.scene4choice2), 8, {state.addScore(Element.AERO)}, Element.AERO))
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_flame_bottom_left,
                    R.anim.fade_in_slow, R.id.main)),
                    ContextCompat.getColor(context, R.color.darkBrown), ContextCompat.getColor(context, R.color.brown))
            }
            //Chose light and water, now choose Air or Earth
            if(index == 5)
            {
                val prompts = listOf(getString(context, R.string.scene5item1), getString(context, R.string.scene5item2),
                    getString(context, R.string.scene5item3), getString(context, R.string.scene5item4),
                    getString(context, R.string.scene5item5), getString(context, R.string.scene5item6))
                val choices = listOf(Choice(getString(context, R.string.scene5choice1), 9, {state.addScore(Element.TERRA)}, Element.TERRA),
                    Choice(getString(context, R.string.scene5choice2), 9, {state.addScore(Element.AERO)}, Element.AERO))
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_river,
                    R.anim.fade_in_very_slow, R.id.main)),
                    ContextCompat.getColor(context, R.color.lightishBlue), ContextCompat.getColor(context, R.color.lighterBlue))
            }
            //Chose Darkness and Fire, now choose Air or Earth
            if(index == 6)
            {
                val prompts = listOf(getString(context, R.string.scene6item1), getString(context, R.string.scene6item2),
                    getString(context, R.string.scene6item3), getString(context, R.string.scene6item4),
                    getString(context, R.string.scene6item5))
                val choices = listOf(Choice(getString(context, R.string.scene6choice1), 10, {state.addScore(Element.TERRA)}, Element.TERRA),
                    Choice(getString(context, R.string.scene6choice2), 10, {state.addScore(Element.AERO)}, Element.AERO))
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_flame_bottom_left,
                    R.anim.fade_in_very_slow, R.id.main)),
                    ContextCompat.getColor(context, R.color.faintRed), ContextCompat.getColor(context, R.color.darkRed))
            }
            //Chose Darkness and Water, now choose Air or Earth
            if(index == 7)
            {
                val prompts = listOf(getString(context, R.string.scene7item1), getString(context, R.string.scene7item2),
                    getString(context, R.string.scene7item3), getString(context, R.string.scene7item4),
                    getString(context, R.string.scene7item5))
                val choices = listOf(Choice(getString(context, R.string.scene7choice1), 11, {state.addScore(Element.TERRA)}, Element.TERRA),
                    Choice(getString(context, R.string.scene7choice2), 11, {state.addScore(Element.AERO)}, Element.AERO))
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_river, R.anim.fade_in_very_slow, R.id.main)),
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
                    listOf(Choice(getString(context, R.string.scene8choice1),12,{state.addScore(Element.LUXOR,2)}, Element.LUXOR),
                        Choice(getString(context, R.string.scene8choice2),14,{state.addScore(Element.PYRO,2)}, Element.PYRO),
                        Choice(getString(context, R.string.scene8choice3),16,{state.addScore(Element.TERRA,2)}, Element.TERRA))
                }
                else
                {
                    listOf(Choice(getString(context, R.string.scene8choice1),12,{state.addScore(Element.LUXOR,2)}, Element.LUXOR),
                        Choice(getString(context, R.string.scene8choice2),14,{state.addScore(Element.PYRO,2)}, Element.PYRO),
                        Choice(getString(context, R.string.scene8choice3Alt),17,{state.addScore(Element.AERO,2)}, Element.AERO))
                }
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_sunshine_upper_left,
                    R.anim.fade_in_very_slow, R.id.main)),
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

                //TODO: Make an animation so the glyph fades in and pulses
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_magic_glyph,
                    R.anim.fade_in_very_slow, R.id.background)),
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
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_sunshine_upper_left,
                    R.anim.fade_in_very_slow, R.id.background)),
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

                //TODO: replace with a cool moon sigil
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_moonshine_upper_left,
                    R.anim.fade_in_very_slow, R.id.background)),
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
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_faint_light_from_above,
                    R.anim.fade_in_very_slow, R.id.background)),
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
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_gray_skull,
                    R.anim.fade_in_very_slow, R.id.background)),
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
                return Node(index, prompts, choices, listOf(AnimationInfo(R.drawable.scene_object_flame,
                    R.anim.fade_in_very_slow, R.id.background)),
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
                //TODO: Add a waterdrop animation
                return Node(index, prompts, choices,
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
                return Node(index, prompts, choices,
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
                return Node(index, prompts, choices,
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
                    getString(context,R.string.scene54item3),state.playerName + " wake up!")
                val choices = listOf(Choice(getString(context,R.string.scene54choice),55,{}, Element.PHYSICAL))
                return Node(index, prompts, choices, ContextCompat.getColor(context, Element.getBackgroundColor(Element.PHYSICAL)),
                    ContextCompat.getColor(context, Element.getTextColor(Element.PHYSICAL)))
            }
            //OakTree-players room
            if(index == 55)
            {
                val prompts: List<String> = listOf(getString(context,R.string.scene55prompt))
                val choices = listOf(
                    Choice(getString(context, R.string.scene55choice1),56,{state.addScore(Element.UMBRAL)},Element.UMBRAL),
                    Choice(getString(context, R.string.scene55choice2),57,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context, R.string.scene55choice3),58,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context, R.string.scene55choice4),56,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context, R.string.scene55choice5),58,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene55choice6),59,{},Element.NEUTRAL))
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 56)
            {
                val prompts: List<String> = listOf(getString(context,R.string.scene56prompt))
                val choices = listOf(
                    Choice(getString(context, R.string.scene56choice1),60,{state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context, R.string.scene56choice2),58,{state.addScore(Element.AQUA)}, Element.AQUA),
                    Choice(getString(context, R.string.scene56choice3),58,{state.addScore(Element.TERRA)}, Element.TERRA))
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 57)
            {
                val prompts: List<String> = listOf(getString(context, R.string.scene57prompt))
                val choices = listOf(
                    Choice(getString(context, R.string.scene57choice1),60,{state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context, R.string.scene57choice2),58,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context, R.string.scene57choice3),58,{state.addScore(Element.TERRA)},Element.TERRA))
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 58)
            {
                val prompts: List<String> = listOf(getString(context, R.string.scene58prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene58choice1),61),
                    Choice(getString(context,R.string.scene58choice2),62),
                    Choice(getString(context,R.string.scene58choice3), 63,{state.addScore(Element.UMBRAL)},Element.UMBRAL),
                    Choice(getString(context,R.string.scene58choice4),78,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene58choice5),78,{state.addScore(Element.AERO)},Element.AERO)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 59)
            {
                val prompts = listOf(getString(context, R.string.scene59prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene59choice1), 58),
                    Choice(getString(context,R.string.scene59choice2),68)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 60)
            {
                val prompts = listOf(getString(context,R.string.scene60prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene60choice1),61),
                    Choice(getString(context,R.string.scene60choice2),62),
                    Choice(getString(context,R.string.scene60choice3),63,{state.addScore(Element.UMBRAL)}, Element.UMBRAL),
                    Choice(getString(context,R.string.scene60choice4),78,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene60choice5),78,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene60choice6),64,{state.addScore(Element.UMBRAL)},Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 61)
            {
                val prompts = listOf(getString(context,R.string.scene61prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene61choice1), 65),
                    Choice(getString(context,R.string.scene61choice2), 66, {state.addScore(Element.LUXOR)}, Element.LUXOR)

                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 62)
            {
                val prompts = listOf(getString(context,R.string.scene62prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene62choice1), 67),
                    Choice(getString(context,R.string.scene62choice2), 67,{state.addScore(Element.AERO)}, Element.AERO),
                    Choice(getString(context,R.string.scene62choice3),67,{state.addScore(Element.AQUA)}, Element.AQUA)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 63)
            {
                val prompts = listOf(getString(context,R.string.scene63prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene63choice1), 61),
                    Choice(getString(context,R.string.scene63choice2), 62),
                    Choice(getString(context,R.string.scene63choice3), 62)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 64)
            {
                val prompts = listOf(getString(context,R.string.scene64prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene64choice1), 61),
                    Choice(getString(context,R.string.scene64choice2), 62),
                    Choice(getString(context,R.string.scene64choice3), 78),//TODO: add mirror scene index
                    Choice(getString(context,R.string.scene64choice4), 77,{state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 65)
            {
                val prompts = listOf(getString(context,R.string.scene65prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene65choice1), 78),
                    Choice(getString(context,R.string.scene65choice2), 78,{state.addScore(Element.STORM)}, Element.STORM),
                    Choice(getString(context,R.string.scene65choice3),77,{state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 66)
            {
                val prompts = listOf(getString(context, R.string.scene66prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene66choice1),70,{state.addScore(Element.REDEMPTION)}, Element.REDEMPTION),
                    Choice(getString(context,R.string.scene66choice2),71,{state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context,R.string.scene66choice3), 65),
                    Choice(getString(context,R.string.scene66choice4),71,{state.addScore(Element.DEMON)}, Element.DEMON)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 67)
            {
                val prompts = listOf(getString(context, R.string.scene67prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene67choice1),78),
                    Choice(getString(context,R.string.scene67choice2),77,{state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 68)
            {
                val prompts = listOf(getString(context, R.string.scene68prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene68choice1),58),
                    Choice(getString(context,R.string.scene68choice2),72),
                    Choice(getString(context,R.string.scene68choice3),73)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 69)
            {
                val prompts = listOf(getString(context, R.string.scene69prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene69choice),78)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 70)
            {
                val prompts = listOf(getString(context, R.string.scene70prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene70choice1), 65),
                    Choice(getString(context,R.string.scene70choice2), 71, {state.addScore(Element.LUXOR)}, Element.LUXOR),
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 71)
            {
                val prompts = listOf(getString(context, R.string.scene71prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene71choice1), 78),
                    Choice(getString(context,R.string.scene71choice2),69)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 72)
            {
                val prompts = listOf(getString(context, R.string.scene72prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene72choice),78,{state.setAmnesiac(true)}, Element.NEUTRAL)//TODO add mirror scene index
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 73)
            {
                val prompts = listOf(getString(context, R.string.scene73prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene73choice),78,{state.setAmnesiac(true)}, Element.NEUTRAL)//TODO add mirror scene index
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 74)
            {
                val prompts = listOf(getString(context, R.string.scene74prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene74choice1),75,{state.addScore(Element.DEMON)}, Element.DEMON),//TODO add mirror scene index
                    Choice(getString(context,R.string.scene74choice2), 76,{state.addScore(Element.LUXOR)}, Element.LUXOR)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 75)
            {
                val prompts = listOf(getString(context, R.string.scene75prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene75choice1),78),
                    Choice(getString(context,R.string.scene75choice2), 78, {state.addScore(Element.STORM)}, Element.STORM),
                    Choice(getString(context,R.string.scene75choice3),77,{state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 76)
            {
                val prompts = listOf(getString(context, R.string.scene76prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene76choice1),78),
                    Choice(getString(context,R.string.scene76choice2), 78, {state.addScore(Element.STORM)}, Element.STORM),
                    Choice(getString(context,R.string.scene76choice3),77,{state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 77)
            {
                val prompts = listOf(getString(context, R.string.scene77prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene77choice1), 78, {state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context,R.string.scene77choice2), 78, {state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context,R.string.scene77choice3),78,{state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 78)
            {
                val prompts = listOf(getString(context, R.string.scene78prompt) + " " + Gender.getSubjectPronoun(context, state.gender)
                + ", " + Gender.getObjectPronoun(context, state.gender) + ", " + Gender.getPossessivePronoun(context, state.gender))
                val choices = listOf(
                    Choice(getString(context,R.string.scene78choice1),78){state.cyclePortrait()},
                    Choice(getString(context,R.string.scene78choice1),78){state.cyclePortraitBack()},
                    Choice(getString(context,R.string.scene78choice2),78){state.cyclePortraitGender()},
                    Choice(getString(context,R.string.scene78choice3), 78){state.cycleGender()},
                    Choice(getString(context,R.string.scene78choice4), 79)

                )
                val animations = listOf(AnimationInfo(R.drawable.scene_object_bedside_mirror, R.anim.fade_in_fast, R.id.background_center),
                    AnimationInfo(state.playerPortraitImageId, R.anim.fade_in_fast, ImageView.ScaleType.FIT_XY,
                        AnimationInfo.getDefaultLayoutParams(R.id.background_center,0.45f,0.225f)),
                    AnimationInfo(R.drawable.scene_object_bedside_mirror_overlap, R.anim.fade_in_fast, R.id.background_center))
                return Node(index, prompts, choices, animations, context)
            }
            if(index == 79)
            {
                val prompts = listOf(getString(context, R.string.scene79prompt))
                val choices: List<Choice> = listOf(
                    Choice(getString(context,R.string.scene79choice1),80,
                    {
                        if(!state.getSeenNodeBefore(index))
                        {
                            state.addScore(Element.LUXOR)
                            state.visitNode(index)
                        }
                    }, Element.LUXOR),
                    Choice(getString(context,R.string.scene79choice2), 0,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.AQUA)
                                state.visitNode(index)
                            }
                        }, Element.AQUA),
                    Choice(getString(context,R.string.scene79choice3), 0,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.TERRA)
                                state.visitNode(index)
                            }
                        }, Element.TERRA),
                    Choice(getString(context,R.string.scene79choice4), 0,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.NIGHTWING)
                                state.visitNode(index)
                            }
                        }, Element.NIGHTWING),
                    Choice(getString(context,R.string.scene79choice5),0,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.AERO)
                                state.visitNode(index)
                            }
                        }, Element.AERO)
                )
                val animations = listOf(AnimationInfo(R.drawable.background_oaktree_daylight, R.anim.fade_in_fast, R.id.background_center))
                return Node(index, prompts, choices, animations, context)
            }
            if(index == 80)
            {
                val prompts = listOf(getString(context, R.string.scene80prompt1) + state.playerName + getString(context,R.string.scene80prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene80choice1), 81,{state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context,R.string.scene80choice2),82,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene80choice3),83,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene80choice4),84,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene80choice5),85,{state.addScore(Element.UMBRAL)},Element.UMBRAL)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 81)
            {
                val prompts = listOf(getString(context,R.string.scene81prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene81choice1),86),
                    Choice(getString(context,R.string.scene81choice2),87)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 82)
            {
                val prompts = listOf(getString(context,R.string.scene82prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene82choice1),101,{state.addScore(Element.AQUA)}, Element.AQUA),
                    Choice(getString(context,R.string.scene82choice2),86),
                    Choice(getString(context,R.string.scene82choice3),88)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 83)
            {
                val prompts = listOf(getString(context,R.string.scene83prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene83choice1),86),
                    Choice(getString(context,R.string.scene83choice2),87)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 84)
            {
                val prompts = listOf(getString(context,R.string.scene84prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene84choice1),88,{state.addScore(Element.LUNAR)}, Element.LUNAR),
                    Choice(getString(context,R.string.scene84choice2),89,{state.addScore(Element.UMBRAL)},Element.UMBRAL),
                    Choice(getString(context,R.string.scene84choice3),86)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 85)
            {
                val prompts = listOf(getString(context,R.string.scene85prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene85choice1),90,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene85choice2),91),
                    Choice(getString(context,R.string.scene85choice3),87),
                    Choice(getString(context,R.string.scene85choice4),92, {state.addScore(Element.UMBRAL)}, Element.UMBRAL)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 86)
            {
                val prompts = listOf(getString(context, R.string.scene86prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene86choice1),93),
                    Choice(getString(context,R.string.scene86choice2), 79)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 87)
            {
                val prompts = listOf(getString(context, R.string.scene87prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene87choice1), 86),
                    Choice(getString(context,R.string.scene87choice2), 88, {state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene87choice3), 94,{state.addScore(Element.ANGEL)},Element.ANGEL),
                    Choice(getString(context,R.string.scene87choice4),79))
                return getMichaelChurchNode(index,prompts,choices,context)
            }
            if(index == 88)
            {
                val prompts = listOf(getString(context, R.string.scene88prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene88choice1),93, {state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context,R.string.scene88choice2), 93)
                )
                return getMichaelChurchNode(index, prompts,choices, context)
            }
            if(index == 89)
            {
                val prompts = listOf(getString(context, R.string.scene89prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene89choice1),86),
                    Choice(getString(context,R.string.scene89choice2),88),
                    Choice(getString(context,R.string.scene89choice3),94)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 90)
            {
                val prompts = listOf(getString(context, R.string.scene90prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene90choice1), 86),
                    Choice(getString(context,R.string.scene90choice2),88),
                    Choice(getString(context,R.string.scene90choice3),94)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 91)
            {
                val prompts = listOf(getString(context, R.string.scene91prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene91choice1),86),
                    Choice(getString(context,R.string.scene91choice2),87)
                )
                return getMichaelChurchNode(index,prompts, choices, context)
            }
            if(index == 92)
            {
                val prompts = listOf(getString(context, R.string.scene92prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene92choice1),86),
                    Choice(getString(context,R.string.scene92choice2),88),
                    Choice(getString(context,R.string.scene92choice3), 94)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 93)
            {
                val casual: String=when (state.gender)
                {
                    Gender.MALE -> {
                        "pal"
                    }
                    Gender.FEMALE -> {
                        "sweetie"
                    }
                    else -> {
                        "kid"
                    }
                }
                val prompts = listOf(getString(context, R.string.scene93prompt1) + casual + getString(context, R.string.scene93prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene93choice1), 96,{state.addScore(Element.ANGEL)}, Element.ANGEL),
                    Choice(getString(context,R.string.scene93choice2),96),
                    Choice(getString(context,R.string.scene93choice3), 97,{state.addScore(Element.ROTTEN)}, Element.ROTTEN)
                )
                return getFatherChurchNode(index, prompts, choices, context)
            }
            if(index == 94)
            {
                //TODO: extend
                if(state.currentGold > 10)
                {
                    val prompts = listOf(getString(context, R.string.scene94prompt2))
                    var choices = mutableListOf(
                        Choice(getString(context,R.string.scene94choice1),95,{state.addScore(Element.ANGEL)}, Element.ANGEL),
                        Choice(getString(context,R.string.scene94choice4),87))
                    if(state.currentGold > 100)
                    {
                        choices.add(Choice(getString(context,R.string.scene94choice2),95,{state.addScore(Element.ANGEL)}, Element.ANGEL))
                    }
                    if(state.currentGold > 1000)
                    {
                        choices.add(Choice(getString(context,R.string.scene94choice3), 95,{state.addScore(Element.ANGEL)}, Element.ANGEL))
                    }
                    return getMichaelChurchNode(index, prompts, choices, context)
                }
                val prompts = listOf(getString(context, R.string.scene94prompt1))
                val choices = listOf(Choice(getString(context,R.string.scene94choice4), 87))
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 95)
            {
                val prompts = listOf(getString(context, R.string.scene95prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene95choice1), 86),
                    Choice(getString(context,R.string.scene95choice2),88),
                    Choice(getString(context,R.string.scene95choice3), 94)
                )
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            if(index == 96)
            {
                val prompts = listOf(getString(context, R.string.scene96prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene96choice1), 98),
                    Choice(getString(context,R.string.scene96choice2), 99),
                    Choice(getString(context,R.string.scene96choice3),100)
                )
                return getFatherChurchNode(index, prompts, choices, context)
            }
            if(index == 97)
            {
                val prompts = listOf(getString(context, R.string.scene97prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene97choice1),96,{state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context,R.string.scene97choice2),96)
                )
                return getFatherChurchNode(index, prompts, choices, context)
            }
            if(index == 98)
            {
                val prompts = listOf(getString(context, R.string.scene98prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene98choice),79)
                )
                return getFatherChurchNode(index, prompts, choices, context)
            }
            if(index == 99)
            {
                val prompts = listOf(getString(context, R.string.scene99prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene99choice1), 98),
                    Choice(getString(context,R.string.scene99choice2), 100,{state.addScore(Element.LUXOR)}, Element.LUXOR)
                )
                return getFatherChurchNode(index, prompts, choices, context)
            }
            if(index == 100)
            {
                val casual: String=when (state.gender)
                {
                    Gender.MALE -> {
                        "pal"
                    }
                    Gender.FEMALE -> {
                        "sweetie"
                    }
                    else -> {
                        "kid"
                    }
                }
                val prompts = listOf(getString(context,R.string.scene100prompt1) + casual + getString(context,R.string.scene100prompt2))
                val choices = listOf(Choice(getString(context,R.string.scene100choice),79))
                return getFatherChurchNode(index, prompts, choices, context)
            }
            if(index == 101)
            {
                val prompts = listOf(getString(context,R.string.scene101prompt))
                val choices = listOf(Choice(getString(context,R.string.scene101choice1),86),
                    Choice(getString(context,R.string.scene101choice2),88),
                    Choice(getString(context,R.string.scene101choice3),94))
                return getMichaelChurchNode(index, prompts, choices, context)
            }
            throw IllegalStateException("Scene1Node index not found, max 101 actual: $index");
        }

        private fun getEnterNameNode(context: Context, index: Int, promptIndex: Int, element: Element): Node
        {
            val prompts: List<String> = listOf(getString(context, promptIndex))
            val choices = listOf(Choice(getString(context,R.string.enter_name),54,{},element))
            return Node(index, prompts, choices, listOf(AnimationInfo(Element.getInfantMonster(context, element).imageResourceId,
                R.anim.fade_in_slow, R.id.background_center, ImageView.ScaleType.FIT_CENTER)),
                ContextCompat.getColor(context, Element.getBackgroundColor(element)),
                ContextCompat.getColor(context, Element.getTextColor(element)))
        }

        private fun getPlayerRoomAnimations(): List<AnimationInfo>
        {
            return listOf(
                AnimationInfo(R.drawable.background_players_room,
                    R.anim.fade_in_fast, R.id.background_center),
                AnimationInfo(R.drawable.character_john_profile, R.anim.fade_in_fast, R.id.background_center,ImageView.ScaleType.FIT_CENTER))
        }

        private fun getMichaelChurchNode(index: Int, prompts: List<String>, choices: List<Choice>, context: Context): Node{
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_church, R.anim.fade_in_fast,R.id.background_center),
                AnimationInfo(R.drawable.character_michael_profile, R.anim.fade_in_fast,R.id.background_center))
            return Node(index, prompts, choices, animations, context)
        }

        private fun getFatherChurchNode(index: Int, prompts: List<String>, choices: List<Choice>, context: Context): Node{
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_church, R.anim.fade_in_fast,R.id.background_center),
                AnimationInfo(R.drawable.character_chuck_profile, R.anim.fade_in_fast,R.id.background_center))
            return Node(index, prompts, choices, animations, context)
        }
    }
}