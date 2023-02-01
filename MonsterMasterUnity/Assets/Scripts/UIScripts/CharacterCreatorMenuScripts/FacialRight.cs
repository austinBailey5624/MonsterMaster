using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the right facial hair selector in the character creator menu
*   Copyright 2022-2023 Austin Bailey All Rights Reserved
*/
public class FacialRight : CharacterCustomizeButton
{
    //TODO: Simplify with List
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
                mainCharacter.animationSets[(int)EBodyPart.Facial] = wraparoundSet; //fiveShadowSet;
            }
            else if (currentHair.Equals(fiveShadowSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = blankSet; //fullBeardSet;
            }
            else if (currentHair.Equals(fullBeardSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = fiveShadowSet; //goateeSet;
            }
            else if (currentHair.Equals(goateeSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = fullBeardSet; //moustacheSet;
            }
            else if (currentHair.Equals(moustacheSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = goateeSet; //peachFuzzSet;
            }
            else if (currentHair.Equals(peachFuzzSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = moustacheSet; //trampBeardSet;
            }
            else if (currentHair.Equals(trampBeardSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = peachFuzzSet; //wraparoundSet;
            }
            else if (currentHair.Equals(wraparoundSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.Facial] = trampBeardSet; //blankSet;
            }
            Color hairColor = mainCharacter.colors[(int)EBodyPart.Facial];
            facialHair.gameObject.GetComponent<SpriteRenderer>().color =
                hairColor;
            mainCharacter.setSprite(0, EDirection.Down);
            keydown = false;
        }
    }
}
