using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to handle Objects, like bookshelves or pictures
 * that the player can have a conversation with
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class ConversationObject : MonoBehaviour
{
    public ConversationNodeImpl conversationNode;

    public SecondaryElement element;

    private Vector3 position;

    private Transform adjacentTransform;

    private Vector3 belowPosition;

    private Vector3 abovePosition;

    private Vector3 leftPosition;

    private Vector3 rightPosition;

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

        position = this.transform.position;

    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetAxis("Submit") > GameState.buttonUpTolerance && GameState.isFrozen == false)
        {
            Vector3 belowPosition =
                new Vector3(position.x, position.y - GameState.tilesize, position.z);
            Vector3 abovePosition =
                new Vector3(position.x, position.y + GameState.tilesize, position.z);
            Vector3 leftPosition =
                new Vector3(position.x - GameState.tilesize, position.y, position.z);
            Vector3 rightPosition = new Vector3(position.x + GameState.tilesize, position.y, position.z);
            if ((belowPosition - adjacentTransform.position).sqrMagnitude <
            GameState.buttonUpTolerance)
            {
                Action();
            }
            else if ((abovePosition - adjacentTransform.position).sqrMagnitude < GameState.buttonUpTolerance)
            {
                Action();
            }
            else if ((rightPosition - adjacentTransform.position).sqrMagnitude < GameState.buttonUpTolerance)
            {
                Action();
            }
            else if ((leftPosition - adjacentTransform.position).sqrMagnitude < GameState.buttonUpTolerance)
            {
                Action();
            }
        }
    }

    public virtual void Action()
    {
        GameObject conversationController = GameObject.FindGameObjectWithTag("Conversation");
        conversationController.GetComponent<ConversationController>().Activate(conversationNode, element, null);
    }
}
