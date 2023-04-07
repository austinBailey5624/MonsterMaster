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
 * Copyright 2022 - 2023 Austin Bailey, All Rights Reserved
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
        //Set all traits to child traits, we won't change Solidity, Age and most Traversal Traits (Except Light Emitting and Flying)
        Traits result = newMonsterTypeTraits;

        //Handle Traversal Traits that can be 'upgraded' by parents traits
        ETraitValue parentFlightTraversal = inheritedTraits(fatherTraits.flightTraversal, motherTraits.flightTraversal, newGenerationValue);
        if((int)result.flightTraversal < (int)parentFlightTraversal)
        {
            result.flightTraversal = parentFlightTraversal;
        }

        ETraitValue parentLightProduction = inheritedTraits(fatherTraits.lightProduction, motherTraits.lightProduction, newGenerationValue);
        if((int)result.lightProduction > 0 && (int)result.lightProduction < (int)parentLightProduction)
        {//parent light production is higher, and we have a positive value, so we upgrade to the parents value
            result.lightProduction = parentLightProduction;
        }
        if((int)result.lightProduction < 0 && (int)result.lightProduction > (int)parentLightProduction)
        {//parent light production is lower, and we have a negative value, so we upgrade to the parents value
            result.lightProduction = parentLightProduction;
        }

        //Handle Evolutionary Traits
        result.physicalTraitValue = max(result.physicalTraitValue, inheritedTraits(fatherTraits.physicalTraitValue, motherTraits.physicalTraitValue, newGenerationValue));
        result.balancedTraitValue = max(result.balancedTraitValue, inheritedTraits(fatherTraits.balancedTraitValue, motherTraits.balancedTraitValue, newGenerationValue));
        result.magicalTraitValue  = max(result.magicalTraitValue,  inheritedTraits(fatherTraits.magicalTraitValue,  motherTraits.magicalTraitValue,  newGenerationValue));

        //Handle Inherited Traots
        //Start with Immolated, Hot and Fish because they have special logic
        result.immolatedTraitValue = max(result.immolatedTraitValue, inheritedTraits(fatherTraits.immolatedTraitValue, motherTraits.immolatedTraitValue, newGenerationValue));
        result.hotTraitValue = valueFromSum((int)result.hotTraitValue + (int)inheritedTraits(fatherTraits.hotTraitValue, motherTraits.hotTraitValue, newGenerationValue));
        result.fishTraitValue = max(result.fishTraitValue, inheritedTraits(fatherTraits.fishTraitValue, motherTraits.fishTraitValue, newGenerationValue));
        if ((int)result.immolatedTraitValue > 0)//if the baby is born immolated, it must remain immolated
        {
            if((int)result.hotTraitValue < 0)//if we are cold- eliminate that
            {
                result.hotTraitValue = (ETraitValue)0;
            }
            if((int)result.lightProduction <=0)
            {
                result.lightProduction = (ETraitValue)1;
            }
            result.fishTraitValue = 0;//we cant be a fish
            result.underwaterTraversal = EUnderwaterTraversalTrait.Unsubmergible;
        }
        else if((int)result.fishTraitValue > 0)//if they are born a fish
        {
            result.immolatedTraitValue = (ETraitValue)0;
            result.underwaterTraversal = EUnderwaterTraversalTrait.WaterBreathing;
            

        }
        else if((int)result.hotTraitValue < 0)//they are born cold
        {
            //if we are born cold and we are not born immolated, we can't be immolated
            result.immolatedTraitValue = (ETraitValue)0;

        }
        //If we're not cold, immolated or a fish we leave everything to their default values

        result.avengerTraitValue = max(result.avengerTraitValue, inheritedTraits(fatherTraits.avengerTraitValue, motherTraits.avengerTraitValue, newGenerationValue));
        result.beachDwellingTraitValue = max(result.beachDwellingTraitValue, inheritedTraits(fatherTraits.beachDwellingTraitValue, motherTraits.beachDwellingTraitValue, newGenerationValue));
        result.cloudyTraitValue = max(result.cloudyTraitValue, inheritedTraits(fatherTraits.cloudyTraitValue, motherTraits.cloudyTraitValue, newGenerationValue));
        result.connectionTraitValue = max(result.connectionTraitValue, inheritedTraits(fatherTraits.connectionTraitValue, motherTraits.connectionTraitValue, newGenerationValue));
        result.dealtInKindTraitValue = max(result.dealtInKindTraitValue, inheritedTraits(fatherTraits.dealtInKindTraitValue, motherTraits.dealtInKindTraitValue, newGenerationValue));
        result.deathConsumingTraitValue = max(result.deathConsumingTraitValue, inheritedTraits(fatherTraits.deathConsumingTraitValue, motherTraits.deathConsumingTraitValue, newGenerationValue));
        result.depthsDwellingTraitValue = max(result.depthsDwellingTraitValue, inheritedTraits(fatherTraits.depthsDwellingTraitValue, motherTraits.depthsDwellingTraitValue, newGenerationValue));
        result.diurnalTraitValue = max(result.diurnalTraitValue, inheritedTraits(fatherTraits.diurnalTraitValue, motherTraits.diurnalTraitValue, newGenerationValue));
        result.elementalStoneTraitValue = max(result.elementalStoneTraitValue, inheritedTraits(fatherTraits.elementalStoneTraitValue, motherTraits.elementalStoneTraitValue, newGenerationValue));
        result.flockTraitValue = max(result.flockTraitValue, inheritedTraits(fatherTraits.flockTraitValue, motherTraits.flockTraitValue, newGenerationValue));
        result.forestMagicTraitValue = max(result.forestMagicTraitValue, inheritedTraits(fatherTraits.forestMagicTraitValue, motherTraits.forestMagicTraitValue, newGenerationValue));
        result.guiltTraitValue = max(result.guiltTraitValue, inheritedTraits(fatherTraits.guiltTraitValue, motherTraits.guiltTraitValue, newGenerationValue));
        result.hateHypocricyTrateValue = max(result.hateHypocricyTrateValue, inheritedTraits(fatherTraits.hateHypocricyTrateValue, motherTraits.hateHypocricyTrateValue, newGenerationValue));
        result.healerTraitValue = max(result.healerTraitValue, inheritedTraits(fatherTraits.healerTraitValue, motherTraits.healerTraitValue, newGenerationValue));
        result.isolationTraitValue = max(result.isolationTraitValue, inheritedTraits(fatherTraits.isolationTraitValue, motherTraits.isolationTraitValue, newGenerationValue));
        result.naturalTraitValue = max(result.naturalTraitValue, inheritedTraits(fatherTraits.naturalTraitValue, motherTraits.naturalTraitValue, newGenerationValue));
        result.nocturnalTraitValue = max(result.nocturnalTraitValue, inheritedTraits(fatherTraits.nocturnalTraitValue, motherTraits.nocturnalTraitValue, newGenerationValue));
        result.protectorTraitValue = max(result.protectorTraitValue, inheritedTraits(fatherTraits.protectorTraitValue, motherTraits.protectorTraitValue, newGenerationValue));
        result.rainbowTraitValue = max(result.rainbowTraitValue, inheritedTraits(fatherTraits.rainbowTraitValue, motherTraits.rainbowTraitValue, newGenerationValue));
        result.rebirthTraitValue = max(result.rebirthTraitValue, inheritedTraits(fatherTraits.rebirthTraitValue, motherTraits.rebirthTraitValue, newGenerationValue));
        result.regenShieldTraitValue = max(result.regenShieldTraitValue, inheritedTraits(fatherTraits.regenShieldTraitValue, motherTraits.regenShieldTraitValue, newGenerationValue));
        result.rootedTraitValue = max(result.rootedTraitValue, inheritedTraits(fatherTraits.rootedTraitValue, motherTraits.rootedTraitValue, newGenerationValue));
        result.sandyTraitValue = max(result.sandyTraitValue, inheritedTraits(fatherTraits.sandyTraitValue, motherTraits.sandyTraitValue, newGenerationValue));
        result.steamyTraitValue = max(result.steamyTraitValue, inheritedTraits(fatherTraits.steamyTraitValue, motherTraits.steamyTraitValue, newGenerationValue));
        result.toxicTraitValue = max(result.toxicTraitValue, inheritedTraits(fatherTraits.toxicTraitValue, motherTraits.toxicTraitValue, newGenerationValue));
        result.vampireTraitValue = max(result.vampireTraitValue, inheritedTraits(fatherTraits.vampireTraitValue, motherTraits.vampireTraitValue, newGenerationValue));
        result.wetTraitValue = max(result.wetTraitValue, inheritedTraits(fatherTraits.wetTraitValue, motherTraits.wetTraitValue, newGenerationValue));


        //Elemental Magic Traits
        result.pyromagiaTraitValue = max(result.pyromagiaTraitValue, inheritedTraits(fatherTraits.pyromagiaTraitValue, motherTraits.pyromagiaTraitValue, newGenerationValue));
        result.aquamagiaTraitValue = max(result.aquamagiaTraitValue, inheritedTraits(fatherTraits.aquamagiaTraitValue, motherTraits.aquamagiaTraitValue, newGenerationValue));
        result.terramagiaTraitValue = max(result.terramagiaTraitValue, inheritedTraits(fatherTraits.terramagiaTraitValue, motherTraits.terramagiaTraitValue, newGenerationValue));
        result.aeroMagiaTraitValue = max(result.aeroMagiaTraitValue, inheritedTraits(fatherTraits.aeroMagiaTraitValue, motherTraits.aeroMagiaTraitValue, newGenerationValue));
        result.luxorMagiaTraitValue = max(result.luxorMagiaTraitValue, inheritedTraits(fatherTraits.luxorMagiaTraitValue, motherTraits.luxorMagiaTraitValue, newGenerationValue));
        result.umbralMagiaTraitValue = max(result.umbralMagiaTraitValue, inheritedTraits(fatherTraits.umbralMagiaTraitValue, motherTraits.umbralMagiaTraitValue, newGenerationValue));

        //Stat Traits
        result.calmTraitValue = valueFromSum((int)result.calmTraitValue + (int)inheritedTraits(fatherTraits.calmTraitValue, motherTraits.calmTraitValue, newGenerationValue));
        result.strongTraitValue = valueFromSum((int)result.strongTraitValue + (int)inheritedTraits(fatherTraits.strongTraitValue, motherTraits.strongTraitValue, newGenerationValue));
        result.wiseTraitValue = valueFromSum((int)result.wiseTraitValue + (int)inheritedTraits(fatherTraits.wiseTraitValue, motherTraits.wiseTraitValue, newGenerationValue));
        result.fastTraitValue = valueFromSum((int)result.fastTraitValue + (int)inheritedTraits(fatherTraits.fastTraitValue, motherTraits.fastTraitValue, newGenerationValue));
        result.hardyTraitValue = valueFromSum((int)result.hardyTraitValue + (int)inheritedTraits(fatherTraits.hardyTraitValue, motherTraits.hardyTraitValue, newGenerationValue));
        result.richTraitValue = valueFromSum((int)result.richTraitValue + (int)inheritedTraits(fatherTraits.richTraitValue, motherTraits.richTraitValue, newGenerationValue));

        return result;
    }

    private static ETraitValue valueFromSum(int sum)
    {
        if(sum > 5)
        {
            return (ETraitValue)5;
        }
        if(sum < -5)
        {
            return ETraitValue.Unaligned5;
        }
        return (ETraitValue)sum;
    }

    private static ETraitValue max(ETraitValue child, ETraitValue parents)
    {
        if((int)child > (int)parents)
        {
            return child;
        }
        return parents;
    }

    private static ETraitValue inheritedTraits(ETraitValue father, ETraitValue mother, int generationValue)
    {
        if(generationValue == 2)
        {
            return gen2InheritedTraits(father, mother);
        }
        if(generationValue == 3)
        {
            return gen3InheritedTraits(father, mother);
        }
        return father;//TODO Remove
    }

    private static ETraitValue gen2InheritedTraits(ETraitValue father, ETraitValue mother)
    {
        ETraitValue result;
        if (father == mother)
        {
            result = father;
        }
        //case where the value is opposed
        if( ((int)father > 0 && (int)mother < 0) || ((int)father < 0 && (int)mother > 0) )
        {
            int sum = (int)father + (int)mother;
            result = (ETraitValue) sum;
        }
        if ((int)father >= 0 && (int)mother >= 0)//both positive or zero, happy path, going up
        {
            if (father > mother)
            {
                result = gen2InheritedTraitsHelper(father, mother);
            }
            else
            {
                result = gen2InheritedTraitsHelper(mother, father);
            }
        }
        else //at least one is negative, if only one is negative, the other is zero, we're going down
        {
            if ( father < mother )
            {
                result = gen2InheritedTraitsHelperNegative(father, mother);
            }
            else
            {
                result = gen2InheritedTraitsHelperNegative(mother, father);
            }
        }
        return result;
    }

    private static ETraitValue gen2InheritedTraitsHelper(ETraitValue higher, ETraitValue lower)
    {
        ETraitValue result;
        if (lower == 0)
        {
            if (higher - 2 > 0)
            {
                int sum = (int)higher - 2;
                result = (ETraitValue)sum;
            }
            else
            {
                result = ETraitValue.Neutral;
            }
        }
        else
        {
            if ((int)higher > 3)
            {
                int sum = (int)higher - 2;
                result = (ETraitValue)sum;
            }
            else
            {
                int sum = (int)higher - 1;
                result = (ETraitValue)sum;
            }
            if(lower > result)
            {
                result = lower;
            }
        }
        return result;
    }

    private static ETraitValue gen2InheritedTraitsHelperNegative(ETraitValue biggerNegative, ETraitValue lesserNegative)
    {
        ETraitValue result;
        if((int)lesserNegative == 0)
        {
            if((int)biggerNegative + 2 < 0)
            {
                int sum = (int)biggerNegative + 2;
                result = (ETraitValue)sum;
            }
            else
            {
                result = 0;
            }
        }
        else
        {
            if((int)biggerNegative < -3)
            {
                int sum = (int)biggerNegative + 2;
                result = (ETraitValue)sum;
            }
            else
            {
                int sum = (int)biggerNegative + 1;
                result = (ETraitValue)sum;
            }
            if((int)lesserNegative < (int)result)
            {
                int sum = (int)lesserNegative;
                result = (ETraitValue)sum;
            }
        }
        return result;
    }

    private static ETraitValue gen3InheritedTraits(ETraitValue father, ETraitValue mother)
    {
        ETraitValue result;
        int sum;
        if(father == mother)
        {
            if((int)father == 0)
            {
                return 0;
            }
            sum = (int)father + 1;
            result = (ETraitValue)sum;
            if((int)result > 5)
            {
                result = (ETraitValue)5;
            }
            return result;
        }
        //case where the value is opposed (the values have opposite signs)
        if ((father > 0 && mother < 0) || (father < 0 && mother > 0))
        {
            sum = (int)father + (int)mother;
            result = (ETraitValue)sum;
        }
        if (father >= 0 && mother >= 0)//both positive or zero, happy path, going up
        {
            result = father > mother ? gen3InheritedTraitsHelper(father, mother) : gen3InheritedTraitsHelper(mother, father);
        }
        else //at least one is negative, if only one is negative, the other is zero, we're going down
        {
            result = father < mother ? gen3InheritedTraitsHelperNegative(father, mother) : gen3InheritedTraitsHelperNegative(mother, father);
        }
        return result;
    }

    public static ETraitValue gen3InheritedTraitsHelper(ETraitValue higher, ETraitValue lower)
    {
        int sum;
        if (lower == 0)
        {
            if ((int)higher > 3)
            {
                sum = (int)higher - 2;
                return (ETraitValue)sum;
            }
            else
            {
                sum = (int)higher - 1;
                return (ETraitValue)sum;
            }
        }
        sum = (int)higher - 1;
        return (ETraitValue)sum;
    }

    private static ETraitValue gen3InheritedTraitsHelperNegative(ETraitValue biggerNegative, ETraitValue lesserNegative)
    {
        int sum;
        if ((int)lesserNegative == 0)
        {
            if ((int)biggerNegative < -3)
            {
                sum = (int)biggerNegative + 2;
            }
            else
            {
                sum = (int)biggerNegative + 1;
            }
            return (ETraitValue)sum;
        }
        sum = (int)biggerNegative + 1;
        return (ETraitValue)sum;
    }

    private static ETraitValue gen4InheritedTraits(ETraitValue father, ETraitValue mother)
    {
        ETraitValue result;
        if (father == mother)
        {
            if (father == 0)
            {
                return 0;
            }
            result = (ETraitValue)((int)father + 1);
            if ((int)result > 5)
            {
                result = (ETraitValue)5;
            }
            return result;
        }
        //case where the value is opposed
        if ((father > 0 && mother < 0) || (father < 0 && mother > 0))
        {
            result = (ETraitValue)(int)father + (int)mother;
            if((int)result > 0)
            {
                result++;
            }
            else if((int)result < 0)
            {
                result--;
            }
        }
        if ((int)father >= 0 && (int)mother >= 0)//both positive or zero, happy path, going up
        {
            result = gen4InheritedTraitsHelper(father, mother);
        }
        else //at least one is negative, if only one is negative, the other is zero, we're going down
        {
            result = gen4InheritedTraitsHelperNegative(father, mother);
        }
        return result;
    }

    private static ETraitValue gen4InheritedTraitsHelper(ETraitValue father, ETraitValue mother)
    {
        ETraitValue higher;
        ETraitValue lower;
        if(father > mother)
        {
            higher = father;
            lower = mother;
        }
        else
        {
            higher = mother;
            lower = father;
        }

        if((int)lower == 0 || (int)higher > 3)
        {
            return (ETraitValue)((int)higher - 1);
        }
        return higher;
    }

    private static ETraitValue gen4InheritedTraitsHelperNegative(ETraitValue father, ETraitValue mother)
    {
        ETraitValue biggerNegative;
        ETraitValue lesserNegative;
        if(father > mother)
        {
            lesserNegative = father;
            biggerNegative = mother;
        }
        else
        {
            lesserNegative = mother;
            biggerNegative = father;
        }

        if((int)lesserNegative == 0 || (int)biggerNegative < -3)
        {
            return (ETraitValue)((int)biggerNegative + 1);
        }
        return  biggerNegative;
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
