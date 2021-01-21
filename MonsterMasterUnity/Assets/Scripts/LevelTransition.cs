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
        //if(transform.position.x == adjacentTransform.position.x && transform.position.y == adjacentTransform.position.y && Input.GetMouseButtonDown(0))
        if((transform.position - adjacentTransform.position).sqrMagnitude < 0.1f && Input.GetMouseButtonDown(0))
        {
            SceneManager.LoadScene(nextSceneName);
        }
        if(Input.GetMouseButtonDown(0))
        {
            Debug.Log("ourPosition:" + transform.position + "  theirPosition:" + adjacentTransform.position + "  equals" + (transform.position.x.Equals(adjacentTransform.position.x)));
            
        }
    }
}
