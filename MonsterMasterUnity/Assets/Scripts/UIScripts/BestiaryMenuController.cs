using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the behavior of the Bestiary Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class BestiaryMenuController : MonoBehaviour
{
    DesignColors colors;



    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        for(int i = 0; i<4; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }
        GameObject elementTags = this.transform.GetChild(4).gameObject;
        GameObject vertElementTags = this.transform.GetChild(5).gameObject;
        DesignColors redColors = GameState.designColorsController.getElementDesignColors("Pyro");
        elementTags.transform.GetChild(0).gameObject.GetComponent<SpriteRenderer>().color = redColors.backgroundColor;
        vertElementTags.transform.GetChild(0).gameObject.GetComponent<SpriteRenderer>().color = redColors.backgroundColor;
        DesignColors blueColors = GameState.designColorsController.getElementDesignColors("Aqua");
        elementTags.transform.GetChild(1).gameObject.GetComponent<SpriteRenderer>().color = blueColors.backgroundColor;
        vertElementTags.transform.GetChild(1).gameObject.GetComponent<SpriteRenderer>().color = blueColors.backgroundColor;
        DesignColors greenColors = GameState.designColorsController.getElementDesignColors("Terra");
        elementTags.transform.GetChild(2).gameObject.GetComponent<SpriteRenderer>().color = greenColors.backgroundColor;
        vertElementTags.transform.GetChild(2).gameObject.GetComponent<SpriteRenderer>().color = greenColors.backgroundColor;
        DesignColors yellowColors = GameState.designColorsController.getElementDesignColors("Aero");
        elementTags.transform.GetChild(3).gameObject.GetComponent<SpriteRenderer>().color = yellowColors.backgroundColor;
        vertElementTags.transform.GetChild(3).gameObject.GetComponent<SpriteRenderer>().color = yellowColors.backgroundColor;
        DesignColors lightColors = GameState.designColorsController.getElementDesignColors("Luxor");
        elementTags.transform.GetChild(4).gameObject.GetComponent<SpriteRenderer>().color = lightColors.backgroundColor;
        vertElementTags.transform.GetChild(4).gameObject.GetComponent<SpriteRenderer>().color = lightColors.backgroundColor;
        DesignColors darkColors = GameState.designColorsController.getElementDesignColors("Umbral");
        elementTags.transform.GetChild(5).gameObject.GetComponent<SpriteRenderer>().color = darkColors.backgroundColor;
        vertElementTags.transform.GetChild(5).gameObject.GetComponent<SpriteRenderer>().color = darkColors.backgroundColor;
        GameObject canvas = this.transform.GetChild(6).gameObject;
        GameObject unchangingText = canvas.transform.GetChild(0).gameObject;
        for(int i = 0; i<3; i++)
        {
            unchangingText.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }
        unchangingText.transform.GetChild(3).gameObject.GetComponent<TMP_Text>().color = redColors.textColor;
        unchangingText.transform.GetChild(4).gameObject.GetComponent<TMP_Text>().color = blueColors.textColor;
        unchangingText.transform.GetChild(5).gameObject.GetComponent<TMP_Text>().color = greenColors.textColor;
        unchangingText.transform.GetChild(6).gameObject.GetComponent<TMP_Text>().color = yellowColors.textColor;
        unchangingText.transform.GetChild(7).gameObject.GetComponent<TMP_Text>().color = lightColors.textColor;
        unchangingText.transform.GetChild(8).gameObject.GetComponent<TMP_Text>().color = darkColors.textColor;
        unchangingText.transform.GetChild(9).gameObject.GetComponent<TMP_Text>().color = redColors.textColor;
        unchangingText.transform.GetChild(10).gameObject.GetComponent<TMP_Text>().color = blueColors.textColor;
        unchangingText.transform.GetChild(11).gameObject.GetComponent<TMP_Text>().color = greenColors.textColor;
        unchangingText.transform.GetChild(12).gameObject.GetComponent<TMP_Text>().color = yellowColors.textColor;
        unchangingText.transform.GetChild(13).gameObject.GetComponent<TMP_Text>().color = lightColors.textColor;
        unchangingText.transform.GetChild(14).gameObject.GetComponent<TMP_Text>().color = darkColors.textColor;
    }
}
