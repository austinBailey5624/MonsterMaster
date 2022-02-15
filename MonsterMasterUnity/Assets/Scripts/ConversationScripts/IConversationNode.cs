using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Interface to guide the constructions of ConversationNodes
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public interface IConversationNode 
{
    //The choices the player can make that will direct them to the next node of the conversation
    List<ConversationChoiceImpl> getConversationChoices();

    //The text of what the character says
    string getConversationText();
}
