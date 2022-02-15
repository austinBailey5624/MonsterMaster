using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Interface to structure how general Conversation Choices will work from the Coversation module
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public interface IConversationChoice 
{
    //Flavor text is the short text giving the 'gist' of the full choice, not the full text
    string getFlavorText();

    //This is the full response of the choice
    string getFullText();

    //This method modifies the game State- elemental affinity, the state of the characters involved etc;
    void getEffect();

    //This determines if selecting this choice terminates the conversation
    bool getTerminatesConversation();

    //The next node in the conversation graph- returns null if the conversation is terminated
    ConversationNodeImpl getNextNode();
}
