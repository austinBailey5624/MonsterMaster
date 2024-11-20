package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat.getString

/**
 * Enum to help organize game state with quests
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright Austin Bailey 2024 All Rights Reserved
 */
enum class Quest
{
    CHORES,AMNESIA,KYLER_REDEMPTION,MORNS_ERRAND,WRITING_LESSON,SELL_AMULET,EXPLORE;

    companion object
    {
        fun getName(context: Context, quest: Quest): String
        {
            return when(quest)
            {
                CHORES -> getString(context, R.string.quest_chores_name)
                AMNESIA -> getString(context, R.string.quest_amnesia_name)
                KYLER_REDEMPTION -> getString(context, R.string.quest_kyler_redemption_name)
                MORNS_ERRAND -> getString(context, R.string.quest_morns_errand_name)
                WRITING_LESSON -> getString(context, R.string.quest_writing_lesson_name)
                SELL_AMULET -> getString(context,R.string.quest_sell_amulet_name)
                EXPLORE -> getString(context,R.string.quest_explore_name)
            }
        }

        fun getQuestStageMeaning(context:Context, quest: Quest, stage: Int): String
        {
            return when(quest)
            {
                CHORES -> getChoresStages(context)[stage]
                AMNESIA -> getAmnesiaStages(context)[stage]
                KYLER_REDEMPTION -> getKylerRedemptionStages(context)[stage]
                MORNS_ERRAND -> getMornsErrandStages(context)[stage]
                WRITING_LESSON -> getWritingLessonStages(context)[stage]
                SELL_AMULET -> getSellAmuletStages(context)[stage]
                EXPLORE -> getExploreStages(context)[stage]
            }
        }

        fun getChoresStages(context: Context): List<String>
        {
            return listOf(
                getString(context,R.string.quest_0),
                getString(context,R.string.quest_chores_1),
                getString(context,R.string.quest_chores_2),
                getString(context,R.string.quest_chores_3),
                getString(context,R.string.quest_chores_4),
                getString(context,R.string.quest_chores_5),
                getString(context,R.string.quest_chores_6),
                getString(context,R.string.quest_chores_7),
                getString(context,R.string.quest_chores_8),
                getString(context,R.string.quest_chores_9))
        }

        fun getAmnesiaStages(context: Context): List<String>
        {
            return listOf(
                getString(context,R.string.quest_0),
                getString(context,R.string.quest_amnesia_stage_1)
            )
        }

        fun getKylerRedemptionStages(context: Context): List<String>
        {
            return listOf(
                getString(context,R.string.quest_0),
                getString(context,R.string.quest_kyler_redemption_1)
            )
        }

        fun getMornsErrandStages(context: Context): List<String>
        {
            return listOf(
                getString(context,R.string.quest_0),
                getString(context,R.string.quest_morns_errand_1),
                getString(context,R.string.quest_morns_errand_2),
                getString(context,R.string.quest_morns_errand_3),
                getString(context,R.string.quest_morns_errand_4),
                getString(context,R.string.quest_morns_errand_5),
                getString(context,R.string.quest_morns_errand_6),
                getString(context,R.string.quest_morns_errand_7),
                getString(context,R.string.quest_morns_errand_8),
                getString(context,R.string.quest_morns_errand_9)
            )
        }

        fun getWritingLessonStages(context: Context): List<String>
        {
            return listOf(
                getString(context,R.string.quest_0),
                getString(context,R.string.quest_writing_lesson_1),
                getString(context,R.string.quest_writing_lesson_2),
                getString(context,R.string.quest_writing_lesson_3)
            )
        }

        fun getSellAmuletStages(context: Context): List<String>
        {
            return listOf(
                getString(context, R.string.quest_0),
                getString(context, R.string.quest_sell_amulet_1),
                getString(context, R.string.quest_sell_amulet_2),
                getString(context, R.string.quest_sell_amulet_3),
                getString(context, R.string.quest_sell_amulet_4),
                getString(context, R.string.quest_sell_amulet_5)
            )
        }

        fun getExploreStages(context: Context): List<String>
        {
            return listOf(
                getString(context,R.string.quest_explore_1),
                getString(context,R.string.quest_explore_2),
                getString(context,R.string.quest_explore_3),
                getString(context,R.string.quest_explore_4)
            )
        }
    }
}