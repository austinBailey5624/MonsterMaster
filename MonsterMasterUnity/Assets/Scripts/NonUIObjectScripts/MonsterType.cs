using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;

/**
*   Class to represent the type of a monster. There can be more than one instance of a
*   monster with this type- monster type is like the 'species' of the monster
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class MonsterType : MonoBehaviour, IAnimationSet, ISpritedObject, IDescribedObject
{
    public Sprite defaultSprite;

    public new string name;

    public string description;

    public SecondaryElement secondaryElement;

    public MonsterType physicalEvolution;

    public MonsterType balancedEvolution;

    public MonsterType magicalEvolution;

    public MonsterType previousEvolution;

    public bool leftSpritesAreRightSpritesReversed;

    public List<Sprite> upSprites;

    public List<Sprite> downSprites;

    public List<Sprite> rightSprites;

    public List<Sprite> leftSprites;

    public List<Sprite> attackSprites;

    public List<Sprite> onHitSprites;

    public List<Sprite> onDeathSprites;

    public List<Sprite> idleSprites;

    public List<Sprite> magicSprites;

    public Traits monsterTraits;

    public Sprite getDefaultSprite()
    {
        if(defaultSprite == null && previousEvolution != null)
        {
            return previousEvolution.getDefaultSprite();
        }
        return defaultSprite;
    }

    public string getName()
    {
        return name;
    }

    public string getDescription()
    {
        return description;
    }

    public SecondaryElement getSecondaryElement()
    {
        return secondaryElement;
    }

    public MonsterType getPhysicalEvolution()
    {
        return physicalEvolution;
    }

    public MonsterType getBalancedEvolution()
    {
        return balancedEvolution;
    }

    public MonsterType getMagicalEvolution()
    {
        return magicalEvolution;
    }

    public MonsterType getPreviousEvolution()
    {
        return previousEvolution;
    }

    public List<Sprite> getDownSprites()
    {
        if (downSprites == null || !downSprites.Any())
        {
            if(previousEvolution != null)
            {
                return previousEvolution.getDownSprites();
            }
            else
            {
                List<Sprite> defaultSprites = new List<Sprite>();
                defaultSprites.Add(defaultSprite);
                return defaultSprites;
            }
        }
        return downSprites;
    }

    public List<Sprite> getUpSprites()
    {
        if (upSprites == null || !upSprites.Any())
        {
            return getDownSprites();
        }
        return upSprites;
    }

    public List<Sprite> getRightSprites()
    {
        if (rightSprites == null || !rightSprites.Any())
        {
            return getDownSprites();
        }
        return rightSprites;
    }

    public List<Sprite> getLeftSprites()
    {
        if(leftSprites == null || !leftSprites.Any())
        {
            return getDownSprites();
        }
        return leftSprites;
    }

    public List<Sprite> getAttackSprites()
    {
        if(leftSprites == null || !leftSprites.Any())
        {
            return getDownSprites();
        }
        return attackSprites;
    }

    public List<Sprite> getOnHitSprites()
    {
        if(onHitSprites == null || !onHitSprites.Any())
        {
            return getDownSprites();
        }
        return onHitSprites;
    }

    public List<Sprite> getOnDeathSprites()
    {
        if(onDeathSprites == null || !onDeathSprites.Any())
        {
            return getDownSprites();
        }
        return onDeathSprites;
    }

    public List<Sprite> getIdleSprites()
    {
        if(idleSprites == null || !idleSprites.Any())
        {
            return getDownSprites();
        }
        return idleSprites;
    }
}
