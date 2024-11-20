package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat.getString

/**
 * Enum ot help organize gender and gender-specific elements of the game
 * @Author: Austin Bailey
 * @Year: 2024
 *
 * @Copyright Austin Bailey 2024 All Rights Reserved
 */
enum class Gender
{
    MALE,FEMALE,NEUTRAL;

    companion object
    {
        fun getSubjectPronoun(context: Context, gender: Gender): String
        {
            return when(gender)
            {
                MALE    -> getString(context, R.string.pronoun_subject_masculine)
                FEMALE  -> getString(context, R.string.pronoun_subject_feminine)
                NEUTRAL -> getString(context, R.string.pronoun_subject_neutral)
            }
        }

        fun getObjectPronoun(context: Context, gender: Gender): String
        {
            return when(gender)
            {
                MALE     -> getString(context, R.string.pronoun_object_masculine)
                FEMALE   -> getString(context, R.string.pronoun_object_feminine)
                NEUTRAL  -> getString(context, R.string.pronoun_object_neutral)
            }
        }

        fun getPossessivePronoun(context: Context, gender: Gender): String
        {
            return when(gender)
            {
                MALE    -> getString(context, R.string.pronoun_possessive_masculine)
                FEMALE  -> getString(context, R.string.pronoun_possessive_feminine)
                NEUTRAL -> getString(context, R.string.pronoun_possessive_neutral)
            }
        }

        fun getDadsNickname(context: Context, gender: Gender): String
        {
            return when(gender)
            {
                MALE -> getString(context, R.string.nickname_masculine)
                FEMALE -> getString(context, R.string.nickname_feminine)
                NEUTRAL -> getString(context, R.string.nickname_neutral)
            }
        }

        fun getBrahmsNickname(context:Context, gender:Gender): String
        {
            return when(gender)
            {
                MALE -> getString(context,R.string.nickname2_masculine)
                FEMALE -> getString(context,R.string.nickname2_feminine)
                NEUTRAL -> getString(context,R.string.nickname2_neutral)
            }
        }

        fun getMornsNickname(context:Context, gender:Gender): String
        {
            return when(gender)
            {
                MALE -> getString(context,R.string.nickname3masculine)
                FEMALE -> getString(context,R.string.nickname3feminine)
                NEUTRAL -> getString(context,R.string.nickname3neutral)
            }
        }
    }
}