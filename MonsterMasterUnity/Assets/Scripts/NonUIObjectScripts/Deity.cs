using System.Collections;
using System.Collections.Generic;
using UnityEngine;


/**
 * Class representing the information for any single Deity in the game
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class Deity : MonoBehaviour, ISpritedObject, IDescribedObject
{
    public SecondaryElement secondaryElement;

    public Sprite defaultSprite;
    
    public new string name;

    public string description;

    public string enemyTitle;

    public string unfriendlyTitle;

    public string irritatedTitle;

    public string unknownTitle;

    public string interestedTitle;

    public string friendlyTitle;

    public string alliedTitle;

    public string howToImproveRelationship;

    public string howToDamageRelationship;

    private Dictionary<ERelationshipLevel, string> titleByRelationshipLevel = new Dictionary<ERelationshipLevel, string>();

    public Sprite getDefaultSprite()
    {
        return defaultSprite;
    }

    public string getName()
    {
        return name;
    }

    public string getDescription()
    {
        return description;
    }

    public SecondaryElement getSecondaryElement()
    {
        return secondaryElement;
    }

    public string getTitle(int affinity)
    {
        setRelationshipLevels();
        if(affinity <= -1000)
        {
            return titleByRelationshipLevel[ERelationshipLevel.Enemy];
        }
        if(affinity < -500)
        {
            return titleByRelationshipLevel[ERelationshipLevel.Unfriendly];
        }
        if(affinity < -200)
        {
            return titleByRelationshipLevel[ERelationshipLevel.Irritated];
        }
        if(affinity <= 200)
        {
            return titleByRelationshipLevel[ERelationshipLevel.Unknown];
        }
        if(affinity <=500)
        {
            return titleByRelationshipLevel[ERelationshipLevel.Interested];
        }
        if(affinity <1000)
        {
            return titleByRelationshipLevel[ERelationshipLevel.Friendly];
        }
        return titleByRelationshipLevel[ERelationshipLevel.Allied];
    }

    private void setRelationshipLevels()
    {
        List<ERelationshipLevel> relationshipTypes = new List<ERelationshipLevel>()
        {
            ERelationshipLevel.Enemy,
            ERelationshipLevel.Unfriendly,
            ERelationshipLevel.Irritated,
            ERelationshipLevel.Unknown,
            ERelationshipLevel.Interested,
            ERelationshipLevel.Friendly,
            ERelationshipLevel.Allied
        };

        titleByRelationshipLevel[ERelationshipLevel.Enemy] = "Enemy";
        titleByRelationshipLevel[ERelationshipLevel.Unfriendly] = "Unfriendly";
        titleByRelationshipLevel[ERelationshipLevel.Irritated] = "Irritated";
        titleByRelationshipLevel[ERelationshipLevel.Unknown] = "Unknown";
        titleByRelationshipLevel[ERelationshipLevel.Interested] = "Interested";
        titleByRelationshipLevel[ERelationshipLevel.Friendly] = "Friendly";
        titleByRelationshipLevel[ERelationshipLevel.Allied] = "Allied";

        updateTitle(ERelationshipLevel.Enemy, enemyTitle);
        updateTitle(ERelationshipLevel.Unfriendly, unfriendlyTitle);
        updateTitle(ERelationshipLevel.Irritated, irritatedTitle);
        updateTitle(ERelationshipLevel.Unknown, unknownTitle);
        updateTitle(ERelationshipLevel.Interested, interestedTitle);
        updateTitle(ERelationshipLevel.Friendly, interestedTitle);
        updateTitle(ERelationshipLevel.Allied, alliedTitle);
    }

    public enum ERelationshipLevel
    {
        Enemy,
        Unfriendly,
        Irritated,
        Unknown,
        Interested,
        Friendly,
        Allied
    }

    public void updateTitle(ERelationshipLevel level, string title)
    {
        if(title == null || title.Length < 2)
        {
            return;
        }
        titleByRelationshipLevel[level] = title;
    }
}
