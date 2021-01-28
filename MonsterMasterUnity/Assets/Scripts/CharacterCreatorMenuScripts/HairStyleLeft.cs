using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HairStyleLeft : MonoBehaviour
{
    public AnimationSet hairBaldingSet;

    public AnimationSet hairCroppedSet;

    public AnimationSet tonsureSet;

    void OnMouseUp()
    {
        MainCharacterController mainCharacter =
            GameObject
                .FindGameObjectWithTag("Player")
                .GetComponent<MainCharacterController>();
        GameObject hairStyle = mainCharacter.transform.GetChild(5).gameObject;
        if (mainCharacter.hairStyleSet.Equals(tonsureSet))
        {
            mainCharacter.hairStyleSet = hairBaldingSet;
        }
        else if (mainCharacter.hairStyleSet.Equals(hairBaldingSet))
        {
            mainCharacter.hairStyleSet = hairCroppedSet;
        }
        else if (mainCharacter.hairStyleSet.Equals(hairCroppedSet))
        {
            mainCharacter.hairStyleSet = tonsureSet;
        }
        mainCharacter.setSprite(0, 3);
    }
}
