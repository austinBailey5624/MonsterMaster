using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ButtonSceneTransition : ButtonController
{
    public string nextSceneName;

    void OnMouseUp()
    {
        string gotoSceneName = GameState.previousSceneName;
        GameState.previousSceneName = SceneManager.GetActiveScene().name;
        if (nextSceneName.Equals("previousScene"))
        {
            SceneManager.LoadScene(gotoSceneName);
        }
        else if (nextSceneName.Length > 1)
        {
            SceneManager.LoadScene(nextSceneName);
        }
    }
}
