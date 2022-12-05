using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control the behavior of the Undo button in the Name Character menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 * */
public class CharacterNameUndoButton : ButtonSystemNode
{
    public override void delayedAction()
    {
        if (GameState.mainCharacterName.Length > 0)
        {
            GameState.mainCharacterName = GameState.mainCharacterName.Remove(GameState.mainCharacterName.Length - 1, 1);
        }
    }
}
