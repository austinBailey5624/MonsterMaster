using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FacialRight : MonoBehaviour
{
    public Sprite fiveShadow;
    public Sprite fullBeard;
    public Sprite goatee;
    public Sprite moustache;
    public Sprite peachFuzz;
    public Sprite trampBeard;
    public Sprite wraparound;

    void OnMouseUp()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        GameObject facialHair = mainCharacter.transform.GetChild(6).gameObject;
        GameObject hairStyle = mainCharacter.transform.GetChild(5).gameObject;
        Color hairColor = hairStyle.gameObject.GetComponent<SpriteRenderer>().color;
        Sprite facial = facialHair.gameObject.GetComponent<SpriteRenderer>().sprite;

        if (facial == null)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = wraparound;
        }
        else if (facial == fiveShadow)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = null;
        }
        else if (facial == fullBeard)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = fiveShadow;
        }
        else if (facial == goatee)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = fullBeard;
        }
        else if (facial == moustache)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = goatee;
        }
        else if (facial == peachFuzz)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = moustache;
        }
        else if (facial == trampBeard)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = peachFuzz;
        }
        else if (facial == wraparound)
        {
            facialHair.gameObject.GetComponent<SpriteRenderer>().sprite = trampBeard;
        }

        facialHair.gameObject.GetComponent<SpriteRenderer>().color = hairColor;
    }
}
