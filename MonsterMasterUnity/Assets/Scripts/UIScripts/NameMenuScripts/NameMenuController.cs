using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/**
 * Class to control the behavior of the Name Character Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class NameMenuController : MonoBehaviour
{

    private DesignColors colors;

    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for(int i = 0; i < 3; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject canvas = this.transform.GetChild(3).gameObject;
        for(int i = 0; i < 3; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
        GameObject nameBox = canvas.transform.GetChild(3).gameObject;
        nameBox.gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        nameBox.transform.GetChild(0).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        GameObject letterBoxes = canvas.transform.GetChild(4).gameObject;
        for(int i = 0; i < 27; i++)
        {
            letterBoxes.transform.GetChild(i).transform.GetChild(0).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }
}
