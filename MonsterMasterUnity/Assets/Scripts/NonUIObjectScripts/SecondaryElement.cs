using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to represent mixed elements, AKA subelements. These elements are a mixture of 
*   two Primary Elements. You can have a mix of two of the same primary elements and still
*   be a secondary Element
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class SecondaryElement : MonoBehaviour, IElement
{
    public Sprite defaultSprite;
    public new string name;
    public string description;
    public PrimaryElement firstPrimaryElement;
    public PrimaryElement secondPrimaryElement;
    public Color defaultColor;
    public Color highlightColor;
    public MonsterType babyMonster;

    public Sprite getDefaultSprite()
    {
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

    public PrimaryElement getFirstPrimaryElement()
    {
        return firstPrimaryElement;
    }

    public PrimaryElement getSecondPrimaryElement()
    {
        return secondPrimaryElement;
    }

    public Color getDefaultColor()
    {
        return defaultColor;
    }

    public Color getHighlightColor()
    {
        return highlightColor;
    }

    public MonsterType getBaby()
    {
        return babyMonster;
    }
}
