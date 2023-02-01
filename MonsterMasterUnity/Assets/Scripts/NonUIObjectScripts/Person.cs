using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static EDirection;

/**
*   Class to handle behaviors common to all people to avoid rewriting code
*   Copyright 2022-2023 Austin Bailey All Rights Reserved
*/
public class Person : MonoBehaviour, ITraversalActor
{
    public bool isMale;

    public List<AnimationSet> animationSets;

    public List<Color> colors;

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
        for(int i = 0; i < 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].frontSprites[0];
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().color =
                colors[i];
        }
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
                if (animationSets[0].leftIsRightReversed)
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
        for(int i = 0; i < 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].frontSprites[spriteIndex];
        }
    }

    private void setRightSprite(int spriteIndex)
    {
        for(int i = 0; i< 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].rightSprites[spriteIndex];
        }
    }

    private void setLeftSprite(int spriteIndex)
    {
        for (int i = 0; i < 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].leftSprites[spriteIndex];
        }
    }

    private void setBackSprite(int spriteIndex)
    {
        for (int i = 0; i < 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].backSprites[spriteIndex];
        }
    }
}
