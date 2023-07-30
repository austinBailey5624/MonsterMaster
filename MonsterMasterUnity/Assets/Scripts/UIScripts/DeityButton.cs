using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

/**
 * Class to control the behavior of the Deity Buttons in the Diety Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DeityButton : ButtonSceneTransitionNode
{
    public Deity deity;
    private GameObject alignmentBar;
    private GameObject titleBox;
    private GameObject selector;
    private GameObject selectedCircle;
    private Color transparent = new Color(0f, 0f, 0f, 0f);
    private Color white = new Color(1f, 1f, 1f, 1f);
    private DesignColors colors;


    private void Awake()
    {
        alignmentBar = this.transform.GetChild(0).gameObject;
        titleBox = this.transform.GetChild(1).gameObject;
        selector = this.transform.GetChild(2).gameObject;
        selectedCircle = this.transform.GetChild(3).gameObject;
        colors = GameState.designColorsController.getElementDesignColors(deity.secondaryElement);
        titleBox.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        if (GameState.difficultyState.getDifficultyLevel(DifficultyState.EDifficultyType.DeityVisibility) == DifficultyState.EDifficultyLevel.Hard)
        {
            alignmentBar.GetComponent<SpriteRenderer>().color = transparent;
            selector.GetComponent<SpriteRenderer>().color = transparent;
        }
        else
        {
            Vector2 position = selector.transform.localPosition;
            position.x = getXValue(GameState.getAffinity(deity));
            selector.transform.localPosition = position;
        }
        nextSceneName = "DeitySelectedMenu";

        this.transform.gameObject.GetComponent<SpriteRenderer>().sprite = deity.defaultSprite;
    }

    public override void executeSelectedBehavior()
    {
        selectedCircle.GetComponent<SpriteRenderer>().color = white;
        titleBox.GetComponent<SpriteRenderer>().color = colors.selectedColor;
    }

    public override void executeUnselectedBehavior()
    {
        selectedCircle.GetComponent<SpriteRenderer>().color = transparent;
        titleBox.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
    }

    private float getXValue(int affinityValue)
    {
        float keyValue = 1.75f;
        int maxValue = 1000;
        //-1000 and worse should be x=1.75
        //+1000 and better should be x=-1.75
        if(affinityValue <= -maxValue)
        {
            return keyValue;
        }
        if(affinityValue >= maxValue)
        {
            return -keyValue;
        }
        return (affinityValue * (-keyValue / maxValue));
    }

    public override void actionWhenSelected()
    {
        DeityMenuState.selectedDeity = deity;
        string tempPrevPlace = GameState.previousPlaceName;
        string tempPrevMenu = GameState.previousMenuName;
        string activeSceneName = SceneManager.GetActiveScene().name;
        if (activeSceneName.Contains("Menu") || activeSceneName.Contains("menu")
        )
        {
            GameState.previousMenuName = activeSceneName;
        }
        else
        {
            GameState.previousPlaceName = activeSceneName;
        }

        if (nextSceneName.Equals("previousPlace"))
        {
            SceneManager.LoadScene(tempPrevPlace);
        }
        else if (nextSceneName.Equals("previousMenu"))
        {
            SceneManager.LoadScene(tempPrevMenu);
        }
        else if (nextSceneName.Length > 1)
        {
            SceneManager.LoadScene(nextSceneName);
        }
    }
}

