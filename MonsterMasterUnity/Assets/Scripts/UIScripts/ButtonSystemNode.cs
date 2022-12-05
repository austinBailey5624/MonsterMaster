using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to handle buttons that are in a system
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class ButtonSystemNode : MonoBehaviour, IButtonSystemNode
{
    public bool isSelected;

    protected Sprite defaultSprite;

    public Sprite selectedSprite;

    public ButtonSystemNode upButton;

    public ButtonSystemNode rightButton;

    public ButtonSystemNode leftButton;

    public ButtonSystemNode downButton;

    protected Dictionary<EDirection, ButtonSystemNode> buttonsByDirection;

    protected EDirection shouldMove = EDirection.Center;

    protected bool shouldSubmit = false;

    public virtual void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        buttonsByDirection = new Dictionary<EDirection, ButtonSystemNode>();
        buttonsByDirection[EDirection.Up] = upButton;
        buttonsByDirection[EDirection.Right] = rightButton;
        buttonsByDirection[EDirection.Left] = leftButton;
        buttonsByDirection[EDirection.Down] = downButton;
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

    public virtual void select()
    {
        this.isSelected = true;
    }

    public virtual void unSelect()
    {
        this.isSelected = false;
    }

    public virtual void Update()
    {
        otherUpdate();
        if (isSelected)
        {
            executeSelectedBehavior();//TODO rename to selected Display maybe?
        }
        else
        {
            executeUnselectedBehavior();//TODO rename to unselected Display Maybe?
        }
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        float cancel = Input.GetAxis("Cancel");
        float submit = Input.GetAxis("Submit");
        if (isSelected)
        {
            if (horizontal > GameState.buttonUpTolerance && rightButton != null)
            {
                shouldMove = EDirection.Right;
            }
            else if (horizontal < -GameState.buttonUpTolerance && leftButton != null)
            {
                shouldMove = EDirection.Left;
            }
            else if (vertical > GameState.buttonUpTolerance && upButton != null)
            {
                shouldMove = EDirection.Up;
            }
            else if (vertical < -GameState.buttonUpTolerance && downButton != null)
            {
                shouldMove = EDirection.Down;
            }
            else if (submit > GameState.buttonUpTolerance)
            {
                actionWhenSelected();
                shouldSubmit = true;
            }
            if (
                Mathf.Abs(horizontal) < GameState.buttonDownTolerance &&
                Mathf.Abs(vertical) < GameState.buttonDownTolerance &&
                Mathf.Abs(cancel) < GameState.buttonDownTolerance &&
                Mathf.Abs(submit) < GameState.buttonDownTolerance
            )
            {
                if (shouldMove != EDirection.Center)
                {
                    this.unSelect();
                }
                if (shouldMove == EDirection.Right)
                {
                    rightButton.select();
                }
                else if (shouldMove == EDirection.Left)
                {
                    leftButton.select();
                }
                else if (shouldMove == EDirection.Up)
                {
                    upButton.select();
                }
                else if (shouldMove == EDirection.Down)
                {
                    downButton.select();
                }
                shouldMove = EDirection.Center;
                if(shouldSubmit)
                {
                    delayedAction();
                    shouldSubmit = false;
                }
            }
        }
    }

    public virtual void otherUpdate()
    {
        //left to inheritors to implement
    }

    public virtual void actionWhenSelected()
    {
        //left to inheritors to implement
    }

    public virtual void delayedAction()
    {

    }

    public virtual void executeSelectedBehavior()
    {
        if (selectedSprite != null)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = getSelectedSprite();
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getDefaultDesignColors().selectedColor;
        }
    }

    public virtual void executeUnselectedBehavior()
    {
        if (selectedSprite != null)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = getDefaultSprite();
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getDefaultDesignColors().backgroundColor;
        }
    }
}
