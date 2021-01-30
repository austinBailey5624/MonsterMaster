using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ShirtRight : MonoBehaviour
{
    public Sprite tshirt;
    public Sprite tanktop;
    public Sprite longSleeve;
    public Sprite robe;
    private Color darkGreen = new Color(0f, .3f, 0f, 1f);
    private Color lightGrey = new Color(.8f, .8f, .8f, 1f);
    private Color darkGrey = new Color(.2f, .2f, .2f, 1f);
    private Color brown = new Color(.2f, .1f, 0f, 1f);
    private Color red = new Color(.8f, 0f, 0f, 1f);


    void OnMouseUp()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        GameObject shirt = mainCharacter.transform.GetChild(4).gameObject;
        Sprite curShirtSprite = shirt.gameObject.GetComponent<SpriteRenderer>().sprite;
        Color curShirtColor = shirt.gameObject.GetComponent<SpriteRenderer>().color;
        if (curShirtSprite.Equals(tshirt))
        {
            shirt.gameObject.GetComponent<SpriteRenderer>().sprite = robe; 
            if (ColorsEqual(curShirtColor, darkGreen))
            {
                shirt.gameObject.GetComponent<SpriteRenderer>().color = red;
            }
            else if (ColorsEqual(curShirtColor, lightGrey))
            {
                shirt.gameObject.GetComponent<SpriteRenderer>().color = darkGreen;
            }
            else if (ColorsEqual(curShirtColor, darkGrey))
            {
                shirt.gameObject.GetComponent<SpriteRenderer>().color = lightGrey;
            }
            else if (ColorsEqual(curShirtColor, brown))
            {
                shirt.gameObject.GetComponent<SpriteRenderer>().color = darkGrey;
            }
            else if (ColorsEqual(curShirtColor, red))
            {
                shirt.gameObject.GetComponent<SpriteRenderer>().color = brown;
            }

        }
        else if (curShirtSprite.Equals(tanktop))
        {
            shirt.gameObject.GetComponent<SpriteRenderer>().sprite = tshirt;
        }
        else if (curShirtSprite.Equals(longSleeve))
        {
            shirt.gameObject.GetComponent<SpriteRenderer>().sprite = tanktop;
        }
        else if (curShirtSprite.Equals(robe))
        {
            shirt.gameObject.GetComponent<SpriteRenderer>().sprite = longSleeve;
        }
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .001f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) && (Mathf.Abs(color1.g - color2.g) < tolerance) && (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
