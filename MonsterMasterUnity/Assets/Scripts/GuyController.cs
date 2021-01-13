using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class GuyController : MonoBehaviour
{
    public Animator animator;
    float travelLeft;
    float travelRight;
    float travelUp;
    float travelDown;

    void Start()
    {
        travelLeft = 0;
        travelRight = 0;
        travelUp = 0;
        travelDown = 0;
    }

    void Update()
    {
        float tileSize = 1f;
        Vector2 position = transform.position;
        float speed = .003f;
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        bool isMoving = false;
        if (travelLeft <= 0 && travelRight <= 0 && travelUp <= 0 && travelDown <= 0)
        {
            if (horizontal > 0.0f) //right
            {
                travelRight = tileSize;
            }
            else if (horizontal < 0.0f) //left
            {
                travelLeft = tileSize;
            }
            if (vertical > 0.0f)//Up
            {
                travelUp = tileSize;
            }
            else if (vertical < 0.0f)//down
            {
                travelDown = tileSize;
            }
        }

        if(travelLeft >0)
        {
            position.x = position.x - speed;
            travelLeft -= speed;
            isMoving = true;
        }
        else if(travelRight > 0)
        {
            position.x = position.x + speed;
            travelRight -= speed;
            isMoving = true;
        }
        else if(travelUp > 0)
        {
            position.y = position.y + speed;
            travelUp -= speed;
            isMoving = true;
        }
        else if(travelDown > 0)
        {
            position.y = position.y - speed;
            travelDown -= speed;
            isMoving = true;
        }
        animator.SetBool("movingLeft",travelLeft > 0);
        animator.SetBool("movingRight", travelRight > 0);
        animator.SetBool("movingBack",travelUp > 0);
        animator.SetBool("movingForwards", travelDown > 0);
        animator.SetBool("speedIsZero", !isMoving);
  
        transform.position = position;
    }
}
