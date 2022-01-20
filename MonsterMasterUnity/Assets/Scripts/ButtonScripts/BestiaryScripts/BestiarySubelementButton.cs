using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

/**
*   Class to handle the Subelement Buttons in the Bestiary Menu
*   Copyright 2022, Austin Bailey All Rights Reserved
*/
public class BestiarySubelementButton : BestiaryButton
{
    public string subelementName;
    public SecondaryElement secondaryElement;

    private Color white = new Color(1f, 1f, 1f, 1f);
    private Color invisible = new Color(1f, 1f, 1f, 0f);
    private Color brown = new Color(1f, 112f / 255f, 0f, 1f);
    private int shouldMove=0;
    private float tolerance;
            
    void selectedDisplay()
    {
        GameObject selectedBand = this.transform.GetChild(0).gameObject;
        selectedBand.gameObject.GetComponent<SpriteRenderer>().color = white;
        GameObject textBackground = this.transform.GetChild(1).gameObject;
        textBackground.gameObject.GetComponent<SpriteRenderer>().color = brown;
        GameObject invisibleController = GameObject.FindGameObjectWithTag("Scene");
        invisibleController.gameObject.GetComponent<VanishingTextController>().appearText(subelementName);
    }

    void unselectedDisplay()
    {
        GameObject selectedBand = this.transform.GetChild(0).gameObject;
        selectedBand.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        GameObject textBackground = this.transform.GetChild(1).gameObject;
        textBackground.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        GameObject invisibleController = GameObject.FindGameObjectWithTag("Scene");
        invisibleController.gameObject.GetComponent<VanishingTextController>().disappearText(subelementName);
    }

    void Update()
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
            if (horizontal > tolerance && rightButton != null)
            {
                shouldMove = 1;
            }
            else if (horizontal < -tolerance && leftButton != null)
            {
                shouldMove = 2;
            }
            else if (vertical > tolerance && upButton != null)
            {
                shouldMove = 3;
            }
            else if (vertical < -tolerance && downButton != null)
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
                if(shouldMove > 0)
                {
                    this.unSelect();
                }
                if (shouldMove == 1)
                {
                    rightButton.select();
                }
                else if (shouldMove == 2)
                {
                    leftButton.select();
                }
                else if (shouldMove == 3)
                {
                    upButton.select();
                }
                else if (shouldMove == 4)
                {
                    downButton.select();
                }
                shouldMove = 0;
            }
        }
    }

    public override void actionWhenSelected()
    {
        GameState.selectedBestiaryElement = secondaryElement;
        GameState.previousMenuName = SceneManager.GetActiveScene().name;
        SceneManager.LoadScene("BestiarySubelementMenu");
    }
}
