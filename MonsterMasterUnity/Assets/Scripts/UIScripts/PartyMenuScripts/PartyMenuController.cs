using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control the behavior of the Party Menu
 * Copyright 2023 Austin Bailey All Rights Reserved
 */
public class PartyMenuController : MonoBehaviour
{
    private DesignColors colors;

    void Start()
    {
        GameState.isFrozen = true;
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for(int i = 0; i < 17; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
    }
}
