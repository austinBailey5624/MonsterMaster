using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Interface to represent objects that have a sprite
*   Though many objects have many sprites, this is a single sprite that will be used
*   To represent the object in general.
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public interface ISpritedObject 
{
    Sprite getDefaultSprite();
}
