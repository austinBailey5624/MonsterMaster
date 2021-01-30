using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Person : MonoBehaviour
{
    public bool isMale;
    public Sprite bodySprite;
    public Sprite eyeWhitesSprite;
    public Sprite irisSprite;
    public Sprite pantSprite;
    public Sprite shirtSprite;
    public Sprite shoesSprite;
    public Sprite hairStyleSprite;
    public Sprite facialHairSprite;
    public Color bodyColor;
    public Color eyeWhitesColor;
    public Color irisColor;
    public Color pantColor;
    public Color shirtColor;
    public Color shoesColor;
    public Color hairStyleColor;
    public string subjectPronoun;
    public string objectPronoun;
    public string possesivePronoun;

    void Start()
    {
        GameObject body = this.transform.GetChild(0).gameObject;
        body.gameObject.GetComponent<SpriteRenderer>().sprite = bodySprite;
        body.gameObject.GetComponent<SpriteRenderer>().color = bodyColor;
        GameObject eyeWhites = this.transform.GetChild(1).gameObject;
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().sprite = eyeWhitesSprite;
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().color = eyeWhitesColor;
        GameObject iris = this.transform.GetChild(2).gameObject;
        iris.gameObject.GetComponent<SpriteRenderer>().sprite = irisSprite;
        iris.gameObject.GetComponent<SpriteRenderer>().color = irisColor;
        GameObject pants = this.transform.GetChild(3).gameObject;
        pants.gameObject.GetComponent<SpriteRenderer>().sprite = pantSprite;
        pants.gameObject.GetComponent<SpriteRenderer>().color = pantColor;
        GameObject shirt = this.transform.GetChild(4).gameObject;
        shirt.gameObject.GetComponent<SpriteRenderer>().sprite = shirtSprite;
        shirt.gameObject.GetComponent<SpriteRenderer>().color = shirtColor;
        GameObject hairStyle = this.transform.GetChild(5).gameObject;
        hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite = hairStyleSprite;
        hairStyle.gameObject.GetComponent<SpriteRenderer>().color = hairStyleColor;
        GameObject facialHair = this.transform.GetChild(6).gameObject;
        facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = facialHairSprite;
        facialHair.gameObject.GetComponent<SpriteRenderer>().color = hairStyleColor;
    }

    void Update()
    {

    }
}
