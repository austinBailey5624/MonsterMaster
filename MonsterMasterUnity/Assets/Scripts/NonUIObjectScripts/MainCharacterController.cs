using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using static EDirection;


/**
*   Class to control the Main Character
*   Copyright 2022 Austin Bailey All Rights reserved
*/
public class MainCharacterController : Person
{
    public static MainCharacterController mainCharacter;

    public float speed;

    private string lastSceneName;

    private float travelDistance = 0.0f;

    private EDirection direction = EDirection.Down;

    private float tileSize = 1f;

    public string subjectPronoun;

    public string objectPronoun;

    public string possesivePronoun;

    private List<GameObject> bodyParts;

    private GameObject monster1;

    private GameObject monster2;

    private GameObject monster3;

    private GameObject monster4;

    private GameObject monster5;

    private GameObject monster6;

    private Vector2 lastPosition;

    private Vector2 lastPosition2;

    private Vector2 lastPosition3;

    private Vector2 lastPosition4;

    private Vector2 lastPosition5;

    private Vector2 lastPosition6;

    private double tolerance = .05;

    private void Awake()
    {
        if(mainCharacter == null)
        {
            mainCharacter = this;
        }
        else
        {
            Destroy(this.gameObject);
            return;
        }
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

        bodyParts = new List<GameObject>()
        {
            body,
            eyeWhites,
            iris,
            pants,
            shirt,
            hairStyle,
            shoes,
            facialHair
        };

        Vector3 characterScale = transform.localScale;
        characterScalex = characterScale.x;

        string currentScene = SceneManager.GetActiveScene().name;
        if (GameState.playerPositionBySceneName.ContainsKey(currentScene))
        {
            transform.position =
                GameState.playerPositionBySceneName[currentScene];
        }
        lastPosition  = transform.position;
        lastPosition2 = transform.position;
        lastPosition3 = transform.position;
        lastPosition4 = transform.position; 
        lastPosition5 = transform.position;
        lastPosition6 = transform.position;

        monster1 = this.transform.GetChild(8).gameObject;
        monster2 = this.transform.GetChild(9).gameObject;
        monster3 = this.transform.GetChild(10).gameObject;
        monster4 = this.transform.GetChild(11).gameObject;
        monster5 = this.transform.GetChild(12).gameObject;
        monster6 = this.transform.GetChild(13).gameObject;

        initializeMonster(monster1);
        initializeMonster(monster2);
        initializeMonster(monster3);
        initializeMonster(monster4);
        initializeMonster(monster5);
        initializeMonster(monster6);
    }

    void initializeMonster(GameObject monster)
    {
        if (monster == null || monster.gameObject == null || monster.gameObject.GetComponent<Monster>() == null)
        {
            return;
        }
        MonsterType type = monster.gameObject.GetComponent<Monster>().monsterType;
        monster.gameObject.GetComponent<SpriteRenderer>().sprite = monster1.gameObject.GetComponent<Monster>().monsterType.getDownSprites()[0];
        monster.gameObject.transform.position = this.transform.position;
        if (type.defaultSprite.rect.width == 16)
        {
            monster.gameObject.GetComponent<Transform>().localScale = new Vector3(.3f, .3f, 1);
        }
        if (type.defaultSprite.rect.width == 32)
        {
            monster.gameObject.GetComponent<Transform>().localScale = new Vector3(1, 1, 1);

        }
        if (type.defaultSprite.rect.width == 64)
        {
            monster.gameObject.GetComponent<Transform>().localScale = new Vector3(.6f, .6f, 1);
        }

    }

    void Update()
    {
        string sceneName = SceneManager.GetActiveScene().name;

        if (
            !sceneName.Equals(lastSceneName) //if we've changed scenes
        )
        {
            executeSceneTransitionAction(sceneName);
            lastSceneName = sceneName;
        }
        if (GameState.isFrozen)
        {
            setSprite(0, direction);
        }
        else
        {
            //If we are not already moving
            if (travelDistance <= 0)
            {
                determineDirection();
            }

            if (travelDistance > 0)
            {
                moveCharacter();
                selectMovementSprite();
            }

 /*           if (direction==EDirection.Left)
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
            }*/


            if (Input.GetAxis("Cancel") > .1f && GameState.isFrozen == false)
            {
                GameState.previousPlaceName = sceneName;
                GameState.playerPositionBySceneName[sceneName] =
                    transform.position;
                SceneManager.LoadScene("PauseMenu");
            }
        }
    }

    private void determineDirection()
    {
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        
        if (
            vertical > 0.0f //Up
        )
        {
            travelDistance = tileSize;
            direction = EDirection.Up;
        }
        else if (
            horizontal > 0.0f //right
        )
        {
            travelDistance = tileSize;
            direction = EDirection.Right;
        }
        else if (
            horizontal < 0.0f //left
        )
        {
            travelDistance = tileSize;
            direction = EDirection.Left;
        }
        if (
            vertical < 0.0f //down
        )
        {
            travelDistance = tileSize;
            direction = EDirection.Down;
        }
        if(travelDistance == tileSize)
        {
            lastPosition6 = lastPosition5;
            lastPosition5 = lastPosition4;
            lastPosition4 = lastPosition3;
            lastPosition3 = lastPosition2;
            lastPosition2 = lastPosition;
            lastPosition = transform.position;
        }
    }
    
    private void moveCharacter()
    {
        Vector2 position = transform.position;
        if (direction == EDirection.Up)
        {
            position.y = position.y + speed;
            travelDistance -= speed;
        }
        else if (direction == EDirection.Right)
        {
            position.x = position.x + speed;
            travelDistance -= speed;
        }
        else if (direction == EDirection.Left)
        {
            position.x = position.x - speed;
            travelDistance -= speed;
        }
        else if (direction == EDirection.Down)
        {
            position.y = position.y - speed;
            travelDistance -= speed;
        }
        transform.position = position;
        if(monster1 != null)
        {
            moveMonster(monster1,lastPosition);
        }
        if(monster2 != null)
        {
            moveMonster(monster2, lastPosition2);
        }
        if(monster3 != null)
        {
            moveMonster(monster3, lastPosition3);
        }
        if(monster4 != null)
        {
            moveMonster(monster4, lastPosition4);
        }
        if(monster5 != null)
        {
            moveMonster(monster5, lastPosition5);
        }
        if(monster6 != null)
        {
            moveMonster(monster6, lastPosition6);
        }
    }

    private void moveMonster(GameObject monster, Vector2 target)
    {
        float adjustedSpeed = speed;
        Vector2 position = monster.gameObject.transform.position;
        if (target.y - position.y > tolerance)//move up
        {
            position.y += adjustedSpeed;
        }
        if (position.y - target.y > tolerance)//move down
        {
            position.y -=  adjustedSpeed;
        }
        if (target.x - position.x > tolerance)//move Right
        {
            position.x += adjustedSpeed;
        }
        if (position.x - target.x > tolerance)//move Left
        {
            position.x -= adjustedSpeed;
        }
        monster.gameObject.transform.position = position;
    }

    private void selectMovementSprite()
    {
        int index;
        if (travelDistance > 0 && travelDistance <= .25 * tileSize)
        {
            index = 0;
            setSprite(index, direction);
        }
        else if (
            travelDistance > .25 * tileSize &&
            travelDistance <= .5 * tileSize
        )
        {
            index = 1;
            setSprite(index, direction);
        }
        else if (
            travelDistance > .5 * tileSize &&
            travelDistance <= .75 * tileSize
        )
        {
            index = 2;
            setSprite(index, direction);
        }
        else if (travelDistance > .75 * tileSize)
        {
            index = 3;
            setSprite(index, direction);
        }
        else
        {
            index = 0;
        }
        if(monster1 != null)
        {
            monster1.gameObject.GetComponent<Monster>().setSprite(index, direction);
        }
        if (monster2 != null)
        {
            monster2.gameObject.GetComponent<Monster>().setSprite(index, direction);
        }
        if (monster3 != null)
        {
            monster3.gameObject.GetComponent<Monster>().setSprite(index, direction);
        }
        if (monster4 != null)
        {
            monster4.gameObject.GetComponent<Monster>().setSprite(index, direction);
        }
        if (monster5 != null)
        {
            monster5.gameObject.GetComponent<Monster>().setSprite(index, direction);
        }
        if (monster6 != null)
        {
            monster6.gameObject.GetComponent<Monster>().setSprite(index, direction);
        }

    }


    private void executeSceneTransitionAction(string sceneName)
    {
        Vector2 position = transform.position;
        if (sceneName != "CharacterCreatorMenu")
        {
            GameState.isFrozen = false;
            Vector3 startScale = transform.localScale;
            characterScalex = 3.5f;

            startScale.x = characterScalex;
            startScale.y = characterScalex;
            this.gameObject.GetComponent<BoxCollider2D>().size = new Vector2(1f / (float)characterScalex, 1f / (float)characterScalex);
            transform.localScale = startScale;
            if (!sceneName.Contains("Menu"))
            {
                position = GameState.playerPositionBySceneName[sceneName];
                transform.position = position;
                monster1.gameObject.transform.position = position;
            }
        }
        travelDistance = 0;
    }
}
