using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the behavior of the right facial hair selector in the character creator menu
*   Copyright 2022 Austin Bailey
*/
public class FacialRight : CharacterCreatorMenuButton
{
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
        AnimationSet currentHair = mainCharacter.facialHairSet;
        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            if (currentHair.Equals(blankSet))
            {
                mainCharacter.facialHairSet = wraparoundSet; //fiveShadowSet;
            }
            else if (currentHair.Equals(fiveShadowSet))
            {
                mainCharacter.facialHairSet = blankSet; //fullBeardSet;
            }
            else if (currentHair.Equals(fullBeardSet))
            {
                mainCharacter.facialHairSet = fiveShadowSet; //goateeSet;
            }
            else if (currentHair.Equals(goateeSet))
            {
                mainCharacter.facialHairSet = fullBeardSet; //moustacheSet;
            }
            else if (currentHair.Equals(moustacheSet))
            {
                mainCharacter.facialHairSet = goateeSet; //peachFuzzSet;
            }
            else if (currentHair.Equals(peachFuzzSet))
            {
                mainCharacter.facialHairSet = moustacheSet; //trampBeardSet;
            }
            else if (currentHair.Equals(trampBeardSet))
            {
                mainCharacter.facialHairSet = peachFuzzSet; //wraparoundSet;
            }
            else if (currentHair.Equals(wraparoundSet))
            {
                mainCharacter.facialHairSet = trampBeardSet; //blankSet;
            }
            Color hairColor = mainCharacter.hairStyleColor;
            facialHair.gameObject.GetComponent<SpriteRenderer>().color =
                hairColor;
            mainCharacter.setSprite(0, 3);
            keydown = false;
        }
    }
}