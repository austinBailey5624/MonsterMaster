using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the behavior of the delete button in the load menu
*   Copyright 2022 Austin Bailey
*/
public class LoadMenuDeleteButton : ButtonSystemNode
{
    public LoadMenuSaveSlotButton selectedSlot;

    private bool keydown = false;

    public void setSelectedSlot(LoadMenuSaveSlotButton selectedSaveSlot)
    {
        this.selectedSlot = selectedSaveSlot;
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
            //TODO add code to delete the selected Save in the save slot
            selectedSlot.select();
            selectedSlot.unhighlight();
            this.unSelect();
            keydown = false;
        }
    }
}
