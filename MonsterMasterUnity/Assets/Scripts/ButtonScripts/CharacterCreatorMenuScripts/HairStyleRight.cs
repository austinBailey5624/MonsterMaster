using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*    Class to control the behavior of the left hair style selector in the character creator menu
*   Copyright 2022 Austin Bailey
*/
public class HairStyleRight : CharacterCreatorMenuButton
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
            if (mainCharacter.hairStyleSet.Equals(tonsureSet))
            {
                mainCharacter.hairStyleSet = hairCroppedSet;
            }
            else if (mainCharacter.hairStyleSet.Equals(hairBaldingSet))
            {
                mainCharacter.hairStyleSet = tonsureSet;
            }
            else if (mainCharacter.hairStyleSet.Equals(hairCroppedSet))
            {
                mainCharacter.hairStyleSet = hairBaldingSet;
            }
            mainCharacter.setSprite(0, EDirection.Down);
            keydown = false;
        }
    }
}
