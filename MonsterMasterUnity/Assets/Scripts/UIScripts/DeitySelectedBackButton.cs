using System.Collections;
using System.Collections.Generic;
using UnityEngine;


/**
 * Class to control the behavior of the back button in the 
 * Deity Selected Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DeitySelectedBackButton : ButtonSceneTransitionNode
{
    public DesignColors designColors;


    public override void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        buttonsByDirection = new Dictionary<EDirection, ButtonSystemNode>();
        buttonsByDirection[EDirection.Up] = upButton;
        buttonsByDirection[EDirection.Right] = rightButton;
        buttonsByDirection[EDirection.Left] = leftButton;
        buttonsByDirection[EDirection.Down] = downButton;
        nextSceneName = "DeitiesMenu";
    }

    public override void executeSelectedBehavior()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = designColors.selectedColor;

    }

    public override void executeUnselectedBehavior()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = designColors.backgroundColor;
    }
}
