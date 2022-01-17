using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the behavior of the skin tone left button in the Character Creator
*   Copyright 2022 Austin Bailey
*/
public class SkinToneLeft : CharacterCreatorMenuButton
{
    private Color skinTone1 = new Color(1f, 208f / 255f, 169f / 255f, 1f);

    private Color skinTone2 = new Color(1f, 187f / 255f, 124f / 255f, 1f);

    private Color skinTone3 = new Color(1f, 158f / 255f, 122f / 255f, 1f);

    private Color skinTone4 = new Color(186f / 255f, 124f / 255f, 66f / 255f, 1f);

    private Color skinTone5 = new Color(140f / 255f, 82f / 255f, 27f / 255f, 1f);

    private Color skinTone6 = new Color(97f / 255f, 56f / 255f, 18f / 255f, 1f);

    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            if (ColorsEqual(mainCharacter.bodyColor, skinTone1))
            {
                mainCharacter.bodyColor = skinTone2;
            }
            else if (ColorsEqual(mainCharacter.bodyColor, skinTone2))
            {
                mainCharacter.bodyColor = skinTone3;
            }
            else if (ColorsEqual(mainCharacter.bodyColor, skinTone3))
            {
                mainCharacter.bodyColor = skinTone4;
            }
            else if (ColorsEqual(mainCharacter.bodyColor, skinTone4))
            {
                mainCharacter.bodyColor = skinTone5;
            }
            else if (ColorsEqual(mainCharacter.bodyColor, skinTone5))
            {
                mainCharacter.bodyColor = skinTone6;
            }
            else if (ColorsEqual(mainCharacter.bodyColor, skinTone6))
            {
                mainCharacter.bodyColor = skinTone1;
            }
            mainCharacter
                .transform
                .GetChild(0)
                .GetComponent<SpriteRenderer>()
                .color = mainCharacter.bodyColor;
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
