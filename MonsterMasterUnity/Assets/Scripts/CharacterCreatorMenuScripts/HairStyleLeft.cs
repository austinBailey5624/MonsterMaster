using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HairStyleLeft : MonoBehaviour
{
    public Sprite hairBalding;
    public Sprite hairCropped;
    public Sprite tonsure;

    void OnMouseUp()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");

        mainCharacter.GetComponent<Person>().hairStyleSprite = tonsure;
        GameObject hairStyle = mainCharacter.transform.GetChild(5).gameObject;
        if(hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite.Equals(tonsure))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite = hairBalding;
        }
        else if(hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite.Equals(hairBalding))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite = hairCropped;
        }
        else if(hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite.Equals(hairCropped))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite = tonsure;
        }
    }
}
