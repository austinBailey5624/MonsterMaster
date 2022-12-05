using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the behavior of the Credits Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class CreditsMenuController : MonoBehaviour
{
    DesignColors colors;

    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for (int i = 0; i < 4; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject canvas = this.transform.GetChild(4).gameObject;
        for (int i = 0; i < 5; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }
}
