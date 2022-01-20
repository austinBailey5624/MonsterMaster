using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Interface for objects that have a description (to be read in the encyclopedia)
*   It is assumed that anything that has a description will also have a name
*   Copyright 2022 Austin Bailey All Rights Reserved
*/
public interface IDescribedObject : INamedObject
{
    string getDescription();
}
