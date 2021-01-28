using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PantsLeft : MonoBehaviour
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

        if (curPantsSet.Equals(shortsSet))
        {
            mainCharacter.pantsSet = jeansSet;
        }
        else if (curPantsSet.Equals(jeansSet))
        {
            mainCharacter.pantsSet = shortsSet;
            if (ColorsEqual(darkBlue, mainCharacter.pantColor))
            {
                mainCharacter.pantColor = darkGrey;
            }
            else if (ColorsEqual(darkGrey, mainCharacter.pantColor))
            {
                mainCharacter.pantColor = brown;
            }
            else if (ColorsEqual(brown, mainCharacter.pantColor))
            {
                mainCharacter.pantColor = darkBlue;
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
        float tolerance = .001f;
        return (Mathf.Abs(color1.r - color2.r) < tolerance) &&
        (Mathf.Abs(color1.g - color2.g) < tolerance) &&
        (Mathf.Abs(color1.b - color2.b) < tolerance);
    }
}
