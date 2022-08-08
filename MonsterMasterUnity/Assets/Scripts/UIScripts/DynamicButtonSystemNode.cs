using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Abstract class for Buttons whose movement in a button 
 * System is determined dynamically.
 * Copyright 2022 Austin Bailey All Rights Reserved.
 */
public abstract class DynamicButtonSystemNode : MonoBehaviour, IButton
{
    public Sprite defaultSprite;

    public bool isSelected;

    public bool isInContext;

    public List<DynamicButtonSystemNode> upButtons;

    public List<DynamicButtonSystemNode> downButtons;

    public List<DynamicButtonSystemNode> leftButtons;

    public List<DynamicButtonSystemNode> rightButtons;

    protected EDirection shouldMove = EDirection.Center;

    protected DynamicButtonSystemNode upButton;

    protected DynamicButtonSystemNode downButton;

    protected DynamicButtonSystemNode leftButton;

    protected DynamicButtonSystemNode rightButton;

    protected DesignColors designColors;

    protected Color invisible = new Color(0f, 0f, 0f, 0f);

    public bool IsSelected()
    {
        return isSelected;
    }

    public bool IsInContext()
    {
        return isInContext;
    }
    public void select()
    {
        isSelected = true;
    }

    public void unSelect()
    {
        isSelected = false;
    }

    public List<DynamicButtonSystemNode> getUpButtons()
    {
        return upButtons;
    }

    public List<DynamicButtonSystemNode> getDownButtons()
    {
        return downButtons;
    }

    public List<DynamicButtonSystemNode> getLeftButtons()
    {
        return leftButtons;
    }

    public List<DynamicButtonSystemNode> getRightButtons()
    {
        return rightButtons;
    }

    public Sprite getDefaultSprite()
    {
        return defaultSprite;
    }

    public virtual void Awake()
    {
        designColors = GameState.designColorsController.getSpecializedDesignColors();
    }

    public virtual void Start()
    { 
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        resolveLinks();
    }

    public void resolveLinks()
    {
        upButton = getFirstInContext(EDirection.Up);
        downButton = getFirstInContext(EDirection.Down);
        leftButton = getFirstInContext(EDirection.Left);
        rightButton = getFirstInContext(EDirection.Right);
    }

    /**
   * Warning: Can return null if none of the elements in the corresponding list are in context
   */
    private DynamicButtonSystemNode getFirstInContext(EDirection direction)
    {
        List<DynamicButtonSystemNode> listToCycle = new List<DynamicButtonSystemNode>();
        if (direction == EDirection.Up)
        {
            listToCycle = upButtons;
        }
        else if (direction == EDirection.Down)
        {
            listToCycle = downButtons;
        }
        else if (direction == EDirection.Left)
        {
            listToCycle = leftButtons;
        }
        else if (direction == EDirection.Right)
        {
            listToCycle = rightButtons;
        }
        for (int i = 0; i < listToCycle.Count; i++)
        {
            if (listToCycle[i].isInContext)
            {
                return listToCycle[i];
            }
        }
        return null;
    }

    public virtual void selectedDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = designColors.selectedColor;
    }

    public virtual void unselectedDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = designColors.backgroundColor;
    }

    public virtual void notInContextDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = invisible;
    }

    public virtual void setDesignColors(DesignColors designColors)
    {
        this.designColors = designColors;
    }


    void Update()
    {
        if(isInContext)
        {
            if(isSelected)
            {
                selectedDisplay();
            }
            else
            {
                unselectedDisplay();
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
                }
            }
        }
        else
        {
            notInContextDisplay();
        }
    }

    public abstract void actionWhenSelected();
}
