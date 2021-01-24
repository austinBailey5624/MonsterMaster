using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameSaveManager : MonoBehaviour
{
    public static GameSaveManager gameSave;
//    public static float oakTreeX = 10.5f;
//    public static float oakTreeY = 4.5f;
//    public static float x = 0.0f;//Used By pause menu
//    public static float y = 0.0f;
    public static Dictionary<string, Vector2> playerPositionBySceneName = new Dictionary<string, Vector2>();
    public static string sceneName;
    public static bool pauseMenuFlag = false;
    


    private void Awake()
    {
        if(gameSave == null)
        {
            gameSave = this;
        }
        else
        {
            Destroy(this.gameObject);
        }
        DontDestroyOnLoad(this.gameObject);
        Vector2 oakTreeStart = new Vector2();
        oakTreeStart.x = 10.5f;
        oakTreeStart.y = 4.5f;
        playerPositionBySceneName["OakTree"] = oakTreeStart;
    }
}
