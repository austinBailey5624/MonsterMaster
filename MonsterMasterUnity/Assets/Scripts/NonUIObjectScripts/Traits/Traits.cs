using System.Collections;
using System.Collections.Generic;
using UnityEngine;


/**
 * Class to represent the values of the traits for the MonsterType, which
 * are physical or material charastics of the monster that differentiate it from
 * others, including age, ability to fly or swim, if its on fire, etc
 * 
 * See: https://github.com/austinBailey5624/MonsterMaster/wiki/FeatureIdea:Traits
 * 
 * 
 * Copyright 2022 Austin Bailey, All Rights Reserved
 */
public class Traits : MonoBehaviour, IDescribedObject
{
    public new string name;

    public string description;

    public ESolidityTrait solidity;

    public EAgeTrait age;

    public UnderwaterTraversalTrait underwaterTraversal;

    public EFlightTraversalTrait flightTraversal;

    public ELightProductionTrait lightProduction;

    public int physicalTraitValue = 0;

    public int balancedTraitValue = 0;

    public int magicalTraitValue = 0;

    public int immolatedTraitValue = 0;

    public int fishTraitValue = 0;

    public int naturalTraitValue = 0;

    public int sandyTraitValue = 0;

    public int dealtInKindTraitValue = 0;

    public int steamyTraitValue = 0;

    public int wetTraitValue = 0;

    public int cloudyTraitValue = 0;

    public int depthsDwellingTraitValue = 0;

    public int forestMagicTraitValue = 0;

    public int rootedTraitValue = 0;

    public int healerTraitValue = 0;

    public int toxicTraitValue = 0;

    public int rebirthTraitValue = 0;

    public int beachDwellingTraitValue = 0;

    public int flockTraitValue = 0;

    public int vampireTraitValue = 0;

    public int diurnalTraitValue = 0;

    public int nocturnalTraitValue = 0;

    public int protectorTraitValue = 0;

    public int regenShieldTraitValue = 0;

    public int avengerTraitValue = 0;

    public int connectionTraitValue = 0;

    public int guiltTraitValue = 0;

    public int hateHypocricyTrateValue = 0;

    public int isolationTraitValue = 0;

    public int rainbowTraitValue = 0;

    public int elementalStoneTraitValue = 0;

    public int pyromagiaTraitValue = 0;

    public int aquamagiaTraitValue = 0;

    public int terramagiaTraitValue = 0;

    public int aeroMagiaTraitValue = 0;

    public int luxorMagiaTraitValue = 0;

    public int umbralMagiaTraitValue = 0;

    public int calmTraitValue = 0;//calm is positive, Angry is negative

    public int hotTraitValue = 0;//Hot is positive, Cold is negative

    public int strongTraitValue = 0;//Strong is positive, Weak is negative

    public int wiseTraitValue = 0;//Wise is positive, Dumb is negative

    public int fastTraitValue = 0;//Fast is positive, Slow is negative

    public int hardyTraitValue = 0;//Hardy is positive, Faint is negative




    public string getName()
    {
        return name;
    }

    public string getDescription()
    {
        return description;
    }

    public Traits makeChildTraits(Traits fatherTraits, Traits motherTraits)
    {
        //TODO flesh out including difficulty
        return fatherTraits;
    }
}
