using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to determine the behavior of the healthbar in the 
 * Status Bar Prefab. It will determine which health bar 
 * 'sprite' is appropriate to display given the values
 * of the min and max health.
 * Copyright 2023 Austin Bailey All Rights Reserved.
 * TODO: update with gradual change in hp for visual effect
 */
public class HeathBar : MonoBehaviour
{
    [SerializeField]
    private int maxHp;
    [SerializeField]
    private int curHp;
    public List<Sprite> hpBars;
    public Sprite maxHpBar;

    void Start()
    {
        maxHp = 0;
        curHp = 0;
        updateHpDisplay();
    }

    void setHP(int hpMax, int hpCur)
    {
        maxHp = hpMax;
        curHp = hpCur;
        updateHpDisplay();
    }

    public void damage(int damage)
    {
        curHp -= damage;
        updateHpDisplay();
    }

    public bool isKOed()
    {
        return curHp <= 0;
    }

    public void Update()
    {
        updateHpDisplay();
    }

    private void updateHpDisplay()
    {
        if(maxHp <=0 || curHp <=0)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = hpBars[0];
            return;
        }
        if(curHp >= maxHp)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = maxHpBar;
            return;
        }
        Debug.Log("Count: " + hpBars.Count);
        int index = (int)((float)hpBars.Count * ((float)curHp / (float)maxHp));
        Debug.Log("cur/max" + (curHp / maxHp));
        Debug.Log("Index: " + index);
        this.gameObject.GetComponent<SpriteRenderer>().sprite = hpBars[index];
    }
}
