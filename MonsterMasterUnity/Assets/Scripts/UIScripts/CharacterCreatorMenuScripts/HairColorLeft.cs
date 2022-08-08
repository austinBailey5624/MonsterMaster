using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the Left Hair Color Selector in the Character Creator Menu
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class HairColorLeft : CharacterCustomizeButton
{
    private Color redHead = new Color(1f, 74 / 255f, 0f, 1f);

    private Color blonde = new Color(1f, 204f / 255f, 0f, 1f);

    private Color lightBrown = new Color(191f / 255f, 100f / 255f, 0f, 1f);

    private Color brown = new Color(152f / 255f, 78f / 255f, 0f, 1f);

    private Color darkBrown = new Color(94f / 255f, 48f / 255f, 0f, 1f);

    private Color black = new Color(20f / 255f, 20f / 255f, 20f / 255f, 1f);

    private Color charcoal = new Color(82f / 255f, 82f / 255f, 82f / 255f / 1f);

    private Color greying = new Color(162f / 255f, 162f / 255f, 162f / 255f, 1f);

    private Color white = new Color(227f / 255f, 227f / 255f, 227f / 255f, 1f);

    private Color blue = new Color(0f, 139f / 255f, 1f, 1f);

    private Color green = new Color(60f / 255f, 1f, 65f / 255f, 1f);

    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();

        float submit = Input.GetAxisRaw("Submit");
        if(submit == 1)
        {
            keydown = true;
        }
        else if(submit == 0 && keydown == true)
        {
        if (ColorsEqual(mainCharacter.hairStyleColor, redHead))
        {
            mainCharacter.hairStyleColor = blonde;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, blonde))
        {
            mainCharacter.hairStyleColor = lightBrown;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, lightBrown))
        {
            mainCharacter.hairStyleColor = brown;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, brown))
        {
            mainCharacter.hairStyleColor = darkBrown;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, darkBrown))
        {
            mainCharacter.hairStyleColor = black;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, black))
        {
            mainCharacter.hairStyleColor = charcoal;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, charcoal))
        {
            mainCharacter.hairStyleColor = greying;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, greying))
        {
            mainCharacter.hairStyleColor = white;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, white))
        {
            mainCharacter.hairStyleColor = blue;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, blue))
        {
            mainCharacter.hairStyleColor = green;
        }
        else if (ColorsEqual(mainCharacter.hairStyleColor, green))
        {
            mainCharacter.hairStyleColor = redHead;
        }
        mainCharacter
            .transform
            .GetChild(5)
            .GetComponent<SpriteRenderer>()
            .color = mainCharacter.hairStyleColor;
        mainCharacter
            .transform
            .GetChild(7)
            .GetComponent<SpriteRenderer>()
            .color = mainCharacter.hairStyleColor;
        mainCharacter.setSprite(0, EDirection.Down);
        keydown = false;
    }}

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .001f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) &&
        (Mathf.Abs(color1.g - color2.g) < tolerance) &&
        (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
