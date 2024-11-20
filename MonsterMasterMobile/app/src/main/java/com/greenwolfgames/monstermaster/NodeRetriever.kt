package com.greenwolfgames.monstermaster

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString

/**
 * Class to retrieve Nodes based on the provided index. Some nodes will behave differently depending on the state
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright: Austin Bailey 2024 All Rights Reserved
 */
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
                    Choice(getString(context,R.string.scene72choice),78,{state.setQuestStage(Quest.AMNESIA,1)}, Element.NEUTRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 73)
            {
                val prompts = listOf(getString(context, R.string.scene73prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene73choice),78,{state.setQuestStage(Quest.AMNESIA,1)}, Element.NEUTRAL)
                )
                return Node(index, prompts, choices, getPlayerRoomAnimations(), context)
            }
            if(index == 74)
            {
                val prompts = listOf(getString(context, R.string.scene74prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene74choice1),75,{state.addScore(Element.DEMON)}, Element.DEMON),
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

                val choices: List<Choice>
                //if we've visited this node before, we don't award points on decisions (avoid infinite loop)
                if(state.getSeenNodeBefore(index))
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene79choice1),80),
                        Choice(getString(context,R.string.scene79choice2),102),
                        Choice(getString(context,R.string.scene79choice3),177),
                        Choice(getString(context,R.string.scene79choice4),187),
                        Choice(getString(context,R.string.scene79choice5),0)
                    )
                }
                //if we've never been to this node before
                else
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene79choice1),80,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.LUXOR)
                                state.visitNode(index)
                            }
                        }, Element.LUXOR),
                        Choice(getString(context,R.string.scene79choice2), 102,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.AQUA)
                                state.visitNode(index)
                            }
                        }, Element.AQUA),
                        Choice(getString(context,R.string.scene79choice3), 177,
                        {
                            if(!state.getSeenNodeBefore(index))
                            {
                                state.addScore(Element.TERRA)
                                state.visitNode(index)
                            }
                        }, Element.TERRA),
                        Choice(getString(context,R.string.scene79choice4), 187,
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
                }
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
                    Choice(getString(context,R.string.scene85choice2),91 ){state.setQuestStage(Quest.KYLER_REDEMPTION,1)},
                    Choice(getString(context,R.string.scene85choice3),87 ){state.setQuestStage(Quest.KYLER_REDEMPTION,1)},
                    Choice(getString(context,R.string.scene85choice4),92, {state.addScore(Element.UMBRAL);state.setQuestStage(Quest.KYLER_REDEMPTION,1)}, Element.UMBRAL)
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
                val prompts = listOf(getString(context, R.string.scene93prompt1) + " "
                        + Gender.getDadsNickname(context, state.gender) + " " + getString(context, R.string.scene93prompt2))
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
                    val choices = mutableListOf(
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
                    Choice(getString(context,R.string.scene96choice1), 98){state.initChoresQuestline()},
                    Choice(getString(context,R.string.scene96choice2), 99){state.initChoresQuestline()},
                    Choice(getString(context,R.string.scene96choice3),100){state.initChoresQuestline()}
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
                val prompts = listOf(getString(context,R.string.scene100prompt1) + Gender.getDadsNickname(context, state.gender) + getString(context,R.string.scene100prompt2))
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
            if(index == 102)
            {
                val prompts = listOf(getString(context,R.string.scene102prompt1) + " " + state.playerName + " " +
                getString(context,R.string.scene102prompt2))
                val choices = listOf(Choice(getString(context,R.string.scene102choice1),103,{state.addScore(Element.PYRO)}, Element.PYRO),
                    Choice(getString(context,R.string.scene102choice2),104,{state.addScore(Element.LUXOR)}, Element.LUXOR),
                    Choice(getString(context,R.string.scene102choice3),105,{state.addScore(Element.PEGASUS)}, Element.PEGASUS),
                    Choice(getString(context,R.string.scene102choice4),106,{state.addScore(Element.AQUA)}, Element.AQUA),
                    Choice(getString(context,R.string.scene102choice5),107),
                    Choice(getString(context,R.string.scene102choice6),108,{state.addScore(Element.PHOENIX)}, Element.PHOENIX))
                return getBrahmNode(index, prompts, choices, context)
            }
            if(index == 103)
            {
                val prompts = listOf(getString(context,R.string.scene103prompt))
                val choices = listOf(Choice(getString(context,R.string.scene103choice1),109,{state.addScore(Element.AQUA)},Element.AQUA),
                Choice(getString(context,R.string.scene103choice2),109,{state.addScore(Element.UMBRAL)},Element.UMBRAL),
                Choice(getString(context,R.string.scene103choice3),110))
                return getBrahmNode(index, prompts, choices, context)
            }
            if(index == 104)
            {
                val prompts = listOf(getString(context,R.string.scene104prompt))
                val choices = listOf(Choice(getString(context,R.string.scene104choice1), 111,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene104choice2),112,{state.addScore(Element.WEATHER)},Element.WEATHER),
                    Choice(getString(context,R.string.scene104choice3),113))
                return getBrahmNode(index, prompts, choices, context)
            }
            if(index == 105)
            {
                val prompts = listOf(getString(context,R.string.scene105prompt))
                val choices = listOf(Choice(getString(context,R.string.scene105choice1),114,{state.addScore(Element.BIRD)},Element.BIRD),
                    Choice(getString(context,R.string.scene105choice2),113,{state.addScore(Element.AQUA)},Element.AQUA))
                return getBrahmNode(index, prompts, choices, context)
            }
            if(index == 106)
            {
                val prompts = listOf(getString(context,R.string.scene106prompt))
                val choices = listOf(Choice(getString(context,R.string.scene106choice1),133,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene106choice2),115,{state.addScore(Element.LAVA)},Element.LAVA))
                return getBrahmNode(index,prompts, choices, context)
            }
            if(index == 107)
            {
                val prompts = listOf(getString(context,R.string.scene107prompt))
                val choices = listOf(Choice(getString(context,R.string.scene107choice1),116),
                    Choice(getString(context,R.string.scene107choice2),117))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 108)
            {
                val prompts = listOf(getString(context,R.string.scene108prompt))
                val choices = listOf(Choice(getString(context,R.string.scene108choice1),112,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene108choice2),131,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene108choice3),140,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene108choice4),152,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene108choice5),160,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene108choice6),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 109)
            {
                val prompts = listOf(getString(context,R.string.scene109prompt))
                val choices = listOf(Choice(getString(context,R.string.scene109choice1),112,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene109choice2),131,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene109choice3),140,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene109choice4),152,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene109choice5),160,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene109choice6),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 110)
            {
                val prompts = listOf(getString(context,R.string.scene110prompt))
                val choices = listOf(Choice(getString(context,R.string.scene110choice1),165),
                    Choice(getString(context,R.string.scene110choice2),168),
                    Choice(getString(context,R.string.scene110choice3),109))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 111)
            {
                val prompts = listOf(getString(context,R.string.scene111prompt))
                val choices = listOf(Choice(getString(context,R.string.scene111choice1),170),
                    Choice(getString(context,R.string.scene111choice2),171),
                    Choice(getString(context,R.string.scene111choice3),112))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 112)
            {
                val prompts = listOf(getString(context,R.string.scene112prompt))
                val choices = listOf(Choice(getString(context,R.string.scene112choice1),118),
                    Choice(getString(context,R.string.scene112choice2),119,{state.addScore(Element.UMBRAL)},Element.UMBRAL))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 113)
            {
                val prompts = listOf(getString(context,R.string.scene113prompt))
                val choices = listOf(Choice(getString(context,R.string.scene113choice1),112,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene113choice1),131,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene113choice3),140,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene113choice4),152,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene113choice5),160,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene113choice6),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 114)
            {
                val prompts = listOf(getString(context,R.string.scene114prompt))
                val choices = listOf(Choice(getString(context,R.string.scene114choice1),112,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene114choice2),131,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene114choice3),140,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene114choice4),152,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene114choice5),160,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene114choice6),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 115)
            {
                val prompts = listOf(getString(context,R.string.scene115prompt))
                val choices = listOf(Choice(getString(context,R.string.scene115choice1),131),
                    Choice(getString(context,R.string.scene115choice2),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 116)
            {
                val prompts = listOf(getString(context,R.string.scene116prompt))
                val choices = listOf(Choice(getString(context,R.string.scene116choice1),112),
                    Choice(getString(context,R.string.scene116choice1),172))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 117)
            {
                val prompts = listOf(getString(context,R.string.scene117prompt))
                val choices = listOf(Choice(getString(context,R.string.scene117choice1),175,{state.addScore(Element.JUSTICE)},Element.JUSTICE),
                    Choice(getString(context,R.string.scene117choice2),112,{state.addScore(Element.AQUA)},Element.AQUA))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 118)
            {
                val prompts = listOf(getString(context,R.string.scene118prompt))
                val choices = listOf(Choice(getString(context,R.string.scene118choice1),120),
                    Choice(getString(context,R.string.scene118choice2),119))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 119)
            {
                val prompts = listOf(getString(context,R.string.scene119prompt))
                val choices = listOf(Choice(getString(context,R.string.scene119choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 120)
            {
                val prompts = listOf(getString(context,R.string.scene120prompt))
                val choices = listOf(Choice(getString(context,R.string.scene120choice1),121),
                    Choice(getString(context,R.string.scene120choice2),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 121)
            {
                val prompts = listOf(getString(context,R.string.scene121prompt))
                val choices = listOf(Choice(getString(context,R.string.scene121choice1),123),
                    Choice(getString(context,R.string.scene121choice2),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 122)
            {
                val prompts = listOf(getString(context,R.string.scene122prompt))
                val choices = listOf(Choice(getString(context,R.string.scene122choice),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 123)
            {
                val prompts = listOf(getString(context,R.string.scene123prompt))
                val choices = listOf(Choice(getString(context,R.string.scene123choice1),124,{state.addScore(Element.LUNAR)},Element.LUNAR),
                    Choice(getString(context,R.string.scene123choice2),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 124)
            {
                val prompts = listOf(getString(context,R.string.scene124prompt))
                val choices = listOf(Choice(getString(context,R.string.scene124choice1),125,{state.addScore(Element.LUNAR)},Element.LUNAR),
                    Choice(getString(context,R.string.scene124choice2),126,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 125)
            {
                val prompts = listOf(getString(context,R.string.scene125prompt))
                val choices = listOf(Choice(getString(context,R.string.scene125choice1),127,{state.addScore(Element.LUNAR)},Element.LUNAR),
                    Choice(getString(context,R.string.scene125choice2),126,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 126)
            {
                val prompts = listOf(getString(context,R.string.scene126prompt))
                val choices = listOf(Choice(getString(context,R.string.scene126choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 127)
            {
                val prompts = listOf(getString(context,R.string.scene127prompt))
                val choices = listOf(Choice(getString(context,R.string.scene127choice),128))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 128)
            {
                val prompts = listOf(getString(context,R.string.scene128prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene128choice1),129){state.setChoresStage_WritingLessonFinished()},
                    Choice(getString(context,R.string.scene128choice2),130){state.setChoresStage_WritingLessonFinished()})
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 129)
            {
                val prompts = listOf(getString(context,R.string.scene129prompt))
                val choices = listOf(Choice(getString(context,R.string.scene129choice1),176),
                    Choice(getString(context,R.string.scene129choice2),130))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 130)
            {
                val prompts = listOf(getString(context,R.string.scene130prompt))
                val choices = listOf(Choice(getString(context,R.string.scene130choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 131)
            {
                val prompts = listOf(getString(context,R.string.scene131prompt))
                val choices = listOf(Choice(getString(context,R.string.scene131choice1),133,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene132choice2),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 132)
            {
                val prompts = listOf(getString(context,R.string.scene132prompt))
                val choices = listOf(Choice(getString(context,R.string.scene132choice1),113),
                    Choice(getString(context,R.string.scene132choice2),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 133)
            {
                val prompts = listOf(getString(context,R.string.scene133prompt))
                val choices = listOf(Choice(getString(context,R.string.scene133choice1),134,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene133choice2),119,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 134)
            {
                val prompts = listOf(getString(context,R.string.scene134prompt))
                val choices = listOf(Choice(getString(context,R.string.scene134choice1),135,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene134choice2),119,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 135)
            {
                val prompts = listOf(getString(context,R.string.scene135prompt))
                val choices = listOf(Choice(getString(context,R.string.scene135choice1),136,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene135choice2),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index ==136)
            {
                val prompts = listOf(getString(context,R.string.scene136prompt))
                val choices = listOf(Choice(getString(context,R.string.scene136choice), 137){state.setChoresStage_WritingLessonFinished()})
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 137)
            {
                val prompts = listOf(getString(context,R.string.scene137prompt1) + " " + state.playerName + " " + getString(context,R.string.scene137prompt2))
                val choices = listOf(Choice(getString(context,R.string.scene137choice1),79),
                    Choice(getString(context,R.string.scene137choice2), 138,{state.addScore(Element.AQUA)},Element.AQUA))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 138)
            {
                val prompts = listOf(getString(context,R.string.scene138prompt))
                val choices = listOf(Choice(getString(context,R.string.scene138choice1),79),
                    Choice(getString(context,R.string.scene138choice2),139,{state.addScore(Element.DEEP)},Element.DEEP))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 139)
            {
                val prompts = listOf(getString(context,R.string.scene139prompt))
                val choices = listOf(Choice(getString(context,R.string.scene139choice),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 140)
            {
                val prompts = listOf(getString(context,R.string.scene140prompt))
                val choices = listOf(Choice(getString(context,R.string.scene140choice1),141,{state.addScore(Element.STEAM)},Element.STEAM),
                    Choice(getString(context,R.string.scene140choice2),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 141)
            {
                val prompts = listOf(getString(context,R.string.scene141prompt))
                val choices = listOf(Choice(getString(context,R.string.scene141choice1),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene141choice2),141,{state.addScore(Element.STEAM)},Element.STEAM))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 142)
            {
                val prompts = listOf(getString(context,R.string.scene142prompt))
                val choices = listOf(Choice(getString(context,R.string.scene142choice1),143,{state.addScore(Element.STEAM)},Element.STEAM),
                    Choice(getString(context,R.string.scene142choice2),119,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 143)
            {
                val prompts = listOf(getString(context,R.string.scene143prompt))
                val choices = listOf(Choice(getString(context,R.string.scene143choice1),144,{state.addScore(Element.STEAM)},Element.STEAM),
                    Choice(getString(context,R.string.scene143choice2),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 144)
            {
                val prompts = listOf(getString(context,R.string.scene144prompt))
                val choices = listOf(Choice(getString(context,R.string.scene144choice1),145,{state.addScore(Element.STEAM)},Element.STEAM),
                    Choice(getString(context,R.string.scene144choice2),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 145)
            {
                val prompts = listOf(getString(context,R.string.scene145prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene145choice1),137){state.setChoresStage_WritingLessonFinished()},
                    Choice(getString(context,R.string.scene145choice1),146,{state.addScore(Element.LAVA);state.setChoresStage_WritingLessonFinished()}, Element.LAVA))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 146)
            {
                val prompts = listOf(getString(context,R.string.scene146prompt))
                val choices = listOf(Choice(getString(context,R.string.scene146choice1),147,{state.addScore(Element.JUSTICE)},Element.JUSTICE),
                    Choice(getString(context,R.string.scene146choice2),148),
                    Choice(getString(context,R.string.scene146choice3),149,{state.addScore(Element.DEMON)},Element.DEMON))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 147)
            {
                val prompts = listOf(getString(context,R.string.scene147prompt))
                val choices = listOf(Choice(getString(context,R.string.scene147choice1),150))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 148)
            {
                val prompts = listOf(getString(context,R.string.scene148prompt))
                val choices = listOf(Choice(getString(context,R.string.scene148choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 149)
            {
                val prompts = listOf(getString(context,R.string.scene149prompt))
                val choices = listOf(Choice(getString(context,R.string.scene149choice1),150,{state.addScore(Element.JUSTICE)},Element.JUSTICE),
                    Choice(getString(context,R.string.scene149choice2),151,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene149choice3),151,{state.addScore(Element.DEMON)},Element.DEMON))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 150)
            {
                val prompts = listOf(getString(context,R.string.scene150prompt))
                val choices = listOf(Choice(getString(context,R.string.scene150choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 151)
            {
                val prompts = listOf(getString(context,R.string.scene151prompt))
                val choices = listOf(Choice(getString(context,R.string.scene151choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 152)
            {
                val prompts = listOf(getString(context,R.string.scene152prompt))
                val choices = listOf(Choice(getString(context,R.string.scene152choice1),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene152choice2),153,{state.addScore(Element.WEATHER)},Element.WEATHER))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 153)
            {
                val prompts = listOf(getString(context,R.string.scene153prompt))
                val choices = listOf(Choice(getString(context,R.string.scene153choice1),119,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene153choice2),154,{state.addScore(Element.WEATHER)},Element.WEATHER))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 154)
            {
                val prompts = listOf(getString(context,R.string.scene154prompt))
                val choices = listOf(Choice(getString(context,R.string.scene154choice1),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene154choice2),155,{state.addScore(Element.WEATHER)},Element.WEATHER))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 155)
            {
                val prompts = listOf(getString(context,R.string.scene155prompt))
                val choices = listOf(Choice(getString(context,R.string.scene155choice1),137),
                    Choice(getString(context,R.string.scene155choice2),156){state.setChoresStage_WritingLessonFinished()},
                    Choice(getString(context,R.string.scene155choice3),157){state.setChoresStage_WritingLessonFinished()})
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 156)
            {
                val prompts = listOf(getString(context,R.string.scene156prompt))
                val choices = listOf(Choice(getString(context,R.string.scene156choice1),137))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 157)
            {
                val prompts = listOf(getString(context,R.string.scene157prompt))
                val choices = listOf(Choice(getString(context,R.string.scene157choice1),158,{state.addScore(Element.ANGEL)},Element.ANGEL),
                    Choice(getString(context,R.string.scene157choice2),159,{state.addScore(Element.NIGHTWING)},Element.NIGHTWING))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 158)
            {
                val prompts = listOf(getString(context,R.string.scene158prompt1) + " " + Gender.getBrahmsNickname(context,state.gender))
                val choices = listOf(Choice(getString(context,R.string.scene158choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 159)
            {
                val prompts = listOf(getString(context,R.string.scene159prompt))
                val choices = listOf(Choice(getString(context,R.string.scene159choice1),79))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 160)
            {
                val prompts = listOf(getString(context,R.string.scene160prompt))
                val choices = listOf(Choice(getString(context,R.string.scene160choice1),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene160choice2),161,{state.addScore(Element.AERO)},Element.AERO))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 161)
            {
                val prompts = listOf(getString(context,R.string.scene161prompt))
                val choices = listOf(Choice(getString(context,R.string.scene161choice1),119,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene161choice2),163,{state.addScore(Element.AERO)},Element.AERO))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 162)
            {
                val prompts = listOf(getString(context,R.string.scene162prompt))
                val choices = listOf(Choice(getString(context,R.string.scene162choice1),122,{state.addScore(Element.PHOENIX)},Element.PHOENIX),
                    Choice(getString(context,R.string.scene162choice2),163,{state.addScore(Element.AERO)},Element.AERO))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 163)
            {
                val prompts = listOf(getString(context,R.string.scene163prompt))
                val choices = listOf(Choice(getString(context,R.string.scene163choice1),137){state.setChoresStage_WritingLessonFinished()})
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 164)
            {
                val prompts = listOf(getString(context,R.string.scene164prompt))
                val choices = listOf(Choice(getString(context,R.string.scene164choice1),165))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 165)
            {
                val prompts = listOf(getString(context,R.string.scene165prompt))
                val choices = listOf(Choice(getString(context,R.string.scene165choice1),166),
                    Choice(getString(context,R.string.scene165choice2),167),
                    Choice(getString(context,R.string.scene165choice3),166))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 166)
            {
                val prompts = listOf(getString(context,R.string.scene166prompt))
                val choices = listOf(Choice(getString(context,R.string.scene166choice1),113))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 167)
            {
                val prompts = listOf(getString(context,R.string.scene167prompt))
                val choices = listOf(Choice(getString(context,R.string.scene167choice1),168),
                    Choice(getString(context,R.string.scene167choice2),113))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 168)
            {
                val prompts = listOf(getString(context,R.string.scene168prompt))
                val choices = listOf(Choice(getString(context,R.string.scene168choice1),112,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene168choice2),131,{state.addScore(Element.AQUA)},Element.AQUA),
                    Choice(getString(context,R.string.scene168choice3),140,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene168choice4),152,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene168choice5),160,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene168choice6),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 169)
            {
                val prompts = listOf(getString(context,R.string.scene169prompt))
                val choices = listOf(Choice(getString(context,R.string.scene169choice1),112,{state.addScore(Element.LUXOR)},Element.LUXOR),
                    Choice(getString(context,R.string.scene169choice2),132,{state.addScore(Element.PHOENIX)},Element.PHOENIX))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 170)
            {
                val prompts = listOf(getString(context,R.string.scene170prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene170choice1),171,{state.addScore(Element.JUSTICE)},Element.JUSTICE),
                    Choice(getString(context,R.string.scene170choice2),171,{state.addScore(Element.LUNAR)},Element.LUNAR),
                    Choice(getString(context,R.string.scene170choice3),171,{state.addScore(Element.COMPASSION)},Element.COMPASSION),
                    Choice(getString(context,R.string.scene170choice4),171,{state.addScore(Element.ANGEL)},Element.ANGEL),
                    Choice(getString(context,R.string.scene170choice5),171,{state.addScore(Element.REDEMPTION)},Element.REDEMPTION),
                    Choice(getString(context,R.string.scene170choice6),112,{state.addScore(Element.AQUA)},Element.AQUA))
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 171)
            {
                val prompts = listOf(getString(context,R.string.scene171prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene171choice1),112),
                    Choice(getString(context,R.string.scene171choice2),119)
                )
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 172)
            {
                val prompts = listOf(getString(context,R.string.scene172prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene172choice1),173),
                    Choice(getString(context,R.string.scene172choice2),174),
                    Choice(getString(context,R.string.scene172choice3),113),
                    Choice(getString(context,R.string.scene172choice4),132)
                )
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 173)
            {
                val prompts = listOf(getString(context,R.string.scene173prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene173choice1),174),
                    Choice(getString(context,R.string.scene173choice2),113),
                    Choice(getString(context,R.string.scene173choice3),132)
                )
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 174)
            {
                val prompts = listOf(getString(context,R.string.scene174prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene174choice1),113),
                    Choice(getString(context,R.string.scene174choice2),132)
                )
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 175)
            {
                val prompts = listOf(getString(context,R.string.scene175prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene175choice1),113),
                    Choice(getString(context,R.string.scene175choice2),132)
                )
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 176)
            {
                val prompts = listOf(getString(context,R.string.scene176prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene176choice),130)
                )
                return getBrahmNode(index,prompts,choices,context)
            }
            if(index == 177)
            {
                val prompts = listOf(getString(context,R.string.scene177prompt1) + " " + Gender.getBrahmsNickname(context,state.gender) + " "
                        + getString(context,R.string.scene177prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene177choice1),178,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene177choice2),179,{state.addScore(Element.UMBRAL)},Element.UMBRAL),
                    Choice(getString(context,R.string.scene177choice3),180),
                    Choice(getString(context,R.string.scene177choice4),181,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene177choice5),182,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene177choice6),183)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 178)
            {
                val prompts = listOf(getString(context,R.string.scene178prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene178choice1),182,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene178choice2),183,{state.addScore(Element.STORM)},Element.STORM),
                    Choice(getString(context,R.string.scene178choice3),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 179)
            {
                val prompts = listOf(getString(context,R.string.scene179prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene179choice1),184,{state.addScore(Element.PYRO)},Element.PYRO),
                    Choice(getString(context,R.string.scene179choice2),185,{state.addScore(Element.SEABREEZE)},Element.SEABREEZE),
                    Choice(getString(context,R.string.scene179choice3),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 180)
            {
                val prompts = listOf(getString(context,R.string.scene180prompt1) + " " + Gender.getBrahmsNickname(context,state.gender) + " "
                + getString(context,R.string.scene180prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene180choice1),186),
                    Choice(getString(context,R.string.scene180choice2),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 181)
            {
                val prompts = listOf(getString(context,R.string.scene181prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene181choice1),186),
                    Choice(getString(context,R.string.scene181choice2),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 182)
            {
                val prompts = listOf(getString(context,R.string.scene182prompt1) + " " + Gender.getBrahmsNickname(context,state.gender) + " "
                + getString(context,R.string.scene182prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene182choice1),186),
                    Choice(getString(context,R.string.scene182choice2),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 183)
            {
                val prompts = listOf(getString(context,R.string.scene183prompt1) + " " + Gender.getBrahmsNickname(context,state.gender) + " "
                + getString(context,R.string.scene183prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene183choice1),186),
                    Choice(getString(context,R.string.scene183choice2),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 184)
            {
                val prompts = listOf(getString(context,R.string.scene184prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene184choice1),186),
                    Choice(getString(context,R.string.scene184choice2),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 185)
            {
                val prompts = listOf(getString(context,R.string.scene185prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene185choice1),186),
                    Choice(getString(context,R.string.scene185choice2),79)
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 186)
            {
                val prompts = listOf(getString(context,R.string.scene186prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene186choice),79,{state.setQuestStage(Quest.EXPLORE, 1)})
                )
                return getGateNode(index,prompts,choices,context)
            }
            if(index == 187)
            {
                val prompts = listOf(getString(context,R.string.scene187prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene187choice1),188),
                    Choice(getString(context,R.string.scene187choice2),206),
                    Choice(getString(context,R.string.scene187choice3),217),
                    Choice(getString(context,R.string.scene187choice4),0),//TODO: finish
                    Choice(getString(context,R.string.scene187choice5),0),//TODO: finish
                    Choice(getString(context,R.string.scene187choice6),79)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.background_morns_tavern,R.anim.fade_in_fast, R.id.background_center)
                )
                return Node(index, prompts, choices, animations, context)
            }
            if(index == 188)
            {
                val prompts = listOf(getString(context,R.string.scene188prompt1) + " " + Gender.getMornsNickname(context,state.gender)
                + getString(context,R.string.scene188prompt2))
                val choices: List<Choice>
                if(state.getQuestStage(Quest.CHORES) == 3)
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene188choice1),189),
                        Choice(getString(context,R.string.scene188choice4),190),
                        Choice(getString(context,R.string.scene188choice6),203))
                }
                else if(state.getQuestStage(Quest.CHORES) == 0)
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene188choice5),196),//WRONG INDEX
                        Choice(getString(context,R.string.scene188choice4),190),
                        Choice(getString(context,R.string.scene188choice6),203))
                }
                else if(state.getQuestStage(Quest.CHORES) == 5)
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene188choice2),189),
                        Choice(getString(context,R.string.scene188choice4),190),
                        Choice(getString(context,R.string.scene188choice6),203))
                }
                else if(state.getQuestStage(Quest.CHORES)==8)
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene188choice3),189),
                        Choice(getString(context,R.string.scene188choice4),190),
                        Choice(getString(context,R.string.scene188choice6),203))
                }
                else
                {
                    choices = listOf(
                        Choice(getString(context,R.string.scene188choice4),190),
                        Choice(getString(context,R.string.scene188choice6),203))
                }
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast, R.id.background_center)
                )
                return Node(index, prompts, choices, animations, context)
            }
            if(index == 189)
            {
                val prompts = listOf(getString(context,R.string.scene189prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene189choice1),191,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene189choice2),192,{state.addScore(Element.UMBRAL)},Element.UMBRAL)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 190)
            {
                val prompts = listOf(getString(context,R.string.scene190prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene190choice1),191,{state.addScore(Element.AERO)},Element.AERO),
                    Choice(getString(context,R.string.scene190choice2),192,{state.addScore(Element.UMBRAL)},Element.UMBRAL)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 191)
            {
                val prompts = listOf(getString(context,R.string.scene191prompt1) + " " + Gender.getMornsNickname(context, state.gender)
                + getString(context,R.string.scene191prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene191choice1), 193,{state.addScore(Element.TERRA)},Element.TERRA),
                    Choice(getString(context,R.string.scene191choice2),194,{state.addScore(Element.AERO)},Element.AERO)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 192)
            {
                val prompts = listOf(getString(context,R.string.scene192prompt1) + " " + Gender.getMornsNickname(context, state.gender)
                + getString(context,R.string.scene192prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene192choice1),196,{state.addScore(Element.ROTTEN)},Element.ROTTEN),
                    Choice(getString(context,R.string.scene192choice2),191,{state.addScore(Element.AERO)},Element.AERO)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 193)
            {
                val prompts = listOf(getString(context,R.string.scene193prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene193choice1),197,{state.addScore(Element.COMPASSION)},Element.COMPASSION),
                    Choice(getString(context,R.string.scene193choice2),198))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                    )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 194)
            {
                val prompts = listOf(getString(context,R.string.scene194prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene194choice1),197,{state.addScore(Element.COMPASSION)},Element.COMPASSION),
                    Choice(getString(context,R.string.scene194choice2),198,)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 195)
            {
                val prompts = listOf(getString(context,R.string.scene195prompt1)+ " " + Gender.getMornsNickname(context,state.gender)
                + getString(context,R.string.scene195prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene195choice1),199),
                    Choice(getString(context,R.string.scene195choice2),187,{state.setQuestStage(Quest.MORNS_ERRAND,9)})
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 196)
            {
                val prompts = listOf(getString(context,R.string.scene196prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene196choice1),200,{state.addScore(Element.UMBRAL)},Element.UMBRAL),
                    Choice(getString(context,R.string.scene196choice2),191)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 197)
            {
                val prompts = listOf(getString(context,R.string.scene197prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene197choice1),198,{state.addScore(Element.COMPASSION)},Element.COMPASSION),
                    Choice(getString(context,R.string.scene197choice2),201,{state.addScore(Element.NIGHTWING)},Element.NIGHTWING)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 198)
            {
                val prompts = listOf(getString(context,R.string.scene198prompt))
                val choices = listOf(Choice(getString(context,R.string.scene198choice),187,{state.setQuestStage(Quest.MORNS_ERRAND,2)}))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 199)
            {
                val prompts = listOf(getString(context,R.string.scene199prompt))
                val choices = listOf(Choice(getString(context,R.string.scene199choice1),197,{state.addScore(Element.COMPASSION)},Element.COMPASSION),
                    Choice(getString(context,R.string.scene199choice2),198))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 200)
            {
                val prompts = listOf(getString(context,R.string.scene200prompt))
                val choices = listOf(Choice(getString(context,R.string.scene200choice1),191),
                    Choice(getString(context,R.string.scene200choice2),202,{state.addScore(Element.UMBRAL)},Element.UMBRAL))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 201)
            {
                val prompts = listOf(getString(context,R.string.scene201prompt1) + " " + Gender.getMornsNickname(context,state.gender)
                + getString(context,R.string.scene201prompt2))
                val choices = listOf(Choice(getString(context,R.string.scene201choice),187,{state.setQuestStage(Quest.MORNS_ERRAND,9)}))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 202)
            {
                val prompts = listOf(getString(context,R.string.scene202prompt))
                val choices = listOf(Choice(getString(context,R.string.scene202choice1),197,{state.addScore(Element.COMPASSION)},Element.COMPASSION),
                    Choice(getString(context,R.string.scene202choice2),198),
                    Choice(getString(context,R.string.scene202choice3),201,{state.addScore(Element.STORM)},Element.STORM))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 203)
            {
                val prompts = listOf(getString(context,R.string.scene203prompt))
                val choices = listOf(Choice(getString(context,R.string.scene203choice1),204),
                    Choice(getString(context,R.string.scene203choice2),189))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 204)
            {
                val prompts = listOf(getString(context,R.string.scene204prompt))
                val choices = listOf(Choice(getString(context,R.string.scene204choice1),205),
                    Choice(getString(context,R.string.scene204choice2),189))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 205)
            {
                val prompts = listOf(getString(context,R.string.scene205prompt))
                val choices = listOf(Choice(getString(context,R.string.scene205choice),189))
                val animations = listOf(
                    AnimationInfo(R.drawable.character_morn,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 206)
            {
                val prompts = listOf(getString(context,R.string.scene206prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene206choice1),207),
                    Choice(getString(context,R.string.scene206choice2),208),
                    Choice(getString(context,R.string.scene206choice3),187),
                    Choice(getString(context,R.string.scene206choice4),211),
                    Choice(getString(context,R.string.scene206choice5),214),
                    Choice(getString(context,R.string.scene206choice6),213)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 207)
            {
                val prompts = listOf(getString(context,R.string.scene207prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene207choice1),209),
                    Choice(getString(context,R.string.scene207choice2),210)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 208)
            {
                val prompts = listOf(getString(context,R.string.scene208prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene208choice1),187),
                    Choice(getString(context,R.string.scene208choice2),207),
                    Choice(getString(context,R.string.scene208choice3),214)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 209)
            {
                val prompts = listOf(getString(context,R.string.scene209prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene209choice1),0),//TODO finish
                    Choice(getString(context,R.string.scene209choice2),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 210)
            {
                val prompts = listOf(getString(context,R.string.scene210prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene210choice1),187),
                    Choice(getString(context,R.string.scene210choice2),214),
                    Choice(getString(context,R.string.scene210choice3),213)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 211)
            {
                val prompts = listOf(getString(context,R.string.scene211prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene211choice1),207),
                    Choice(getString(context,R.string.scene211choice2),214),
                    Choice(getString(context,R.string.scene211choice3),212,{state.addScore(Element.VENGEANCE)}, Element.VENGEANCE),
                    Choice(getString(context,R.string.scene211choice4),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 212)
            {
                val prompts = listOf(getString(context,R.string.scene212prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene212choice1),213),
                    Choice(getString(context,R.string.scene212choice2),207),
                    Choice(getString(context,R.string.scene212choice3),214)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 213)
            {
                val prompts = listOf(getString(context,R.string.scene213prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene213choice1),207),
                    Choice(getString(context,R.string.scene213choice2),214),
                    Choice(getString(context,R.string.scene213choice3),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 214)
            {
                val prompts = listOf(getString(context,R.string.scene214prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene214choice1),215),
                    Choice(getString(context,R.string.scene214choice2),207),
                    Choice(getString(context,R.string.scene214choice3),213),
                    Choice(getString(context,R.string.scene214choice4),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 215)
            {
                val prompts = listOf(getString(context,R.string.scene215prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene215choice1),216),
                    Choice(getString(context,R.string.scene215choice2),217),
                    Choice(getString(context,R.string.scene215choice3),207),
                    Choice(getString(context,R.string.scene215choice4),213),
                    Choice(getString(context,R.string.scene215choice5),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 216)
            {
                val prompts = listOf(getString(context,R.string.scene216prompt1) + " " + Gender.getBrahmsNickname(context,state.gender)
                        + getString(context,R.string.scene216prompt2))
                val choices = listOf(
                    Choice(getString(context,R.string.scene216choice1),207),
                    Choice(getString(context,R.string.scene216choice2),213),
                    Choice(getString(context,R.string.scene216choice3),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_barmaid,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 217)
            {
                val prompts = listOf(getString(context,R.string.scene217prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene217choice1),218),
                    Choice(getString(context,R.string.scene217choice2),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_black_cat,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 218)
            {
                val prompts = listOf(getString(context,R.string.scene218prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene218choice),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_black_cat,R.anim.appear,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 219)
            {
                val prompts = listOf(getString(context,R.string.scene219prompt1) + " "
                        + Gender.getProphetsNickname(context,state.gender)
                        + getString(context,R.string.scene219prompt2) + " "
                        + Gender.getProphetsNickname(context,state.gender) + " "
                        + getString(context,R.string.scene219prompt3))
                val choices = listOf(
                    Choice(getString(context,R.string.scene219choice1),220),
                    Choice(getString(context,R.string.scene219choice2),221),
                    Choice(getString(context,R.string.scene219choice3),222),
                    Choice(getString(context,R.string.scene219choice4),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_mad_prophet,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 220)
            {
                val prompts = listOf(getString(context,R.string.scene220prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene220choice1),221),
                    Choice(getString(context,R.string.scene220choice2),223),
                    Choice(getString(context,R.string.scene220choice3),222),
                    Choice(getString(context,R.string.scene220choice4),187)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_mad_prophet,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 221)
            {
                val prompts = listOf(getString(context,R.string.scene221prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene221choice1),225),
                    Choice(getString(context,R.string.scene221choice2),220),
                    Choice(getString(context,R.string.scene221choice3),222)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_mad_prophet,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 222)
            {
                val prompts = listOf(getString(context,R.string.scene222prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene222choice1),227),
                    Choice(getString(context,R.string.scene222choice2),228),
                    Choice(getString(context,R.string.scene222choice3),223),
                    Choice(getString(context,R.string.scene222choice4),224)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_mad_prophet,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 223)
            {
                val prompts = listOf(getString(context,R.string.scene223prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene223choice1),228),
                    Choice(getString(context,R.string.scene223choice2),228),
                    Choice(getString(context,R.string.scene223choice3),227),
                    Choice(getString(context,R.string.scene223choice4),224)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_mad_prophet,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            if(index == 224)
            {
                val prompts = listOf(getString(context,R.string.scene224prompt))
                val choices = listOf(
                    Choice(getString(context,R.string.scene224choice1),228),
                    Choice(getString(context,R.string.scene224choice2),231),
                    Choice(getString(context,R.string.scene224choice3),227),
                    Choice(getString(context,R.string.scene224choice4),223)
                )
                val animations = listOf(
                    AnimationInfo(R.drawable.character_mad_prophet,R.anim.fade_in_fast,R.id.background_center)
                )
                return Node(index,prompts,choices,animations,context)
            }
            else
            {
                val prompts = listOf("Whoops! please tell Austin theres an issue with node: " + index)
                val choices = listOf(Choice("Go back to Oaktree",79))
                return Node(index,prompts,choices,listOf(),context)
            }
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

        private fun getBrahmNode(index: Int, prompts: List<String>, choices: List<Choice>, context: Context): Node{
            val animations = listOf(AnimationInfo(R.drawable.background_brahms_room, R.anim.fade_in_fast, R.id.background_center),
                AnimationInfo(R.drawable.character_brahm_profile, R.anim.fade_in_fast, R.id.background_center))
            return Node(index, prompts, choices, animations, context)
        }

        private fun getGateNode(index: Int, prompts: List<String>, choices: List<Choice>, context: Context): Node
        {
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_gate,R.anim.fade_in_fast,R.id.background_center),
                AnimationInfo(R.drawable.character_guard_profile,R.anim.fade_in_fast,R.id.background_center))
            return Node(index,prompts,choices,animations,context)
        }
    }
}