using System.Collections; 
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class VanishingTextController : MonoBehaviour
{
    private Dictionary<string, int> textIndexBySubelementName = new Dictionary<string, int>(){
        {"Pyro",0},
        {"Lava",1},
        {"Dinosaur",2},
        {"Sand",3},
        {"Justice",4},
        {"Vengence",5},
        {"Steam",6},
        {"Aqua",7},
        {"Amphibious",8},
        {"Weather",9},
        {"Ice",10},
        {"Deep",11 } };


    public void appearText(string subelementName)
    {
        int showingIndex = textIndexBySubelementName[subelementName];
        GameObject selectedText = this.transform.GetChild(showingIndex).gameObject;
        selectedText.gameObject.GetComponent<TMP_Text>().text = subelementName;
    }

    public void disappearText(string subelementName)
    {
        int showingIndex = textIndexBySubelementName[subelementName];
        GameObject selectedText = this.transform.GetChild(showingIndex).gameObject;
        selectedText.gameObject.GetComponent<TMP_Text>().text = "";
    }
}
