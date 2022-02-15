using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to control the behavior of the initial conversation with Michael
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class MichaelNode0 : ConversationNodeImpl
{

    public override string getConversationText()
    {
        return GameState.mainCharacterName + ", I haven't seen you in church lately, is aught amiss?";
    }
}
