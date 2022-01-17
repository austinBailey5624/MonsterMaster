using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the behavior of the left change pronoun button in the character creator menu
*   Copyright 2022 Austin Bailey
*/
public class ChangePronounLeft : CharacterCreatorMenuButton
{
    private bool keydown = false;

    public override void actionWhenSelected()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        string subjectPronoun = mainCharacter.subjectPronoun;
        float submit = Input.GetAxisRaw("Submit");
        if (submit == 1)
        {
            keydown = true;
        }
        if (submit == 0 && keydown == true)
        {
            if (subjectPronoun.Equals("He"))
            {
                mainCharacter.subjectPronoun = "They";
                mainCharacter.objectPronoun = "Them";
                mainCharacter.possesivePronoun = "Theirs";
            }
            else if (subjectPronoun.Equals("She"))
            {
                mainCharacter.subjectPronoun = "He";
                mainCharacter.objectPronoun = "Him";
                mainCharacter.possesivePronoun = "His";
            }
            else if (subjectPronoun.Equals("They"))
            {
                mainCharacter.subjectPronoun = "She";
                mainCharacter.objectPronoun = "Her";
                mainCharacter.possesivePronoun = "Hers";
            }
            keydown = false;
        }
    }
}
