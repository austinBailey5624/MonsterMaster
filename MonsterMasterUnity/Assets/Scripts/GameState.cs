using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameState : MonoBehaviour
{
    public static GameState gameSave;
    public static Dictionary<string, Vector2> playerPositionBySceneName = new Dictionary<string, Vector2>();
    public static string previousSceneName;
  
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
    }
}
