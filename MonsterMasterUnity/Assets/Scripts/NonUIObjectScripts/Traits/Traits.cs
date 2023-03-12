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

    public EUnderwaterTraversalTrait underwaterTraversal;

    public ETraitValue flightTraversal; //positive is flight, negative is heavy

    public ETraitValue lightProduction; //positive is light generation, negative is consumption

    //Evolutionary Traits
    public ETraitValue physicalTraitValue = 0;

    public ETraitValue balancedTraitValue = 0;

    public ETraitValue magicalTraitValue = 0;

    //Inherited Traits

    public ETraitValue avengerTraitValue = 0;

    public ETraitValue beachDwellingTraitValue = 0;

    public ETraitValue cloudyTraitValue = 0;

    public ETraitValue connectionTraitValue = 0;

    public ETraitValue dealtInKindTraitValue = 0;

    public ETraitValue deathConsumingTraitValue = 0;

    public ETraitValue depthsDwellingTraitValue = 0;

    public ETraitValue diurnalTraitValue = 0;

    public ETraitValue elementalStoneTraitValue = 0;

    public ETraitValue fishTraitValue = 0;

    public ETraitValue flockTraitValue = 0;

    public ETraitValue forestMagicTraitValue = 0;

    public ETraitValue guiltTraitValue = 0;

    public ETraitValue hateHypocricyTrateValue = 0;

    public ETraitValue healerTraitValue = 0;

    public ETraitValue immolatedTraitValue = 0;

    public ETraitValue isolationTraitValue = 0;

    public ETraitValue naturalTraitValue = 0;

    public ETraitValue nocturnalTraitValue = 0;

    public ETraitValue protectorTraitValue = 0;

    public ETraitValue rainbowTraitValue = 0;

    public ETraitValue rebirthTraitValue = 0;

    public ETraitValue regenShieldTraitValue = 0;

    public ETraitValue rootedTraitValue = 0;

    public ETraitValue sandyTraitValue = 0;

    public ETraitValue steamyTraitValue = 0;

    public ETraitValue toxicTraitValue = 0;

    public ETraitValue vampireTraitValue = 0;

    public ETraitValue wetTraitValue = 0;

    //Magic Traits
    public ETraitValue pyromagiaTraitValue = 0;

    public ETraitValue aquamagiaTraitValue = 0;

    public ETraitValue terramagiaTraitValue = 0;

    public ETraitValue aeroMagiaTraitValue = 0;

    public ETraitValue luxorMagiaTraitValue = 0;

    public ETraitValue umbralMagiaTraitValue = 0;

    //Stat Traits
    public ETraitValue calmTraitValue = 0;//calm is positive, Angry is negative

    public ETraitValue hotTraitValue = 0;//Hot is positive, Cold is negative

    public ETraitValue strongTraitValue = 0;//Strong is positive, Weak is negative

    public ETraitValue wiseTraitValue = 0;//Wise is positive, Dumb is negative

    public ETraitValue fastTraitValue = 0;//Fast is positive, Slow is negative

    public ETraitValue hardyTraitValue = 0;//Hardy is positive, Faint is negative

    public ETraitValue richTraitValue = 0;//Rich is positive, Poor is negative




    public string getName()
    {
        return name;
    }

    public string getDescription()
    {
        return description;
    }

    public static Traits makeChildTraits(Traits fatherTraits, Traits motherTraits, Traits newMonsterTypeTraits, int newGenerationValue)
    {
        //TODO flesh out including difficulty
        return fatherTraits;
    }

    public static Traits evolveTraits(Traits currentTraits, Traits evolutionTraits)
    {
        //TODO flesh out
        return currentTraits;
    }

    public string toString()
    {
        string result = "Traits: ";
        result += basicTraitsToString();
        result += evolutionaryTraitsToString();
        result += inheritedTraitsToString();
        result += magicTraitsToString();
        result += statTraitsToString();
        return result;
    }

    private string basicTraitsToString()
    {
        string result = "";
        result += solidityTraitsToString();
        result += ageTraitToString();
        result += underwaterToString();
        result += flightTraversalToString();
        result += lightProductionToString();
        return result;
    }

    private string evolutionaryTraitsToString()
    {
        string result = "";
        result += physicalTraitToString();
        result += balancedTraitToString();
        result += magicalTraitToString();
        return result;
    }

    private string inheritedTraitsToString()
    {
        string result = "";
        result += inheritedTraitToString(avengerTraitValue, "Avenger ");
        result += inheritedTraitToString(beachDwellingTraitValue, "Beach Dwelling ");
        result += inheritedTraitToString(cloudyTraitValue, "Cloudy ");
        result += inheritedTraitToString(connectionTraitValue, "Connection ");
        result += inheritedTraitToString(dealtInKindTraitValue, "Dealt In Kind ");
        result += inheritedTraitToString(deathConsumingTraitValue, "Death Consuming ");
        result += inheritedTraitToString(depthsDwellingTraitValue, "Depths Dwelling ");
        result += inheritedTraitToString(diurnalTraitValue, "Diurnal ");
        result += inheritedTraitToString(elementalStoneTraitValue, "Elemental Stone ");
        result += inheritedTraitToString(fishTraitValue, "Fish ");
        result += inheritedTraitToString(flockTraitValue, "Flock ");
        result += inheritedTraitToString(forestMagicTraitValue, "Forest Magic ");
        result += inheritedTraitToString(guiltTraitValue, "Guilt ");
        result += inheritedTraitToString(hateHypocricyTrateValue, "Hate Hypocricy ");
        result += inheritedTraitToString(healerTraitValue, "Healer ");
        result += inheritedTraitToString(immolatedTraitValue, "Immolated ");
        result += inheritedTraitToString(isolationTraitValue, "Isolation ");
        result += inheritedTraitToString(naturalTraitValue, "Natural ");
        result += inheritedTraitToString(nocturnalTraitValue, "Nocturnal ");
        result += inheritedTraitToString(protectorTraitValue, "Protector ");
        result += inheritedTraitToString(rainbowTraitValue, "Rainbow ");
        result += inheritedTraitToString(rebirthTraitValue, "Rebirth ");
        result += inheritedTraitToString(regenShieldTraitValue, "Regen Shield ");
        result += inheritedTraitToString(rootedTraitValue, "Rooted ");
        result += inheritedTraitToString(sandyTraitValue, "Sandy ");
        result += inheritedTraitToString(steamyTraitValue, "Steamy ");
        result += inheritedTraitToString(toxicTraitValue, "Toxic ");
        result += inheritedTraitToString(vampireTraitValue, "Vampire ");
        result += inheritedTraitToString(wetTraitValue, "Wet ");

        return result;
    }
    
    private string magicTraitsToString()
    {
        string result = "";
        result += inheritedTraitToString(pyromagiaTraitValue, "Pyromagia ");
        result += inheritedTraitToString(aquamagiaTraitValue, "Aquamagia ");
        result += inheritedTraitToString(terramagiaTraitValue, "Terramagia ");
        result += inheritedTraitToString(aeroMagiaTraitValue, "Aeromagia ");
        result += inheritedTraitToString(luxorMagiaTraitValue, "Luxormagia ");
        result += inheritedTraitToString(umbralMagiaTraitValue, "Umbralmagia ");
        return result;
    }

    private string statTraitsToString()
    {
        string result = "";
        result += statTraitToString(calmTraitValue, "Calm ", "Angry ");
        result += statTraitToString(hotTraitValue, "Hot ", "Cold ");
        result += statTraitToString(strongTraitValue, "Strong ", "Weak ");
        result += statTraitToString(wiseTraitValue, "Wise ", "Dumb ");
        result += statTraitToString(fastTraitValue, "Fast ", "Slow ");
        result += statTraitToString(hardyTraitValue, "Hardy ", "Faint ");
        result += statTraitToString(richTraitValue, "Rich ", "Poor ");
        return result;
    }

    private string solidityTraitsToString()
    {
        string result = "";
        if (solidity == ESolidityTrait.Corporeal)
        {
            result += "Corporeal, ";
        }
        else if (solidity == ESolidityTrait.Liquid)
        {
            result += "Liquid, ";
        }
        else if (solidity == ESolidityTrait.PartiallyCorporeal)
        {
            result += "Partially Corporeal, ";
        }
        else if (solidity == ESolidityTrait.Vapor)
        {
            result += "Vapor, ";
        }
        else if (solidity == ESolidityTrait.Incorporeal)
        {
            result += "Incorporeal, ";
        }
        return result;
    }

    private string ageTraitToString()
    {
        if(age == EAgeTrait.Infant)
        {
            return "Infant, ";
        }
        if (age == EAgeTrait.Adolescent)
        {
            return "Adolescent, ";
        }
        if(age == EAgeTrait.Adult)
        {
            return "Adult, ";
        }
        if(age == EAgeTrait.Elder)
        {
            return "Elder, ";
        }
        if(age == EAgeTrait.Ancient)
        {
            return "Ancient, ";
        }
        return "";
    }

    private string underwaterToString()
    {
        if(underwaterTraversal == EUnderwaterTraversalTrait.Neutral)
        {
            return "Neutral to water, ";
        }
        if(underwaterTraversal == EUnderwaterTraversalTrait.WaterFriendly)
        {
            return "Water Friendly, ";
        }
        if(underwaterTraversal == EUnderwaterTraversalTrait.WaterAdjacent)
        {
            return "Water Adjacent, ";
        }
        if(underwaterTraversal == EUnderwaterTraversalTrait.WaterBreathing)
        {
            return "Water Breathing, ";
        }
        if(underwaterTraversal == EUnderwaterTraversalTrait.WaterUnfriendly)
        {
            return "Water Unfriendly, ";
        }
        if(underwaterTraversal == EUnderwaterTraversalTrait.WaterAbhorrent)
        {
            return "Water Abhorrent, ";
        }
        if(underwaterTraversal == EUnderwaterTraversalTrait.Unsubmergible)
        {
            return "Unsubmergible, ";
        }
        return "";
    }

    private string flightTraversalToString()
    {
        if(flightTraversal == 0)
        {
            return "Floating, ";
        }
        string type = "";
        if(flightTraversal > 0)
        {
            type += "Flying ";
        }
        else
        {
            type += "Heavy ";
        }
        type += traitValueToInt(flightTraversal) + ", ";
        return type;
    }

    private string lightProductionToString()
    {
        if(lightProduction == 0)
        {
            return "";
        }
        if(lightProduction > 0)
        {
            return "Light Generating " + traitValueToInt(lightProduction) + ", ";
        }
        return "Light Consuming " + -traitValueToInt(lightProduction) + ", ";
    }

    private string physicalTraitToString()
    {
        if(physicalTraitValue == 0)
        {
            return "";
        }
        return "Physical " + traitValueToInt(physicalTraitValue) + ", ";
    }

    private string balancedTraitToString()
    {
        if(balancedTraitValue == 0)
        {
            return "";
        }
        return "Balanced " + traitValueToInt(balancedTraitValue) + ", ";

    }

    private string magicalTraitToString()
    {
        if(magicalTraitValue == 0)
        {
            return "";
        }
        return "Magical " + traitValueToInt(magicalTraitValue) + ", ";
    }

    private string inheritedTraitToString(ETraitValue traitValue, string traitName)
    {
        if(traitValue == 0)
        {
            return "";
        }
        return traitName + traitValueToInt(traitValue) + ", ";
    }

    private string statTraitToString(ETraitValue traitValue, string positiveName, string negativeName)
    {
        if (traitValue == 0)
        {
            return "";
        }
        if (traitValue > 0)
        {
            return positiveName + traitValueToInt(traitValue) + ", ";
        }
        return negativeName + traitValueToInt(traitValue) + ", ";
    }

    private int traitValueToInt(ETraitValue value)
    {
        if(value == ETraitValue.Aligned1 || value == ETraitValue.Unaligned1)
        {
            return 1;
        }
        if(value == ETraitValue.Aligned2 || value == ETraitValue.Unaligned2)
        {
            return 2;
        }
        if(value == ETraitValue.Aligned3  || value == ETraitValue.Unaligned3)
        {
            return 3;
        }
        if(value == ETraitValue.Aligned4 || value == ETraitValue.Unaligned4)
        {
            return 4;
        }
        if(value == ETraitValue.Aligned5 || value == ETraitValue.Unaligned5)
        {
            return 5;
        }
        return 0;
    }
}
