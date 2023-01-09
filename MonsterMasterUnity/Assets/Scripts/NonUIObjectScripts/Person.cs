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

    public AnimationSet bodySet;

    public AnimationSet eyeWhitesSet;

    public AnimationSet irisSet;

    public AnimationSet pantsSet;

    public AnimationSet shirtSet;

    public AnimationSet hairStyleSet;

    public AnimationSet shoesSet;

    public AnimationSet facialHairSet;

    public Color bodyColor;

    public Color eyeWhitesColor;

    public Color irisColor;

    public Color pantColor;

    public Color shirtColor;

    public Color shoesColor;

    public Color hairStyleColor;

    private int spriteIndex = 0;

    private int updateSlowdown = 0;

    protected bool facingLeft = false;

    protected float characterScalex = 1.0f;

    protected void Start()
    {
        GameObject body = this.transform.GetChild(0).gameObject;
        body.gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.frontSprites[0];
        body.gameObject.GetComponent<SpriteRenderer>().color = bodyColor;

        GameObject eyeWhites = this.transform.GetChild(1).gameObject;
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.frontSprites[0];
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().color =
            eyeWhitesColor;

        GameObject iris = this.transform.GetChild(2).gameObject;
        iris.gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.frontSprites[0];
        iris.gameObject.GetComponent<SpriteRenderer>().color = irisColor;

        GameObject pants = this.transform.GetChild(3).gameObject;
        pants.gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.frontSprites[0];
        pants.gameObject.GetComponent<SpriteRenderer>().color = pantColor;

        GameObject shirt = this.transform.GetChild(4).gameObject;
        shirt.gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.frontSprites[0];
        shirt.gameObject.GetComponent<SpriteRenderer>().color = shirtColor;

        GameObject hairStyle = this.transform.GetChild(5).gameObject;
        hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.frontSprites[0];
        hairStyle.gameObject.GetComponent<SpriteRenderer>().color =
            hairStyleColor;

        GameObject shoes = this.transform.GetChild(6).gameObject;
        shoes.gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.frontSprites[0];
        shoes.gameObject.GetComponent<SpriteRenderer>().color = shoesColor;

        GameObject facialHair = this.transform.GetChild(7).gameObject;
        facialHair.gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.frontSprites[0];
        facialHair.gameObject.GetComponent<SpriteRenderer>().color =
            hairStyleColor;

        Vector3 characterScale = transform.localScale;
        characterScalex = characterScale.x;
    }

    void Update()
    {
        if (updateSlowdown == 600)
        {
            if (spriteIndex == 3)
            {
                spriteIndex = 0;
                // directionIndex = directionIndex == 3 ? 0 : directionIndex + 1;
            }
            else
            {
                spriteIndex++;
            }
            // setSprite (spriteIndex, directionIndex);

            updateSlowdown = 0;
        }
        updateSlowdown++;
    }

    public void setSprite(int spriteIndex, EDirection direction)
    {
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

/*        if (facingLeft)
        {
            Vector3 characterScale = transform.localScale;
            characterScale.x = -characterScalex;
            this.transform.localScale = characterScale;
        }
        else
        {
            Vector3 characterScale = transform.localScale;
            characterScale.x = characterScalex;
            this.transform.localScale = characterScale;
        }*/
    }

    private void flipBodyParts(bool facingLeft)
    {
        List<GameObject> bodyParts = new List<GameObject>(8);
        for(int i = 0; i< 8; i++)
        {
            bodyParts.Add(this.transform.GetChild(i).gameObject);
        }
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
        GameObject body = this.transform.GetChild(0).gameObject;
        GameObject eyeWhites = this.transform.GetChild(1).gameObject;
        GameObject iris = this.transform.GetChild(2).gameObject;
        GameObject pants = this.transform.GetChild(3).gameObject;
        GameObject shirt = this.transform.GetChild(4).gameObject;
        GameObject hairStyle = this.transform.GetChild(5).gameObject;
        GameObject shoes = this.transform.GetChild(6).gameObject;
        GameObject facialHair = this.transform.GetChild(7).gameObject;
        body.gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.frontSprites[spriteIndex];
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.frontSprites[spriteIndex];
        iris.gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.frontSprites[spriteIndex];
        pants.gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.frontSprites[spriteIndex];
        shirt.gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.frontSprites[spriteIndex];
        hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.frontSprites[spriteIndex];
        shoes.gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.frontSprites[spriteIndex];
        facialHair.gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.frontSprites[spriteIndex];
    }

    private void setRightSprite(int spriteIndex)
    {
        GameObject body = this.transform.GetChild(0).gameObject;
        GameObject eyeWhites = this.transform.GetChild(1).gameObject;
        GameObject iris = this.transform.GetChild(2).gameObject;
        GameObject pants = this.transform.GetChild(3).gameObject;
        GameObject shirt = this.transform.GetChild(4).gameObject;
        GameObject hairStyle = this.transform.GetChild(5).gameObject;
        GameObject shoes = this.transform.GetChild(6).gameObject;
        GameObject facialHair = this.transform.GetChild(7).gameObject;
        body.gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.rightSprites[spriteIndex];
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.rightSprites[spriteIndex];
        iris.gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.rightSprites[spriteIndex];
        pants.gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.rightSprites[spriteIndex];
        shirt.gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.rightSprites[spriteIndex];
        hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.rightSprites[spriteIndex];
        shoes.gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.rightSprites[spriteIndex];
        facialHair.gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.rightSprites[spriteIndex];
    }

    private void setLeftSprite(int spriteIndex)
    {
        GameObject body = this.transform.GetChild(0).gameObject;
        GameObject eyeWhites = this.transform.GetChild(1).gameObject;
        GameObject iris = this.transform.GetChild(2).gameObject;
        GameObject pants = this.transform.GetChild(3).gameObject;
        GameObject shirt = this.transform.GetChild(4).gameObject;
        GameObject hairStyle = this.transform.GetChild(5).gameObject;
        GameObject shoes = this.transform.GetChild(6).gameObject;
        GameObject facialHair = this.transform.GetChild(7).gameObject;
        body.gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.leftSprites[spriteIndex];
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.leftSprites[spriteIndex];
        iris.gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.leftSprites[spriteIndex];
        pants.gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.leftSprites[spriteIndex];
        shirt.gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.leftSprites[spriteIndex];
        hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.leftSprites[spriteIndex];
        shoes.gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.leftSprites[spriteIndex];
        facialHair.gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.leftSprites[spriteIndex];
    }

    private void setBackSprite(int spriteIndex)
    {
        GameObject body = this.transform.GetChild(0).gameObject;
        GameObject eyeWhites = this.transform.GetChild(1).gameObject;
        GameObject iris = this.transform.GetChild(2).gameObject;
        GameObject pants = this.transform.GetChild(3).gameObject;
        GameObject shirt = this.transform.GetChild(4).gameObject;
        GameObject hairStyle = this.transform.GetChild(5).gameObject;
        GameObject shoes = this.transform.GetChild(6).gameObject;
        GameObject facialHair = this.transform.GetChild(7).gameObject;
        body.gameObject.GetComponent<SpriteRenderer>().sprite =
            bodySet.backSprites[spriteIndex];
        eyeWhites.gameObject.GetComponent<SpriteRenderer>().sprite =
            eyeWhitesSet.backSprites[spriteIndex];
        iris.gameObject.GetComponent<SpriteRenderer>().sprite =
            irisSet.backSprites[spriteIndex];
        pants.gameObject.GetComponent<SpriteRenderer>().sprite =
            pantsSet.backSprites[spriteIndex];
        shirt.gameObject.GetComponent<SpriteRenderer>().sprite =
            shirtSet.backSprites[spriteIndex];
        hairStyle.gameObject.GetComponent<SpriteRenderer>().sprite =
            hairStyleSet.backSprites[spriteIndex];
        shoes.gameObject.GetComponent<SpriteRenderer>().sprite =
            shoesSet.backSprites[spriteIndex];
        facialHair.gameObject.GetComponent<SpriteRenderer>().sprite =
            facialHairSet.backSprites[spriteIndex];
    }
}
