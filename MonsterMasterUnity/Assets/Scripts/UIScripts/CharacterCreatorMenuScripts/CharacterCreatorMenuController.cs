using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/**
 * Class to control the Behavior of the Character Controller Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 * */
public class CharacterCreatorMenuController : MonoBehaviour
{
    private DesignColors colors;

    void Start()
    {
        GameState.isFrozen = true;
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for(int i = 0; i < 5; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject leftSelectors = this.transform.GetChild(5).gameObject;
        colorSelectors(leftSelectors);
        GameObject rightSelectors = this.transform.GetChild(6).gameObject;
        colorSelectors(rightSelectors);
        GameObject pronouns = this.transform.GetChild(7).gameObject;
        pronouns.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        GameObject pronounsText = pronouns.transform.GetChild(0).transform.GetChild(0).gameObject;
        pronounsText.gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        GameObject canvas = this.transform.GetChild(8).gameObject;
        for(int i = 0; i<11; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
    }

    private void colorSelectors(GameObject selectors)
    {
        for (int i = 0; i < 4; i++)
        {
            colorSelector(selectors.transform.GetChild(i).gameObject);
        }
    }

    private void colorSelector(GameObject selector)
    {
        GameObject left = selector.transform.GetChild(0).gameObject;
        GameObject leftArrow = left.transform.GetChild(0).gameObject;
        leftArrow.GetComponent<SpriteRenderer>().color = colors.selectedColor;
        GameObject leftBox = left.transform.GetChild(1).gameObject;
        leftBox.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        GameObject right = selector.transform.GetChild(1).gameObject;
        GameObject rightArrow = right.transform.GetChild(0).gameObject;
        rightArrow.GetComponent<SpriteRenderer>().color = colors.selectedColor;
        GameObject rightBox = right.transform.GetChild(1).gameObject;
        rightBox.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        GameObject textBackground = selector.transform.GetChild(2).gameObject;
        textBackground.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
    }
}
