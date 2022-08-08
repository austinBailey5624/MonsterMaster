using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DifficultyMenuButton : MonoBehaviour, IButtonSystemNode
{
    public bool isActive;

    public bool isSelected;

    protected Sprite defaultSprite;

    public Sprite selectedSprite;

    public DifficultyMenuButton upButton;

    public DifficultyMenuButton rightButton;

    public DifficultyMenuButton leftButton;

    public DifficultyMenuButton downButton;

    public DifficultyState.EDifficultyLevel difficultyLevel;

    public DifficultyState.EDifficultyType difficultyType;

    public bool isTransitionButton = false;

    protected float tolerance = .25f;

    private EDirection shouldMove = EDirection.Neutral;

    private Color defaultColor;

    private Color activeColor = new Color(1f, 200f / 255f, 51f / 255f);

    private DesignColors colors;

    void Start()
    {
        colors = GameState.designColorsController.getSpecializedDesignColors();
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        defaultColor = this.gameObject.GetComponent<SpriteRenderer>().color;
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
        GameState.difficultyState.setDifficulty(difficultyType, difficultyLevel);
        DifficultyMenuState.selectedDifficultyType = difficultyType;
    }

    public virtual void unSelect()
    {
        this.isSelected = false;
    }

    public virtual void activate()
    {
        this.isActive = true;
        GameState.difficultyState.setDifficulty(difficultyType, difficultyLevel);
        DifficultyMenuState.selectedDifficultyType = difficultyType;
    }

    public virtual void deactivate()
    {
        this.isActive = false;
    }

    void Update()
    {
        if (isActive)
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = activeColor;
        }
        else if (isSelected)
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = colors.selectedColor;
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }

        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        float cancel = Input.GetAxis("Cancel");
        float submit = Input.GetAxis("Submit");
        if (!isTransitionButton)
        { 
            if (GameState.difficultyState.getDifficultyLevel(difficultyType) == difficultyLevel)
            {
                this.isSelected = true;
            }
            else
            {
                this.isSelected = false;
            }
        }
        if (isActive)
        {
            if (horizontal > tolerance && rightButton != null)
            {
                shouldMove = EDirection.Right;
            }
            else if (horizontal < -tolerance && leftButton != null)
            {
                shouldMove = EDirection.Left;
            }
            else if (vertical > tolerance && upButton != null)
            {
                shouldMove = EDirection.Up;
            }
            else if (vertical < -tolerance && downButton != null)
            {
                shouldMove = EDirection.Down;
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
                if (shouldMove != EDirection.Neutral)
                {
                    this.deactivate();
                }
                if (shouldMove == EDirection.Right)
                {
                    rightButton.activate();
                }
                else if (shouldMove == EDirection.Left)
                {
                    leftButton.activate();
                }
                else if (shouldMove == EDirection.Up)
                {
                    upButton.activate();
                }
                else if (shouldMove == EDirection.Down)
                {
                    downButton.activate();
                }
                shouldMove = EDirection.Neutral;
            }
        }
    }

    public virtual void actionWhenSelected()
    {
        // Empty because this will be overridden by the derived class
    }

    public enum EDirection
    {
        Neutral,
        Up,
        Right,
        Left,
        Down
    }
}
