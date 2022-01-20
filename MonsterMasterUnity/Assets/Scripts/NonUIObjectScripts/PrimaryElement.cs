using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to represent Primary or 'pure' elements
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class PrimaryElement :MonoBehaviour, IElement
{
    public Sprite defaultSprite;
    public new string name;
    public string description;

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
}
