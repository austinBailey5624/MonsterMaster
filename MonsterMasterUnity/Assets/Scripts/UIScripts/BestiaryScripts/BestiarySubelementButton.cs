using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

/**
*   Class to handle the Subelement Buttons in the Bestiary Menu
*   Copyright 2022, Austin Bailey All Rights Reserved
*/
public class BestiarySubelementButton : ButtonSystemNode
{
    public string subelementName;
    public SecondaryElement secondaryElement;

    private Color white = new Color(1f, 1f, 1f, 1f);
    private Color invisible = new Color(1f, 1f, 1f, 0f);
    DesignColors colors;
    private float tolerance;

    public override void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        buttonsByDirection = new Dictionary<EDirection, ButtonSystemNode>();
        buttonsByDirection[EDirection.Up] = upButton;
        buttonsByDirection[EDirection.Right] = rightButton;
        buttonsByDirection[EDirection.Left] = leftButton;
        buttonsByDirection[EDirection.Down] = downButton;
        colors = GameState.designColorsController.getElementDesignColors(secondaryElement);
    }
            
    public override void executeSelectedBehavior()
    {
        GameObject selectedBand = this.transform.GetChild(0).gameObject;
        selectedBand.gameObject.GetComponent<SpriteRenderer>().color = white;
        GameObject textBackground = this.transform.GetChild(1).gameObject;
        textBackground.gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        GameObject invisibleController = GameObject.FindGameObjectWithTag("Scene");
        invisibleController.gameObject.GetComponent<VanishingTextController>().appearText(subelementName);
    }

    public override void executeUnselectedBehavior()
    {
        GameObject selectedBand = this.transform.GetChild(0).gameObject;
        selectedBand.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        GameObject textBackground = this.transform.GetChild(1).gameObject;
        textBackground.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        GameObject invisibleController = GameObject.FindGameObjectWithTag("Scene");
        invisibleController.gameObject.GetComponent<VanishingTextController>().disappearText(subelementName);
    }


    public override void actionWhenSelected()
    {
        BestiaryMenuState.selectedBestiaryElement = secondaryElement;
        GameState.previousMenuName = SceneManager.GetActiveScene().name;
        SceneManager.LoadScene("BestiarySubelementMenu");
    }
}
