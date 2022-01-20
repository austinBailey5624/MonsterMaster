using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

using static EDirection;

/**
*   Controller class for Buttons in the Bestiary Subelement Menu that represent 
*   Monster Types.
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class BestiaryMonsterTypeButton : BestiaryButton
{
    public static int maxTime = 150;

    public List<BestiaryButton> upButtons;

    public List<BestiaryButton> downButtons;

    public List<BestiaryButton> leftButtons;

    public List<BestiaryButton> rightButtons;

    public MonsterType monsterType;

    private GameObject monsterSprite;

    private List<Sprite> spritesToDisplay;

    private Color white = new Color(1f, 1f, 1f, 1f);

    private Color invisible = new Color(1f, 1f, 1f, 0f);

    private Color defaultColor;

    private float tolerance = .25f;

    private int curTime = 0;

    private int maxNumSprites;

    private int spriteIndex = 0;

    private int shouldMove = 0;

    private BestiaryButton upButton2;

    private BestiaryButton downButton2;

    private BestiaryButton leftButton2;

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

    void cycleSprite()
    {
        if (spriteIndex >= maxNumSprites - 1)
        {
            spriteIndex = 0;
        }
        else
        {
            spriteIndex++;
        }
        monsterSprite.gameObject.GetComponent<SpriteRenderer>().color = white;
        monsterSprite.gameObject.GetComponent<SpriteRenderer>().sprite =
            spritesToDisplay[spriteIndex];
    }

    void notInContextDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        if (monsterSprite != null)
        {
            monsterSprite.gameObject.GetComponent<SpriteRenderer>().color =
                invisible;
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
    }

    public void activate(Color activateColor)
    {
        defaultColor = activateColor;
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        monsterSprite = this.transform.GetChild(0).gameObject;
        if (monsterType == null)
        {
            hide();
        }
        else
        {
            show (activateColor);
            spritesToDisplay = monsterType.getDownSprites();
            maxNumSprites = spritesToDisplay.Count;
            monsterSprite.gameObject.GetComponent<SpriteRenderer>().sprite =
                monsterType.getDefaultSprite();
            unselectedDisplay();
        }
    }

    public void resolveLinks()
    {
        upButton2 = getFirstInContext(EDirection.Up);
        downButton2 = getFirstInContext(EDirection.Down);
        leftButton2 = getFirstInContext(EDirection.Left);
        rightButton2 = getFirstInContext(EDirection.Right);
    }

    // Update is called once per frame
    void Update()
    {
        if (isInContext)
        {
            if (isSelected)
            {
                selectedDisplay();
                if (curTime >= maxTime)
                {
                    cycleSprite();
                    curTime = 0;
                }
                else
                {
                    curTime++;
                }
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
        float vertical = Input.GetAxis("Vertical");
        float cancel = Input.GetAxis("Cancel");
        float submit = Input.GetAxis("Submit");
        if (isSelected)
        {
            if (horizontal > tolerance && rightButton2 != null)
            {
                shouldMove = 1;
            }
            else if (horizontal < -tolerance && leftButton2 != null)
            {
                shouldMove = 2;
            }
            else if (vertical > tolerance && upButton2 != null)
            {
                shouldMove = 3;
            }
            else if (vertical < -tolerance && downButton2 != null)
            {
                shouldMove = 4;
            }
            else if (submit > tolerance)
            {
                actionWhenSelected();
            }
            if (
                Mathf.Abs(horizontal) < .001f &&
                Mathf.Abs(vertical) < .001f &&
                Mathf.Abs(cancel) < .001f &&
                Mathf.Abs(submit) < .001f
            )
            {
                if (shouldMove > 0)
                {
                    this.unSelect();
                }
                if (shouldMove == 1)
                {
                    rightButton2.select();
                }
                else if (shouldMove == 2)
                {
                    leftButton2.select();
                }
                else if (shouldMove == 3)
                {
                    upButton2.select();
                }
                else if (shouldMove == 4)
                {
                    downButton2.select();
                }
                shouldMove = 0;
            }
        }
    }

    public override void actionWhenSelected()
    {
        GameState.selectedBestiaryMonsterType = monsterType;
        SceneManager.LoadScene ("BestiaryMonsterTypeMenu");
    }

    /**
    * Warning: Can return null if none of the elements in the corresponding list are in context
    */
    private BestiaryButton getFirstInContext(EDirection direction)
    {
        List<BestiaryButton> listToCycle = new List<BestiaryButton>();
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

    public void hide()
    {
        this.isInContext = false;
        this.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        if (monsterSprite != null)
        {
            monsterSprite.gameObject.GetComponent<SpriteRenderer>().color =
                invisible;
        }
    }

    public void show(Color color)
    {
        this.isInContext = true;
        this.gameObject.GetComponent<SpriteRenderer>().color = color;
        if (monsterSprite != null)
        {
            monsterSprite.gameObject.GetComponent<SpriteRenderer>().color =
                white;
        }
    }
}
