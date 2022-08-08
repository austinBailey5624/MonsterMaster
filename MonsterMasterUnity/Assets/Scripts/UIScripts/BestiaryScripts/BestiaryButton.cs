using System.Collections;
using System.Collections.Generic;
using UnityEngine;


/**
 * Class to control the behavior of Bestiary Buttons
 * Copyright Austin Bailey 2022 All Rights Reserved
 */
public abstract class BestiaryButton : MonoBehaviour, IButtonSystemNode
{
    public bool isSelected;
    public bool isInContext;
    public Sprite selectedSprite;
    protected Sprite defaultSprite;
    public BestiaryButton upButton;
    public BestiaryButton downButton;
    public BestiaryButton leftButton;
    public BestiaryButton rightButton;
    


    
    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
    }

    public Sprite getDefaultSprite()
    {
        return defaultSprite;
    }

    public Sprite getSelectedSprite()
    {
        return selectedSprite;
    }

    public bool getIsSelected()
    {
        return isSelected;
    }

    public IButtonSystemNode getUpButton()
    {
        return upButton;
    }

    public IButtonSystemNode getDownButton()
    {
        return downButton;
    }

    public IButtonSystemNode getLeftButton()
    {
        return leftButton;
    }

    public IButtonSystemNode getRightButton()
    {
        return rightButton;
    }

    public bool getIsInContext()
    {
        return isInContext;
    }

    public void select()
    {
        this.isSelected = true;
    }

    public void unSelect()
    {
        this.isSelected = false;
    }

    public abstract void actionWhenSelected();
}
