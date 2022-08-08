using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the save slots in the load menu
*   Copyright 2022 Austin Bailey
*/
public class LoadMenuSaveSlotButton : ButtonSystemNode
{
    public LoadMenuSaveButton saveButton;

    public LoadMenuDeleteButton deleteButton;

    public LoadMenuLoadButton loadButton;

    private bool keydown = false;

    private bool isHighlighted = false;

    public void unhighlight()
    {
        isHighlighted = false;
    }

    public override void actionWhenSelected()
    {
        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            this.isHighlighted = true;
            if ("MainMenu".Equals(GameState.previousMenuName))
            {
                loadButton.select();
            }
            else
            {
                saveButton.select();
            }
            saveButton.setSelectedSlot(this);
            deleteButton.setSelectedSlot(this);
            loadButton.setSelectedSlot(this);
            this.unSelect();
            keydown = false;
        }
    }

    public override void executeSelectedBehavior()
    {
        isHighlighted = false;
        this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getDefaultDesignColors().selectedColor;
    }

    public override void executeUnselectedBehavior()
    {
        if(isHighlighted)
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getDefaultDesignColors().selectedColor;
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().color = GameState.designColorsController.getDefaultDesignColors().backgroundColor;
        }
    }
}
