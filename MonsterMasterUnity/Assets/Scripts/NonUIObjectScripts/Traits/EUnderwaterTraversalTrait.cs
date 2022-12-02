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
public enum UnderwaterTraversalTrait
{
    WaterBreathing,
    WaterAdjacent,
    WaterFriendly,
    Neutral,
    WaterUnfriendly,
    WaterAbhorrent,
    Unsubmergible
}
