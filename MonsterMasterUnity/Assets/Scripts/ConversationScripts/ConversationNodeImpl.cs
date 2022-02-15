using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*    Implementation Class of IConversationNode
*    Copyright 2022 Austin Bailey All Rights Reserved
*/
public class ConversationNodeImpl : MonoBehaviour, IConversationNode
{
    public List<ConversationChoiceImpl> conversationChoices;

    public string conversationText;

    public List<ConversationChoiceImpl> getConversationChoices()
    {
        return conversationChoices;
    }

    public virtual string getConversationText()
    {
        return conversationText;
    }
}
