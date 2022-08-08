using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to represent State in the Bestiary Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class BestiaryMenuState : MonoBehaviour
{
    public static BestiaryMenuState menuState;

    public static SecondaryElement selectedBestiaryElement;

    public static MonsterType selectedBestiaryMonsterType;

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
