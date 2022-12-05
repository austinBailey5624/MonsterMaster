using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to represent the State of the Name Character Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class NameCharacterMenuState : MonoBehaviour
{
    public static NameCharacterMenuState menuState;

    public static bool usingCaps = true;

    private void Awake()
    {
        if(menuState == null)
        {
            menuState = this;
        }
        else
        {
            Destroy(this.gameObject);
            return;
        }
    }
}
