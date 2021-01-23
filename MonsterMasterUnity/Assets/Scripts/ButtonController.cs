using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ButtonController : MonoBehaviour
{
    private Sprite defaultSprite;
    public Sprite hoverSprite;
    public Renderer renderer;

    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
        renderer = GetComponent<Renderer>();
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
