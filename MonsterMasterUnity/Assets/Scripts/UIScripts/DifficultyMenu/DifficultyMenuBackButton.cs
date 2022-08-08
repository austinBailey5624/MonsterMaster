using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class DifficultyMenuBackButton : DifficultyMenuButton
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
            SceneManager.LoadScene(tempPrevPlace);
        }
        else if (nextSceneName.Equals("previousMenu"))
        {
            SceneManager.LoadScene(tempPrevMenu);
        }
        else if (nextSceneName.Length > 1)
        {
            SceneManager.LoadScene(nextSceneName);
        }
    }

    public override void select()
    {
        this.isSelected = true;
    }

    public override void unSelect()
    {
        this.isSelected = false;
        this.isActive = false;
    }

    public override void activate()
    {
        this.isActive = true;
    }
}
