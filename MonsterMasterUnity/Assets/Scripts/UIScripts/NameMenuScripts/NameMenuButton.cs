using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the behavior of the Letter Buttons in NameCharacterMenu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class NameMenuButton : ButtonSystemNode
{
    public string capLetter = "#";

    public string lowerLetter = "$";

    private DesignColors colors;

    public override void otherUpdate()
    {
        GameObject text = this.transform.GetChild(0).gameObject;
        if(NameCharacterMenuState.usingCaps)
        {
            text.gameObject.GetComponent<TMP_Text>().text = capLetter;
        }
        else
        {
            text.gameObject.GetComponent<TMP_Text>().text = lowerLetter;
        }
    }

    public override void delayedAction()
    {
        if(GameState.mainCharacterName.Length > 12)
        {
            return;
        }
        if (NameCharacterMenuState.usingCaps)
        {
            GameState.mainCharacterName += capLetter;
            NameCharacterMenuState.usingCaps = false;
        }
        else
        {
            GameState.mainCharacterName += lowerLetter;
        }
    }
}
