using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Enum to represent the ability for a being
 * to breathe and move about underwater. Fish
 * Are waterbreathing, While flame creatures
 * are Unsubmergible. Everything in the middle
 * can submerge with various levels of help
 * Copyright 2022 Austin Bailey, All Rights Reserved
 */
public enum EUnderwaterTraversalTrait
{

    Neutral=0,
    WaterFriendly = 1,
    WaterAdjacent=2,
    WaterBreathing = 3,
    WaterUnfriendly =-1,
    WaterAbhorrent=-2,
    Unsubmergible=-3
}
