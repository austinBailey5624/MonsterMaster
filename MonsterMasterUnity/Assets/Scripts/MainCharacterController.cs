using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public enum Direction
{
    Up = 0,
    Right = 1,
    Left = 2,
    Down = 3
}

/**
*   Class to control the Main Character
*   Copyright 2022 Austin Bailey
*/
public class MainCharacterController : Person
{
    public float speed;

    public bool isFrozen;

    private string lastSceneName;

    private bool facingLeft2;

    private float travelDistance = 0.0f;

    private int direction = 0;

    private float tileSize = 1f;

    public string subjectPronoun;

    public string objectPronoun;

    public string possesivePronoun;

    private void Awake()
    {
        DontDestroyOnLoad(this.gameObject);
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

        facingLeft2 = false;
        string currentScene = SceneManager.GetActiveScene().name;
        if (GameState.playerPositionBySceneName.ContainsKey(currentScene))
        {
            transform.position =
                GameState.playerPositionBySceneName[currentScene];
        }
    }

    void Update()
    {
        string sceneName = SceneManager.GetActiveScene().name;
        Vector2 position = transform.position;
        if (
            !sceneName.Equals(lastSceneName) //if we've changed scenes
        )
        {
            lastSceneName = sceneName;
            if (sceneName != "CharacterCreatorMenu")
            {
                Vector3 startScale = transform.localScale;
                characterScalex = 3.5f;

                startScale.x = characterScalex;
                startScale.y = characterScalex;
                this.gameObject.GetComponent<BoxCollider2D>().size = new Vector2(1f/(float)characterScalex,1f/(float)characterScalex);
                transform.localScale = startScale;
                if(!sceneName.Contains("Menu"))
                {
                    position = GameState.playerPositionBySceneName[sceneName];
                }
            }
        }
        if (isFrozen)
        {
            setSprite(0, direction);
        }
        else
        {
            float horizontal = Input.GetAxis("Horizontal");
            float vertical = Input.GetAxis("Vertical");

            if (travelDistance <= 0)
            {
                facingLeft2 = false;
                if (
                    vertical > 0.0f //Up
                )
                {
                    travelDistance = tileSize;
                    direction = 0;
                }
                else if (
                    horizontal > 0.0f //right
                )
                {
                    travelDistance = tileSize;
                    direction = 1;
                }
                else if (
                    horizontal < 0.0f //left
                )
                {
                    travelDistance = tileSize;
                    direction = 2;
                    facingLeft2 = true;
                }
                if (
                    vertical < 0.0f //down
                )
                {
                    travelDistance = tileSize;
                    direction = 3;
                }
            }

            if (travelDistance > 0 && direction == 0)
            {
                position.y = position.y + speed;
                travelDistance -= speed;
            }
            else if (travelDistance > 0 && direction == 1)
            {
                position.x = position.x + speed;
                travelDistance -= speed;
            }
            else if (travelDistance > 0 && direction == 2)
            {
                position.x = position.x - speed;
                travelDistance -= speed;
            }
            else if (travelDistance > 0 && direction == 3)
            {
                position.y = position.y - speed;
                travelDistance -= speed;
            }

            if (travelDistance > 0 && travelDistance <= .25 * tileSize)
            {
                setSprite(0, direction);
            }
            else if (
                travelDistance > .25 * tileSize &&
                travelDistance <= .5 * tileSize
            )
            {
                setSprite(1, direction);
            }
            else if (
                travelDistance > .5 * tileSize &&
                travelDistance <= .75 * tileSize
            )
            {
                setSprite(2, direction);
            }
            else if (travelDistance > .75 * tileSize)
            {
                setSprite(3, direction);
            }

            if (facingLeft2)
            {
                Vector3 characterScale = transform.localScale;
                characterScale.x = -characterScalex;
                transform.localScale = characterScale;
            }
            else
            {
                Vector3 characterScale = transform.localScale;
                characterScale.x = characterScalex;
                transform.localScale = characterScale;
            }

            transform.position = position;

            if (Input.GetAxis("Cancel") > .1f)
            {
                GameState.previousPlaceName = sceneName;
                GameState.playerPositionBySceneName[sceneName] =
                    transform.position;
                SceneManager.LoadScene("PauseMenu");
            }
        }
    }
}
