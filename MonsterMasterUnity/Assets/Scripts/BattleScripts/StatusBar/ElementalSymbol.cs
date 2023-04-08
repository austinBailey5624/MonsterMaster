using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control the behavior of Elemental Symbols
 * (Mainly just set the symbol based on the element)
 * Copyright 2023 Austin Bailey All Rights Reserved
 */
public class ElementalSymbol : MonoBehaviour
{
    public SecondaryElement mElement;

    void Start()
    {
        this.gameObject.GetComponent<SpriteRenderer>().sprite = mElement.defaultSprite;
    }

    public void setElement(SecondaryElement element)
    {
        mElement = element;
        this.gameObject.GetComponent<SpriteRenderer>().sprite = mElement.defaultSprite;
    }

    //TODO remvoe after testing
    void Update()
    {
        this.gameObject.GetComponent<SpriteRenderer>().sprite = mElement.defaultSprite;
    }
}
