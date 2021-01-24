using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ButtonSceneTransition : ButtonController
{
    public string nextSceneName;

    void OnMouseUp()
    {
        SceneManager.LoadScene(nextSceneName);
    }
}
