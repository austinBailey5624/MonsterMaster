using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Interface to represent Objects that traverse the tilemap
 * Copyright 2022 Austin Bailey All Rights Reserved
 * */
public interface ITraversalActor
{
    /**
     * Sets the sprite of the Traversal actor across two values
     * the sprite index, which determines which sprite in the 
     * animation set to use,
     * and the EDirection which also determines which sprite in the 
     * animation set to use
     */
    public void setSprite(int spriteIndex, EDirection direction);
}
