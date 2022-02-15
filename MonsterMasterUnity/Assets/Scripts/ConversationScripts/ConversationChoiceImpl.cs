using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Implementation of IConversationChoice
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class ConversationChoiceImpl : MonoBehaviour, IConversationChoice
{
    public string flavorText;

    public string fullText;

    public bool terminatesConversation;

    public ConversationNodeImpl nextNode;

    public string getFlavorText()
    {
        return flavorText;
    }

    public string getFullText()
    {
        return fullText;
    }

    public virtual void getEffect()
    {
        return;
    }

    public bool getTerminatesConversation()
    {
        return terminatesConversation;
    }

    public ConversationNodeImpl getNextNode()
    {
        return nextNode;
    }
}
