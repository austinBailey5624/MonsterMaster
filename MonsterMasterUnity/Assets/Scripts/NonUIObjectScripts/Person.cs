using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to handle behaviors common to all people to avoid rewriting code
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public class Person : MonoBehaviour, ITraversalActor
{
    public bool isMale;

    //TODO: Refactor AnimationSets to List
    public AnimationSet bodySet;

    public AnimationSet eyeWhitesSet;

    public AnimationSet irisSet;

    public AnimationSet pantsSet;

    public AnimationSet shirtSet;

    public AnimationSet hairStyleSet;

    public AnimationSet shoesSet;

    public AnimationSet facialHairSet;

    //TODO: refactor Colors to List
    public Color bodyColor;

    public Color eyeWhitesColor;

    public Color irisColor;

    public Color pantColor;

    public Color shirtColor;

    public Color shoesColor;

    public Color hairStyleColor;

    private int spriteIndex = 0;

    private int updateSlowdown = 0;

    /**
     * Note for indexes of bodyParts:
     * 0: Body (blank body)
     * 1: EyeWhites
     * 2: Iris
     * 3: Pants
     * 4: Shirt
     * 5: HairStyle
     * 6: Shoes
     * 7: Facial hair / makeup
     */
    protected List<GameObject> bodyParts;

    protected bool facingLeft = false;

    protected void Start()
    {
        initBodyParts();
        bodyParts[0].gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.frontSprites[0];
        bodyParts[0].gameObject.GetComponent<SpriteRenderer>().color = bodyColor;
        bodyParts[1].gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.frontSprites[0];
        bodyParts[1].gameObject.GetComponent<SpriteRenderer>().color =
            eyeWhitesColor;
        bodyParts[2].gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.frontSprites[0];
        bodyParts[2].gameObject.GetComponent<SpriteRenderer>().color = irisColor;
        bodyParts[3].gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.frontSprites[0];
        bodyParts[3].gameObject.GetComponent<SpriteRenderer>().color = pantColor;
        bodyParts[4].gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.frontSprites[0];
        bodyParts[4].gameObject.GetComponent<SpriteRenderer>().color = shirtColor;
        bodyParts[5].gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.frontSprites[0];
        bodyParts[5].gameObject.GetComponent<SpriteRenderer>().color =
            hairStyleColor;
        bodyParts[6].gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.frontSprites[0];
        bodyParts[6].gameObject.GetComponent<SpriteRenderer>().color = shoesColor;
        bodyParts[7].gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.frontSprites[0];
        bodyParts[7].gameObject.GetComponent<SpriteRenderer>().color =
            hairStyleColor;
    }

    protected void initBodyParts()
    {
        if(bodyParts != null)
        {
            return;
        }
        bodyParts = new List<GameObject>();

        for (int i = 0; i < 8; i++)
        {
            bodyParts.Add(this.transform.GetChild(i).gameObject);
        }

    }

    void Update()
    {
        if (updateSlowdown == 600)
        {
            if (spriteIndex == 3)
            {
                spriteIndex = 0;
            }
            else
            {
                spriteIndex++;
            }
            updateSlowdown = 0;
        }
        updateSlowdown++;
    }

    public void setSprite(int spriteIndex, EDirection direction)
    {
        initBodyParts();
        facingLeft = false;
        switch (direction)
        {
            case EDirection.Up: 
                setBackSprite (spriteIndex);
                break;
            case EDirection.Right: 
                setRightSprite (spriteIndex);
                break;
            case EDirection.Left:
                if (bodySet.leftIsRightReversed)
                {
                    //Since Left is Right Reversed, we set right and then flip later
                    setRightSprite (spriteIndex);
                    facingLeft = true;
                }
                else
                {
                    setLeftSprite (spriteIndex);
                }
                break;
            case EDirection.Down: 
                setFrontSprite (spriteIndex);
                break;
            default:
                setFrontSprite (spriteIndex);
                break;
        }
        flipBodyParts(facingLeft);
    }

    private void flipBodyParts(bool facingLeft)
    {
        for (int i = 0; i < bodyParts.Count; i++)
        {
            Vector3 characterScale = bodyParts[i].transform.localScale;
            if(facingLeft)
            {
                if(characterScale.x > 0)
                {
                    characterScale.x *= -1;
                }
            }
            else //facing Right
            {
                if(characterScale.x < 0)
                {
                    characterScale.x *= -1;
                }
            }
            bodyParts[i].transform.localScale = characterScale;
        }
    }

    private void setFrontSprite(int spriteIndex)
    {
        bodyParts[0].gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.frontSprites[spriteIndex];
        bodyParts[1].gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.frontSprites[spriteIndex];
        bodyParts[2].gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.frontSprites[spriteIndex];
        bodyParts[3].gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.frontSprites[spriteIndex];
        bodyParts[4].gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.frontSprites[spriteIndex];
        bodyParts[5].gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.frontSprites[spriteIndex];
        bodyParts[6].gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.frontSprites[spriteIndex];
        bodyParts[7].gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.frontSprites[spriteIndex];
    }

    private void setRightSprite(int spriteIndex)
    {
        bodyParts[0].gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.rightSprites[spriteIndex];
        bodyParts[1].gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.rightSprites[spriteIndex];
        bodyParts[2].gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.rightSprites[spriteIndex];
        bodyParts[3].gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.rightSprites[spriteIndex];
        bodyParts[4].gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.rightSprites[spriteIndex];
        bodyParts[5].gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.rightSprites[spriteIndex];
        bodyParts[6].gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.rightSprites[spriteIndex];
        bodyParts[7].gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.rightSprites[spriteIndex];
    }

    private void setLeftSprite(int spriteIndex)
    {
        bodyParts[0].gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.leftSprites[spriteIndex];
        bodyParts[1].gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.leftSprites[spriteIndex];
        bodyParts[2].gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.leftSprites[spriteIndex];
        bodyParts[3].gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.leftSprites[spriteIndex];
        bodyParts[4].gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.leftSprites[spriteIndex];
        bodyParts[5].gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.leftSprites[spriteIndex];
        bodyParts[6].gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.leftSprites[spriteIndex];
        bodyParts[7].gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.leftSprites[spriteIndex];
    }

    private void setBackSprite(int spriteIndex)
    {
        bodyParts[0].gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.backSprites[spriteIndex];
        bodyParts[1].gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.backSprites[spriteIndex];
        bodyParts[2].gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.backSprites[spriteIndex];
        bodyParts[3].gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.backSprites[spriteIndex];
        bodyParts[4].gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.backSprites[spriteIndex];
        bodyParts[5].gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.backSprites[spriteIndex];
        bodyParts[6].gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.backSprites[spriteIndex];
        bodyParts[7].gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.backSprites[spriteIndex];
    }
}
