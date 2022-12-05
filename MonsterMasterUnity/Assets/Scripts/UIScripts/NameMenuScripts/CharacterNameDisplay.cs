using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the behavior of the Character name display
 * in the name Character Menu
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class CharacterNameDisplay : MonoBehaviour
{
    // Update is called once per frame
    void Update()
    {
        GameObject text = this.transform.GetChild(0).gameObject;
        text.gameObject.GetComponent<TMP_Text>().text = GameState.mainCharacterName;
    }
}
