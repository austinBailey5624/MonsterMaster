using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameState : MonoBehaviour
{
    public static GameState gameSave;

    public static Dictionary<string, Vector2> playerPositionBySceneName = getInitialPositions();

    public static string previousPlaceName;

    public static string previousMenuName;

    private void Awake()
    {
        if (gameSave == null)
        {
            gameSave = this;
        }
        else
        {
            Destroy(this.gameObject);
            return;
        }
        DontDestroyOnLoad(this.gameObject);
    }

    private static Dictionary<string, Vector2> getInitialPositions()
    {
        Dictionary<string, Vector2> initialPositions = new Dictionary<string, Vector2>();
        initialPositions["Oaktree"] = new Vector2(10.5f,4.5f);
        initialPositions["OaktreeChurch"] = new Vector2(-1.5f,-16.5f);
        initialPositions["OakTree_EmmasHouse"] = new Vector2(10.5f, 19.5f);
        return initialPositions;
    }
}
