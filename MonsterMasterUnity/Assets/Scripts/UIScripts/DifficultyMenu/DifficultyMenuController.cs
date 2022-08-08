using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/**
 * Class to control the Behavior of the Difficulty Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DifficultyMenuController : MonoBehaviour
{
    private DesignColors colors;

    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for (int i = 0; i < 5; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject settings = this.transform.GetChild(5).gameObject;
        GameObject selected;
        for (int i = 0; i < 8; i++)
        {
            selected = settings.transform.GetChild(i).gameObject;
            selected.gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
            for(int j = 0; j < 3; j++)
            {
                selected.transform.GetChild(j).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
            }
        }
        GameObject canvas = this.transform.GetChild(6).gameObject;
        for(int i = 0; i <37; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }
}
