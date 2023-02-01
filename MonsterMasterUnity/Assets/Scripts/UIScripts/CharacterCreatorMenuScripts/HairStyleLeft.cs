using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to control the behavior of the left hair style selector button in the Character Creator Menu
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class HairStyleLeft : CharacterCustomizeButton
{
    public AnimationSet hairBaldingSet;

    public AnimationSet hairCroppedSet;

    public AnimationSet tonsureSet;

    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        GameObject hairStyle = mainCharacter.transform.GetChild(5).gameObject;
        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        else if (submit == 0 && keydown == true)
        {
            if (mainCharacter.animationSets[(int)EBodyPart.HairStyle].Equals(tonsureSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.HairStyle] = hairBaldingSet;
            }
            else if (mainCharacter.animationSets[(int)EBodyPart.HairStyle].Equals(hairBaldingSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.HairStyle] = hairCroppedSet;
            }
            else if (mainCharacter.animationSets[(int)EBodyPart.HairStyle].Equals(hairCroppedSet))
            {
                mainCharacter.animationSets[(int)EBodyPart.HairStyle] = tonsureSet;
            }
            mainCharacter.setSprite(0, EDirection.Down);
            keydown = false;
        }
    }
}
