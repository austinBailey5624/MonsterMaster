using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AnimationSet : MonoBehaviour
{
    public bool leftIsRightReversed;

    public List<Sprite> frontSprites;

    public List<Sprite> backSprites;

    public List<Sprite> rightSprites;

    public List<Sprite> leftSprites;

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
}
