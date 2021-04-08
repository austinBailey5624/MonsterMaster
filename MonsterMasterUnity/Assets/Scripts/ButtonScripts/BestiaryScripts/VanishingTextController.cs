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
        {"Deep",11},
        {"Fey",12},
        {"Plant",13},
        {"Terra",14},
        {"Pegasus",15},
        {"Compassion",16},
        {"Rotten",17},
        {"Phoenix",18},
        {"Seabreeze",19},
        {"Bird",20},
        {"Aero",21 },
        {"Cocka",22 },
        {"Nightwing",23 },
        {"Solar",24 },
        {"Lunar",25 },
        {"Guardian",26 },
        {"Angel",27 },
        {"Luxor",28 },
        {"Redemption",29 },
        {"Demon",30 },
        {"Poison",31 },
        {"Undead",32 },
        {"Storm",33 },
        {"Betrayer",34 },
        {"Umbral",35 }
    };



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
