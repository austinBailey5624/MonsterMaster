using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenuNewGameController : ButtonController
{
    public string nextSceneName;

    // Update is called once per frame
    void OnMouseUp()
    {
        SceneManager.LoadScene(nextSceneName);
    }
}
