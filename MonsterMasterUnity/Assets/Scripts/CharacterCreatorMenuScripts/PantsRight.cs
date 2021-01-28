using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PantsRight : MonoBehaviour
{
    public AnimationSet jeansSet;

    public AnimationSet shortsSet;

    private Color darkBlue = new Color(.1f, .25f, .5f, 1f);

    private Color darkGrey = new Color(.2f, .2f, .2f, 1f);

    private Color brown = new Color(.2f, .1f, 0f, 1f);

    void OnMouseUp()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        AnimationSet curPantsSet = mainCharacter.pantsSet;

        if (curPantsSet.Equals(jeansSet))
        {
            mainCharacter.pantsSet = shortsSet;
        }
        else if (curPantsSet.Equals(shortsSet))
        {
            mainCharacter.pantsSet = jeansSet;
            Color pantColor =
                mainCharacter
                    .transform
                    .GetChild(3)
                    .GetComponent<SpriteRenderer>()
                    .color;
            if (ColorsEqual(darkBlue, pantColor))
            {
                mainCharacter.pantColor = brown;
            }
            else if (ColorsEqual(darkGrey, pantColor))
            {
                mainCharacter.pantColor = darkBlue;
            }
            else if (ColorsEqual(brown, pantColor))
            {
                mainCharacter.pantColor = darkGrey;
            }
            mainCharacter
                .transform
                .GetChild(3)
                .GetComponent<SpriteRenderer>()
                .color = mainCharacter.pantColor;
        }
        mainCharacter.setSprite(0, 3);
    }

    bool ColorsEqual(Color color1, Color color2)
    {
        float tolerance = .01f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) &&
        (Mathf.Abs(color1.g - color2.g) < tolerance) &&
        (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
