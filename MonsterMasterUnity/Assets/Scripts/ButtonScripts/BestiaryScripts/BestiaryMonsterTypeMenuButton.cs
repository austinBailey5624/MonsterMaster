using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

using static EDirection;

/**
*  Class that controls the behaviour of the Monster Type Menu Buttons in the
*  Bestiary Monster Type Menu.
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class BestiaryMonsterTypeMenuButton : BestiaryButton
{
    public List<BestiaryButton> leftButtons;

    public List<BestiaryButton> rightButtons;

    public MonsterType monsterType;

    private float tolerance = .25f;

    private Color white = new Color(1f, 1f, 1f, 1f);

    private Color invisible = new Color(1f, 1f, 1f, 0f);

    private Color defaultColor;

    private BestiaryButton leftButton2;

    private EDirection shouldMove = EDirection.Center;

    private BestiaryButton rightButton2;

    void selectedDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().sprite =
            getSelectedSprite();
        if (defaultColor != null)
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = defaultColor;
        }
    }

    void unselectedDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().sprite = defaultSprite;
        if (defaultColor != null)
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = defaultColor;
        }
    }

    void notInContextDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = invisible;
    }

    public void activate(Color activateColor)
    {
        defaultColor = activateColor;
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        if (monsterType == null)
        {
            hide();
        }
        else
        {
            show (activateColor);
            unselectedDisplay();
        }
    }

    public void resolveLinks()
    {
        leftButton2 = getFirstInContext(EDirection.Left);
        rightButton2 = getFirstInContext(EDirection.Right);
    }

    public override void actionWhenSelected()
    {
        GameState.selectedBestiaryMonsterType = monsterType;
        SceneManager.LoadScene("BestiaryMonsterTypeMenu");
    }

    public BestiaryButton getFirstInContext(EDirection direction)
    {
        List<BestiaryButton> listToCycle = new List<BestiaryButton>();
        if (direction == EDirection.Left)
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

    public void setMonsterType(MonsterType monsterType)
    {
        this.monsterType = monsterType;
    }

    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
    }

    void Update()
    {
        if (isInContext)
        {
            if (isSelected)
            {
                selectedDisplay();
            }
            else
            {
                unselectedDisplay();
            }
        }
        else
        {
            notInContextDisplay();
        }
        float horizontal = Input.GetAxis("Horizontal");
        float submit = Input.GetAxis("Submit");
        if (isSelected)
        {
            if (horizontal > tolerance && rightButton2 != null)
            {
                shouldMove = EDirection.Right;
            }
            else if (horizontal < -tolerance && leftButton2 != null)
            {
                shouldMove = EDirection.Left;
            }
            else if (submit > tolerance)
            {
                actionWhenSelected();
            }
            if (Mathf.Abs(horizontal) < .001f && Mathf.Abs(submit) < .001f)
            {
                if (shouldMove != EDirection.Center)
                {
                    this.unSelect();
                }
                if (shouldMove == EDirection.Right)
                {
                    rightButton2.select();
                }
                else if (shouldMove == EDirection.Left)
                {
                    leftButton2.select();
                }
                shouldMove = EDirection.Center;
            }
        }
    }

    public void hide()
    {
        this.isInContext = false;
        this.gameObject.GetComponent<SpriteRenderer>().color = invisible;
    }

    public void show(Color color)
    {
        this.isInContext = true;
        this.gameObject.GetComponent<SpriteRenderer>().color = color;
    }
}
