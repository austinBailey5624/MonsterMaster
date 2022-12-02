using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;

/**
*   Class to control the behavior of the MonsterView component in the BestiaryMonsterTypeMenu
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class BestiaryMonsterViewController : MonoBehaviour
{
    public static int maxTime = 150;

    private int spriteIndex = 0;

    private Color white = new Color(1f, 1f, 1f, 1f);

    private int curTime = 0;

    private List<Sprite> spritesToDisplay;

    public MonsterType monsterType;

    private GameObject monsterSprite;

    void cycleSprite()
    {
        if (spriteIndex >= spritesToDisplay.Count - 1)
        {
            spriteIndex = 0;
        }
        else
        {
            spriteIndex++;
        }

        monsterSprite.GetComponent<SpriteRenderer>().sprite =
            spritesToDisplay[spriteIndex];
    }

    void Start()
    {
        monsterSprite = this.transform.GetChild(0).gameObject;
    }

    public void activate()
    {
        monsterSprite = this.transform.GetChild(0).gameObject;
        if (monsterType.idleSprites.Any())
        {
            monsterSprite.gameObject.transform.localScale = new Vector3(1,1,1);
        }
        else
        {
            monsterSprite.gameObject.transform.localScale = new Vector3(8,8,1);
        }
        spritesToDisplay = monsterType.getIdleSprites();
    }

    void Update()
    {
        if (curTime >= maxTime)
        {
            cycleSprite();
            curTime = 0;
        }
        curTime++;
    }
}
