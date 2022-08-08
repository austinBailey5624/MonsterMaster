using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/**
 * Class to control the Behavior of the Main Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class MainMenuController : MonoBehaviour
{
    private DesignColors colors;

    private void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for(int i = 0; i < 5; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject canvas = this.transform.GetChild(5).gameObject;
        for (int i = 0; i < 4; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }
}
