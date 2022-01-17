using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the save slots in the load menu
*   Copyright 2022 Austin Bailey
*/
public class LoadMenuSaveSlotButton : LoadMenuButton
{
    public LoadMenuSaveButton saveButton;

    public LoadMenuDeleteButton deleteButton;

    public LoadMenuLoadButton loadButton;

    private bool keydown = false;

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
}
