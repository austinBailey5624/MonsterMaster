using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainCharacterController : MonoBehaviour
{
    public Animator animator;
    public float speed;
    float travelLeft;
    float travelRight;
    float travelUp;
    float travelDown;
    bool facingLeft;



    void Start()
    {
        travelLeft = 0;
        travelRight = 0;
        travelUp = 0;
        travelDown = 0;
        facingLeft = false;
        string currentScene = SceneManager.GetActiveScene().name;
        if (GameState.playerPositionBySceneName.ContainsKey(currentScene))
        {
            transform.position = GameState.playerPositionBySceneName[currentScene];
        }
    }

    void Update()
    {
        float tileSize = 1f;
        Vector2 position = transform.position;
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        bool isMoving = false;
        if (travelLeft <= 0 && travelRight <= 0 && travelUp <= 0 && travelDown <= 0)
        {
            if (horizontal > 0.0f) //right
            {
                travelRight = tileSize;
                facingLeft = false;
            }
            else if (horizontal < 0.0f) //left
            {
                travelLeft = tileSize;
                facingLeft = true;
            }
            if (vertical > 0.0f)//Up
            {
                travelUp = tileSize;
                facingLeft = false;
            }
            else if (vertical < 0.0f)//down
            {
                travelDown = tileSize;
                facingLeft = false;
            }
        }
        bool movingLeft = false;
        bool movingRight = false;
        bool movingUp = false;
        bool movingDown = false;

        if(travelLeft > 0)
        {
            movingLeft = true;
            position.x = position.x - speed;
            travelLeft -= speed;
            isMoving = true;
        }
        else if(travelRight > 0)
        {
            movingRight = true;
            position.x = position.x + speed;
            travelRight -= speed;
            isMoving = true;
        }
        else if(travelUp > 0)
        {
            movingUp = true;
            position.y = position.y + speed;
            travelUp -= speed;
            isMoving = true;
        }
        else if(travelDown > 0)
        {
            movingDown = true;
            position.y = position.y - speed;
            travelDown -= speed;
            isMoving = true;
        }
        animator.SetBool("isMoving", isMoving);
        animator.SetBool("movingLeft",movingLeft);
        animator.SetBool("movingRight", movingRight);
        animator.SetBool("movingBack",movingUp);
        animator.SetBool("movingForwards", movingDown);
        if(facingLeft)
        {
            Vector3 characterScale = transform.localScale;
            characterScale.x = -1;
            transform.localScale = characterScale;
        }
        else
        {
            Vector3 characterScale = transform.localScale;
            characterScale.x = 1;
            transform.localScale = characterScale;
        }

  
        transform.position = position;

        if (Input.GetAxis("Cancel")>.1f)
        {
            string sceneName = SceneManager.GetActiveScene().name;
            GameState.previousSceneName = sceneName;
            GameState.playerPositionBySceneName[sceneName] = transform.position;
            SceneManager.LoadScene("PauseMenu");
        }
    }
}
