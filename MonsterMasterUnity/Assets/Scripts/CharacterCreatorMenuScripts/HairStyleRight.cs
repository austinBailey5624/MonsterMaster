using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HairStyleRight : MonoBehaviour
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
            mainCharacter.hairStyleSet = hairCroppedSet;
        }
        else if (mainCharacter.hairStyleSet.Equals(hairBaldingSet))
        {
            mainCharacter.hairStyleSet = tonsureSet;
        }
        else if (mainCharacter.hairStyleSet.Equals(hairCroppedSet))
        {
            mainCharacter.hairStyleSet = hairBaldingSet;
        }
        mainCharacter.setSprite(0, 3);
    }
}
