using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using static EDirection;


/**
*   Class to control the Main Character
*   Copyright 2022-2023 Austin Bailey All Rights reserved
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

    private List<GameObject> monsters = new List<GameObject>();

    private List<Vector2> lastPositions = new List<Vector2>();


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
        initBodyParts();
        for (int i = 0; i < 8; i++)
        {
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().sprite =
                animationSets[i].frontSprites[0];
            bodyParts[i].gameObject.GetComponent<SpriteRenderer>().color =
                colors[i];
        }


        string currentScene = SceneManager.GetActiveScene().name;
        if (GameState.playerPositionBySceneName.ContainsKey(currentScene))
        {
            transform.position =
                GameState.playerPositionBySceneName[currentScene];
        }

        initLastPositions(transform.position);
        initMonsters();
    }

    private void initLastPositions(Vector2 position)
    {
        lastPositions = new List<Vector2>();
        for (int i = 0; i < 6; i++)
        {
            lastPositions.Add(position);
        }
    }

    private void initPositions()
    {
        for(int i = 0; i < monsters.Count; i++)
        {
            if(monsters[i] != null)
            {
                monsters[i].gameObject.transform.position = this.transform.position;
            }
        }
    }

    private void initMonsters()
    {
        for(int i = 8; i < 14; i++)
        {
            monsters.Add(this.transform.GetChild(i).gameObject);
        }
        for(int i = 0; i <6; i++)
        {
            initMonster(monsters[i]);
        }
    }

    private void initMonster(GameObject monster)
    {
        if (monster == null || monster.gameObject == null || monster.gameObject.GetComponent<Monster>() == null)
        {
            return;
        }
        MonsterType type = monster.gameObject.GetComponent<Monster>().monsterType;
        monster.gameObject.GetComponent<SpriteRenderer>().sprite = monsters[0].gameObject.GetComponent<Monster>().monsterType.getDownSprites()[0];
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
            setLastPositions();
        }
    }

    private void setLastPositions()
    {
        for(int i = 5; i > 0; i--)
        {
            lastPositions[i] = lastPositions[i - 1];
        }
        lastPositions[0] = transform.position;
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

        for(int i = 0; i<6; i++)
        {
            if(monsters[i] != null)
            {
                moveMonster(monsters[i], lastPositions[i]);
            }
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
        for(int i = 0; i< 6; i++)
        {
            monsters[i].gameObject.GetComponent<Monster>().setSprite(index, direction);
        }
    }


    private void executeSceneTransitionAction(string sceneName)
    {
        Vector2 position = transform.position;
        if (sceneName != "CharacterCreatorMenu")
        {
            GameState.isFrozen = false;
            Vector3 startScale = transform.localScale;
            float characterScaleBase = 3.5f;

            startScale.x = characterScaleBase;
            startScale.y = characterScaleBase;
            this.gameObject.GetComponent<BoxCollider2D>().size = new Vector2(1f / (float)characterScaleBase, 1f / (float)characterScaleBase);
            transform.localScale = startScale;
            if (!sceneName.Contains("Menu"))
            {
                position = GameState.playerPositionBySceneName[sceneName];
                transform.position = position;
                initLastPositions(position);
                initPositions();
            }
        }
        travelDistance = 0;
    }
}
