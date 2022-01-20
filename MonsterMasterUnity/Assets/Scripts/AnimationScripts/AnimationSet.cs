using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to represent all of the Sprites and Animation a object has to cycle through
*   through the course of its life.
*   Copyright 2022 Austin Bailey
*/
public class AnimationSet : MonoBehaviour, IAnimationSet
{
    public bool leftIsRightReversed;

    public new string name;
    
    public string description;

    public Sprite defaultSprite;

    public List<Sprite> frontSprites;

    public List<Sprite> backSprites;

    public List<Sprite> rightSprites;

    public List<Sprite> leftSprites;

    public Sprite getDefaultSprite()
    {
        return defaultSprite;
    }

    public string getDescription()
    {
        return description;
    }

    public string getName()
    {
        return name;
    }

    public List<Sprite> getUpSprites()
    {
        return frontSprites;
    }

    public List<Sprite> getDownSprites()
    {
        return backSprites;
    }

    public List<Sprite> getRightSprites()
    {
        return rightSprites;
    }

    public List<Sprite> getLeftSprites()
    {
        return leftSprites;
    }

    public List<Sprite> getAttackSprites()
    {
        return rightSprites;
    }

    public List<Sprite> getOnHitSprites()
    {
        return rightSprites;
    }

    public List<Sprite> getOnDeathSprites()
    {
        return rightSprites;
    }

    public override bool Equals(System.Object other)
    {
        if (other == null)
        {
            return false;
        }

        AnimationSet otherAnimationSet = other as AnimationSet;
        if ((System.Object) otherAnimationSet == null)
        {
            return false;
        }

        if(leftIsRightReversed != otherAnimationSet.leftIsRightReversed)
        {
            return false;
        }

        if (frontSprites.Count != otherAnimationSet.frontSprites.Count)
        {
            return false;
        }
        for (int i = 0; i < frontSprites.Count; i++)
        {
            if (frontSprites[i] != otherAnimationSet.frontSprites[i])
            {
                return false;
            }
        }

        if (backSprites.Count != otherAnimationSet.backSprites.Count)
        {
            return false;
        }
        for (int i = 0; i< backSprites.Count; i++)
        {
            if(backSprites[i] != otherAnimationSet.backSprites[i])
            {
                return false;
            }
        }


        return true;
    }

    public override int GetHashCode()
    {
        return 0;
    }
}
