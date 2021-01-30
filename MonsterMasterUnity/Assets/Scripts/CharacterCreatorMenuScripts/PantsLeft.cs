using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PantsLeft : MonoBehaviour
{
    public Sprite pantsSprite;
    public Sprite shorts;
    private Color darkBlue = new Color(.1f, .25f, .5f, 1f);
    private Color darkGrey = new Color(.2f, .2f, .2f, 1f);
    private Color brown = new Color(.2f, .1f, 0f, 1f);


    void OnMouseUp()
    {
        GameObject mainCharacter = GameObject.FindGameObjectWithTag("Player");
        GameObject pants = mainCharacter.transform.GetChild(3).gameObject;
        Sprite curPants = pants.gameObject.GetComponent<SpriteRenderer>().sprite;
        Color curPantsColor =  pants.gameObject.GetComponent<SpriteRenderer>().color;

        if(curPants.Equals(pantsSprite))
        {
            pants.gameObject.GetComponent<SpriteRenderer>().sprite = shorts;
        }
        else if(curPants.Equals(shorts))
        {
            pants.gameObject.GetComponent<SpriteRenderer>().sprite = pantsSprite;
            if(ColorsEqual(curPantsColor, darkBlue))
            {
                pants.gameObject.GetComponent<SpriteRenderer>().color = darkGrey;
            }
            else if(ColorsEqual(curPantsColor, darkGrey))
            {
                pants.gameObject.GetComponent<SpriteRenderer>().color = brown;
            }
            else if(ColorsEqual(curPantsColor, brown))
            {
                pants.gameObject.GetComponent<SpriteRenderer>().color = darkBlue;
            }
        }
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .001f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) && (Mathf.Abs(color1.g - color2.g) < tolerance) && (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
