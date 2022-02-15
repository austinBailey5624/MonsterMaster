using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using static EAffinity;

/**
* Class to handle the 'state' of the game. I.E. all of the variables that make the different for each 
* Save Slot should be saved here (to be loaded and unloaded via JSON storage). This is used to 
* store variables and information between scenes. Yes, its a bit of a God class but I haven't come up 
* with a better idea yet.
* Copyright 2022 Austin Bailey All Rights Reserved
*/
public class GameState : MonoBehaviour
{
    public static GameState gameSave;

    public static Dictionary<string, Vector2> playerPositionBySceneName = getInitialPositions();

    public static string previousPlaceName;

    public static string previousMenuName;

    public static SecondaryElement selectedBestiaryElement;

    public static MonsterType selectedBestiaryMonsterType;

    public static string mainCharacterName = "Guy";

    public static Dictionary<EAffinity, int> affinities = getInitialAffinity();

    public static bool isFrozen = false;

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
        Dictionary<string, Vector2> initialPositions =
            new Dictionary<string, Vector2>();
        initialPositions["Oaktree"] = new Vector2(10.5f, 4.5f);
        initialPositions["Oaktree_Church"] = new Vector2(-1.5f, -16.5f);
        initialPositions["Oaktree_EmmasHouse"] = new Vector2(10.5f, 19.5f);
        initialPositions["OakTree_EmmasHouse"] = new Vector2(10.5f, 19.5f);//TODO: Hack, remove when possible
        initialPositions["Oaktree_BrahmsHouse"] = new Vector2(10.5f, 1.5f);
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
                EAffinity.Thanatos,
                EAffinity.Malacathe,
                EAffinity.Illian,
                EAffinity.Arachnis,
                EAffinity.Muir,
                EAffinity.Acheron,
                EAffinity.TheEnemy
            };
        for (int i = 0; i< affinities.Count; i++)
        {
            initialAffinity[affinities[i]] = 0;
        }
        return initialAffinity;
    }
}
