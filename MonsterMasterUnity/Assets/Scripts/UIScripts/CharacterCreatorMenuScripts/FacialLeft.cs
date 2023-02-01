using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the Left Facial Hair selector in the Character Creator Menu
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class FacialLeft : CharacterCustomizeButton
{

    //TODO: Simplify with a List
    public AnimationSet fiveShadowSet;

    public AnimationSet fullBeardSet;

    public AnimationSet goateeSet;

    public AnimationSet moustacheSet;

    public AnimationSet peachFuzzSet;

    public AnimationSet trampBeardSet;

    public AnimationSet wraparoundSet;

    public AnimationSet blankSet;

    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        GameObject facialHair = mainCharacter.transform.GetChild(5).gameObject;
        AnimationSet currentHair = mainCharacter.animationSets[(int)EBodyPart.Facial];

        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            if (currentHair.Equals(blankSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = fiveShadowSet;
            }
            else if (currentHair.Equals(fiveShadowSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = fullBeardSet;
            }
            else if (currentHair.Equals(fullBeardSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = goateeSet;
            }
            else if (currentHair.Equals(goateeSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = moustacheSet;
            }
            else if (currentHair.Equals(moustacheSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = peachFuzzSet;
            }
            else if (currentHair.Equals(peachFuzzSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = trampBeardSet;
            }
            else if (currentHair.Equals(trampBeardSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = wraparoundSet;
            }
            else if (currentHair.Equals(wraparoundSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = blankSet;
            }
            Color hairColor = mainCharacter.colors[(int)EBodyPart.Facial];
            facialHair.gameObject.GetComponent<SpriteRenderer>().color =
                hairColor;
            mainCharacter.setSprite(0, EDirection.Down);
            keydown = false;
        }
    }
}
