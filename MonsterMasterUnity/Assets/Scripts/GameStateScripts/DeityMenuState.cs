using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to represent the state of the DeityMenu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DeityMenuState : MonoBehaviour
{
    public static DeityMenuState menuState;

    public static Deity selectedDeity;

    private void Awake()
    {
        if (menuState == null)
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
