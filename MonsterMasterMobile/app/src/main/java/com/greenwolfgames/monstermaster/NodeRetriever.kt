package com.greenwolfgames.monstermaster

import android.content.Context
import android.util.Log
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
class NodeRetriever(private val context: Context, private val state: State)
{
    fun getNode(index: Int): Node
    {
        if (index == 1)
        {
            val prompts = listOf(getString(context, R.string.scene1item1),
                getString(context, R.string.scene1item2),
                getString(context, R.string.scene1item3),
                getString(context, R.string.scene1item4),
                getString(context, R.string.scene1item5),
                getString(context, R.string.scene1item6),
                getString(context, R.string.scene1item7))
            val choices = listOf(getChoice(R.string.scene1choice1, 2, Element.LUXOR),
                getChoice(R.string.scene1choice2, 3, Element.UMBRAL))
            return getNode(index, prompts, choices, Element.INITIAL)
        } //Chose Light, now choose Fire or Water
        if (index == 2)
        {
            val prompts = listOf(getString(context, R.string.scene2item1),
                getString(context, R.string.scene2item2),
                getString(context, R.string.scene2item3),
                getString(context, R.string.scene2item4),
                getString(context, R.string.scene2item5))
            val choices = listOf(getChoice(R.string.scene2choice1, 4, Element.PYRO),
                getChoice(R.string.scene2choice2, 5, Element.AQUA))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_faint_light_from_above,
                R.anim.fade_in_very_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.LUXOR)
        } //Chose Darkness, now choose Fire or Water
        if (index == 3)
        {
            val prompts = listOf(getString(context, R.string.scene3item1),
                getString(context, R.string.scene3item2),
                getString(context, R.string.scene3item3),
                getString(context, R.string.scene3item4),
                getString(context, R.string.scene3item5),
                getString(context, R.string.scene3item6))
            val choices = listOf(getChoice(R.string.scene3choice1, 6, Element.PYRO),
                getChoice(R.string.scene3choice2, 7, Element.AQUA))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_trees,
                R.anim.fade_in_very_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.UMBRAL)
        } // Chose Light and Fire, now choose Air or Earth
        if (index == 4)
        {
            val prompts = listOf(getString(context, R.string.scene4item1),
                getString(context, R.string.scene4item2),
                getString(context, R.string.scene4item3),
                getString(context, R.string.scene4item4),
                getString(context, R.string.scene4item5),
                getString(context, R.string.scene4item6))
            val choices = listOf(getChoice(R.string.scene4choice1, 8, Element.TERRA),
                getChoice(R.string.scene4choice2, 8, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_flame_bottom_left,
                R.anim.fade_in_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.SOLAR)
        } //Chose light and water, now choose Air or Earth
        if (index == 5)
        {
            val prompts = listOf(getString(context, R.string.scene5item1),
                getString(context, R.string.scene5item2),
                getString(context, R.string.scene5item3),
                getString(context, R.string.scene5item4),
                getString(context, R.string.scene5item5),
                getString(context, R.string.scene5item6))
            val choices = listOf(getChoice(R.string.scene5choice1, 9, Element.TERRA),
                getChoice(R.string.scene5choice2, 9, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_river,
                R.anim.fade_in_very_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.LUNAR)
        } //Chose Darkness and Fire, now choose Air or Earth
        if (index == 6)
        {
            val prompts = listOf(getString(context, R.string.scene6item1),
                getString(context, R.string.scene6item2),
                getString(context, R.string.scene6item3),
                getString(context, R.string.scene6item4),
                getString(context, R.string.scene6item5))
            val choices = listOf(getChoice(R.string.scene6choice1, 10, Element.TERRA),
                getChoice(R.string.scene6choice2, 10, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_flame_bottom_left,
                R.anim.fade_in_very_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.DEMON)
        } //Chose Darkness and Water, now choose Air or Earth
        if (index == 7)
        {
            val prompts = listOf(getString(context, R.string.scene7item1),
                getString(context, R.string.scene7item2),
                getString(context, R.string.scene7item3),
                getString(context, R.string.scene7item4),
                getString(context, R.string.scene7item5))
            val choices = listOf(getChoice(R.string.scene7choice1, 11, Element.TERRA),
                getChoice(R.string.scene7choice2, 11, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_river,
                R.anim.fade_in_very_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.DEEP)
        } //Chose Light and Fire, with an option of either Earth or Air, in either case, commit to one of the three elements you've chosen
        if (index == 8)
        {
            val prompts = listOf(getString(context, R.string.scene8item1),
                getString(context, R.string.scene8item2),
                getString(context, R.string.scene8item3),
                getString(context, R.string.scene8item4),
                getString(context, R.string.scene8item5),
                getString(context, R.string.scene8item6))
            val choices: List<Choice> =
                if (state.getScore(Element.TERRA) > state.getScore(Element.AERO))
                {
                    listOf(getChoice(R.string.scene8choice1, 12, Element.LUXOR),
                        getChoice(R.string.scene8choice2, 14, Element.PYRO),
                        getChoice(R.string.scene8choice3, 16, Element.TERRA))
                }
                else
                {
                    listOf(getChoice(R.string.scene8choice1, 12, Element.LUXOR),
                        getChoice(R.string.scene8choice2, 14, Element.PYRO),
                        getChoice(R.string.scene8choice3Alt, 17, Element.AERO))
                }
            val animations = listOf(AnimationInfo(R.drawable.scene_object_sunshine_upper_left,
                R.anim.fade_in_very_slow,
                R.id.main))
            return getNode(index, prompts, choices, animations, Element.JUSTICE)
        } //Chose Light water and either air or earth, in either case, commit to one of the three elements you've chosen
        if (index == 9)
        {
            val prompts = listOf(getString(context, R.string.scene9item1),
                getString(context, R.string.scene9item2),
                getString(context, R.string.scene9item3),
                getString(context, R.string.scene9item4),
                getString(context, R.string.scene9item5))
            val choices: List<Choice> =
                if (state.getScore(Element.TERRA) > state.getScore(Element.AERO))
                {
                    listOf(getChoice(R.string.scene9choice1, 12, Element.LUXOR),
                        getChoice(R.string.scene9choice2, 15, Element.AQUA),
                        getChoice(R.string.scene9choice3, 16, Element.TERRA))
                }
                else
                {
                    listOf(getChoice(R.string.scene9choice1, 12, Element.LUXOR),
                        getChoice(R.string.scene9choice2, 15, Element.AQUA),
                        getChoice(R.string.scene9choice3Alt, 17, Element.AERO))
                }
            val animations = listOf(AnimationInfo(R.drawable.scene_object_magic_glyph,
                R.anim.fade_in_halfway_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.ICE)
        } //Chose darkness and fire, and either air or earth, in either case, commit to one of the three elements you've chosen
        if (index == 10)
        {
            val prompts: List<String>
            val choices: List<Choice>
            if (state.getScore(Element.TERRA) > state.getScore(Element.AERO))
            {
                prompts = listOf(getString(context, R.string.scene10item1),
                    getString(context, R.string.scene10item2),
                    getString(context, R.string.scene10item3),
                    getString(context, R.string.scene10item4),
                    getString(context, R.string.scene10item5),
                    getString(context, R.string.scene10item6))
                choices = listOf(getChoice(R.string.scene10choice1, 13, Element.UMBRAL),
                    getChoice(R.string.scene10choice2, 14, Element.PYRO),
                    getChoice(R.string.scene10choice3, 16, Element.TERRA))
            }
            else
            {
                prompts = listOf(getString(context, R.string.scene10item1),
                    getString(context, R.string.scene10item2),
                    getString(context, R.string.scene10item3),
                    getString(context, R.string.scene10item4Alt),
                    getString(context, R.string.scene10item5),
                    getString(context, R.string.scene10item6))
                choices = listOf(getChoice(R.string.scene10choice1, 13, Element.UMBRAL),
                    getChoice(R.string.scene10choice2Alt, 14, Element.PYRO),
                    getChoice(R.string.scene10choice3Alt, 17, Element.AERO))
            }
            val animations = listOf(AnimationInfo(R.drawable.scene_object_sunshine_upper_left,
                R.anim.fade_in_very_slow,
                R.id.background))
            return getNode(index, prompts, choices, animations, Element.VENGEANCE)
        } //Choose Darkness and Water, and either air or earth, in either case, commit to one of the three elements you've chosen
        if (index == 11)
        {
            val prompts = listOf(getString(context, R.string.scene11item1),
                getString(context, R.string.scene11item2),
                getString(context, R.string.scene11item3),
                getString(context, R.string.scene11item4),
                getString(context, R.string.scene11item5),
                getString(context, R.string.scene11item6))
            val choices: List<Choice> =
                if (state.getScore(Element.TERRA) > state.getScore(Element.AERO))
                {
                    listOf(getChoice(R.string.scene11choice1, 13, Element.UMBRAL),
                        getChoice(R.string.scene11choice2, 15, Element.AQUA),
                        getChoice(R.string.scene11choice3, 16, Element.TERRA))
                }
                else
                {
                    listOf(getChoice(R.string.scene11choice1, 13, Element.UMBRAL),
                        getChoice(R.string.scene11choice2, 15, Element.AQUA),
                        getChoice(R.string.scene11choice3Alt, 16, Element.AERO))
                }
            val animations = listOf(AnimationInfo(R.drawable.scene_object_moonshine_upper_left,
                R.anim.fade_in_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER),
                AnimationInfo(R.drawable.element_lunar,
                    R.anim.fade_in_very_slow,
                    R.id.background,
                    ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.LUNAR)
        }
        if (index == 12)
        {
            val prompts = listOf(getString(context, R.string.scene12item1),
                getString(context, R.string.scene12item2),
                getString(context, R.string.scene12item3),
                getString(context, R.string.scene12item4),
                getString(context, R.string.scene12item5))
            val choices = listOf(getChoice(R.string.scene12choice1, 18, Element.LUXOR),
                getChoice(R.string.scene12choice2, 19, Element.REDEMPTION),
                getChoice(R.string.scene12choice3, 20, Element.SOLAR),
                getChoice(R.string.scene12choice4, 21, Element.LUNAR),
                getChoice(R.string.scene12choice5, 22, Element.GUARDIAN),
                getChoice(R.string.scene12choice6, 23, Element.ANGEL))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_faint_light_from_above,
                R.anim.fade_in_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER),
                AnimationInfo(R.drawable.element_luxor,
                    R.anim.fade_in_halfway_very_slow,
                    R.id.background,
                    ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.LUXOR)
        }
        if (index == 13)
        {
            val prompts = listOf(getString(context, R.string.scene13item1),
                getString(context, R.string.scene13item2),
                getString(context, R.string.scene13item3),
                getString(context, R.string.scene13item4),
                getString(context, R.string.scene13item5),
                getString(context, R.string.scene13item6))
            val choices = listOf(getChoice(R.string.scene13choice1, 24, Element.BETRAYER),
                getChoice(R.string.scene13choice2, 25, Element.UMBRAL),
                getChoice(R.string.scene13choice3, 26, Element.DEMON),
                getChoice(R.string.scene13choice4, 27, Element.POISON),
                getChoice(R.string.scene13choice5, 28, Element.UNDEAD),
                getChoice(R.string.scene13choice6, 29, Element.STORM))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_gray_skull,
                R.anim.fade_in_halfway_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.UMBRAL)
        }
        if (index == 14)
        {
            val prompts = listOf(getString(context, R.string.scene14item1),
                getString(context, R.string.scene14item2),
                getString(context, R.string.scene14item3),
                getString(context, R.string.scene14item4),
                getString(context, R.string.scene14item5))
            val choices = listOf(getChoice(R.string.scene14choice1, 30, Element.JUSTICE),
                getChoice(R.string.scene14choice2, 31, Element.VENGEANCE),
                getChoice(R.string.scene14choice3, 32, Element.PYRO),
                getChoice(R.string.scene14choice4, 33, Element.LAVA),
                getChoice(R.string.scene14choice5, 34, Element.DINO),
                getChoice(R.string.scene14choice6, 35, Element.SAND))
            val animations = listOf(AnimationInfo(R.drawable.element_pyro,
                R.anim.fade_in_halfway_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.PYRO)
        }
        if (index == 15)
        {
            val prompts = listOf(getString(context, R.string.scene15item1),
                getString(context, R.string.scene15item2),
                getString(context, R.string.scene15item3),
                getString(context, R.string.scene15item4),
                getString(context, R.string.scene15item5))
            val choices = listOf(getChoice(R.string.scene15choice1, 36, Element.ICE),
                getChoice(R.string.scene15choice2, 37, Element.DEEP),
                getChoice(R.string.scene15choice3, 38, Element.STEAM),
                getChoice(R.string.scene15choice4, 39, Element.AQUA),
                getChoice(R.string.scene15choice5, 40, Element.AMPHIBIOUS),
                getChoice(R.string.scene15choice6, 41, Element.WEATHER))
            val animations = listOf(AnimationInfo(R.drawable.element_aqua,
                R.anim.fade_in_halfway_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.AQUA)
        }
        if (index == 16)
        {
            val prompts: List<String> =
                if (state.getScore(Element.TERRA) > state.getScore(Element.AERO))
                {
                    listOf(getString(context, R.string.scene16item1),
                        getString(context, R.string.scene16item2),
                        getString(context, R.string.scene16item3),
                        getString(context, R.string.scene16item4),
                        getString(context, R.string.scene16item5))
                }
                else
                {
                    listOf(getString(context, R.string.scene16item1Alt),
                        getString(context, R.string.scene16item2),
                        getString(context, R.string.scene16item3),
                        getString(context, R.string.scene16item4),
                        getString(context, R.string.scene16item5))
                }
            val choices = listOf(getChoice(R.string.scene16choice1, 42, Element.COMPASSION),
                getChoice(R.string.scene16choice2, 43, Element.ROTTEN),
                getChoice(R.string.scene16choice3, 44, Element.FEY),
                getChoice(R.string.scene16choice4, 45, Element.PLANT),
                getChoice(R.string.scene16choice5, 46, Element.TERRA),
                getChoice(R.string.scene16choice6, 47, Element.PEGASUS))
            val animations = listOf(AnimationInfo(R.drawable.element_terra,
                R.anim.fade_in_halfway_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.TERRA)
        }
        if (index == 17)
        {
            val prompts: List<String>
            if (state.getScore(Element.LUXOR) > state.getScore(Element.UMBRAL) && state.getScore(
                    Element.PYRO) > state.getScore(Element.AQUA)
            )
            {
                prompts = listOf(getString(context, R.string.scene17item1),
                    getString(context, R.string.scene17item2),
                    getString(context, R.string.scene17item3),
                    getString(context, R.string.scene17item4),
                    getString(context, R.string.scene17item5))
            }
            else if (state.getScore(Element.UMBRAL) > state.getScore(Element.LUXOR) && state.getScore(
                    Element.PYRO) > state.getScore(Element.AQUA)
            )
            {
                prompts = listOf(getString(context, R.string.scene17item1Alt1),
                    getString(context, R.string.scene17item2),
                    getString(context, R.string.scene17item3),
                    getString(context, R.string.scene17item4),
                    getString(context, R.string.scene17item5))
            }
            else
            {
                prompts = listOf(getString(context, R.string.scene17item1Alt2),
                    getString(context, R.string.scene17item2),
                    getString(context, R.string.scene17item3),
                    getString(context, R.string.scene17item4),
                    getString(context, R.string.scene17item5))
            }
            val choices = listOf(getChoice(R.string.scene17choice1, 48, Element.COCKA),
                getChoice(R.string.scene17choice2, 49, Element.NIGHTWING),
                getChoice(R.string.scene17choice3, 50, Element.PHOENIX),
                getChoice(R.string.scene17choice4, 51, Element.SEABREEZE),
                getChoice(R.string.scene17choice5, 52, Element.BIRD),
                getChoice(R.string.scene17choice6, 53, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.element_aero,
                R.anim.fade_in_halfway_very_slow,
                R.id.background,
                ImageView.ScaleType.FIT_CENTER))
            return getNode(index, prompts, choices, animations, Element.AERO)
        }
        if (index == 18)
        {
            return getEnterNameNode(context, index, R.string.scene18prompt, Element.LUXOR)
        }
        if (index == 19)
        {
            return getEnterNameNode(context, index, R.string.scene19prompt, Element.REDEMPTION)
        }
        if (index == 20)
        {
            return getEnterNameNode(context, index, R.string.scene20prompt, Element.SOLAR)
        }
        if (index == 21)
        {
            return getEnterNameNode(context, index, R.string.scene21prompt, Element.LUNAR)
        }
        if (index == 22)
        {
            return getEnterNameNode(context, index, R.string.scene22prompt, Element.GUARDIAN)
        }
        if (index == 23)
        {
            return getEnterNameNode(context, index, R.string.scene23prompt, Element.ANGEL)
        }
        if (index == 24)
        {
            return getEnterNameNode(context, index, R.string.scene24prompt, Element.BETRAYER)
        }
        if (index == 25)
        {
            return getEnterNameNode(context, index, R.string.scene25prompt, Element.UMBRAL)
        }
        if (index == 26)
        {
            return getEnterNameNode(context, index, R.string.scene26prompt, Element.DEMON)
        }
        if (index == 27)
        {
            return getEnterNameNode(context, index, R.string.scene27prompt, Element.POISON)
        }
        if (index == 28)
        {
            return getEnterNameNode(context, index, R.string.scene28prompt, Element.UNDEAD)
        }
        if (index == 29)
        {
            return getEnterNameNode(context, index, R.string.scene29prompt, Element.STORM)
        }
        if (index == 30)
        {
            return getEnterNameNode(context, index, R.string.scene30prompt, Element.JUSTICE)
        }
        if (index == 31)
        {
            return getEnterNameNode(context, index, R.string.scene31prompt, Element.VENGEANCE)
        }
        if (index == 32)
        {
            return getEnterNameNode(context, index, R.string.scene32prompt, Element.PYRO)
        }
        if (index == 33)
        {
            return getEnterNameNode(context, index, R.string.scene33prompt, Element.LAVA)
        }
        if (index == 34)
        {
            return getEnterNameNode(context, index, R.string.scene34prompt, Element.DINO)
        }
        if (index == 35)
        {
            return getEnterNameNode(context, index, R.string.scene35prompt, Element.SAND)
        }
        if (index == 36)
        {
            return getEnterNameNode(context, index, R.string.scene36prompt, Element.ICE)
        }
        if (index == 37)
        {
            return getEnterNameNode(context, index, R.string.scene37prompt, Element.DEEP)
        }
        if (index == 38)
        {
            return getEnterNameNode(context, index, R.string.scene38prompt, Element.STEAM)
        }
        if (index == 39)
        {
            return getEnterNameNode(context, index, R.string.scene39prompt, Element.AQUA)
        }
        if (index == 40)
        {
            return getEnterNameNode(context, index, R.string.scene40prompt, Element.AMPHIBIOUS)
        }
        if (index == 41)
        {
            return getEnterNameNode(context, index, R.string.scene41prompt, Element.WEATHER)
        }
        if (index == 42)
        {
            return getEnterNameNode(context, index, R.string.scene42prompt, Element.COMPASSION)
        }
        if (index == 43)
        {
            return getEnterNameNode(context, index, R.string.scene43prompt, Element.ROTTEN)
        }
        if (index == 44)
        {
            return getEnterNameNode(context, index, R.string.scene44prompt, Element.FEY)
        }
        if (index == 45)
        {
            return getEnterNameNode(context, index, R.string.scene45prompt, Element.PLANT)
        }
        if (index == 46)
        {
            return getEnterNameNode(context, index, R.string.scene46prompt, Element.TERRA)
        }
        if (index == 47)
        {
            return getEnterNameNode(context, index, R.string.scene47prompt, Element.PEGASUS)
        }
        if (index == 48)
        {
            return getEnterNameNode(context, index, R.string.scene48prompt, Element.COCKA)
        }
        if (index == 49)
        {
            return getEnterNameNode(context, index, R.string.scene49prompt, Element.NIGHTWING)
        }
        if (index == 50)
        {
            return getEnterNameNode(context, index, R.string.scene50prompt, Element.PHOENIX)
        }
        if (index == 51)
        {
            return getEnterNameNode(context, index, R.string.scene51prompt, Element.SEABREEZE)
        }
        if (index == 52)
        {
            return getEnterNameNode(context, index, R.string.scene52prompt, Element.BIRD)
        }
        if (index == 53)
        {
            return getEnterNameNode(context, index, R.string.scene53prompt, Element.AERO)
        }
        if (index == 54)
        {
            val prompts: List<String> = listOf(getString(context, R.string.scene54item1),
                state.playerName,
                getString(context, R.string.scene54item2),
                state.playerName,
                getString(context, R.string.scene54item3),
                state.playerName + " wake up!")
            val choices = listOf(getChoice(R.string.scene54choice, 55, Element.PHYSICAL))
            return getNode(index, prompts, choices, Element.PHYSICAL)
        } //OakTree-players room
        if (index == 55)
        {
            val prompts = getPrompt(R.string.scene55prompt)
            val choices = listOf(getChoice(R.string.scene55choice1, 56, Element.UMBRAL),
                getChoice(R.string.scene55choice2, 57, Element.AQUA),
                getChoice(R.string.scene55choice3, 58, Element.AERO),
                getChoice(R.string.scene55choice4, 56, Element.PYRO),
                getChoice(R.string.scene55choice5, 58, Element.TERRA),
                getChoice(R.string.scene55choice6, 59, Element.NEUTRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 56)
        {
            val prompts = getPrompt(R.string.scene56prompt)
            val choices = listOf(getChoice(R.string.scene56choice1, 60, Element.PYRO),
                getChoice(R.string.scene56choice2, 58, Element.AQUA),
                getChoice(R.string.scene56choice3, 58, Element.TERRA))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 57)
        {
            val prompts = getPrompt(R.string.scene57prompt)
            val choices = listOf(getChoice(R.string.scene57choice1, 60, Element.PYRO),
                getChoice(R.string.scene57choice2, 58, Element.AQUA),
                getChoice(R.string.scene57choice3, 58, Element.TERRA))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 58)
        {
            val prompts = getPrompt(R.string.scene58prompt)
            val choices = listOf(getChoice(R.string.scene58choice1, 61),
                getChoice(R.string.scene58choice2, 62),
                getChoice(R.string.scene58choice3, 63, Element.UMBRAL),
                getChoice(R.string.scene58choice4, 78, Element.TERRA),
                getChoice(R.string.scene58choice5, 78, Element.AERO))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 59)
        {
            val prompts = getPrompt(R.string.scene59prompt)
            val choices = listOf(getChoice(R.string.scene59choice1, 58),
                getChoice(R.string.scene59choice2, 68))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 60)
        {
            val prompts = getPrompt(R.string.scene60prompt)
            val choices = listOf(getChoice(R.string.scene60choice1, 61),
                getChoice(R.string.scene60choice2, 62),
                getChoice(R.string.scene60choice3, 63, Element.UMBRAL),
                getChoice(R.string.scene60choice4, 78, Element.TERRA),
                getChoice(R.string.scene60choice5, 78, Element.AERO),
                getChoice(R.string.scene60choice6, 64, Element.UMBRAL))
            val action: () -> Unit = {
                state.getPlayerBattleActor().takeDamage(3.0)
            }
            return Node(index,
                prompts,
                choices,
                getPlayerRoomAnimations(),
                ContextCompat.getColor(context, Element.getBackgroundColor(Element.NEUTRAL)),
                ContextCompat.getColor(context, Element.getTextColor(Element.NEUTRAL)),
                state,
                action)
        }
        if (index == 61)
        {
            val prompts = getPrompt(R.string.scene61prompt)
            val choices = listOf(getChoice(R.string.scene61choice1, 65),
                getChoice(R.string.scene61choice2, 66, Element.LUXOR))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 62)
        {
            val prompts = getPrompt(R.string.scene62prompt)
            val choices = listOf(getChoice(R.string.scene62choice1, 67),
                getChoice(R.string.scene62choice2, 67, Element.AERO),
                getChoice(R.string.scene62choice3, 67, Element.AQUA))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 63)
        {
            val prompts = getPrompt(R.string.scene63prompt)
            val choices = listOf(getChoice(R.string.scene63choice1, 61),
                getChoice(R.string.scene63choice2, 62),
                getChoice(R.string.scene63choice3, 78))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 64)
        {
            val prompts = getPrompt(R.string.scene64prompt)
            val choices = listOf(getChoice(R.string.scene64choice1, 61),
                getChoice(R.string.scene64choice2, 62),
                getChoice(R.string.scene64choice3, 78),
                getChoice(R.string.scene64choice4, 77, Element.UMBRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 65)
        {
            val prompts = getPrompt(R.string.scene65prompt)
            val choices = listOf(getChoice(R.string.scene65choice1, 78),
                getChoice(R.string.scene65choice2, 78, Element.STORM),
                getChoice(R.string.scene65choice3, 77, Element.UMBRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 66)
        {
            val prompts = getPrompt(R.string.scene66prompt)
            val choices = listOf(getChoice(R.string.scene66choice1, 70, Element.REDEMPTION),
                getChoice(R.string.scene66choice2, 71, Element.LUXOR),
                getChoice(R.string.scene66choice3, 65),
                getChoice(R.string.scene66choice4, 71, Element.DEMON))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 67)
        {
            val prompts = getPrompt(R.string.scene67prompt)
            val choices = listOf(getChoice(R.string.scene67choice1, 78),
                getChoice(R.string.scene67choice2, 77, Element.UMBRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 68)
        {
            val prompts = getPrompt(R.string.scene68prompt)
            val choices = listOf(getChoice(R.string.scene68choice1, 58),
                getChoice(R.string.scene68choice2, 72),
                getChoice(R.string.scene68choice3, 73))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 69)
        {
            val prompts = getPrompt(R.string.scene69prompt)
            val choices = listOf(getChoice(R.string.scene69choice, 78))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 70)
        {
            val prompts = getPrompt(R.string.scene70prompt)
            val choices = listOf(
                getChoice(R.string.scene70choice1, 65),
                getChoice(R.string.scene70choice2, 71, Element.LUXOR),
            )
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 71)
        {
            val prompts = getPrompt(R.string.scene71prompt)
            val choices = listOf(getChoice(R.string.scene71choice1, 78),
                getChoice(R.string.scene71choice2, 69))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 72)
        {
            val prompts = getPrompt(R.string.scene72prompt)
            val choices = listOf(getChoice(R.string.scene72choice, 78))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 73)
        {
            val prompts = getPrompt(R.string.scene73prompt)
            val choices = listOf(getChoice(R.string.scene73choice, 78))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 74)
        {
            val prompts = getPrompt(R.string.scene74prompt)
            val choices = listOf(getChoice(R.string.scene74choice1, 75, Element.DEMON),
                getChoice(R.string.scene74choice2, 76, Element.LUXOR))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 75)
        {
            val prompts = getPrompt(R.string.scene75prompt)
            val choices = listOf(getChoice(R.string.scene75choice1, 78),
                getChoice(R.string.scene75choice2, 78, Element.STORM),
                getChoice(R.string.scene75choice3, 77, Element.UMBRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 76)
        {
            val prompts = getPrompt(R.string.scene76prompt)
            val choices = listOf(getChoice(R.string.scene76choice1, 78),
                getChoice(R.string.scene76choice2, 78, Element.STORM),
                getChoice(R.string.scene76choice3, 77, Element.UMBRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 77)
        {
            val prompts = getPrompt(R.string.scene77prompt)
            val choices = listOf(getChoice(R.string.scene77choice1, 78, Element.PYRO),
                getChoice(R.string.scene77choice2, 78, Element.LUXOR),
                getChoice(R.string.scene77choice3, 78, Element.UMBRAL))
            return getNode(index, prompts, choices, getPlayerRoomAnimations())
        }
        if (index == 78)
        {
            val prompts =
                listOf(getString(context, R.string.scene78prompt) + " " + Gender.getSubjectPronoun(
                    context,
                    state.gender) + ", " + Gender.getObjectPronoun(context,
                    state.gender) + ", " + Gender.getPossessivePronoun(context, state.gender))
            val choices = listOf(Choice(getString(context, R.string.scene78choice1),
                78) { state.cyclePortrait() },
                Choice(getString(context, R.string.scene78choice1),
                    78) { state.cyclePortraitBack() },
                Choice(getString(context, R.string.scene78choice2),
                    78) { state.cyclePortraitGender() },
                Choice(getString(context, R.string.scene78choice3), 78) { state.cycleGender() },
                Choice(getString(context, R.string.scene78choice4), 79))
            val animations = listOf(AnimationInfo(R.drawable.scene_object_bedside_mirror,
                R.anim.fade_in_fast,
                R.id.background_center),
                AnimationInfo(state.playerPortraitImageId,
                    R.anim.fade_in_fast,
                    ImageView.ScaleType.FIT_XY,
                    AnimationInfo.getDefaultLayoutParams(R.id.background_center, 0.45f, 0.225f)),
                AnimationInfo(R.drawable.scene_object_bedside_mirror_overlap,
                    R.anim.fade_in_fast,
                    R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 79)
        {
            val prompts = getPrompt(R.string.scene79prompt)
            val choices = listOf(getChoice(R.string.scene79choice1, 80, Element.LUXOR),
                getChoice(R.string.scene79choice2, 102, Element.AQUA),
                getChoice(R.string.scene79choice3, 177, Element.TERRA),
                getChoice(R.string.scene79choice4, 187, Element.NIGHTWING),
                getChoice(R.string.scene79choice5, 236, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_daylight,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 80)
        {
            if (state.getQuestStage(8) == 1) //neutral
            {
                val prompts = listOf(getString(context,
                    R.string.scene80alt1prompt1) + " " + Gender.getNickname2(context,
                    state.gender) + " " + getString(context, R.string.scene80alt1prompt2))
                val choices = listOf(Choice(getString(context, R.string.scene80alt1choice1), 93),
                    getChoice(R.string.scene80alt1choice2, 94),
                    getChoice(R.string.scene80alt1choice3, 251),
                    getChoice(R.string.scene80alt1choice4, 252),
                    getChoice(R.string.scene80alt1choice5, 79))
                return getMichaelChurchNode(index, prompts, choices)
            }
            if (state.getQuestStage(8) == 4) //insulted
            {
                val prompts = getPrompt(R.string.scene80alt2prompt)
                val choices = listOf(getChoice(R.string.scene80alt2choice1, 253),
                    getChoice(R.string.scene80alt2choice2, 93),
                    getChoice(R.string.scene80alt2choice3, 251),
                    getChoice(R.string.scene80alt2choice4, 94),
                    getChoice(R.string.scene80alt2choice5, 79))
                return getMichaelChurchNode(index, prompts, choices)
            }
            if (state.getQuestStage(8) == 3) //positive
            {
                val prompts = getPrompt(R.string.scene80alt3prompt)
                val choices = listOf(getChoice(R.string.scene80alt3choice1, 93),
                    getChoice(R.string.scene80alt3choice2, 94),
                    getChoice(R.string.scene80alt3choice3, 251),
                    getChoice(R.string.scene80alt3choice4, 252),
                    getChoice(R.string.scene80alt3choice5, 79))
                return getMichaelChurchNode(index, prompts, choices)
            }
            if (state.getQuestStage(8) == 5) // very positive
            {
                val prompts = getPrompt(R.string.scene80alt4prompt)
                val choices = listOf(getChoice(R.string.scene80alt4choice1, 93),
                    getChoice(R.string.scene80alt4choice2, 94),
                    getChoice(R.string.scene80alt4choice3, 251),
                    getChoice(R.string.scene80alt4choice4, 252),
                    getChoice(R.string.scene80alt4choice5, 79))
                return getMichaelChurchNode(index, prompts, choices)
            }
            if (state.getQuestStage(8) == 2)
            {
                val prompts = getPrompt(R.string.scene80alt5prompt)
                val choices = listOf(getChoice(R.string.scene80alt5choice1, 93),
                    getChoice(R.string.scene80alt5choice2, 94),
                    getChoice(R.string.scene80alt5choice3, 251),
                    getChoice(R.string.scene80alt5choice4, 252),
                    getChoice(R.string.scene80alt5choice5, 79))
                return getMichaelChurchNode(index, prompts, choices)
            }
            else
            {
                val prompts = listOf(getString(context,
                    R.string.scene80prompt1) + state.playerName + getString(context,
                    R.string.scene80prompt2))
                val choices = listOf(Choice(getString(context, R.string.scene80choice1), 81, {
                    state.addScore(Element.PYRO);state.setQuestStage(8, 4)
                }, Element.PYRO, false), Choice(getString(context, R.string.scene80choice2), 82, {
                    state.addScore(Element.AQUA);state.setQuestStage(8, 2)
                }, Element.AQUA, false), Choice(getString(context, R.string.scene80choice3), 83, {
                    state.addScore(Element.TERRA);state.setQuestStage(8, 1)
                }, Element.TERRA, false), Choice(getString(context, R.string.scene80choice4), 84, {
                    state.addScore(Element.LUXOR);state.setQuestStage(8, 3)
                }, Element.LUXOR, false), Choice(getString(context, R.string.scene80choice5), 85, {
                    state.addScore(Element.UMBRAL);state.setQuestStage(8, 4)
                }, Element.UMBRAL, false))
                return getMichaelChurchNode(index, prompts, choices)
            }
        }
        if (index == 81)
        {
            val prompts = getPrompt(R.string.scene81prompt)
            val choices = listOf(getChoice(R.string.scene81choice1, 86),
                getChoice(R.string.scene81choice2, 87))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 82)
        {
            val prompts = getPrompt(R.string.scene82prompt)
            val choices = listOf(getChoice(R.string.scene82choice1, 101, Element.AQUA),
                getChoice(R.string.scene82choice2, 86),
                getChoice(R.string.scene82choice3, 88))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 83)
        {
            val prompts = getPrompt(R.string.scene83prompt)
            val choices = listOf(getChoice(R.string.scene83choice1, 86),
                getChoice(R.string.scene83choice2, 87))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 84)
        {
            val prompts = getPrompt(R.string.scene84prompt)
            val choices = listOf(getChoice(R.string.scene84choice1, 88, Element.LUNAR),
                getChoice(R.string.scene84choice2, 89, Element.UMBRAL),
                getChoice(R.string.scene84choice3, 86))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 85)
        {
            val prompts = getPrompt(R.string.scene85prompt)
            val choices = listOf(Choice(getString(context, R.string.scene85choice1),
                90,
                { state.addScore(Element.STORM) },
                Element.STORM,
                false), Choice(getString(context, R.string.scene85choice2), 91, {
                state.setQuestStage(3, 1)
            }, Element.NEUTRAL, false), Choice(getString(context, R.string.scene85choice3), 87, {
                state.setQuestStage(3, 1)
            }, Element.NEUTRAL, false), Choice(getString(context, R.string.scene85choice4), 92, {
                state.addScore(Element.UMBRAL);state.setQuestStage(3, 1)
            }, Element.UMBRAL, false))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 86)
        {
            val prompts = getPrompt(R.string.scene86prompt)
            val choices = listOf(getChoice(R.string.scene86choice1, 93),
                getChoice(R.string.scene86choice2, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 87)
        {
            val prompts = getPrompt(R.string.scene87prompt)
            val choices = listOf(getChoice(R.string.scene87choice1, 86),
                getChoice(R.string.scene87choice2, 88, Element.LUXOR),
                getChoice(R.string.scene87choice3, 94, Element.ANGEL),
                getChoice(R.string.scene87choice4, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 88)
        {
            val prompts = getPrompt(R.string.scene88prompt)
            val choices = listOf(getChoice(R.string.scene88choice1, 93, Element.LUXOR),
                getChoice(R.string.scene88choice2, 93))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 89)
        {
            val prompts = getPrompt(R.string.scene89prompt)
            val choices = listOf(getChoice(R.string.scene89choice1, 86),
                getChoice(R.string.scene89choice2, 88),
                getChoice(R.string.scene89choice3, 94))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 90)
        {
            val prompts = getPrompt(R.string.scene90prompt)
            val choices = listOf(getChoice(R.string.scene90choice1, 86),
                getChoice(R.string.scene90choice2, 88),
                getChoice(R.string.scene90choice3, 94))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 91)
        {
            val prompts = getPrompt(R.string.scene91prompt)
            val choices = listOf(getChoice(R.string.scene91choice1, 86),
                getChoice(R.string.scene91choice2, 87))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 92)
        {
            val prompts = getPrompt(R.string.scene92prompt)
            val choices = listOf(getChoice(R.string.scene92choice1, 86),
                getChoice(R.string.scene92choice2, 88),
                getChoice(R.string.scene92choice3, 94))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 93)
        {
            if (state.getQuestStage(1) == 2)
            {
                return getDadNode_Default()
            }
            if (state.getQuestStage(1) == 3)
            {
                return getDadNode_talkAboutWriting()
            }
            if (state.getQuestStage(1) == 4)
            {
                return getDadNode_talkAboutMorn()
            }
            if (state.getQuestStage(1) == 5)
            {
                return getDadNode_talkAboutAmulet()
            } //We have completed writing and done chores for morn. If we have not spoken to dad before about it,
            //we should talk about how the writing lesson went, if weve talked about the writing lesson,
            //we need to talk about how the chores with morn went. If we've talked about both, go to alt one
            if (state.getQuestStage(1) == 6)
            {
                if (haveTalkedToDadAboutWriting())
                {
                    return getDadNode_talkAboutMorn()
                }
                if (haveTalkedToDadAboutMornChores())
                {
                    return getDadNode_talkAboutWriting()
                }
                return getDadNode_Default()
            }
            if (state.getQuestStage(1) == 7)
            {
                if(haveTalkedToDadAboutMornChores())
                {
                    return getDadNode_talkAboutAmulet()
                }
                if(haveTalkedToDadAboutSellingNecklace())
                {
                    return getDadNode_talkAboutMorn()
                }
                return getDadNode_Default()
            }
            if(state.getQuestStage(1) == 8)
            {
                if(haveTalkedToDadAboutWriting())
                {
                    return getDadNode_talkAboutAmulet()
                }
                if(haveTalkedToDadAboutSellingNecklace())
                {
                    return getDadNode_talkAboutWriting()
                }
                return getDadNode_Default()
            }
            if(state.getQuestStage(1) == 9)
            {
                val prompts = getPrompt(R.string.scene93alt5prompt)
                val choices = listOf(getChoice(R.string.scene93alt5choice1,281),
                    getChoice(R.string.scene93alt5choice2,282))
                return getFatherChurchNode(index,prompts,choices)
            }
            val prompts =
                listOf(getString(context, R.string.scene93prompt1) + " " + Gender.getNickname1(
                    context,
                    state.gender) + " " + getString(context, R.string.scene93prompt2))
            val choices = listOf(getChoice(R.string.scene93choice1, 96, Element.ANGEL),
                getChoice(R.string.scene93choice2, 96),
                getChoice(R.string.scene93choice3, 97, Element.ROTTEN))

            return getFatherChurchNode(index, prompts, choices)
        }
        if (index == 94)
        { //TODO: extend
            if (state.currentGold > 10)
            {
                val prompts = getPrompt(R.string.scene94prompt2)
                val choices = mutableListOf(getChoice(R.string.scene94choice1, 95, Element.ANGEL),
                    getChoice(R.string.scene94choice4, 87))
                if (state.currentGold > 100)
                {
                    choices.add(getChoice(R.string.scene94choice2, 95, Element.ANGEL))
                }
                if (state.currentGold > 1000)
                {
                    choices.add(getChoice(R.string.scene94choice3, 95, Element.ANGEL))
                }
                return getMichaelChurchNode(index, prompts, choices)
            }
            val prompts = getPrompt(R.string.scene94prompt1)
            val choices = listOf(getChoice(R.string.scene94choice4, 87))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 95)
        {
            val prompts = getPrompt(R.string.scene95prompt)
            val choices = listOf(getChoice(R.string.scene95choice1, 86),
                getChoice(R.string.scene95choice2, 88),
                getChoice(R.string.scene95choice3, 94))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 96)
        {
            val prompts = getPrompt(R.string.scene96prompt)
            val choices = listOf(Choice(getString(context, R.string.scene96choice1),
                98) { state.initChoresQuestline() },
                Choice(getString(context, R.string.scene96choice2),
                    99) { state.initChoresQuestline() },
                Choice(getString(context, R.string.scene96choice3),
                    100) { state.initChoresQuestline() })
            return getFatherChurchNode(index, prompts, choices)
        }
        if (index == 97)
        {
            val prompts = getPrompt(R.string.scene97prompt)
            val choices = listOf(getChoice(R.string.scene97choice1, 96, Element.LUXOR),
                getChoice(R.string.scene97choice2, 96))
            return getFatherChurchNode(index, prompts, choices)
        }
        if (index == 98)
        {
            val prompts = getPrompt(R.string.scene98prompt)
            val choices = listOf(getChoice(R.string.scene98choice, 79))
            return getFatherChurchNode(index, prompts, choices)
        }
        if (index == 99)
        {
            val prompts = getPrompt(R.string.scene99prompt)
            val choices = listOf(getChoice(R.string.scene99choice1, 98),
                getChoice(R.string.scene99choice2, 100, Element.LUXOR))
            return getFatherChurchNode(index, prompts, choices)
        }
        if (index == 100)
        {
            val prompts = getPrompt(R.string.scene100prompt)
            val choices = listOf(getChoice(R.string.scene100choice, 79))
            return getFatherChurchNode(index, prompts, choices)
        }
        if (index == 101)
        {
            val prompts = getPrompt(R.string.scene101prompt)
            val choices = listOf(getChoice(R.string.scene101choice1, 86),
                getChoice(R.string.scene101choice2, 88),
                getChoice(R.string.scene101choice3, 94))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 102)//TODO update
        {
            val prompts: List<String>
            val choices: List<Choice>
            if(state.getQuestStage(5) < 3)
            {
                prompts = listOf(getString(context,
                    R.string.scene102prompt1) + " " + state.playerName + " " + getString(context,
                    R.string.scene102prompt2))
                choices = listOf(getChoice(R.string.scene102choice1, 103, Element.PYRO),
                    getChoice(R.string.scene102choice2, 104, Element.LUXOR),
                    getChoice(R.string.scene102choice3, 105, Element.PEGASUS),
                    getChoice(R.string.scene102choice4, 106, Element.AQUA),
                    getChoice(R.string.scene102choice5, 107),
                    getChoice(R.string.scene102choice6, 108, Element.PHOENIX))
            }
            else
            {
                prompts = listOf(getString(context,R.string.scene102alt1prompt1) + " " + state.playerName + " " + getString(context,R.string.scene102alt1prompt2))
                choices = listOf(getChoice(R.string.scene102alt1choice1, 118, Element.LUXOR),
                    getChoice(R.string.scene102alt1choice2,133, Element.AQUA),
                    getChoice(R.string.scene102alt1choice3,141,Element.PYRO),
                    getChoice(R.string.scene102alt1choice4,153,Element.STORM),
                    getChoice(R.string.scene102alt1choice5,161,Element.PEGASUS),
                    getChoice(R.string.scene102alt1choice6,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 103)
        {
            val prompts = getPrompt(R.string.scene103prompt)
            val choices = listOf(getChoice(R.string.scene103choice1, 109, Element.AQUA),
                getChoice(R.string.scene103choice2, 109, Element.UMBRAL),
                getChoice(R.string.scene103choice3, 110))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 104)
        {
            val prompts = getPrompt(R.string.scene104prompt)
            val choices = listOf(getChoice(R.string.scene104choice1, 111, Element.LUXOR),
                getChoice(R.string.scene104choice2, 112, Element.WEATHER),
                getChoice(R.string.scene104choice3, 113))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 105)
        {
            val prompts = getPrompt(R.string.scene105prompt)
            val choices = listOf(getChoice(R.string.scene105choice1, 114, Element.BIRD),
                getChoice(R.string.scene105choice2, 113, Element.AQUA))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 106)
        {
            val prompts = getPrompt(R.string.scene106prompt)
            val choices = listOf(getChoice(R.string.scene106choice1, 133, Element.AQUA),
                getChoice(R.string.scene106choice2, 115, Element.LAVA))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 107)
        {
            val prompts = getPrompt(R.string.scene107prompt)
            val choices = listOf(getChoice(R.string.scene107choice1, 116),
                getChoice(R.string.scene107choice2, 117))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 108)
        {
            val prompts = getPrompt(R.string.scene108prompt)
            val choices = listOf(getChoice(R.string.scene108choice1, 112, Element.LUXOR),
                getChoice(R.string.scene108choice2, 131, Element.AQUA),
                getChoice(R.string.scene108choice3, 140, Element.PYRO),
                getChoice(R.string.scene108choice4, 152, Element.STORM),
                getChoice(R.string.scene108choice5, 160, Element.AERO),
                getChoice(R.string.scene108choice6, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 109)
        {
            val prompts = getPrompt(R.string.scene109prompt)
            val choices = listOf(getChoice(R.string.scene109choice1, 112, Element.LUXOR),
                getChoice(R.string.scene109choice2, 131, Element.AQUA),
                getChoice(R.string.scene109choice3, 140, Element.PYRO),
                getChoice(R.string.scene109choice4, 152, Element.STORM),
                getChoice(R.string.scene109choice5, 160, Element.AERO),
                getChoice(R.string.scene109choice6, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 110)
        {
            val prompts = getPrompt(R.string.scene110prompt)
            val choices = listOf(getChoice(R.string.scene110choice1, 165),
                getChoice(R.string.scene110choice2, 168),
                getChoice(R.string.scene110choice3, 109))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 111)
        {
            val prompts = getPrompt(R.string.scene111prompt)
            val choices = listOf(getChoice(R.string.scene111choice1, 170),
                getChoice(R.string.scene111choice2, 171),
                getChoice(R.string.scene111choice3, 112))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 112)
        {
            val prompts = getPrompt(R.string.scene112prompt)
            val choices = listOf(getChoice(R.string.scene112choice1, 118),
                getChoice(R.string.scene112choice2, 119, Element.UMBRAL))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 113)
        {
            val prompts = getPrompt(R.string.scene113prompt)
            val choices = listOf(getChoice(R.string.scene113choice1, 112, Element.LUXOR),
                getChoice(R.string.scene113choice1, 131, Element.AQUA),
                getChoice(R.string.scene113choice3, 140, Element.PYRO),
                getChoice(R.string.scene113choice4, 152, Element.STORM),
                getChoice(R.string.scene113choice5, 160, Element.AERO),
                getChoice(R.string.scene113choice6, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 114)
        {
            val prompts = getPrompt(R.string.scene114prompt)
            val choices = listOf(getChoice(R.string.scene114choice1, 112, Element.LUXOR),
                getChoice(R.string.scene114choice2, 131, Element.AQUA),
                getChoice(R.string.scene114choice3, 140, Element.PYRO),
                getChoice(R.string.scene114choice4, 152, Element.STORM),
                getChoice(R.string.scene114choice5, 160, Element.AERO),
                getChoice(R.string.scene114choice6, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 115)
        {
            val prompts = getPrompt(R.string.scene115prompt)
            val choices = listOf(getChoice(R.string.scene115choice1, 131),
                getChoice(R.string.scene115choice2, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 116)
        {
            val prompts = getPrompt(R.string.scene116prompt)
            val choices = listOf(getChoice(R.string.scene116choice1, 112),
                getChoice(R.string.scene116choice1, 172))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 117)
        {
            val prompts = getPrompt(R.string.scene117prompt)
            val choices = listOf(getChoice(R.string.scene117choice1, 175, Element.JUSTICE),
                getChoice(R.string.scene117choice2, 112, Element.AQUA))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 118)
        {
            val prompts = getPrompt(R.string.scene118prompt)
            val choices: List<Choice>
            if(state.getQuestStage(5) < 3)// if we havent yet finished a writing lesson
            {
                choices = listOf(getChoice(R.string.scene118choice1, 120),
                    getChoice(R.string.scene118choice2, 119, { state.setQuestStage(5, 2) }))
            }
            else
            {
                choices = listOf(getChoice(R.string.scene118alt1choice1,102),
                    getChoice(R.string.scene118alt1choice2,120),
                    getChoice(R.string.scene118alt1choice3,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 119)
        {
            val prompts = getPrompt(R.string.scene119prompt)
            val choices = listOf(getChoice(R.string.scene119choice1, 79, {state.setQuestStage(5,3)}))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 120)
        {
            val prompts = getPrompt(R.string.scene120prompt)
            val choices : List<Choice> = if(state.getQuestStage(5) < 3)
            {
                listOf(getChoice(R.string.scene120choice1, 121),
                    getChoice(R.string.scene120choice2, 122, Element.PHOENIX))
            }
            else
            {
                listOf(getChoice(R.string.scene120alt1choice1,118),
                    getChoice(R.string.scene120alt1choice2,121),
                    getChoice(R.string.scene120alt1choice3,102),
                    getChoice(R.string.scene120alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 121)
        {
            val prompts = getPrompt(R.string.scene121prompt)
            val choices : List<Choice> = if(state.getQuestStage(5) <3){
                listOf(getChoice(R.string.scene121choice1, 123),
                    getChoice(R.string.scene121choice2, 122, Element.PHOENIX, {state.setQuestStage(5,2)}))
            }
            else
            {
                listOf(getChoice(R.string.scene121alt1choice1,120),
                    getChoice(R.string.scene121alt1choice2, 123),
                    getChoice(R.string.scene121alt1choice3,102),
                    getChoice(R.string.scene121alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 122)
        {
            val prompts = getPrompt(R.string.scene122prompt)
            val choices = listOf(getChoice(R.string.scene122choice, 79, {state.setQuestStage(5,2)}))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 123)
        {
            val prompts = getPrompt(R.string.scene123prompt)
            val choices = if (state.getQuestStage(5) < 3)
            {
                listOf(getChoice(R.string.scene123choice1, 124, Element.LUNAR),
                    getChoice(R.string.scene123choice2, 122, Element.PHOENIX))
            }
            else
            {
                listOf(getChoice(R.string.scene123alt1choice1, 121),
                    getChoice(R.string.scene123alt1choice2, 124),
                    getChoice(R.string.scene123alt1choice3, 102),
                    getChoice(R.string.scene123alt1choice4, 79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 124)
        {
            val prompts = getPrompt(R.string.scene124prompt)
            val choices = if(state.getQuestStage(5) < 3)
            {
                listOf(getChoice(R.string.scene124choice1, 125, Element.LUNAR),
                    getChoice(R.string.scene124choice2, 126, Element.PHOENIX, {state.setQuestStage(5,2)}))
            }
            else
            {
                listOf(getChoice(R.string.scene124alt1choice1, 123),
                    getChoice(R.string.scene124alt1choice2,125),
                    getChoice(R.string.scene124alt1choice3,102),
                    getChoice(R.string.scene124alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 125)
        {
            val prompts = getPrompt(R.string.scene125prompt)
            val choices = if(state.getQuestStage(5) < 3) {
                listOf(getChoice(R.string.scene125choice1, 127, Element.LUNAR),
                    getChoice(R.string.scene125choice2, 126, Element.PHOENIX))
            }
            else
            {
                listOf(getChoice(R.string.scene125alt1choice1,124),
                    getChoice(R.string.scene125alt1choice2,127),
                    getChoice(R.string.scene125alt1choice3,102),
                    getChoice(R.string.scene125alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 126)
        {
            val prompts = getPrompt(R.string.scene126prompt)
            val choices = listOf(getChoice(R.string.scene126choice1, 79, {state.setQuestStage(5,2)}))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 127)
        {
            val prompts = getPrompt(R.string.scene127prompt)
            val choices = if(state.getQuestStage(5) < 3) {
                listOf(getChoice(R.string.scene127choice1,128, {state.setQuestStage(5,2)}),
                    getChoice(R.string.scene127choice2,126))
            }
            else
            {
                listOf(getChoice(R.string.scene127alt1choice1,125),
                getChoice(R.string.scene127alt1choice2,128),
                    getChoice(R.string.scene127alt1choice3,102),
                    getChoice(R.string.scene127alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 128)
        {
            val prompts = getPrompt(R.string.scene128prompt)
            val choices = if(state.getQuestStage(5) < 3) {
                listOf(Choice(getString(context, R.string.scene128choice1),
                    129) { state.setChoresStage_WritingLessonFinished();state.setQuestStage(5,3); state.setQuestStage(9,1) },
                    Choice(getString(context, R.string.scene128choice2),
                        130) { state.setChoresStage_WritingLessonFinished();state.setQuestStage(5,3);state.setQuestStage(9,1) })
            }
            else
            {
                listOf(getChoice(R.string.scene128alt1choice1,127,{state.setQuestStage(9,1)}),
                    getChoice(R.string.scene128alt1choice2,102,{state.setQuestStage(9,1)}),
                    getChoice(R.string.scene128alt1choice3,79,{state.setQuestStage(9,1)}))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 129)
        {
            val prompts = getPrompt(R.string.scene129prompt)
            val choices = listOf(getChoice(R.string.scene129choice1, 176),
                getChoice(R.string.scene129choice2, 130))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 130)
        {
            val prompts = getPrompt(R.string.scene130prompt)
            val choices = listOf(getChoice(R.string.scene130choice1, 79, {state.setQuestStage(5,2)}))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 131)
        {
            val prompts = getPrompt(R.string.scene131prompt)
            val choices = listOf(getChoice(R.string.scene131choice1, 133, Element.AQUA),
                getChoice(R.string.scene132choice2, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 132)
        {
            val prompts = getPrompt(R.string.scene132prompt)
            val choices = listOf(getChoice(R.string.scene132choice1, 113),
                getChoice(R.string.scene132choice2, 79, {state.setQuestStage(5,3)}))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 133)
        {
            val prompts = getPrompt(R.string.scene133prompt)
            val choices = if(state.getQuestStage(5) < 3) {
                listOf(getChoice(R.string.scene133choice1, 134, Element.AQUA),
                        getChoice(R.string.scene133choice2, 119, Element.PHOENIX))
                }
                else
            {
                listOf(getChoice(R.string.scene133alt1choice1,102),
                    getChoice(R.string.scene133alt1choice2,134),
                    getChoice(R.string.scene133alt1choice3,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 134)
        {
            val prompts = getPrompt(R.string.scene134prompt)
            val choices = if(state.getQuestStage(5) < 3) {
                listOf(getChoice(R.string.scene134choice1, 135, Element.AQUA),
                    getChoice(R.string.scene134choice2, 119, Element.PHOENIX))
            }
            else{
                listOf(getChoice(R.string.scene134alt1choice1,133),
                    getChoice(R.string.scene134alt1choice2,135),
                    getChoice(R.string.scene134alt1choice3,102),
                    getChoice(R.string.scene134alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 135)
        {
            val prompts = getPrompt(R.string.scene135prompt)
            val choices = if(state.getQuestStage(5) <3) {
                listOf(getChoice(R.string.scene135choice1, 136, Element.AQUA),
                    getChoice(R.string.scene135choice2, 122, Element.PHOENIX))
            }
            else
            {
                listOf(getChoice(R.string.scene135alt1choice1,134),
                    getChoice(R.string.scene135alt1choice2,136),
                    getChoice(R.string.scene135alt1choice3,102),
                    getChoice(R.string.scene135alt1choice4,79))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 136)
        {
            val prompts = getPrompt(R.string.scene136prompt)
            val choices = if(state.getQuestStage(5) < 3) {
                listOf(Choice(getString(context, R.string.scene136choice),
                    137) { state.setChoresStage_WritingLessonFinished(); state.setQuestStage(5,3); state.setQuestStage(10,1) })
            }
            else
            {
                listOf(getChoice(R.string.scene136alt1choice1,135,{state.setChoresStage_WritingLessonFinished(); state.setQuestStage(5,3); state.setQuestStage(10,1)}),
                    getChoice(R.string.scene136alt1choice2,102,{state.setChoresStage_WritingLessonFinished(); state.setQuestStage(5,3); state.setQuestStage(10,1)}),
                    getChoice(R.string.scene136alt1choice3,79,{state.setChoresStage_WritingLessonFinished(); state.setQuestStage(5,3); state.setQuestStage(10,1)}))
            }
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 137)
        {
            val prompts = listOf(getString(context,
                R.string.scene137prompt1) + " " + state.playerName + " " + getString(context,
                R.string.scene137prompt2))
            val choices = listOf(getChoice(R.string.scene137choice1, 79),
                getChoice(R.string.scene137choice2, 138, Element.AQUA))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 138)
        {
            val prompts = getPrompt(R.string.scene138prompt)
            val choices = listOf(getChoice(R.string.scene138choice1, 79),
                getChoice(R.string.scene138choice2, 139, Element.DEEP))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 139)
        {
            val prompts = getPrompt(R.string.scene139prompt)
            val choices = listOf(getChoice(R.string.scene139choice, 79))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 140)
        {
            val prompts = getPrompt(R.string.scene140prompt)
            val choices = listOf(getChoice(R.string.scene140choice1, 141, Element.STEAM),
                getChoice(R.string.scene140choice2, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 141)
        {
            val prompts = getPrompt(R.string.scene141prompt)
            val choices = listOf(getChoice(R.string.scene141choice1, 132, Element.PHOENIX),
                getChoice(R.string.scene141choice2, 141, Element.STEAM))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 142)
        {
            val prompts = getPrompt(R.string.scene142prompt)
            val choices = listOf(getChoice(R.string.scene142choice1, 143, Element.STEAM),
                getChoice(R.string.scene142choice2, 119, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 143)
        {
            val prompts = getPrompt(R.string.scene143prompt)
            val choices = listOf(getChoice(R.string.scene143choice1, 144, Element.STEAM),
                getChoice(R.string.scene143choice2, 122, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 144)
        {
            val prompts = getPrompt(R.string.scene144prompt)
            val choices = listOf(getChoice(R.string.scene144choice1, 145, Element.STEAM),
                getChoice(R.string.scene144choice2, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 145)
        {
            val prompts = getPrompt(R.string.scene145prompt)
            val choices = listOf(Choice(getString(context, R.string.scene145choice1),
                137,
                { state.setChoresStage_WritingLessonFinished() },
                Element.AMPHIBIOUS,
                false),
                Choice(getString(context, R.string.scene145choice1),
                    146,
                    { state.addScore(Element.LAVA);state.setChoresStage_WritingLessonFinished() },
                    Element.LAVA,
                    false))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 146)
        {
            val prompts = getPrompt(R.string.scene146prompt)
            val choices = listOf(getChoice(R.string.scene146choice1, 147, Element.JUSTICE),
                getChoice(R.string.scene146choice2, 148),
                getChoice(R.string.scene146choice3, 149, Element.DEMON))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 147)
        {
            val prompts = getPrompt(R.string.scene147prompt)
            val choices = listOf(getChoice(R.string.scene147choice1, 150))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 148)
        {
            val prompts = getPrompt(R.string.scene148prompt)
            val choices = listOf(getChoice(R.string.scene148choice1, 79))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 149)
        {
            val prompts = getPrompt(R.string.scene149prompt)
            val choices = listOf(getChoice(R.string.scene149choice1, 150, Element.JUSTICE),
                getChoice(R.string.scene149choice2, 151, Element.PYRO),
                getChoice(R.string.scene149choice3, 151, Element.DEMON))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 150)
        {
            val prompts = getPrompt(R.string.scene150prompt)
            val choices = listOf(getChoice(R.string.scene150choice1, 79))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 151)
        {
            val prompts = getPrompt(R.string.scene151prompt)
            val choices = listOf(getChoice(R.string.scene151choice1, 79))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 152)
        {
            val prompts = getPrompt(R.string.scene152prompt)
            val choices = listOf(getChoice(R.string.scene152choice1, 132, Element.PHOENIX),
                getChoice(R.string.scene152choice2, 153, Element.WEATHER))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 153)
        {
            val prompts = getPrompt(R.string.scene153prompt)
            val choices = listOf(getChoice(R.string.scene153choice1, 119, Element.PHOENIX),
                getChoice(R.string.scene153choice2, 154, Element.WEATHER))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 154)
        {
            val prompts = getPrompt(R.string.scene154prompt)
            val choices = listOf(getChoice(R.string.scene154choice1, 122, Element.PHOENIX),
                getChoice(R.string.scene154choice2, 155, Element.WEATHER))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 155)
        {
            val prompts = getPrompt(R.string.scene155prompt)
            val choices = listOf(Choice(getString(context, R.string.scene155choice1), 137),
                Choice(getString(context, R.string.scene155choice2),
                    156) { state.setChoresStage_WritingLessonFinished() },
                Choice(getString(context, R.string.scene155choice3),
                    157) { state.setChoresStage_WritingLessonFinished() })
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 156)
        {
            val prompts = getPrompt(R.string.scene156prompt)
            val choices = listOf(getChoice(R.string.scene156choice1, 137))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 157)
        {
            val prompts = getPrompt(R.string.scene157prompt)
            val choices = listOf(getChoice(R.string.scene157choice1, 158, Element.ANGEL),
                getChoice(R.string.scene157choice2, 159, Element.NIGHTWING))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 158)
        {
            val prompts =
                listOf(getString(context, R.string.scene158prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender))
            val choices = listOf(getChoice(R.string.scene158choice1, 79))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 159)
        {
            val prompts = getPrompt(R.string.scene159prompt)
            val choices = listOf(getChoice(R.string.scene159choice1, 79))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 160)
        {
            val prompts = getPrompt(R.string.scene160prompt)
            val choices = listOf(getChoice(R.string.scene160choice1, 132, Element.PHOENIX),
                getChoice(R.string.scene160choice2, 161, Element.AERO))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 161)
        {
            val prompts = getPrompt(R.string.scene161prompt)
            val choices = listOf(getChoice(R.string.scene161choice1, 119, Element.PHOENIX),
                getChoice(R.string.scene161choice2, 163, Element.AERO))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 162)
        {
            val prompts = getPrompt(R.string.scene162prompt)
            val choices = listOf(getChoice(R.string.scene162choice1, 122, Element.PHOENIX),
                getChoice(R.string.scene162choice2, 163, Element.AERO))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 163)
        {
            val prompts = getPrompt(R.string.scene163prompt)
            val choices = listOf(Choice(getString(context, R.string.scene163choice1),
                137) { state.setChoresStage_WritingLessonFinished() })
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 164)
        {
            val prompts = getPrompt(R.string.scene164prompt)
            val choices = listOf(getChoice(R.string.scene164choice1, 165))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 165)
        {
            val prompts = getPrompt(R.string.scene165prompt)
            val choices = listOf(getChoice(R.string.scene165choice1, 166),
                getChoice(R.string.scene165choice2, 167),
                getChoice(R.string.scene165choice3, 166))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 166)
        {
            val prompts = getPrompt(R.string.scene166prompt)
            val choices = listOf(getChoice(R.string.scene166choice1, 113))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 167)
        {
            val prompts = getPrompt(R.string.scene167prompt)
            val choices = listOf(getChoice(R.string.scene167choice1, 168),
                getChoice(R.string.scene167choice2, 113))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 168)
        {
            val prompts = getPrompt(R.string.scene168prompt)
            val choices = listOf(getChoice(R.string.scene168choice1, 112, Element.LUXOR),
                getChoice(R.string.scene168choice2, 131, Element.AQUA),
                getChoice(R.string.scene168choice3, 140, Element.PYRO),
                getChoice(R.string.scene168choice4, 152, Element.STORM),
                getChoice(R.string.scene168choice5, 160, Element.AERO),
                getChoice(R.string.scene168choice6, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 169)
        {
            val prompts = getPrompt(R.string.scene169prompt)
            val choices = listOf(getChoice(R.string.scene169choice1, 112, Element.LUXOR),
                getChoice(R.string.scene169choice2, 132, Element.PHOENIX))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 170)
        {
            val prompts = getPrompt(R.string.scene170prompt)
            val choices = listOf(getChoice(R.string.scene170choice1, 171, Element.JUSTICE),
                getChoice(R.string.scene170choice2, 171, Element.LUNAR),
                getChoice(R.string.scene170choice3, 171, Element.COMPASSION),
                getChoice(R.string.scene170choice4, 171, Element.ANGEL),
                getChoice(R.string.scene170choice5, 171, Element.REDEMPTION),
                getChoice(R.string.scene170choice6, 112, Element.AQUA))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 171)
        {
            val prompts = getPrompt(R.string.scene171prompt)
            val choices = listOf(getChoice(R.string.scene171choice1, 112),
                getChoice(R.string.scene171choice2, 119))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 172)
        {
            val prompts = getPrompt(R.string.scene172prompt)
            val choices = listOf(getChoice(R.string.scene172choice1, 173),
                getChoice(R.string.scene172choice2, 174),
                getChoice(R.string.scene172choice3, 113),
                getChoice(R.string.scene172choice4, 132))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 173)
        {
            val prompts = getPrompt(R.string.scene173prompt)
            val choices = listOf(getChoice(R.string.scene173choice1, 174),
                getChoice(R.string.scene173choice2, 113),
                getChoice(R.string.scene173choice3, 132))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 174)
        {
            val prompts = getPrompt(R.string.scene174prompt)
            val choices = listOf(getChoice(R.string.scene174choice1, 113),
                getChoice(R.string.scene174choice2, 132))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 175)
        {
            val prompts = getPrompt(R.string.scene175prompt)
            val choices = listOf(getChoice(R.string.scene175choice1, 113),
                getChoice(R.string.scene175choice2, 132))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 176)
        {
            val prompts = getPrompt(R.string.scene176prompt)
            val choices = listOf(getChoice(R.string.scene176choice, 130))
            return getBrahmNode(index, prompts, choices)
        }
        if (index == 177)
        {
            val prompts =
                listOf(getString(context, R.string.scene177prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene177prompt2))
            val choices = listOf(getChoice(R.string.scene177choice1, 178, Element.TERRA),
                getChoice(R.string.scene177choice2, 179, Element.UMBRAL),
                getChoice(R.string.scene177choice3, 180),
                getChoice(R.string.scene177choice4, 181, Element.AERO),
                getChoice(R.string.scene177choice5, 182, Element.PYRO),
                getChoice(R.string.scene177choice6, 183))
            return getGateNode(index, prompts, choices)
        }
        if (index == 178)
        {
            val prompts = getPrompt(R.string.scene178prompt)
            val choices = listOf(getChoice(R.string.scene178choice1, 182, Element.PYRO),
                getChoice(R.string.scene178choice2, 183, Element.STORM),
                getChoice(R.string.scene178choice3, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 179)
        {
            val prompts = getPrompt(R.string.scene179prompt)
            val choices = listOf(getChoice(R.string.scene179choice1, 184, Element.PYRO),
                getChoice(R.string.scene179choice2, 185, Element.SEABREEZE),
                getChoice(R.string.scene179choice3, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 180)
        {
            val prompts =
                listOf(getString(context, R.string.scene180prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene180prompt2))
            val choices = listOf(getChoice(R.string.scene180choice1, 186),
                getChoice(R.string.scene180choice2, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 181)
        {
            val prompts = getPrompt(R.string.scene181prompt)
            val choices = listOf(getChoice(R.string.scene181choice1, 186),
                getChoice(R.string.scene181choice2, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 182)
        {
            val prompts =
                listOf(getString(context, R.string.scene182prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene182prompt2))
            val choices = listOf(getChoice(R.string.scene182choice1, 186),
                getChoice(R.string.scene182choice2, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 183)
        {
            val prompts =
                listOf(getString(context, R.string.scene183prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene183prompt2))
            val choices = listOf(getChoice(R.string.scene183choice1, 186),
                getChoice(R.string.scene183choice2, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 184)
        {
            val prompts = getPrompt(R.string.scene184prompt)
            val choices = listOf(getChoice(R.string.scene184choice1, 186),
                getChoice(R.string.scene184choice2, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 185)
        {
            val prompts = getPrompt(R.string.scene185prompt)
            val choices = listOf(getChoice(R.string.scene185choice1, 186),
                getChoice(R.string.scene185choice2, 79))
            return getGateNode(index, prompts, choices)
        }
        if (index == 186)
        {
            val prompts = getPrompt(R.string.scene186prompt)
            val choices = listOf(getChoice(R.string.scene186choice,
                79,
                { state.setQuestStage(7, 1) }))
            return getGateNode(index, prompts, choices)
        }
        if (index == 187)
        {
            val prompts = getPrompt(R.string.scene187prompt)
            val choices = listOf(getChoice(R.string.scene187choice1, 188),
                getChoice(R.string.scene187choice2, 206),
                getChoice(R.string.scene187choice3, 217),
                getChoice(R.string.scene187choice4,
                    219), //Choice(getString(context,R.string.scene187choice5),0),//TODO: finish and restore
                getChoice(R.string.scene187choice6, 79))
            val animations = listOf(AnimationInfo(R.drawable.background_morns_tavern,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 188)
        {
            val prompts =
                listOf(getString(context, R.string.scene188prompt1) + " " + Gender.getNickname3(
                    context,
                    state.gender) + getString(context, R.string.scene188prompt2))
            val choices: List<Choice>
            if (state.getQuestStage(1) == 3)
            {
                choices = listOf(getChoice(R.string.scene188choice1, 189),
                    getChoice(R.string.scene188choice4, 190),
                    getChoice(R.string.scene188choice6, 203))
            }
            else if (state.getQuestStage(1) == 0)
            {
                choices = listOf(getChoice(R.string.scene188choice5, 235),
                    getChoice(R.string.scene188choice4, 190),
                    getChoice(R.string.scene188choice6, 203))
            }
            else if (state.getQuestStage(1) == 5)
            {
                choices = listOf(getChoice(R.string.scene188choice2, 189),
                    getChoice(R.string.scene188choice4, 190),
                    getChoice(R.string.scene188choice6, 203))
            }
            else if (state.getQuestStage(1) == 8)
            {
                choices = listOf(getChoice(R.string.scene188choice3, 189),
                    getChoice(R.string.scene188choice4, 190),
                    getChoice(R.string.scene188choice6, 203))
            }
            else
            {
                choices = listOf(getChoice(R.string.scene188choice4, 190),
                    getChoice(R.string.scene188choice6, 203))
            }
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 189)
        {
            val prompts = getPrompt(R.string.scene189prompt)
            val choices = listOf(getChoice(R.string.scene189choice1, 191, Element.AERO),
                getChoice(R.string.scene189choice2, 192, Element.UMBRAL))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 190)
        {
            val prompts = getPrompt(R.string.scene190prompt)
            val choices = listOf(getChoice(R.string.scene190choice1, 191, Element.AERO),
                getChoice(R.string.scene190choice2, 192, Element.UMBRAL))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 191)
        {
            val prompts =
                listOf(getString(context, R.string.scene191prompt1) + " " + Gender.getNickname3(
                    context,
                    state.gender) + getString(context, R.string.scene191prompt2))
            val choices = listOf(getChoice(R.string.scene191choice1, 193, Element.TERRA),
                getChoice(R.string.scene191choice2, 194, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 192)
        {
            val prompts =
                listOf(getString(context, R.string.scene192prompt1) + " " + Gender.getNickname3(
                    context,
                    state.gender) + getString(context, R.string.scene192prompt2))
            val choices = listOf(getChoice(R.string.scene192choice1, 196, Element.ROTTEN),
                getChoice(R.string.scene192choice2, 191, Element.AERO))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 193)
        {
            val prompts = getPrompt(R.string.scene193prompt)
            val choices = listOf(getChoice(R.string.scene193choice1, 197, Element.COMPASSION),
                getChoice(R.string.scene193choice2, 198))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 194)
        {
            val prompts = getPrompt(R.string.scene194prompt)
            val choices = listOf(getChoice(R.string.scene194choice1, 197, Element.COMPASSION),
                getChoice(R.string.scene194choice2, 198))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 195)
        {
            val prompts =
                listOf(getString(context, R.string.scene195prompt1) + " " + Gender.getNickname3(
                    context,
                    state.gender) + getString(context, R.string.scene195prompt2))
            val choices = listOf(getChoice(R.string.scene195choice1, 199),
                getChoice(R.string.scene195choice2,
                    187,
                    { state.setQuestStage(4, 9) }))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 196)
        {
            val prompts = getPrompt(R.string.scene196prompt)
            val choices = listOf(getChoice(R.string.scene196choice1, 200, Element.UMBRAL),
                getChoice(R.string.scene196choice2, 191))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 197)
        {
            val prompts = getPrompt(R.string.scene197prompt)
            val choices = listOf(getChoice(R.string.scene197choice1, 198, Element.COMPASSION),
                getChoice(R.string.scene197choice2, 201, Element.NIGHTWING))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 198)
        {
            val prompts = getPrompt(R.string.scene198prompt)
            val choices = listOf(getChoice(R.string.scene198choice,
                187,
                { state.setQuestStage(4, 2) }))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 199)
        {
            val prompts = getPrompt(R.string.scene199prompt)
            val choices = listOf(getChoice(R.string.scene199choice1, 197, Element.COMPASSION),
                getChoice(R.string.scene199choice2, 198))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 200)
        {
            val prompts = getPrompt(R.string.scene200prompt)
            val choices = listOf(getChoice(R.string.scene200choice1, 191),
                getChoice(R.string.scene200choice2, 202, Element.UMBRAL))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 201)
        {
            val prompts =
                listOf(getString(context, R.string.scene201prompt1) + " " + Gender.getNickname3(
                    context,
                    state.gender) + getString(context, R.string.scene201prompt2))
            val choices = listOf(getChoice(R.string.scene201choice,
                187,
                { state.setQuestStage(4, 9) }))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 202)
        {
            val prompts = getPrompt(R.string.scene202prompt)
            val choices = listOf(getChoice(R.string.scene202choice1, 197, Element.COMPASSION),
                getChoice(R.string.scene202choice2, 198),
                getChoice(R.string.scene202choice3, 201, Element.STORM))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 203)
        {
            val prompts = getPrompt(R.string.scene203prompt)
            val choices = listOf(getChoice(R.string.scene203choice1, 204),
                getChoice(R.string.scene203choice2, 189))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 204)
        {
            val prompts = getPrompt(R.string.scene204prompt)
            val choices = listOf(getChoice(R.string.scene204choice1, 205),
                getChoice(R.string.scene204choice2, 189))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 205)
        {
            val prompts = getPrompt(R.string.scene205prompt)
            val choices = listOf(getChoice(R.string.scene205choice, 189))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 206)
        {
            val prompts = getPrompt(R.string.scene206prompt)
            val choices = listOf(getChoice(R.string.scene206choice1, 207),
                getChoice(R.string.scene206choice2, 208),
                getChoice(R.string.scene206choice3, 187),
                getChoice(R.string.scene206choice4, 211),
                getChoice(R.string.scene206choice5, 214),
                getChoice(R.string.scene206choice6, 213))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 207)
        {
            val prompts = getPrompt(R.string.scene207prompt)
            val choices = listOf(getChoice(R.string.scene207choice1, 209),
                getChoice(R.string.scene207choice2, 210))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 208)
        {
            val prompts = getPrompt(R.string.scene208prompt)
            val choices = listOf(getChoice(R.string.scene208choice1, 187),
                getChoice(R.string.scene208choice2, 207),
                getChoice(R.string.scene208choice3, 214))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 209)
        {
            val prompts = getPrompt(R.string.scene209prompt)
            val choices = listOf(getChoice(R.string.scene209choice1, 219),
                getChoice(R.string.scene209choice2, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 210)
        {
            val prompts = getPrompt(R.string.scene210prompt)
            val choices = listOf(getChoice(R.string.scene210choice1, 187),
                getChoice(R.string.scene210choice2, 214),
                getChoice(R.string.scene210choice3, 213))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 211)
        {
            val prompts = getPrompt(R.string.scene211prompt)
            val choices = listOf(getChoice(R.string.scene211choice1, 207),
                getChoice(R.string.scene211choice2, 214),
                getChoice(R.string.scene211choice3, 212, Element.VENGEANCE),
                getChoice(R.string.scene211choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 212)
        {
            val prompts = getPrompt(R.string.scene212prompt)
            val choices = listOf(getChoice(R.string.scene212choice1, 213),
                getChoice(R.string.scene212choice2, 207),
                getChoice(R.string.scene212choice3, 214))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 213)
        {
            val prompts = getPrompt(R.string.scene213prompt)
            val choices = listOf(getChoice(R.string.scene213choice1, 207),
                getChoice(R.string.scene213choice2, 214),
                getChoice(R.string.scene213choice3, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 214)
        {
            val prompts = getPrompt(R.string.scene214prompt)
            val choices = listOf(getChoice(R.string.scene214choice1, 215),
                getChoice(R.string.scene214choice2, 207),
                getChoice(R.string.scene214choice3, 213),
                getChoice(R.string.scene214choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 215)
        {
            val prompts = getPrompt(R.string.scene215prompt)
            val choices = listOf(getChoice(R.string.scene215choice1, 216),
                getChoice(R.string.scene215choice2, 217),
                getChoice(R.string.scene215choice3, 207),
                getChoice(R.string.scene215choice4, 213),
                getChoice(R.string.scene215choice5, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 216)
        {
            val prompts =
                listOf(getString(context, R.string.scene216prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + getString(context, R.string.scene216prompt2))
            val choices = listOf(getChoice(R.string.scene216choice1, 207),
                getChoice(R.string.scene216choice2, 213),
                getChoice(R.string.scene216choice3, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_barmaid,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 217)
        {
            val prompts = getPrompt(R.string.scene217prompt)
            val choices = listOf(getChoice(R.string.scene217choice1, 218),
                getChoice(R.string.scene217choice2, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_black_cat,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 218)
        {
            val prompts = getPrompt(R.string.scene218prompt)
            val choices = listOf(getChoice(R.string.scene218choice, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_black_cat,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 219)
        {
            val prompts =
                listOf(getString(context, R.string.scene219prompt1) + " " + Gender.getNickname4(
                    context,
                    state.gender) + " " + getString(context,
                    R.string.scene219prompt2) + " " + Gender.getNickname4(context,
                    state.gender) + " " + getString(context, R.string.scene219prompt3))
            val choices = listOf(getChoice(R.string.scene219choice1, 220),
                getChoice(R.string.scene219choice2, 221),
                getChoice(R.string.scene219choice3, 222),
                getChoice(R.string.scene219choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.fade_in_fast,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 220)
        {
            val prompts = getPrompt(R.string.scene220prompt)
            val choices = listOf(getChoice(R.string.scene220choice1, 221),
                getChoice(R.string.scene220choice2, 223),
                getChoice(R.string.scene220choice3, 222),
                getChoice(R.string.scene220choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 221)
        {
            val prompts = getPrompt(R.string.scene221prompt)
            val choices = listOf(getChoice(R.string.scene221choice1, 225),
                getChoice(R.string.scene221choice2, 220),
                getChoice(R.string.scene221choice3, 222))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 222)
        {
            val prompts = getPrompt(R.string.scene222prompt)
            val choices = listOf(getChoice(R.string.scene222choice1, 227),
                getChoice(R.string.scene222choice2, 228),
                getChoice(R.string.scene222choice3, 223),
                getChoice(R.string.scene222choice4, 224))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 223)
        {
            val prompts = getPrompt(R.string.scene223prompt)
            val choices = listOf(getChoice(R.string.scene223choice1, 228),
                getChoice(R.string.scene223choice2, 228),
                getChoice(R.string.scene223choice3, 227),
                getChoice(R.string.scene223choice4, 224))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 224)
        {
            val prompts = getPrompt(R.string.scene224prompt)
            val choices = listOf(getChoice(R.string.scene224choice1, 228),
                getChoice(R.string.scene224choice2, 231),
                getChoice(R.string.scene224choice3, 227),
                getChoice(R.string.scene224choice4, 223))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 225)
        {
            val prompts = getPrompt(R.string.scene225prompt)
            val choices = listOf(getChoice(R.string.scene225choice, 226))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 226)
        {
            val prompts = getPrompt(R.string.scene226prompt)
            val choices = listOf(getChoice(R.string.scene226choice1, 227),
                getChoice(R.string.scene226choice2, 232),
                getChoice(R.string.scene226choice3, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 227)
        {
            val prompts = getPrompt(R.string.scene227prompt)
            val choices = listOf(getChoice(R.string.scene227choice1, 228),
                getChoice(R.string.scene227choice2, 232),
                getChoice(R.string.scene227choice3, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 228)
        {
            val prompts = getPrompt(R.string.scene228prompt)
            val choices = listOf(getChoice(R.string.scene228choice1, 229),
                getChoice(R.string.scene228choice2, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 229)
        {
            val prompts = getPrompt(R.string.scene229prompt)
            val choices = listOf(getChoice(R.string.scene229choice1, 230),
                getChoice(R.string.scene229choice2, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 230)
        {
            val prompts = getPrompt(R.string.scene230prompt)
            val choices = listOf(getChoice(R.string.scene230choice1, 233, Element.REDEMPTION),
                getChoice(R.string.scene230choice2, 234, Element.LUXOR),
                getChoice(R.string.scene230choice3, 187, Element.ROTTEN))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 231)
        {
            val prompts = getPrompt(R.string.scene231prompt)
            val choices = listOf(getChoice(R.string.scene231choice1, 228),
                getChoice(R.string.scene231choice2, 227),
                getChoice(R.string.scene231choice3, 225),
                getChoice(R.string.scene231choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 232)
        {
            val prompts = getPrompt(R.string.scene232prompt)
            val choices = listOf(getChoice(R.string.scene232choice1, 228),
                getChoice(R.string.scene232choice2, 227),
                getChoice(R.string.scene232choice3, 225),
                getChoice(R.string.scene232choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 233)
        {
            val prompts = getPrompt(R.string.scene233prompt)
            val choices = listOf(getChoice(R.string.scene233choice, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 234)
        {
            val prompts = getPrompt(R.string.scene234prompt)
            val choices = listOf(getChoice(R.string.scene234choice, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_mad_prophet,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 235)
        {
            val prompts =
                listOf(getString(context, R.string.scene235prompt1) + " " + Gender.getNickname4(
                    context,
                    state.gender) + " " + getString(context, R.string.scene235prompt2))
            val choices = listOf(getChoice(R.string.scene235choice1, 196, Element.AERO),
                getChoice(R.string.scene235choice2, 187))
            val animations = listOf(AnimationInfo(R.drawable.character_morn,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 236)
        {
            val prompts =
                listOf(getString(context, R.string.scene236prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene236prompt2))
            val choices: List<Choice> //If we have spoken to dad and have the amulet to sell
            if (state.getQuestStage(6) == 1)
            {
                choices = listOf(getChoice(R.string.scene236choice1, 237),
                    getChoice(R.string.scene236choice2, 238))
            } //if(state.getQuestStage(Quest.SELL_AMULET) == 0)
            //default branch where we haven't met dad yet
            else
            {
                choices = listOf(getChoice(R.string.scene236choice1, 237))
            }
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.fade_in,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 237)
        {
            val prompts = getPrompt(R.string.scene237prompt)
            val choices = listOf(getChoice(R.string.scene237choice, 79))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 238)
        {
            val prompts = getPrompt(R.string.scene238prompt)
            val choices = listOf(getChoice(R.string.scene238choice1, 239),
                getChoice(R.string.scene238choice2, 240, Element.UMBRAL))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 239)
        {
            val prompts =
                listOf(getString(context, R.string.scene239prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene239prompt2))
            val choices = listOf(getChoice(R.string.scene239choice1, 241) { state.addGold(20) },
                getChoice(R.string.scene239choice2, 242))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 240)
        {
            val prompts = getPrompt(R.string.scene240prompt)
            val choices = listOf(getChoice(R.string.scene240choice1, 243),
                getChoice(R.string.scene240choice2, 242),
                getChoice(R.string.scene240choice3, 187))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 241)
        {
            val prompts = getPrompt(R.string.scene241prompt)
            val choices = listOf(getChoice(R.string.scene241choice1, 243),
                getChoice(R.string.scene241choice2, 244),
                getChoice(R.string.scene241choice3, 247),
                getChoice(R.string.scene241choice4, 187))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 242)
        {
            val prompts = getPrompt(R.string.scene242prompt)
            val choices = listOf(getChoice(R.string.scene242choice1,
                245) { state.addGold(22);state.setQuestStage(6, 2) },
                getChoice(R.string.scene242choice2, 246) {
                    state.setQuestStage(6, 6)
                })
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 243)
        {
            val prompts = getPrompt(R.string.scene243prompt)
            val choices = listOf(getChoice(R.string.scene243choice1, 250))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 244)
        {
            val prompts = getPrompt(R.string.scene244prompt)
            val choices = listOf(getChoice(R.string.scene244choice1, 248) {
                state.removeGold(20);state.setQuestStage(7, 3)
            }, getChoice(R.string.scene244choice2, 249))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 245)
        {
            val prompts = getPrompt(R.string.scene245prompt)
            val choices = listOf(getChoice(R.string.scene245choice1, 243),
                getChoice(R.string.scene245choice2, 244),
                getChoice(R.string.scene245choice3, 247, Element.STORM),
                getChoice(R.string.scene245choice4, 79))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 246)
        {
            val prompts = getPrompt(R.string.scene246prompt)
            val choices = listOf(getChoice(R.string.scene246choice1, 79, Element.AERO),
                getChoice(R.string.scene246choice2, 79, Element.TERRA))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 247)
        {
            val prompts =
                listOf(getString(context, R.string.scene247prompt1) + " " + Gender.getNickname2(
                    context,
                    state.gender) + " " + getString(context, R.string.scene247prompt2))
            val choices = listOf(getChoice(R.string.scene247choice1, 249),
                getChoice(R.string.scene247choice2, 79))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 248)
        {
            val prompts = getPrompt(R.string.scene248prompt)
            val choices = listOf(getChoice(R.string.scene248choice1, 79, Element.AERO),
                getChoice(R.string.scene248choice2, 79, Element.TERRA))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 249)
        {
            val prompts = getPrompt(R.string.scene249prompt)
            val choices = listOf(getChoice(R.string.scene249choice1, 243),
                getChoice(R.string.scene249choice2, 244),
                getChoice(R.string.scene249choice3, 247),
                getChoice(R.string.scene249choice4, 79))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 250)
        {
            val prompts = getPrompt(R.string.scene250prompt)
            val choices = listOf(getChoice(R.string.scene250choice1, 243),
                getChoice(R.string.scene250choice2, 244),
                getChoice(R.string.scene250choice3, 247),
                getChoice(R.string.scene250choice4, 79))
            val animations = listOf(AnimationInfo(R.drawable.background_oaktree_pawnshop,
                R.anim.appear,
                R.id.background_center))
            return getNode(index, prompts, choices, animations)
        }
        if (index == 251)
        {
            val choices = listOf(getChoice(R.string.scene251choice1, 254),
                getChoice(R.string.scene251choice2, 255),
                getChoice(R.string.scene251choice3, 256),
                getChoice(R.string.scene251choice4, 257),
                getChoice(R.string.scene251choice5, 79))
            if (state.getQuestStage(8) == 2)
            {
                return getMichaelChurchNode(index, getPrompt(R.string.scene251alt1prompt), choices)
            }
            return getMichaelChurchNode(index, getPrompt(R.string.scene251prompt), choices)
        }
        if (index == 252)
        {
            val prompts = getPrompt(R.string.scene252prompt)
            val choices = listOf(getChoice(R.string.scene252choice1, 258, Element.PYRO),
                getChoice(R.string.scene252choice2, 258, Element.LUXOR),
                getChoice(R.string.scene252choice3, 258, Element.UMBRAL),
                getChoice(R.string.scene252choice4, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 253)
        {
            val prompts = getPrompt(R.string.scene253prompt)
            val choices = listOf(getChoice(R.string.scene253choice1, 259, Element.TERRA),
                getChoice(R.string.scene253choice2, 260, Element.UMBRAL),
                getChoice(R.string.scene253choice3, 259, Element.LUXOR))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 254)
        {
            val prompts = getPrompt(R.string.scene254prompt)
            val choices = listOf(getChoice(R.string.scene254choice1, 261),
                getChoice(R.string.scene254choice2, 255),
                getChoice(R.string.scene254choice3, 256),
                getChoice(R.string.scene254choice4, 257),
                getChoice(R.string.scene254choice5, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 255)
        {
            val prompts = getPrompt(R.string.scene255prompt)
            val choices = listOf(getChoice(R.string.scene255choice, 262))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 256)
        {
            val prompts = getPrompt(R.string.scene256prompt)
            val choices = listOf(getChoice(R.string.scene256choice, 264))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 257)
        {
            val prompts = getPrompt(R.string.scene257prompt)
            val choices = listOf(getChoice(R.string.scene257choice1, 254),
                getChoice(R.string.scene257choice2, 261),
                getChoice(R.string.scene257choice3, 255),
                getChoice(R.string.scene257choice4, 256),
                getChoice(R.string.scene257choice5, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 258)
        {
            val prompts = getPrompt(R.string.scene258prompt)
            val choices = listOf(getChoice(R.string.scene258choice1, 80, Element.UMBRAL),
                getChoice(R.string.scene258choice2, 80, Element.ANGEL),
                getChoice(R.string.scene258choice3, 80, Element.TERRA))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 259)
        {
            val prompts = getPrompt(R.string.scene259prompt)
            val choices = listOf(getChoice(R.string.scene259choice1, 93),
                getChoice(R.string.scene259choice2, 94),
                getChoice(R.string.scene259choice3, 251),
                getChoice(R.string.scene259choice4, 252),
                getChoice(R.string.scene259choice5, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 260)
        {
            val prompts = getPrompt(R.string.scene260prompt)
            val choices = listOf(getChoice(R.string.scene260choice, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 261)
        {
            val prompts = getPrompt(R.string.scene261prompt)
            val choices = listOf(getChoice(R.string.scene261choice1, 265, Element.JUSTICE),
                getChoice(R.string.scene261choice2, 266, Element.LUNAR),
                getChoice(R.string.scene261choice3, 267, Element.COMPASSION),
                getChoice(R.string.scene261choice4, 268, Element.ANGEL),
                getChoice(R.string.scene261choice5, 269, Element.REDEMPTION),
                getChoice(R.string.scene261choice6, 270))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 262)
        {
            val prompts = getPrompt(R.string.scene262prompt)
            val choices = listOf(getChoice(R.string.scene262choice, 263))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 263)
        {
            val prompts = getPrompt(R.string.scene263prompt)
            val choices = listOf(getChoice(R.string.scene263choice1, 254),
                getChoice(R.string.scene263choice2, 255),
                getChoice(R.string.scene263choice3, 256),
                getChoice(R.string.scene263choice4, 257),
                getChoice(R.string.scene263choice5, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 264)
        {
            val prompts = getPrompt(R.string.scene264prompt)
            val choices = listOf(getChoice(R.string.scene264choice1, 254),
                getChoice(R.string.scene264choice2, 261),
                getChoice(R.string.scene264choice3, 255),
                getChoice(R.string.scene264choice4, 257),
                getChoice(R.string.scene264choice5, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 265)
        {
            val prompts = getPrompt(R.string.scene265prompt)
            val choices = listOf(getChoice(R.string.scene265choice1, 261),
                getChoice(R.string.scene265choice2, 60),
                getChoice(R.string.scene265choice3, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 266)
        {
            val prompts = getPrompt(R.string.scene266prompt)
            val choices = listOf(getChoice(R.string.scene266choice1, 271))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 267)
        {
            val prompts = getPrompt(R.string.scene267prompt)
            val choices = listOf(getChoice(R.string.scene267choice, 272))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 268)
        {
            val prompts = getPrompt(R.string.scene268prompt)
            val choices = listOf(getChoice(R.string.scene268choice1, 273))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 269)
        {
            val prompts = getPrompt(R.string.scene269prompt)
            val choices = listOf(getChoice(R.string.scene269choice1, 274))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 270)
        {
            val prompts = getPrompt(R.string.scene270prompt)
            val choices = listOf(getChoice(R.string.scene270choice1, 261),
                getChoice(R.string.scene270choice2, 80),
                getChoice(R.string.scene270choice3, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 271)
        {
            val prompts = getPrompt(R.string.scene271prompt)
            val choices = listOf(getChoice(R.string.scene271choice1, 261),
                getChoice(R.string.scene271choice2, 80),
                getChoice(R.string.scene271choice3, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 272)
        {
            val prompts = getPrompt(R.string.scene272prompt)
            val choices = listOf(getChoice(R.string.scene272choice1, 261),
                getChoice(R.string.scene272choice2, 80),
                getChoice(R.string.scene272choice3, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 273)
        {
            val prompts = getPrompt(R.string.scene273prompt)
            val choices = listOf(getChoice(R.string.scene273choice1, 261),
                getChoice(R.string.scene273choice2, 80),
                getChoice(R.string.scene274choice3, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        if (index == 274)
        {
            val prompts = getPrompt(R.string.scene274prompt)
            val choices = listOf(getChoice(R.string.scene274choice1, 261),
                getChoice(R.string.scene274choice2, 80),
                getChoice(R.string.scene274choice3, 79))
            return getMichaelChurchNode(index, prompts, choices)
        }
        else
        {
            val prompts = listOf("Whoops! please tell Austin theres an issue with node: " + index)
            val choices = listOf(Choice("Go back to Oaktree", 79))
            return getNode(index, prompts, choices, listOf())
        }
    }

    private fun getEnterNameNode(
        context: Context, index: Int, promptIndex: Int, element: Element): Node
    {
        val prompts: List<String> = listOf(getString(context, promptIndex))
        val choices = listOf(getChoice(R.string.enter_name, 54, element))
        val animations =
            listOf(AnimationInfo(Element.getInfantMonster(context, element).imageResourceId,
                R.anim.fade_in_slow,
                R.id.background_center,
                ImageView.ScaleType.FIT_CENTER))
        return getNode(index, prompts, choices, animations, element)
    }

    private fun getPlayerRoomAnimations(): List<AnimationInfo>
    {
        return listOf(AnimationInfo(R.drawable.background_players_room,
            R.anim.fade_in_fast,
            R.id.background_center),
            AnimationInfo(R.drawable.character_john_profile,
                R.anim.fade_in_fast,
                R.id.background_center,
                ImageView.ScaleType.FIT_CENTER))
    }

    //@formatter:off
    private fun getMichaelChurchNode(
        index: Int, prompts: List<String>, choices: List<Choice>): Node
    {
        val animations = listOf(AnimationInfo(R.drawable.background_oaktree_church,
            R.anim.fade_in_fast,
            R.id.background_center),
            AnimationInfo(R.drawable.character_michael_profile,
                if(index==80){R.anim.fade_in_fast}else{R.anim.appear},
                R.id.background_center))
        return getNode(index, prompts, choices, animations)
    }

    private fun getFatherChurchNode(
        index: Int, prompts: List<String>, choices: List<Choice>): Node
    {
        val animations = listOf(AnimationInfo(R.drawable.background_oaktree_church,
            R.anim.fade_in_fast,
            R.id.background_center),
            AnimationInfo(R.drawable.character_chuck_profile,
                if(index == 91) {R.anim.fade_in_fast} else {R.anim.appear},
                R.id.background_center))
        return getNode(index, prompts, choices, animations)
    }

    private fun getBrahmNode(
        index: Int, prompts: List<String>, choices: List<Choice>): Node
    {
        val animations = listOf(AnimationInfo(R.drawable.background_brahms_room,
            R.anim.fade_in_fast,
            R.id.background_center),
            AnimationInfo(R.drawable.character_brahm_profile,
                if (index == 102) { R.anim.fade_in_fast }else{R.anim.appear},
                R.id.background_center))
        return getNode(index, prompts, choices, animations)
    }
    //formatter:on

    private fun getGateNode(
        index: Int, prompts: List<String>, choices: List<Choice>): Node
    {
        val animations = listOf(AnimationInfo(R.drawable.background_oaktree_gate,
            R.anim.fade_in_fast,
            R.id.background_center),
            AnimationInfo(R.drawable.character_guard_profile,
                R.anim.fade_in_fast,
                R.id.background_center))
        return getNode(index, prompts, choices, animations)
    }

    private fun getChoice(stringId: Int, nextNodeIndex: Int, element: Element): Choice
    {
        return Choice(getString(context, stringId), nextNodeIndex, state, element)
    }

    private fun getChoice(stringId: Int, nextNodeIndex: Int): Choice
    {
        return Choice(getString(context, stringId), nextNodeIndex)
    }

    private fun getChoice(
        stringId: Int, nextNodeIndex: Int, stateChange: (State) -> Unit = {}): Choice
    {
        return Choice(getString(context, stringId), nextNodeIndex, stateChange)
    }

    private fun getChoice(
        stringId: Int, nextNodeIndex: Int, element: Element, stateChange: (State) -> Unit = {}
    ): Choice
    {
        return Choice(getString(context, stringId), nextNodeIndex, element, stateChange)
    }

    private fun getPrompt(stringId: Int): List<String>
    {
        return listOf(getString(context, stringId))
    }

    private fun getNode(
        index: Int, prompt: List<String>, choices: List<Choice>, element: Element): Node
    {
        return Node(index, prompt, choices, element, context, state)
    }

    private fun getNode(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        animations: List<AnimationInfo>): Node
    {
        return Node(index, prompt, choices, Element.NEUTRAL, animations, context, state)
    }

    private fun getNode(
        index: Int,
        prompt: List<String>,
        choices: List<Choice>,
        animations: List<AnimationInfo>,
        element: Element): Node
    {
        return Node(index, prompt, choices, element, animations, context, state)
    }

    private fun getDadNode_talkAboutWriting(): Node
    {
        val prompts = getPrompt(R.string.scene93alt2prompt)
        val choices = listOf(getChoice(R.string.scene93alt2choice1, 276, Element.PYRO),
            getChoice(R.string.scene93alt2choice2, 277, Element.TERRA),
            getChoice(R.string.scene93alt2choice3, 277, Element.AQUA),
            getChoice(R.string.scene93alt2choice4, 276, Element.UMBRAL))
        return getFatherChurchNode(93,prompts,choices)
    }

    private fun getDadNode_talkAboutAmulet(): Node
    {
        val prompts = getPrompt(R.string.scene93alt4prompt)
        val choices = listOf(getChoice(R.string.scene93alt4choice1, 281))
        return getFatherChurchNode(93,prompts,choices)
    }

    private fun getDadNode_talkAboutMorn():Node
    {
        val prompts = getPrompt(R.string.scene93alt3prompt)
        val choices = listOf(getChoice(R.string.scene93alt3choice1, 278, Element.AERO),
            getChoice(R.string.scene93alt3choice2, 279, Element.AQUA),
            getChoice(R.string.scene93alt3choice3, 278, Element.PYRO),
            getChoice(R.string.scene93alt3choice4, 280, Element.TERRA))
        return getFatherChurchNode(93,prompts,choices)
    }

    private fun getDadNode_Default():Node
    {
        val prompts = getPrompt(R.string.scene93alt1prompt)
        val choices = listOf(getChoice(R.string.scene93alt1choice1, 79),
            getChoice(R.string.scene93alt1choice2, 275, Element.UMBRAL))
        return getFatherChurchNode(93,prompts,choices)
    }

    private fun haveTalkedToDadAboutWriting():Boolean
    {
        return state.getSeenNodeBefore(276) || state.getSeenNodeBefore(277)
    }

    private fun haveTalkedToDadAboutMornChores():Boolean
    {
        return state.getSeenNodeBefore(278) || state.getSeenNodeBefore(279) || state.getSeenNodeBefore(280)
    }

    private fun haveTalkedToDadAboutSellingNecklace():Boolean
    {
        return state.getSeenNodeBefore(281)
    }
}