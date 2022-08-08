using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the left shirt selector in the Character Creator Menu
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class ShirtLeft : CharacterCustomizeButton
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

        AnimationSet curShirtSet = mainCharacter.shirtSet;

        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if(submit == 0 && keydown == true)
        {
            if (curShirtSet.Equals(tshirtSet))
            {
                mainCharacter.shirtSet = tanktopSet;
            }
            else if (curShirtSet.Equals(tanktopSet))
            {
                mainCharacter.shirtSet = longSleeveSet;
            }
            else if (curShirtSet.Equals(longSleeveSet))
            {
                mainCharacter.shirtSet = robeSet;
            }
            else if (curShirtSet.Equals(robeSet))
            {
                mainCharacter.shirtSet = tshirtSet;
                if (ColorsEqual(mainCharacter.shirtColor, darkGreen))
                {
                    mainCharacter.shirtColor = lightGrey;
                    mainCharacter
                        .transform
                        .GetChild(4)
                        .GetComponent<SpriteRenderer>()
                        .color = lightGrey;
                }
                else if (ColorsEqual(mainCharacter.shirtColor, lightGrey))
                {
                    mainCharacter.shirtColor = darkGrey;
                    mainCharacter
                        .transform
                        .GetChild(4)
                        .GetComponent<SpriteRenderer>()
                        .color = darkGrey;
                }
                else if (ColorsEqual(mainCharacter.shirtColor, darkGrey))
                {
                    mainCharacter.shirtColor = brown;
                    mainCharacter
                        .transform
                        .GetChild(4)
                        .GetComponent<SpriteRenderer>()
                        .color = brown;
                }
                else if (ColorsEqual(mainCharacter.shirtColor, brown))
                {
                                    mainCharacter.shirtColor = red;
                    mainCharacter
                        .transform
                        .GetChild(4)
                        .GetComponent<SpriteRenderer>()
                        .color = red;
                }
                else if (ColorsEqual(mainCharacter.shirtColor, red))
                {
                    mainCharacter.shirtColor = darkGreen;
                    mainCharacter
                        .transform
                        .GetChild(4)
                        .GetComponent<SpriteRenderer>()
                        .color = darkGreen;
                }
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
