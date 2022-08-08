using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control all of the buttons in the Character Customization Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class CharacterCustomizeButton : ButtonSystemNode
{
    public override void executeSelectedBehavior()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getSpecializedDesignColors().selectedColor;
        GameObject parent = this.transform.parent.gameObject;
        GameObject arrow = parent.transform.GetChild(0).gameObject;
        arrow.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getSpecializedDesignColors().backgroundColor;
    }

    public override void executeUnselectedBehavior()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getSpecializedDesignColors().backgroundColor;
        GameObject parent = this.transform.parent.gameObject;
        GameObject arrow = parent.transform.GetChild(0).gameObject;
        arrow.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getSpecializedDesignColors().selectedColor;

    }
}
