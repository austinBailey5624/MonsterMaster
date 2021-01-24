using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ButtonController : MonoBehaviour 
{
    protected Sprite defaultSprite;
    public Sprite hoverSprite;

    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
    }

    // Update is called once per frame
    void OnMouseEnter()
    {
        this.gameObject.GetComponent<SpriteRenderer>().sprite = hoverSprite;
    }

    void OnMouseExit()
    {
        this.gameObject.GetComponent<SpriteRenderer>().sprite = defaultSprite;
    }
}
