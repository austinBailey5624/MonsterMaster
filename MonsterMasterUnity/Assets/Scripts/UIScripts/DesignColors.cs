using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control the colors of different menus
 * Wanted to call it 'Theme' but that word was taken
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DesignColors 
{
    public Color textColor;
    public Color backgroundColor;
    public Color selectedColor;

    public DesignColors(Color textColor, Color backgroundColor, Color selectedColor)
    {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.selectedColor = selectedColor;
    }
}
