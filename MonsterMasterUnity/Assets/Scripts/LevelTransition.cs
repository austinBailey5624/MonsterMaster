using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class LevelTransition : MonoBehaviour
{
    public Transform adjacentTransform;
    public string nextSceneName;

    void Update()
    {
        if((transform.position - adjacentTransform.position).sqrMagnitude < 0.1f && Input.GetAxis("Submit") > .1f)
        {
            string sceneName = SceneManager.GetActiveScene().name;
            GameState.previousSceneName = sceneName;
            GameState.playerPositionBySceneName[sceneName] = transform.position;
            SceneManager.LoadScene(nextSceneName);
        }
    }
}
