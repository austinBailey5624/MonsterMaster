using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HairColorLeft : MonoBehaviour
{
    private Color redHead = new Color(1f , 74  / 255f, 0f, 1f);
    private Color blonde = new Color(1f, 204f / 255f, 0f, 1f);
    private Color lightBrown = new Color(191f / 255f, 100f / 255f, 0f, 1f);
    private Color brown = new Color(152f / 255f, 78f / 255f, 0f, 1f);
    private Color darkBrown = new Color(94f / 255f, 48f / 255f, 0f, 1f);
    private Color black = new Color(20f / 255f, 20f / 255f, 20f / 255f, 1f);
    private Color charcoal = new Color(82f / 255f, 82f / 255f, 82f / 255f / 1f);
    private Color greying = new Color(162f / 255f, 162f / 255f, 162f / 255f, 1f);
    private Color white = new Color(227f / 255f, 227f / 255f, 227f / 255f, 1f);
    private Color blue = new Color(0f, 139f / 255f, 1f, 1f);
    private Color green = new Color(60f / 255f, 1f, 65f / 255f, 1f);


    void OnMouseUp()
    {

        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        GameObject hairStyle = mainCharacter.transform.GetChild(5).gameObject;
        Color curHairColor = hairStyle.gameObject.GetComponent<SpriteRenderer>().color;
        if (ColorsEqual(curHairColor, redHead))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = blonde;
        }
        else if(ColorsEqual(curHairColor,blonde))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = lightBrown;
        }
        else if(ColorsEqual(curHairColor, lightBrown))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = brown;
        }
        else if(ColorsEqual(curHairColor, brown))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = darkBrown;
        }
        else if(ColorsEqual(curHairColor, darkBrown))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = black;
        }
        else if(ColorsEqual(curHairColor, black))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = charcoal;
        }
        else if(ColorsEqual(curHairColor, charcoal))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = greying;
        }
        else if(ColorsEqual(curHairColor, greying))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = white;
        }
        else if(ColorsEqual(curHairColor, white))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = blue;
        }
        else if(ColorsEqual(curHairColor, blue))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = green;
        }
        else if(ColorsEqual(curHairColor, green))
        {
            hairStyle.gameObject.GetComponent<SpriteRenderer>().color = redHead;
        }
        GameObject facialHair = mainCharacter.transform.GetChild(6).gameObject;
        facialHair.gameObject.GetComponent<SpriteRenderer>().color = hairStyle.gameObject.GetComponent<SpriteRenderer>().color;
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .001f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) && (Mathf.Abs(color1.g - color2.g) < tolerance) && (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
