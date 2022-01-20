using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Interface to handle the organization of Sprite assets for an object
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public interface IAnimationSet : ISpritedObject, IDescribedObject
{
    List<Sprite> getUpSprites();
    List<Sprite> getDownSprites();
    List<Sprite> getRightSprites();
    List<Sprite> getLeftSprites();
    List<Sprite> getAttackSprites();
    List<Sprite> getOnHitSprites();
    List<Sprite> getOnDeathSprites();
}
