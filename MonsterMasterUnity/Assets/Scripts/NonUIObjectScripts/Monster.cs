using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Monster : MonoBehaviour, ITraversalActor
{
    public MonsterType monsterType;

    protected float characterScalex = .275f;

    public void setSprite(int spriteIndex, EDirection direction)
    {
        if(monsterType == null)
        {
            return;
        }
        switch (direction)
        {
            case EDirection.Up:
                setUpSprite(spriteIndex);
                break;
            case EDirection.Right:
                setRightSprite(spriteIndex);
                break;
            case EDirection.Left:
                setLeftSprite(spriteIndex);
                break;
            case EDirection.Down:
                setDownSprite(spriteIndex);
                break;
            default:
                setDownSprite(spriteIndex);
                break;
        }
    }

    private void setUpSprite(int spriteIndex)
    {
        List<Sprite> upSprites = monsterType.getUpSprites();
        if(upSprites.Count > spriteIndex)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = upSprites[spriteIndex];
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = upSprites[0];
        }
    }

    private void setDownSprite(int spriteIndex)
    {
        List<Sprite> downSprites = monsterType.getDownSprites();
        if(downSprites.Count > spriteIndex)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = downSprites[spriteIndex];
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = downSprites[0];
        }
    }

    private void setRightSprite(int spriteIndex)
    {
        List<Sprite> rightSprites = monsterType.getRightSprites();
        if(rightSprites.Count > spriteIndex)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = rightSprites[spriteIndex];
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = rightSprites[0];
        }
    }

    private void setLeftSprite(int spriteIndex)
    {
        List<Sprite> leftSprites = monsterType.leftSprites;
        if(leftSprites == null || leftSprites.Count == 0)
        {
            setRightSprite(spriteIndex);
            return;
        }
        if(leftSprites.Count > spriteIndex)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = leftSprites[spriteIndex];
        }
        else 
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = leftSprites[0];
        }
    }
}