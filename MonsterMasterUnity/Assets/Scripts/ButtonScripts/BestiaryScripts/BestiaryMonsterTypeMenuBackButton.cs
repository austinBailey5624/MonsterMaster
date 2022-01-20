using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

/**
* Class that determines the behavior of the back button in the bestiary monster type menu
* Copyright 2022 Austin Bailey All Rights Reserved
*/
public class BestiaryMonsterTypeMenuBackButton : BestiaryButton
{
    private float tolerance = .25f;

    private int shouldMove = 0;

    public List<BestiaryButton> leftButtons;

    private BestiaryButton leftButton2;

    public override void actionWhenSelected()
    {
        SceneManager.LoadScene("BestiarySubelementMenu");
    }

    public void resolveLinks()
    {
        leftButton2 = getFirstInContext(EDirection.Left);
    }

    public BestiaryButton getFirstInContext(EDirection direction)
    {
        List<BestiaryButton> listToCycle = new List<BestiaryButton>();
        if (direction == EDirection.Left)
        {
            listToCycle = leftButtons;
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

    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        this.isInContext = true;
    }

    void Update()
    {
        if (isSelected)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite =
                getSelectedSprite();
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite =
                defaultSprite;
        }
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        float cancel = Input.GetAxis("Cancel");
        float submit = Input.GetAxis("Submit");
        if (isSelected)
        {
            if (horizontal < -tolerance && leftButton2 != null)
            {
                shouldMove = 2;
            }
            else if (submit > tolerance)
            {
                actionWhenSelected();
            }
            if (
                Mathf.Abs(horizontal) < .001f &&
                Mathf.Abs(cancel) < .001f &&
                Mathf.Abs(submit) < .001f
            )
            {
                if (shouldMove > 0)
                {
                    this.unSelect();
                }
                if (shouldMove == 2)
                {
                    leftButton2.select();
                }
                shouldMove = 0;
            }
        }
    }
}
