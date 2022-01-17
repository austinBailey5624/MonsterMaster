using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the behavior of the left pants selector button in the Character Creator Menu.
*   Copyright 2022 Austin Bailey
*/
public class PantsLeft : CharacterCreatorMenuButton
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
            if (curPantsSet.Equals(shortsSet))
            {
                mainCharacter.pantsSet = jeansSet;
            }
            else if (curPantsSet.Equals(jeansSet))
            {
                mainCharacter.pantsSet = shortsSet;
                if (ColorsEqual(darkBlue, mainCharacter.pantColor))
                {
                    mainCharacter.pantColor = darkGrey;
                }
                else if (ColorsEqual(darkGrey, mainCharacter.pantColor))
                {
                    mainCharacter.pantColor = brown;
                }
                else if (ColorsEqual(brown, mainCharacter.pantColor))
                {
                    mainCharacter.pantColor = darkBlue;
                }
                mainCharacter
                    .transform
                    .GetChild(3)
                    .GetComponent<SpriteRenderer>()
                    .color = mainCharacter.pantColor;
            }
            mainCharacter.setSprite(0, 3);
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
