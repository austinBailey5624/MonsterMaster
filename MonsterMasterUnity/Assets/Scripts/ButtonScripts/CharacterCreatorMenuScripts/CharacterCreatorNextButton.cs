using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

/**
*   Class to control the behavior of the next button in the character creator scene
*   Copyright 2022 Austin Bailey
*/
public class CharacterCreatorNextButton : CharacterCreatorMenuButton
{
    public string nextSceneName;

    public override void actionWhenSelected()
    {
        string tempPrevPlace = GameState.previousPlaceName;
        string tempPrevMenu = GameState.previousMenuName;
        string activeSceneName = SceneManager.GetActiveScene().name;
        if (activeSceneName.Contains("Menu") || activeSceneName.Contains("menu")
        )
        {
            GameState.previousMenuName = activeSceneName;
        }
        else
        {
            GameState.previousPlaceName = activeSceneName;
        }

        if (nextSceneName.Equals("previousPlace"))
        {
            SceneManager.LoadScene (tempPrevPlace);
        }
        else if (nextSceneName.Equals("previousMenu"))
        {
            SceneManager.LoadScene (tempPrevMenu);
        }
        else if (nextSceneName.Length > 1)
        {
            SceneManager.LoadScene (nextSceneName);
        }
    }
}
