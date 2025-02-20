package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat.getString

/**
 * Class to help organize game state with quests
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright Austin Bailey 2024 All Rights Reserved
 */
class Quest
    (
    val index: Int,
    val name: String,
    val stages: List<QuestStage>  )
{
    companion object
    {
        var quests: List<Quest> = listOf()
        fun getQuests(context: Context): List<Quest>
        {
            if (quests.isEmpty())
            {
                quests = initQuests(context)
            }
            return quests
        }

        fun initQuests(context: Context): List<Quest>
        {
            var quests: MutableList<Quest> = mutableListOf()
            quests.add(Quest(0, "", listOf()))
            quests.add(
                Quest(1,
                getString(context, R.string.quest_chores_name),
                listOf(QuestStage(1, getString(context, R.string.quest_chores_1)),
                    QuestStage(2, getString(context, R.string.quest_chores_2)),
                    QuestStage(3, getString(context, R.string.quest_chores_3)),
                    QuestStage(4, getString(context, R.string.quest_chores_4)),
                    QuestStage(5, getString(context, R.string.quest_chores_5)),
                    QuestStage(6, getString(context, R.string.quest_chores_6)),
                    QuestStage(7, getString(context, R.string.quest_chores_7)),
                    QuestStage(8, getString(context, R.string.quest_chores_8)),
                    QuestStage(9, getString(context, R.string.quest_chores_9)))))
            quests.add(Quest(2,
                getString(context, R.string.quest_amnesia_name),
                listOf(QuestStage(1, getString(context, R.string.quest_amnesia_1)))))
            quests.add(Quest(3,
                getString(context, R.string.quest_kyler_redemption_name),
                listOf(QuestStage(1, getString(context, R.string.quest_kyler_redemption_1)))))
            quests.add(Quest(4,
                getString(context, R.string.quest_morns_errand_name),
                listOf(QuestStage(1, getString(context, R.string.quest_morns_errand_1)),
                    QuestStage(2,getString(context,R.string.quest_morns_errand_2)),
                    QuestStage(3, getString(context,R.string.quest_morns_errand_3)),
                    QuestStage(4,getString(context,R.string.quest_morns_errand_4)),
                    QuestStage(5, getString(context,R.string.quest_morns_errand_5)),
                    QuestStage(6,getString(context,R.string.quest_morns_errand_6)),
                    QuestStage(7, getString(context,R.string.quest_morns_errand_7)),
                    QuestStage(8,getString(context,R.string.quest_morns_errand_8)),
                    QuestStage(9, getString(context,R.string.quest_morns_errand_9)))))
            quests.add(Quest(5,
                getString(context,R.string.quest_writing_lesson_name),
                listOf(QuestStage(1, getString(context, R.string.quest_writing_lesson_1)),
                    QuestStage(2, getString(context,R.string.quest_writing_lesson_2)),
                    QuestStage(3, getString(context, R.string.quest_writing_lesson_3)))))
            quests.add(Quest(6,
                getString(context,R.string.quest_sell_amulet_name),
                listOf(QuestStage(1, getString(context, R.string.quest_sell_amulet_1)),
                    QuestStage(2, getString(context, R.string.quest_sell_amulet_2)),
                    QuestStage(3, getString(context, R.string.quest_sell_amulet_3)),
                    QuestStage(4, getString(context, R.string.quest_sell_amulet_4)),
                    QuestStage(5, getString(context, R.string.quest_sell_amulet_5)),
                    QuestStage(6, getString(context, R.string.quest_sell_amulet_6)))))
            quests.add(Quest(7,
                getString(context,R.string.quest_explore_name),
                listOf(QuestStage(1, getString(context,R.string.quest_explore_1)),
                    QuestStage(2, getString(context,R.string.quest_explore_2)),
                    QuestStage(3, getString(context,R.string.quest_explore_3)),
                    QuestStage(4, getString(context,R.string.quest_explore_4)))))
            quests.add(Quest(8,
                getString(context,R.string.quest_michael_attitude_name),
                listOf(QuestStage(1, getString(context,R.string.quest_michael_attitude_1)),
                    QuestStage(2, getString(context,R.string.quest_michael_attitude_2)),
                    QuestStage(3, getString(context,R.string.quest_michael_attitude_3)),
                    QuestStage(4, getString(context,R.string.quest_michael_attitude_4)),
                    QuestStage(5,getString(context,R.string.quest_michael_attitude_5)))))
            quests.add(Quest(9,
                getString(context,R.string.quest_read_five_faces_one_god_name),
                listOf(QuestStage(1, getString(context,R.string.quest_read_five_faces_one_god_1)))))
            quests.add(Quest(10,
                getString(context,R.string.quest_read_mysteries_of_mana_name),
                listOf(QuestStage(1, getString(context,R.string.quest_read_mysteries_of_mana_1)))))
            quests.add(Quest(11,
                getString(context,R.string.quest_read_mixed_party_tactics_name),
                listOf(QuestStage(1, getString(context,R.string.quest_read_mixed_party_tactics_1)))))
            quests.add(Quest(12,
                getString(context,R.string.quest_read_property_ownership_name),
                listOf(QuestStage(1, getString(context,R.string.quest_read_property_ownership_1)))))
            quests.add(Quest(13, getString(context,R.string.quest_read_merchant_adventures_name),
                listOf(QuestStage(1, getString(context,R.string.quest_read_merchant_adventures_1)))))

            return quests
        }
    }
}