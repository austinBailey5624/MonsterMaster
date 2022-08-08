using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the UI objects of the Deities Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DeitiesMenuController : MonoBehaviour
{
    void Start()
    {
        DesignColors defaultColors = GameState.designColorsController.getSpecializedDesignColors();
        this.transform.GetChild(0).gameObject.GetComponent<SpriteRenderer>().color = defaultColors.backgroundColor;
        this.transform.GetChild(1).gameObject.GetComponent<SpriteRenderer>().color = defaultColors.backgroundColor;
        DesignColors lightColors = GameState.designColorsController.getElementDesignColors("Luxor");
        this.transform.GetChild(2).gameObject.GetComponent<SpriteRenderer>().color = lightColors.backgroundColor;
        DesignColors redemptionColors = GameState.designColorsController.getElementDesignColors("Redemption");
        this.transform.GetChild(3).gameObject.GetComponent<SpriteRenderer>().color = redemptionColors.backgroundColor;
        DesignColors darkColors = GameState.designColorsController.getElementDesignColors("Umbral");
        this.transform.GetChild(4).gameObject.GetComponent<SpriteRenderer>().color = darkColors.backgroundColor;
        this.transform.GetChild(5).gameObject.GetComponent<SpriteRenderer>().color = defaultColors.backgroundColor;
        
        GameObject elementTags = this.transform.GetChild(6).gameObject;
        elementTags.transform.GetChild(0).gameObject.GetComponent<SpriteRenderer>().color = lightColors.backgroundColor;
        DesignColors blueColors = GameState.designColorsController.getElementDesignColors("Aqua");
        elementTags.transform.GetChild(1).gameObject.GetComponent<SpriteRenderer>().color = blueColors.backgroundColor;
        DesignColors greenColors = GameState.designColorsController.getElementDesignColors("Terra");
        elementTags.transform.GetChild(2).gameObject.GetComponent<SpriteRenderer>().color = greenColors.backgroundColor;
        DesignColors yellowColors = GameState.designColorsController.getElementDesignColors("Aero");
        elementTags.transform.GetChild(3).gameObject.GetComponent<SpriteRenderer>().color = yellowColors.backgroundColor;
        DesignColors redColors = GameState.designColorsController.getElementDesignColors("Pyro");
        elementTags.transform.GetChild(4).gameObject.GetComponent<SpriteRenderer>().color = redColors.backgroundColor;
        elementTags.transform.GetChild(5).gameObject.GetComponent<SpriteRenderer>().color = darkColors.backgroundColor;

        GameObject canvas = this.transform.GetChild(10).gameObject;
        canvas.transform.GetChild(0).gameObject.GetComponent<TMP_Text>().color = defaultColors.textColor;
        canvas.transform.GetChild(1).gameObject.GetComponent<TMP_Text>().color = lightColors.textColor;
        canvas.transform.GetChild(2).gameObject.GetComponent<TMP_Text>().color = blueColors.textColor;
        canvas.transform.GetChild(3).gameObject.GetComponent<TMP_Text>().color = greenColors.textColor;
        canvas.transform.GetChild(4).gameObject.GetComponent<TMP_Text>().color = yellowColors.textColor;
        canvas.transform.GetChild(5).gameObject.GetComponent<TMP_Text>().color = redColors.textColor;
        canvas.transform.GetChild(6).gameObject.GetComponent<TMP_Text>().color = darkColors.textColor;
        canvas.transform.GetChild(7).gameObject.GetComponent<TMP_Text>().color = lightColors.textColor;
        canvas.transform.GetChild(8).gameObject.GetComponent<TMP_Text>().color = redemptionColors.textColor;
        canvas.transform.GetChild(9).gameObject.GetComponent<TMP_Text>().color = darkColors.textColor;
        canvas.transform.GetChild(10).gameObject.GetComponent<TMP_Text>().color = lightColors.textColor;
        DesignColors velhu = GameState.designColorsController.getElementDesignColors("Lunar");
        canvas.transform.GetChild(11).gameObject.GetComponent<TMP_Text>().color = velhu.textColor;
        DesignColors sid = GameState.designColorsController.getElementDesignColors("Compassion");
        canvas.transform.GetChild(12).gameObject.GetComponent<TMP_Text>().color = sid.textColor;
        DesignColors gabriel = GameState.designColorsController.getElementDesignColors("Angel");
        canvas.transform.GetChild(13).gameObject.GetComponent<TMP_Text>().color = gabriel.textColor;
        DesignColors ahros = GameState.designColorsController.getElementDesignColors("Justice");
        canvas.transform.GetChild(14).gameObject.GetComponent<TMP_Text>().color = ahros.textColor;
        DesignColors pythion = GameState.designColorsController.getElementDesignColors("Redemption");
        canvas.transform.GetChild(15).gameObject.GetComponent<TMP_Text>().color = pythion.textColor;
        DesignColors bennu = GameState.designColorsController.getElementDesignColors("Phoenix");
        canvas.transform.GetChild(16).gameObject.GetComponent<TMP_Text>().color = bennu.textColor;
        canvas.transform.GetChild(17).gameObject.GetComponent<TMP_Text>().color = blueColors.textColor;
        canvas.transform.GetChild(18).gameObject.GetComponent<TMP_Text>().color = greenColors.textColor;
        DesignColors bacchus = GameState.designColorsController.getElementDesignColors("Fey");
        canvas.transform.GetChild(19).gameObject.GetComponent<TMP_Text>().color = bacchus.textColor;
        canvas.transform.GetChild(20).gameObject.GetComponent<TMP_Text>().color = redColors.textColor;
        DesignColors undead = GameState.designColorsController.getElementDesignColors("Undead");
        canvas.transform.GetChild(21).gameObject.GetComponent<TMP_Text>().color = undead.textColor;
        DesignColors acheron = GameState.designColorsController.getElementDesignColors("Betrayer");
        canvas.transform.GetChild(22).gameObject.GetComponent<TMP_Text>().color = acheron.textColor;
        DesignColors illian = GameState.designColorsController.getElementDesignColors("Deep");
        canvas.transform.GetChild(23).gameObject.GetComponent<TMP_Text>().color = illian.textColor;
        DesignColors poison = GameState.designColorsController.getElementDesignColors("Poison");
        canvas.transform.GetChild(24).gameObject.GetComponent<TMP_Text>().color = poison.textColor;
        DesignColors muir = GameState.designColorsController.getElementDesignColors("Nightwing");
        canvas.transform.GetChild(25).gameObject.GetComponent<TMP_Text>().color = muir.textColor;
        DesignColors demon = GameState.designColorsController.getElementDesignColors("Demon");
        canvas.transform.GetChild(26).gameObject.GetComponent<TMP_Text>().color = demon.textColor;
        DesignColors enemy = GameState.designColorsController.getElementDesignColors("Umbral");
        canvas.transform.GetChild(27).gameObject.GetComponent<TMP_Text>().color = enemy.textColor;
        canvas.transform.GetChild(28).gameObject.GetComponent<TMP_Text>().color = defaultColors.textColor;
    }
}
