using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to represent and control the difficulty levels of the game
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DifficultyState : ScriptableObject
{
    private Dictionary<EDifficultyType, EDifficultyLevel> typeByLevel = new Dictionary<EDifficultyType, EDifficultyLevel>();

    public void initDifficulty()
    {

        List<EDifficultyType> difficultyTypes = new List<EDifficultyType>()
        {
            EDifficultyType.Permadeath,
            EDifficultyType.Combat,
            EDifficultyType.Economy,
            EDifficultyType.MonsterStorage,
            EDifficultyType.MonsterPartyLimit,
            EDifficultyType.ElementSelection,
            EDifficultyType.SelfVisibility,
            EDifficultyType.DeityVisibility
        };
        for (int i = 0; i < difficultyTypes.Count; i++)
        {
            this.typeByLevel[difficultyTypes[i]] = EDifficultyLevel.Medium;
        }
    }

    public void setDifficulty(EDifficultyType type, EDifficultyLevel level)
    {
        typeByLevel[type] = level;
    }

    public EDifficultyLevel getDifficultyLevel(EDifficultyType type)
    {
        return typeByLevel[type];
    }

    public double getScoreMultiplier()
    {
        double scoreMultiplier = 1.0;
        if(typeByLevel[EDifficultyType.Permadeath] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .5;
        }
        else if(typeByLevel[EDifficultyType.Permadeath] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += 1;
        }
        if(typeByLevel[EDifficultyType.Combat] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .5;
        }
        else if(typeByLevel[EDifficultyType.Combat] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += 1;
        }
        if(typeByLevel[EDifficultyType.Economy] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .2;
        }
        else if(typeByLevel[EDifficultyType.Economy] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += .4;
        }
        if(typeByLevel[EDifficultyType.MonsterStorage] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .5;
        }
        else if(typeByLevel[EDifficultyType.MonsterStorage] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += .3;
        }
        if(typeByLevel[EDifficultyType.MonsterPartyLimit] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .5;
        }
        else if(typeByLevel[EDifficultyType.MonsterPartyLimit] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += .8;
        }
        if(typeByLevel[EDifficultyType.ElementSelection] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .1;
        }
        else if(typeByLevel[EDifficultyType.ElementSelection] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += .15;
        }
        if(typeByLevel[EDifficultyType.SelfVisibility] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .15;
        }
        else if(typeByLevel[EDifficultyType.SelfVisibility] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += .15;
        }
        if(typeByLevel[EDifficultyType.DeityVisibility] == EDifficultyLevel.Easy)
        {
            scoreMultiplier -= .15;
        }
        else if(typeByLevel[EDifficultyType.DeityVisibility] == EDifficultyLevel.Hard)
        {
            scoreMultiplier += .2;
        }
        if(scoreMultiplier < 0.0)
        {
            scoreMultiplier = 0;
        }
        return scoreMultiplier;
    }

    public enum EDifficultyLevel
    {
        Easy,
        Medium,
        Hard
    }

    public enum EDifficultyType
    {
        Permadeath,
        Combat,
        Economy,
        MonsterStorage,
        MonsterPartyLimit,
        ElementSelection,
        SelfVisibility,
        DeityVisibility
    }

}

