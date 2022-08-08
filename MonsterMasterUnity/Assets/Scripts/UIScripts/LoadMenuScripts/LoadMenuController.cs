using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/**
 * Class to control the Behavior of the Load Menu 
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class LoadMenuController : MonoBehaviour
{
    private DesignColors colors;

    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for (int i=0; i<8; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject canvas = this.transform.GetChild(8).gameObject;
        for(int i = 0; i<7; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }
}
