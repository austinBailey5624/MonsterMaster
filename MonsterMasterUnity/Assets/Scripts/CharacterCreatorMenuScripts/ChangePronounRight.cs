using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ChangePronounRight : MonoBehaviour
{
    void OnMouseUp()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        string subjectPronoun = mainCharacter.subjectPronoun;

        if (subjectPronoun.Equals("She"))
        {
            mainCharacter.subjectPronoun = "They";
            mainCharacter.objectPronoun = "Them";
            mainCharacter.possesivePronoun = "Theirs";
        }
        else if (subjectPronoun.Equals("They"))
        {
            mainCharacter.subjectPronoun = "He";
            mainCharacter.objectPronoun = "Him";
            mainCharacter.possesivePronoun = "His";
        }
        else if (subjectPronoun.Equals("He"))
        {
            mainCharacter.subjectPronoun = "She";
            mainCharacter.objectPronoun = "Her";
            mainCharacter.possesivePronoun = "Hers";
        }
    }
}
