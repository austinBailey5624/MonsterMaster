using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to determine the behavior of the manaBar in the
 * Stats Bar Prefab. It will determine which mana bar 
 * sprite is appropriate to display given the values of the
 * min and max health
 * Copyright 2023 Austin Bailey All Rights Reserved.
 * TODO: update with gradual change visual effect
 */
public class ManaBar : MonoBehaviour
{
    [SerializeField]
    private int maxMp;
    [SerializeField]
    private int curMp;
    public List<Sprite> mpBars;
    public Sprite maxMpBar;

    void Start()
    {
        maxMp = 0;
        curMp = 0;
        updateMpDisplay();
    }

    void setMp(int mpMax, int mpCur)
    {
        maxMp = mpMax;
        curMp = mpCur;
        updateMpDisplay();
    }

    //TODO: Remove after testing 
    void Update()
    {
        updateMpDisplay();
    }

    private void updateMpDisplay()
    {
        if(maxMp <=0 || curMp <=0)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = mpBars[0];
            return;
        }
        if(curMp >= maxMp)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = maxMpBar;
            return;
        }
        int index = (int)((float)mpBars.Count * ((float)curMp / (float)maxMp));
        this.gameObject.GetComponent<SpriteRenderer>().sprite = mpBars[index];
    }
}
