package com.greenwolfgames.monstermaster

import android.content.Context
import androidx.core.content.ContextCompat.getString

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
    }
}