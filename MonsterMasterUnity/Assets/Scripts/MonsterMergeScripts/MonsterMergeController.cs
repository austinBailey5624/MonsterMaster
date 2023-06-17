using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/**
 * Class to control the behavior of the Monster Merge GameObject
 * Copyright 2023 Austin Bailey All Rights Reserved
 * */
public class MonsterMergeController : MonoBehaviour
{
    public static MonsterMergeController monsterMergeController;

    private Color invisible = new Color(0f, 0f, 0f, 0f);

    private Color white = new Color(1f, 1f, 1f, 1f);

    private DesignColors colors;

    private GameObject mergedMonster;

    private GameObject father;

    private GameObject mother;

    private GameObject warningAtTop;

    private GameObject costPanel;

    private GameObject backButton;

    private GameObject mergeButton;

    private GameObject monster1;

    private GameObject monster2;

    private GameObject monster3;

    private GameObject monster4;

    private GameObject monster5;

    private GameObject monster6;

    private GameObject backButtonText;

    private GameObject mergeButtonText;

    private GameObject costText;

    private GameObject warningText;

    private List<GameObject> backgrounds;

    private List<GameObject> texts;

    private void Awake()
    {
        if(monsterMergeController == null)
        {
            monsterMergeController = this;
        }
        else
        {
            Destroy(this.gameObject);
            return;
        }
    }

    void Start()
    {
        mergedMonster = this.transform.GetChild(0).gameObject;
        father = this.transform.GetChild(1).gameObject;
        mother = this.transform.GetChild(2).gameObject;
        warningAtTop = this.transform.GetChild(3).gameObject;
        costPanel = this.transform.GetChild(4).gameObject;
        backButton = this.transform.GetChild(5).gameObject;
        mergeButton = this.transform.GetChild(6).gameObject;
        monster1 = this.transform.GetChild(7).gameObject;
        monster2 = this.transform.GetChild(8).gameObject;
        monster3 = this.transform.GetChild(9).gameObject;
        monster4 = this.transform.GetChild(10).gameObject;
        monster5 = this.transform.GetChild(11).gameObject;
        monster6 = this.transform.GetChild(12).gameObject;
        backButtonText = this.transform.GetChild(13).gameObject;
        mergeButtonText = this.transform.GetChild(14).gameObject;
        costText = this.transform.GetChild(15).gameObject;
        warningText = this.transform.GetChild(16).gameObject;

        backgrounds =
            new List<GameObject>()
            {
                mergedMonster,
                father,
                mother,
                warningAtTop,
                costPanel,
                backButton,
                mergeButton,
                monster1,
                monster2,
                monster3,
                monster4,
                monster5,
                monster6
            };
        texts =
            new List<GameObject>()
            {
                backButtonText,
                mergeButtonText,
                costText,
                warningText
            };
        for (int i = 0; i < backgrounds.Count; i++)
        {
            backgrounds[i].GetComponent<SpriteRenderer>().color = invisible;
        }
        for (int i = 0; i < texts.Count; i++)
        {
            texts[i].GetComponent<TMP_Text>().color = invisible;
        }
        
    }

    void Update()
    {
        
    }
}
