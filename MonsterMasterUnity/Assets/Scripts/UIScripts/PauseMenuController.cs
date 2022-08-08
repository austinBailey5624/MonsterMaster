using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the Behavior of the Pause Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 * */
public class PauseMenuController : MonoBehaviour
{
    DesignColors colors;

    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for(int i = 0; i < 9; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject canvas = this.transform.GetChild(9).gameObject;
        for(int i = 0; i<7; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }
}
