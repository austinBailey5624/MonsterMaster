using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class LevelTransition : MonoBehaviour
{
    public Transform adjacentTransform;
    public string nextSceneName;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if((transform.position - adjacentTransform.position).sqrMagnitude < 0.1f && Input.GetAxis("Select") > .1f)
        {
            SceneManager.LoadScene(nextSceneName);
        }


    }
}
