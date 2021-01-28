using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class PronounDisplay : MonoBehaviour
{
    void Start()
    {
        
    }

    void Update()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        string subjectPronoun = mainCharacter.GetComponent<MainCharacterController>().subjectPronoun;
        if (subjectPronoun == "He")
        {
            this.gameObject.GetComponent<TMP_Text>().fontSize = 40;
        }
        else if(subjectPronoun == "She")
        {
            this.gameObject.GetComponent<TMP_Text>().fontSize = 30;
        }
        else if(subjectPronoun == "They")
        {
            this.gameObject.GetComponent<TMP_Text>().fontSize = 25;
        }

        this.gameObject.GetComponent<TMP_Text>().text = mainCharacter.GetComponent<MainCharacterController>().subjectPronoun
            + ", " + mainCharacter.GetComponent<MainCharacterController>().objectPronoun
            + ", " + mainCharacter.GetComponent<MainCharacterController>().possesivePronoun;
    }
}
