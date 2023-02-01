using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the Shirt Right Button in the Character Creator Menu
*   Copyright 2022-2023 Austin Bailey All Rights Reserved
*/
public class ShirtRight : CharacterCustomizeButton
{
    public AnimationSet tshirtSet;

    public AnimationSet tanktopSet;

    public AnimationSet longSleeveSet;

    public AnimationSet robeSet;

    private Color darkGreen = new Color(0f, .3f, 0f, 1f);

    private Color lightGrey = new Color(.8f, .8f, .8f, 1f);

    private Color darkGrey = new Color(.2f, .2f, .2f, 1f);

    private Color brown = new Color(.2f, .1f, 0f, 1f);

    private Color red = new Color(.8f, 0f, 0f, 1f);

    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        AnimationSet curShirtSet = mainCharacter.animationSets[(int)EBodyPart.Shirt];
        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            if (curShirtSet.Equals(tshirtSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Shirt] = robeSet;
                if (ColorsEqual(mainCharacter.colors[(int)EBodyPart.Shirt], darkGreen))
                {
                    mainCharacter.colors[(int)EBodyPart.Shirt] = red;
                    mainCharacter
                        .transform
                        .GetChild((int)EBodyPart.Shirt)
                        .GetComponent<SpriteRenderer>()
                        .color = red;
                }
                else if (ColorsEqual(mainCharacter.colors[(int)EBodyPart.Shirt], lightGrey))
                {
                    mainCharacter.colors[(int)EBodyPart.Shirt] = darkGreen;
                    mainCharacter
                        .transform
                        .GetChild((int)EBodyPart.Shirt)
                        .GetComponent<SpriteRenderer>()
                        .color = darkGreen;
                }
                else if (ColorsEqual(mainCharacter.colors[(int)EBodyPart.Shirt], darkGrey))
                {
                    mainCharacter.colors[(int)EBodyPart.Shirt] = lightGrey;
                    mainCharacter
                        .transform
                        .GetChild((int)EBodyPart.Shirt)
                        .GetComponent<SpriteRenderer>()
                        .color = lightGrey;
                }
                else if (ColorsEqual(mainCharacter.colors[(int)EBodyPart.Shirt], brown))
                {
                    mainCharacter.colors[(int)EBodyPart.Shirt] = darkGrey;
                    mainCharacter
                        .transform
                        .GetChild((int)EBodyPart.Shirt)
                        .GetComponent<SpriteRenderer>()
                        .color = darkGrey;
                }
                else if (ColorsEqual(mainCharacter.colors[(int)EBodyPart.Shirt], red))
                {
                    mainCharacter.colors[(int)EBodyPart.Shirt] = brown;
                    mainCharacter
                        .transform
                        .GetChild((int)EBodyPart.Shirt)
                        .GetComponent<SpriteRenderer>()
                        .color = brown;
                }
            }
            else if (curShirtSet.Equals(tanktopSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Shirt] = tshirtSet;
            }
            else if (curShirtSet.Equals(longSleeveSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Shirt] = tanktopSet;
            }
            else if (curShirtSet.Equals(robeSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Shirt] = longSleeveSet;
            }
            mainCharacter.setSprite(0, EDirection.Down);
            keydown = false;
        }
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .001f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) &&
        (Mathf.Abs(color1.g - color2.g) < tolerance) &&
        (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
