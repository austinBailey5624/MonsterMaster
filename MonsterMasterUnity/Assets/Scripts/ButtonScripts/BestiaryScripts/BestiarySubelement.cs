using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BestiarySubelement : MonoBehaviour
{
    public string subelementName;
    private Color white = new Color(1f, 1f, 1f, 1f);
    private Color invisible = new Color(1f, 1f, 1f, 0f);
    private Color brown = new Color(1f, 112f / 255f, 0f, 1f);
        
    void OnMouseEnter()
    {
        GameObject selectedBand = this.transform.GetChild(0).gameObject;
        selectedBand.gameObject.GetComponent<SpriteRenderer>().color = white;
        GameObject textBackground = this.transform.GetChild(1).gameObject;
        textBackground.gameObject.GetComponent<SpriteRenderer>().color = brown;
        GameObject invisibleController = GameObject.FindGameObjectWithTag("Scene");
        invisibleController.gameObject.GetComponent<VanishingTextController>().appearText(subelementName);
    }

    void OnMouseExit()
    {
        GameObject selectedBand = this.transform.GetChild(0).gameObject;
        selectedBand.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        GameObject textBackground = this.transform.GetChild(1).gameObject;
        textBackground.gameObject.GetComponent<SpriteRenderer>().color = invisible;
        GameObject invisibleController = GameObject.FindGameObjectWithTag("Scene");
        invisibleController.gameObject.GetComponent<VanishingTextController>().disappearText(subelementName);
    }
}
