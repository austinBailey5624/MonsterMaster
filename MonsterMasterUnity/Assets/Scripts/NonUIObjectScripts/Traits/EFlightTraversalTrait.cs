using System.Collections;
using System.Collections.Generic;
using UnityEngine;


/**
 * Enum to represent how difficult it is for a monster to fly.
 * represented by all of the points of Flying minus the points of heavy,
 * While TooHeavyToFly monsters wont fly under any circumstance,
 * and floating monsters dont hinder flight
 * Copyright 2022 Austin Bailey, All Rights Reserved
 */
public enum EFlightTraversalTrait 
{
    TooHeavyToFly,
    Heavy4,
    Heavy3,
    Heavy2,
    Heavy1,
    Floating,
    Flying1,
    Flying2,
    Flying3,
    Flying4,
    Flying5
}
