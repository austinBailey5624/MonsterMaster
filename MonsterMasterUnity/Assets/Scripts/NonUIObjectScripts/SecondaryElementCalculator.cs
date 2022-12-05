using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
 * Class to calculate the secondary element or subelement based on two primary elements
 * Copyright 2022 Austin Bailey All Rights Reserved
 */
public class SecondaryElementCalculator 
{
    public SecondaryElement pyro;
    public SecondaryElement lava;
    public SecondaryElement dinosaur;
    public SecondaryElement sand;


    public SecondaryElement calculateSecondaryElement(PrimaryElement primary, PrimaryElement secondary)
    {
        if(primary.getName().Equals("Fire"))
        {
            if(secondary.getName().Equals("Fire"))
            {
                return pyro;
            }
            if(secondary.getName().Equals("Water"))
            {
                return lava;
            }
        }
        return pyro;

    }
}
