using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to handle NonPlayerCharacters
*   Copyright 2022-2023 Austin Bailey All Rights Reserved
*/
public class NonPlayerCharacter : Person
{
    private float tolerance = 0.2f;

    private float tilesize = 1f;

    private Transform adjacentTransform;

    public ConversationNodeImpl conversationNode;

    public SecondaryElement element;

    public Sprite conversationPortrait;

    void Awake()
    {
        GameObject player = GameObject.FindGameObjectWithTag("Player");
        if (player == null)
        {
            return;
        }
        else
        {
            adjacentTransform = player.transform;
        }
    }

    new void Start()
    {
        initBodyParts();
        for (int i = 0; i < 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].frontSprites[0];
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().color =
                colors[i];
        }
    }

    void Update()
    {
        if (Input.GetAxis("Submit") > .1f && GameState.isFrozen == false)
        {
            
            Vector3 position = this.transform.position;
            Vector3 belowPosition =
                new Vector3(position.x, position.y - tilesize, position.z);
            Vector3 abovePosition =
                new Vector3(position.x, position.y + tilesize, position.z);
            Vector3 leftPosition =
                new Vector3(position.x - tilesize, position.y, position.z);
            Vector3 rightPosition = new Vector3(position.x + tilesize, position.y, position.z);
            if (
                (belowPosition - adjacentTransform.position).sqrMagnitude <
                tolerance
            )
            {
                setSprite(0, EDirection.Down);
                Action();
            }
            else if((abovePosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0, EDirection.Up);
                Action();
            }
            else if((rightPosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0,EDirection.Right);
                Action();
            }
            else if((leftPosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0,EDirection.Left);
                Action();
            }
        }
    }

    public virtual void Action()
    {
        GameObject conversationController = GameObject.FindGameObjectWithTag("Conversation");
        conversationController.GetComponent<ConversationController>().Activate(conversationNode, element, conversationPortrait);
    }
}
