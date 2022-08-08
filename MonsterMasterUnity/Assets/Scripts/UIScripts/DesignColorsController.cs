using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to control the DesignColors of the game 
 * (Wanted to call them themes but that was taken)
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class DesignColorsController : ScriptableObject
{
    private Color textColor;
    private Color backgroundColor;
    private Color selectedColor;
    public DesignColors getDefaultDesignColors()
    {
        textColor = new Color(26f / 255f, 11f / 255f, 0f, 1f);
        backgroundColor = new Color(128f / 255f, 53f / 255f, 0f, 1f);
        selectedColor = new Color(178f / 255f, 74f / 255f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getElementDesignColors(SecondaryElement secondaryElement)
    {
        if("Pyro".Equals(secondaryElement.getName()))
        {
            return getPyroColors();
        }
        if("Lava".Equals(secondaryElement.getName()))
        {
            return getLavaColors();
        }
        if("Dinosaur".Equals(secondaryElement.getName()))
        {
            return getDinosaurColors();
        }
        if("Sand".Equals(secondaryElement.getName()))
        {
            return getSandColors();
        }
        if("Justice".Equals(secondaryElement.getName()))
        {
            return getJusticeColors();
        }
        if("Vengence".Equals(secondaryElement.getName()) || "Vengeance".Equals(secondaryElement.getName()))
        {
            return getVengeanceColors();
        }
        if("Steam".Equals(secondaryElement.getName()))
        {
            return getSteamColors();
        }
        if("Aqua".Equals(secondaryElement.getName()))
        {
            return getAquaColors();
        }
        if("Amphibious".Equals(secondaryElement.getName()))
        {
            return getAmphibiousColors();
        }
        if("Weather".Equals(secondaryElement.getName()))
        {
            return getWeatherColors();
        }
        if("Ice".Equals(secondaryElement.getName()))
        {
            return getIceColors();
        }
        if("Deep".Equals(secondaryElement.getName()))
        {
            return getDeepColors();
        }
        if("Fey".Equals(secondaryElement.getName()))
        {
            return getFeyColors();
        }
        if("Plant".Equals(secondaryElement.getName()))
        {
            return getPlantColors();
        }
        if("Terra".Equals(secondaryElement.getName()))
        {
            return getTerraColors();
        }
        if("Pegasus".Equals(secondaryElement.getName()))
        {
            return getPegasusColors();
        }
        if("Compassion".Equals(secondaryElement.getName()))
        {
            return getCompassionColors();
        }
        if("Rotten".Equals(secondaryElement.getName()))
        {
            return getRottenColors();
        }
        if("Phoenix".Equals(secondaryElement.getName()))
        {
            return getPhoenixColors();
        }
        if("Seabreeze".Equals(secondaryElement.getName()) || "SeaBreeze".Equals(secondaryElement.getName()))
        {
            return getSeabreezeColors();
        }
        if("Bird".Equals(secondaryElement.getName()))
        {
            return getBirdColors();
        }
        if("Aero".Equals(secondaryElement.getName()))
        {
            return getAeroColors();
        }
        if("Cocka".Equals(secondaryElement.getName()))
        {
            return getCockaColors();
        }
        if("Nightwing".Equals(secondaryElement.getName()) || "NightWing".Equals(secondaryElement.getName()))
        {
            return getNightwingColors();
        }
        if("Solar".Equals(secondaryElement.getName()))
        {
            return getSolarColors();
        }
        if("Lunar".Equals(secondaryElement.getName()))
        {
            return getLunarColors();
        }
        if("Guardian".Equals(secondaryElement.getName()))
        {
            return getGuardianColors();
        }
        if("Angel".Equals(secondaryElement.getName()))
        {
            return getAngelColors();
        }
        if("Luxor".Equals(secondaryElement.getName()))
        {
            return getLuxorColors();
        }
        if("Redemption".Equals(secondaryElement.getName()))
        {
            return getRedemptionColors();
        }
        if("Demon".Equals(secondaryElement.getName()))
        {
            return getDemonColors();
        }
        if("Poison".Equals(secondaryElement.getName()))
        {
            return getPoisonColors();
        }
        if("Undead".Equals(secondaryElement.getName()))
        {
            return getUndeadColors();
        }
        if("Storm".Equals(secondaryElement.getName()))
        {
            return getStormColors();
        }
        if("Betrayer".Equals(secondaryElement.getName()))
        {
            return getBetrayerColors();
        }
        if("Umbral".Equals(secondaryElement.getName()))
        {
            return getUmbralColors();
        }
        return getDefaultDesignColors();
    }

    public DesignColors getElementDesignColors(string secondaryElement)
    {
        if ("Pyro".Equals(secondaryElement))
        {
            return getPyroColors();
        }
        if("Lava".Equals(secondaryElement))
        {
            return getLavaColors();
        }
        if("Dinosaur".Equals(secondaryElement))
        {
            return getDinosaurColors();
        }
        if("Sand".Equals(secondaryElement))
        {
            return getSandColors();
        }
        if("Justice".Equals(secondaryElement))
        {
            return getJusticeColors();
        }
        if("Vengence".Equals(secondaryElement) || "Vengeance".Equals(secondaryElement))
        {
            return getVengeanceColors();
        }
        if("Steam".Equals(secondaryElement))
        {
            return getSteamColors();
        }
        if ("Aqua".Equals(secondaryElement))
        {
            return getAquaColors();
        }
        if ("Amphibious".Equals(secondaryElement))
        {
            return getAmphibiousColors();
        }
        if("Weather".Equals(secondaryElement))
        {
            return getWeatherColors();
        }
        if("Ice".Equals(secondaryElement))
        {
            return getIceColors();
        }
        if("Deep".Equals(secondaryElement))
        {
            return getDeepColors();
        }
        if("Fey".Equals(secondaryElement))
        {
            return getFeyColors();
        }
        if("Plant".Equals(secondaryElement))
        {
            return getPlantColors();
        }
        if ("Terra".Equals(secondaryElement))
        {
            return getTerraColors();
        }
        if("Pegasus".Equals(secondaryElement))
        {
            return getPegasusColors();
        }
        if ("Compassion".Equals(secondaryElement))
        {
            return getCompassionColors();
        }
        if("Rotten".Equals(secondaryElement))
        {
            return getRottenColors();
        }
        if("Phoenix".Equals(secondaryElement))
        {
            return getPhoenixColors();
        }
        if("Seabreeze".Equals(secondaryElement) || "SeaBreeze".Equals(secondaryElement))
        {
            return getSeabreezeColors();
        }
        if("Bird".Equals(secondaryElement))
        {
            return getBirdColors();
        }
        if ("Aero".Equals(secondaryElement))
        {
            return getAeroColors();
        }
        if ("Cocka".Equals(secondaryElement))
        {
            return getCockaColors();
        }
        if("Nightwing".Equals(secondaryElement) || "NightWing".Equals(secondaryElement))
        {
            return getNightwingColors();
        }
        if("Solar".Equals(secondaryElement))
        {
            return getSolarColors();
        }
        if("Lunar".Equals(secondaryElement))
        {
            return getLunarColors();
        }
        if("Guardian".Equals(secondaryElement))
        {
            return getGuardianColors();
        }
        if("Angel".Equals(secondaryElement))
        {
            return getAngelColors();
        }
        if ("Luxor".Equals(secondaryElement))
        {
            return getLuxorColors();
        }
        if ("Redemption".Equals(secondaryElement))
        {
            return getRedemptionColors();
        }
        if ("Demon".Equals(secondaryElement))
        {
            return getDemonColors();
        }
        if("Poison".Equals(secondaryElement))
        {
            return getPoisonColors();
        }
        if("Undead".Equals(secondaryElement))
        {
            return getUndeadColors();
        }
        if("Storm".Equals(secondaryElement))
        {
            return getStormColors();
        }
        if ("Betrayer".Equals(secondaryElement))
        {
            return getBetrayerColors();
        }
        if ("Umbral".Equals(secondaryElement))
        {
            return getUmbralColors();
        }
        return getDefaultDesignColors();
    }

    public DesignColors getPyroColors()
    {
        textColor = new Color(1f, 0f, 0f, 1f);
        backgroundColor = new Color(.6f, .1f, .1f, 1f);
        selectedColor = new Color(.75f, 0f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getLavaColors()
    {
        textColor = new Color(1f, .4f, 0f, 1f);
        backgroundColor = new Color(.7f, .2f, 0f, 1f);
        selectedColor = new Color(.85f, .3f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getDinosaurColors()
    {
        textColor = new Color(.4f, .15f, 0f, 1f);
        backgroundColor = new Color(.6f, .22f, 0f, 1f);
        selectedColor = new Color(.65f, .35f, .1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getSandColors()
    {
        textColor = new Color(.8f, .8f, .3f, 1f);
        backgroundColor = new Color(.65f, .35f, 0f, 1f);
        selectedColor = new Color(1f, .52f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getJusticeColors()
    {
        textColor = new Color(1f, .3f, .3f, 1f);
        backgroundColor = new Color(.75f, .1f, .1f, 1f);
        selectedColor = new Color(1f, .6f, .6f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getVengeanceColors()
    {
        textColor = new Color(.7f, 0f, 0f, 1f);
        backgroundColor = new Color(.35f, 0f, 0f, 1f);
        selectedColor = new Color(.5f, 0f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getSteamColors()
    {
        textColor = new Color(1f, 0f, .6f, 1f);
        backgroundColor = new Color(.5f, .2f, 1f, 1f);
        selectedColor = new Color(.3f, 0f, 1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getAquaColors()
    {
        textColor = new Color(0f, 0f, .6f, 1f);
        backgroundColor = new Color(.2f, .2f, 1f, 1f);
        selectedColor = new Color(0f, 0f, 1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getAmphibiousColors()
    {
        textColor = new Color(0f, .55f, .8f, 1f);
        backgroundColor = new Color(.2f, .8f, .6f, 1f);
        selectedColor = new Color(.25f, .7f, .75f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getWeatherColors()
    {
        textColor = new Color(.8f, .8f, .1f, 1f);
        backgroundColor = new Color(.4f, .4f, .9f, 1f);
        selectedColor = new Color(.15f, .15f, .75f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getIceColors()
    {
        textColor = new Color(.7f, .7f, 1f, 1f);
        backgroundColor = new Color(.5f, .5f, 1f, 1f);
        selectedColor = new Color(.35f, .35f, .85f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getDeepColors()
    {
        textColor = new Color(0f, 0f, .2f, 1f);
        backgroundColor = new Color(.1f, .1f, .3f, 1f);
        selectedColor = new Color(.05f, .05f, .35f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getFeyColors()
    {
        textColor = new Color(1f, .4f, .2f, 1f);
        backgroundColor = new Color(.4f, 1f, .2f, 1f);
        selectedColor = new Color(.6f, 1f, .6f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }
    
    public DesignColors getPlantColors()
    {
        textColor = new Color(0f, .8f, 0f, 1f);
        backgroundColor = new Color(.2f, .6f, .6f, 1f);
        selectedColor = new Color(.6f, 1f, 1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getTerraColors()
    {
        textColor = new Color(0f, .4f, 0f, 1f);
        backgroundColor = new Color(0f, .6f, 0f, 1f);
        selectedColor = new Color(0f, .8f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getPegasusColors()
    {
        textColor = new Color(.8f, .8f, .2f, 1f);
        backgroundColor = new Color(.15f, .6f, 0f, 1f);
        selectedColor = new Color(.2f, .8f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getCompassionColors()
    {
        textColor = new Color(.95f, 1f, .95f, 1f);
        backgroundColor = new Color(.4f, .9f, .4f, 1f);
        selectedColor = new Color(.2f, .7f, .2f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getRottenColors()
    {
        textColor = new Color(0f, .1f, 0f, 1f);
        backgroundColor = new Color(.1f, .3f, .1f, 1f);
        selectedColor = new Color(.05f, .4f, .05f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getPhoenixColors()
    {
        textColor = new Color(1f, 0f, 0f, 1f);
        backgroundColor = new Color(.8f, .7f, 0f, 1f);
        selectedColor = new Color(.6f, .5f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getSeabreezeColors()
    {
        textColor = new Color(0f, 0f, 1f, 1f);
        backgroundColor = new Color(.8f, .8f, 0f, 1f);
        selectedColor = new Color(.6f, .6f, .2f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getBirdColors()
    {
        textColor = new Color(0f, 1f, 0f, 1f);
        backgroundColor = new Color(0f, 0f, .8f, 1f);
        selectedColor = new Color(.3f, .3f, 1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getAeroColors()
    {
        textColor = new Color(.8f, .8f, .3f, 1f);
        backgroundColor = new Color(1f, 1f, .4f, 1f);
        selectedColor = new Color(.7f, .7f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getCockaColors()
    {
        textColor = new Color(1f, 1f, .75f, 1f);
        backgroundColor = new Color(.8f, .8f, .4f, 1f);
        selectedColor = new Color(.6f, .6f, .1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getNightwingColors()
    {
        textColor = new Color(.4f, .4f, 0f, 1f);
        backgroundColor = new Color(.25f, .25f, 0f, 1f);
        selectedColor = new Color(.15f, .15f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getSolarColors()
    {
        textColor = new Color(1f, .75f, .15f, 1f);
        backgroundColor = new Color(.75f, .45f, .1f, 1f);
        selectedColor = new Color(1f, .8f, .6f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getLunarColors()
    {
        textColor = new Color(.825f, .825f, 1f, 1f);
        backgroundColor = new Color(.6f, .6f, 1f, 1f);
        selectedColor = new Color(.65f, .65f, .85f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getGuardianColors()
    {
        textColor = new Color(.85f, 1f, .85f, 1f);
        backgroundColor = new Color(.5f, 1f, .5f, 1f);
        selectedColor = new Color(.7f, 1f, .7f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getAngelColors()
    {
        textColor = new Color(1f, 1f, .85f, 1f);
        backgroundColor = new Color(.9f, .9f, .5f, 1f);
        selectedColor = new Color(.7f, .7f, .3f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getLuxorColors()
    {
        textColor = new Color(1f, 1f, 1f, 1f);
        backgroundColor = new Color(.85f, .85f, .85f, 1f);
        selectedColor = new Color(.9f, .9f, .9f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getRedemptionColors()
    {
        textColor = new Color(.85f, .85f, .85f, 1f);
        backgroundColor = new Color(.6f, .6f, .6f, 1f);
        selectedColor = new Color(.5f, .5f, .5f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getDemonColors()
    {
        textColor = new Color(.5f, 0f, 0f, 1f);
        backgroundColor = new Color(.15f, 0f, 0f, 1f);
        selectedColor = new Color(.3f, 0f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getPoisonColors()
    {
        textColor = new Color(0f, 0f, .5f, 1f);
        backgroundColor = new Color(0f, .55f, 0f, 1f);
        selectedColor = new Color(.2f, .2f, .2f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getUndeadColors()
    {
        textColor = new Color(0f, .05f, 0f, 1f);
        backgroundColor = new Color(.05f, .15f, .05f, 1f);
        selectedColor = new Color(.025f, .2f, .025f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getStormColors()
    {
        textColor = new Color(.1f, .1f, 0f, 1f);
        backgroundColor = new Color(.4f, .4f, 0f, 1f);
        selectedColor = new Color(.25f, .25f, 0f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getBetrayerColors()
    {
        textColor = new Color(.15f, .15f, .15f, 1f);
        backgroundColor = new Color(.25f, .25f, .25f, 1f);
        selectedColor = new Color(.4f, .4f, .4f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }

    public DesignColors getUmbralColors()
    {
        textColor = new Color(0f, 0f, 0f, 1f);
        backgroundColor = new Color(.2f, .2f, .2f, 1f);
        selectedColor = new Color(.1f, .1f, .1f, 1f);
        return new DesignColors(textColor, backgroundColor, selectedColor);
    }



    public DesignColors getSpecializedDesignColors()
    {
        return getDefaultDesignColors();
        //TODO Specialize based on the main characters affinities
    }
}
