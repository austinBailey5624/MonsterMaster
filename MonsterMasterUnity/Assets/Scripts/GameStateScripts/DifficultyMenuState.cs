using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DifficultyMenuState : MonoBehaviour
{
    public static DifficultyMenuState menuState;
    public static DifficultyState.EDifficultyType selectedDifficultyType = DifficultyState.EDifficultyType.Permadeath;

    private void Awake()
    {
        if(menuState == null)
        {
            menuState = this;
        }
        else
        {
            Destroy(this.gameObject);
        }
    }
}
