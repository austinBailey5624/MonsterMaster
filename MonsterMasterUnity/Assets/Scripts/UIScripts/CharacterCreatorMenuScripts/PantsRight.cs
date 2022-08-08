using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the right pants selector button in the Character Creator Menu.
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class PantsRight : CharacterCustomizeButton
{
    public AnimationSet jeansSet;

    public AnimationSet shortsSet;

    private Color darkBlue = new Color(.1f, .25f, .5f, 1f);

    private Color darkGrey = new Color(.2f, .2f, .2f, 1f);

    private Color brown = new Color(.2f, .1f, 0f, 1f);

    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        AnimationSet curPantsSet = mainCharacter.pantsSet;

        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            if (curPantsSet.Equals(jeansSet))
            {
                mainCharacter.pantsSet = shortsSet;
            }
            else if (curPantsSet.Equals(shortsSet))
            {
                mainCharacter.pantsSet = jeansSet;
                Color pantColor =
                    mainCharacter
                        .transform
                        .GetChild(3)
                        .GetComponent<SpriteRenderer>()
                        .color;
                if (ColorsEqual(darkBlue, pantColor))
                {
                    mainCharacter.pantColor = brown;
                }
                else if (ColorsEqual(darkGrey, pantColor))
                {
                    mainCharacter.pantColor = darkBlue;
                }
                else if (ColorsEqual(brown, pantColor))
                {
                    mainCharacter.pantColor = darkGrey;
                }
                mainCharacter
                    .transform
                    .GetChild(3)
                    .GetComponent<SpriteRenderer>()
                    .color = mainCharacter.pantColor;
            }
            mainCharacter.setSprite(0, EDirection.Down);
            keydown = false;
        }
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .01f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) &&
        (Mathf.Abs(color1.g - color2.g) < tolerance) &&
        (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
