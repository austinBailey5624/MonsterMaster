using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

/**
*   Class to handle buttons that transition scenes and are part of a node system.
*   Copyright 2022, Austin Bailey All Rights Reserved
*/
public class ButtonSceneTransitionNode : MonoBehaviour, IButtonSceneTransition, IButtonSystemNode
{
    public bool isSelected;

    protected Sprite defaultSprite;

    public Sprite selectedSprite;

    public ButtonSceneTransitionNode upButton;

    public ButtonSceneTransitionNode rightButton;

    public ButtonSceneTransitionNode leftButton;

    public ButtonSceneTransitionNode downButton;

    public string nextSceneName;

    private float tolerance = .25f;

    private int shouldMove = 0;

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

    public string getNextSceneName()
    {
        return nextSceneName;
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

    public void select()
    {
        this.isSelected = true;
    }

    public void unSelect()
    {
        this.isSelected = false;
    }

    void Update()
    {
        if (isSelected)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = getSelectedSprite();
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

    public virtual void actionWhenSelected()
    {
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
            SceneManager.LoadScene (tempPrevPlace);
        }
        else if (nextSceneName.Equals("previousMenu"))
        {
            SceneManager.LoadScene (tempPrevMenu);
        }
        else if (nextSceneName.Length > 1)
        {
            SceneManager.LoadScene (nextSceneName);
        }
    }
}
