using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Enum to represent how much light a being produces, or
 * consumes, which will be used to determine how much of 
 * a dark cave is lit up around the player etc, or how
 * well hid a player is on a stealth check in darkness
 * Copyright 2022 Austin Bailey, All Rights Reserved
 */
public enum ELightProductionTrait 
{
    LightEmitting5,
    LightEmitting4,
    LightEmitting3,
    LightEmitting2,
    LightEmitting1,
    Neutral,
    LightConsuming1,
    LightConsuming2,
    LightConsuming3,
    LightConsuming4,
    LightConsuming5
}
