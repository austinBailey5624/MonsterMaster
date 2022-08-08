using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/** 
 * Class to handle the display of the player characters pronouns in the character customizer
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class PronounDisplay : MonoBehaviour
{
    void Update()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        string subjectPronoun = mainCharacter.GetComponent<MainCharacterController>().subjectPronoun;
        if (subjectPronoun == "He")
        {
            this.gameObject.GetComponent<TMP_Text>().fontSize = 320;
        }
        else if(subjectPronoun == "She")
        {
            this.gameObject.GetComponent<TMP_Text>().fontSize = 240;
        }
        else if(subjectPronoun == "They")
        {
            this.gameObject.GetComponent<TMP_Text>().fontSize = 200;
        }

        this.gameObject.GetComponent<TMP_Text>().text = mainCharacter.GetComponent<MainCharacterController>().subjectPronoun
            + ", " + mainCharacter.GetComponent<MainCharacterController>().objectPronoun
            + ", " + mainCharacter.GetComponent<MainCharacterController>().possesivePronoun;
    }
}
