using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using static EAffinity;

/**
* Class to handle the 'state' of the game. I.E. all of the variables that make the different for each 
* Save Slot should be saved here (to be loaded and unloaded via JSON storage). This is used to 
* store variables and information between scenes. Yes, its a bit of a God class but I haven't come up 
* with a better idea yet.
* Copyright 2022-2023 Austin Bailey All Rights Reserved
*/
public class GameState : MonoBehaviour
{
    public static GameState gameSave;

    public static Dictionary<string, Vector2> playerPositionBySceneName = getInitialPositions();

    public static string previousPlaceName;

    public static string previousMenuName;

    public static string mainCharacterName = "";

    public static Dictionary<EAffinity, int> affinities = getInitialAffinity();

    public static bool isFrozen = false;

    public static float tilesize = 1f;

    public static float buttonUpTolerance = .25f;

    public static float buttonDownTolerance = .001f;

    public static DifficultyState difficultyState;

    public static DesignColorsController designColorsController;

    public static EBackgroundType currentBattleBackground = EBackgroundType.Forest;


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
        difficultyState = ScriptableObject.CreateInstance<DifficultyState>();
        difficultyState.initDifficulty();
        designColorsController = ScriptableObject.CreateInstance<DesignColorsController>();
        Screen.SetResolution(1600, 900, FullScreenMode.Windowed);
    }

    private static Dictionary<string, Vector2> getInitialPositions()
    {
        Dictionary<string, Vector2> initialPositions =
            new Dictionary<string, Vector2>();
        initialPositions["Oaktree"]                = new Vector2(10.5f, 4.5f);
        initialPositions["Oaktree_Church"]         = new Vector2(-1.5f, -16.5f);
        initialPositions["Oaktree_EmmasHouse"]     = new Vector2(10.5f, 19.5f);
        initialPositions["Oaktree_BrahmsHouse"]    = new Vector2(10.5f, 1.5f);
        initialPositions["Oaktree_PlayersBedroom"] = new Vector2(13.5f, 4.5f);
        initialPositions["OakTree_PlayersBedroom"] = new Vector2(13.5f, 4.5f);//Hack, remove when possible
        return initialPositions;
    }

    private static Dictionary<EAffinity, int> getInitialAffinity()
    {
        Dictionary<EAffinity, int> initialAffinity =
            new Dictionary<EAffinity, int>();
        List<EAffinity> affinities =
            new List<EAffinity>()
            {
                EAffinity.Neutral,
                EAffinity.Fire,
                EAffinity.Water,
                EAffinity.Earth,
                EAffinity.Air,
                EAffinity.Light,
                EAffinity.Darkness,
                EAffinity.Ahros,
                EAffinity.Velhu,
                EAffinity.Sid,
                EAffinity.Gabriel,
                EAffinity.Anu,
                EAffinity.Pythion,
                EAffinity.Mars,
                EAffinity.Neptune,
                EAffinity.Gaia,
                EAffinity.Bacchus,
                EAffinity.Bennu,
                EAffinity.Thanatos,
                EAffinity.Malacathe,
                EAffinity.Illian,
                EAffinity.Arachnis,
                EAffinity.Muir,
                EAffinity.Acheron,
                EAffinity.TheEnemy
            };
        for (int i = 0; i < affinities.Count; i++)
        {
            initialAffinity[affinities[i]] = 0;
        }
        return initialAffinity;
    }

    public static int getAffinity(Deity deity)
    {
        if (deity.name.Equals("Anu"))
        {
            return affinities[EAffinity.Anu];
        }
        if(deity.name.Equals("Velhu"))
        {
            return affinities[EAffinity.Velhu];
        }
        if(deity.name.Equals("Sid"))
        {
            return affinities[EAffinity.Sid];
        }
        if(deity.name.Equals("Gabriel"))
        {
            return affinities[EAffinity.Gabriel];
        }
        if(deity.name.Equals("Ahros"))
        {
            return affinities[EAffinity.Ahros];
        }
        if(deity.name.Equals("Pythion"))
        {
            return affinities[EAffinity.Pythion];
        }
        if(deity.name.Equals("Bennu"))
        {
            return affinities[EAffinity.Bennu];
        }
        if(deity.name.Equals("Neptune"))
        {
            return affinities[EAffinity.Neptune];
        }
        if(deity.name.Equals("Gaia"))
        {
            return affinities[EAffinity.Gaia];
        }
        if(deity.name.Equals("Bacchus"))
        {
            return affinities[EAffinity.Bacchus];
        }
        if(deity.name.Equals("Mars"))
        {
            return affinities[EAffinity.Mars];
        }
        return 0;
    }
}

