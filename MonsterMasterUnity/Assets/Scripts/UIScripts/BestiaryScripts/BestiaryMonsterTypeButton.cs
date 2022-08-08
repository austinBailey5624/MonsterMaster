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
public class BestiaryMonsterTypeButton : DynamicButtonSystemNode
{
    public static int maxTime = 150;

    public MonsterType monsterType;

    private GameObject monsterSprite;

    private List<Sprite> spritesToDisplay;

    private Color white = new Color(1f, 1f, 1f, 1f);

    private int curTime = 0;

    private int maxNumSprites;

    private int spriteIndex = 0;

    public override void Start()
    {
        designColors = GameState.designColorsController.getElementDesignColors(BestiaryMenuState.selectedBestiaryElement);
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        resolveLinks();
    }


    public override void selectedDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = designColors.selectedColor;
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

    public override void unselectedDisplay()
    {
        if (designColors != null)
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = designColors.backgroundColor;
        }
    }

    private void cycleSprite()
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

    public override void notInContextDisplay()
    {
        this.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        if (monsterSprite != null)
        {
            monsterSprite.gameObject.GetComponent<SpriteRenderer>().color =
                invisible;
        }
    }

    public void activate(Color activateColor)
    {
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

    public override void actionWhenSelected()
    {
        BestiaryMenuState.selectedBestiaryMonsterType = monsterType;
        SceneManager.LoadScene ("BestiaryMonsterTypeMenu");
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
    //    this.gameObject.GetComponent<SpriteRenderer>().color = color;
        if (monsterSprite != null)
        {
            monsterSprite.gameObject.GetComponent<SpriteRenderer>().color =
                white;
        }
    }
}
