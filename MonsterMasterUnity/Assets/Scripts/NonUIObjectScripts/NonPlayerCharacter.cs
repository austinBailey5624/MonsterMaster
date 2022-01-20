using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Class to handle NonPlayerCharacters
*   Copyright 2022 Austin Bailey
*/
public class NonPlayerCharacter : Person
{
    private float tolerance = 0.2f;

    private float tilesize = 1f;

    private Transform adjacentTransform;

    void Awake()
    {
        GameObject player = GameObject.FindGameObjectWithTag("Player");
        if (player == null)
        {
            return;
        }
        else
        {
            adjacentTransform = player.transform;
        }
    }

    new void Start()
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
        if (Input.GetAxis("Submit") > .1f)
        {
            
            Vector3 position = this.transform.position;
            Vector3 belowPosition =
                new Vector3(position.x, position.y - tilesize, position.z);
            Vector3 abovePosition =
                new Vector3(position.x, position.y + tilesize, position.z);
            Vector3 leftPosition =
                new Vector3(position.x - tilesize, position.y, position.z);
            Vector3 rightPosition = new Vector3(position.x + tilesize, position.y, position.z);
            // Debug.Log("position:  " + position);
            // Debug.Log("AdjacentPosition: " + adjacentTransform.position);
            if (
                (belowPosition - adjacentTransform.position).sqrMagnitude <
                tolerance
            )
            {
                setSprite(0, 3);
            }
            else if((abovePosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0,0);
            }
            else if((rightPosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0,1);
            }
            else if((leftPosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0,2);
            }
        }
    }
}
