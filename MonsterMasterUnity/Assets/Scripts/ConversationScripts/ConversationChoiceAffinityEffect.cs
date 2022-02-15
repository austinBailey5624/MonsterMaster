using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*  Class to control the behavior of conversation choices that have an impact on the 
*  main characters affinity
*  Copyright 2022 Austin Bailey All Rights Reserved
*/
public class ConversationChoiceAffinityEffect : ConversationChoiceImpl
{
    public EAffinity affinityAffected;
    public int affinityValueChange;

    public override void getEffect()
    {
        Dictionary<EAffinity, int> affinities2 = GameState.affinities;
        affinities2[affinityAffected] += affinityValueChange;
        GameState.affinities = affinities2;
    }
}
