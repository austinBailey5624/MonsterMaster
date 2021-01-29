using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ChangePronounLeft : MonoBehaviour
{
    void OnMouseUp()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        string subjectPronoun = mainCharacter.GetComponent<Person>().subjectPronoun;

        if(subjectPronoun.Equals("He"))
        {
            mainCharacter.GetComponent<Person>().subjectPronoun = "They";
            mainCharacter.GetComponent<Person>().objectPronoun = "Them";
            mainCharacter.GetComponent<Person>().possesivePronoun = "Theirs";
        }
        else if(subjectPronoun.Equals("She"))
        {
            mainCharacter.GetComponent<Person>().subjectPronoun = "He";
            mainCharacter.GetComponent<Person>().objectPronoun = "Him";
            mainCharacter.GetComponent<Person>().possesivePronoun = "His";
        }
        else if(subjectPronoun.Equals("They"))
        {
            mainCharacter.GetComponent<Person>().subjectPronoun = "She";
            mainCharacter.GetComponent<Person>().objectPronoun = "Her";
            mainCharacter.GetComponent<Person>().possesivePronoun = "Hers";
        }
    }
}
