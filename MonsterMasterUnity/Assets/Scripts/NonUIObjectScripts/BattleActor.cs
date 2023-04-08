using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

/**
 * Class to control the behavior of Battle Actors
 * Copyright 2023 Austin Bailey All Rights Reserved
 */
public class BattleActor : MonoBehaviour
{
    [SerializeField] protected int maxHp;
    [SerializeField] protected int curHp;
    [SerializeField] protected int maxMp;
    [SerializeField] protected int curMp;
    protected int level;
    protected int experience;
    List<int> skillSet;

    void Start()
    {
        maxHp = 20;
        curHp = 20;
        maxMp = 10;
        curMp = 10;
        level = 1;
        experience = 0;
    }

    void gainExp(int amount)
    {
        int nextThreshold;
        if (level < 10)
        {
            nextThreshold = 850 * level + 1500;
        }
        else
        {
            nextThreshold = (int)Math.Pow(level, 3.35) + 10000;
        }
        experience += amount;
        if(experience > nextThreshold)
        {
            levelUp();
            experience -= nextThreshold;
        }
    }

    void levelUp()
    {
        level += 1;
    }
}
