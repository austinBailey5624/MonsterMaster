using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SkinToneRight : MonoBehaviour
{
    private Color skinTone1 = new Color(1f, 208f / 255f, 169f / 255f, 1f);
    private Color skinTone2 = new Color(1f, 187f / 255f, 124f / 255f, 1f);
    private Color skinTone3 = new Color(1f, 158f / 255f, 122f / 255f, 1f);
    private Color skinTone4 = new Color(186f / 255f, 124f / 255f, 66f / 255f, 1f);
    private Color skinTone5 = new Color(140f / 255f, 82f / 255f, 27f / 255f, 1f);
    private Color skinTone6 = new Color(97f / 255f, 56f / 255f, 18f / 255f, 1f);


    void OnMouseUp()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        GameObject body = mainCharacter.transform.GetChild(0).gameObject;
        Color bodyColor = body.gameObject.GetComponent<SpriteRenderer>().color;
        if (ColorsEqual(bodyColor, skinTone1))
        {
            body.gameObject.GetComponent<SpriteRenderer>().color = skinTone6;
        }
        else if (ColorsEqual(bodyColor, skinTone2))
        {
            body.gameObject.GetComponent<SpriteRenderer>().color = skinTone1;
        }
        else if (ColorsEqual(bodyColor, skinTone3))
        {
            body.gameObject.GetComponent<SpriteRenderer>().color = skinTone2;
        }
        else if (ColorsEqual(bodyColor, skinTone4))
        {
            body.gameObject.GetComponent<SpriteRenderer>().color = skinTone3;
        }
        else if (ColorsEqual(bodyColor, skinTone5))
        {
            body.gameObject.GetComponent<SpriteRenderer>().color = skinTone4;
        }
        else if (ColorsEqual(bodyColor, skinTone6))
        {
            body.gameObject.GetComponent<SpriteRenderer>().color = skinTone5;
        }
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .001f;
        Debug.Log("Color1:" + color1.r + " " + color1.g + " " + color1.b);
        Debug.Log("Color2:" + color2.r + " " + color2.g + " " + color2.b);
        Debug.Log("Equals:" + ((color1.r - color2.r < tolerance) && (color1.g - color2.g < tolerance) && (color1.b - color2.b < tolerance)));

        return (Mathf.Abs(color1.r - color2.r) < tolerance) && (Mathf.Abs(color1.g - color2.g) < tolerance) && (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
