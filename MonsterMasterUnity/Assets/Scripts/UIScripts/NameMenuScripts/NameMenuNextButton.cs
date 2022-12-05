using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control the behavior of the Next Button in the Name Character Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class NameMenuNextButton : ButtonSceneTransitionNode
{ 
    public override void additionalAction()
    {
        if (GameState.mainCharacterName.Length < 1)
        {
            GameState.mainCharacterName = "Guy";
            return;
        }
    }
}
